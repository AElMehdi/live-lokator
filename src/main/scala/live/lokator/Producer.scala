package live.lokator

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object Producer {

   def main(args: Array[String]): Unit = {
      writeToKafka("quick-start")
   }

   def writeToKafka(topic: String): Unit = {
      val configuration = configureKafka()

      val producer = new KafkaProducer[String, String](configuration)
      val record = new ProducerRecord[String, String](topic, "That's a key", "And Some content in here")

      producer.send(record)
      producer.close()
   }

   def configureKafka(): Properties = {
      val properties = new Properties()

      properties.put("bootstrap.servers", "localhost:9092")
      properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
      properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

      properties
   }
}
