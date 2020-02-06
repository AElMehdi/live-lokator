package live.lokator.kafka.server

import java.net.InetSocketAddress
import java.nio.file.Files
import java.util.Properties

import kafka.server.{KafkaConfig, KafkaServerStartable}
import org.apache.zookeeper.server.{ServerConfig, ZooKeeperServerMain}
import org.apache.zookeeper.server.quorum.QuorumPeerConfig

object KafkaServer extends App {
  val QuorumPeerConfig = new QuorumPeerConfig {
    override def getDataDir = Files.createTempDirectory("zookeeper").toFile
    override def getDataLogDir = Files.createTempDirectory("zookeeper-logs").toFile
    override def getClientPortAddress: InetSocketAddress = new InetSocketAddress(2181)
  }

  class StoppableZooKeeperServerMain extends ZooKeeperServerMain {
    def stop(): Unit = shutdown()
  }

  private val zooKeeperServer = new StoppableZooKeeperServerMain()

  val zooKeeperConfig = new ServerConfig()
  zooKeeperConfig.readFrom(QuorumPeerConfig)

  val zooKeeperThread: Thread = new Thread {
    override def run(): Unit = zooKeeperServer.runFromConfig(zooKeeperConfig)
  }

  zooKeeperThread.start()


  val kafkaProperties = new Properties()
  kafkaProperties.put("zookeeper.connect", "localhost:2181")
  kafkaProperties.put("broker.id", "1")
  kafkaProperties.put("log.dirs", Files.createTempDirectory("kafka-logs").toString)

  val kafkaConfig = KafkaConfig.fromProps(kafkaProperties)

  val kafka = new KafkaServerStartable(kafkaConfig)

  kafka.startup()

  zooKeeperThread.join()


  kafka.shutdown()
  kafka.awaitShutdown()


  zooKeeperServer.stop()
}
