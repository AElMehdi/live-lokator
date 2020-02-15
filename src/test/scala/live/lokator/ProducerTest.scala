package live.lokator

import java.util.Properties

import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.streams.{StreamsBuilder, StreamsConfig, TopologyTestDriver}
import org.apache.kafka.streams.state.KeyValueStore
import org.apache.kafka.streams.test.ConsumerRecordFactory
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite

@RunWith(classOf[JUnitPlatform])
class ProducerTest extends AnyFunSuite {


  test("someMethod is always true") {
    val props = new Properties()
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "test")
    val topology = new StreamsBuilder().build
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234")

    val driver = new TopologyTestDriver(topology,
      props)

    val recordFactory = new ConsumerRecordFactory("input-topic", new StringSerializer(), new StringSerializer())

    val words = "Hello Kafka Streams, All streams lead to Kafka"
    driver.pipeInput(recordFactory.create(words))

    // Te be tested
    val store: KeyValueStore[String, java.lang.Long] = driver.getKeyValueStore("counts-store")

    assert(true)
    driver.close()
  }
}
