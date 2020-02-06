package live.lokator

import java.time.Duration
import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer

class Consumer {


   def main(args: Array[String]): Unit = {
      println("Bingo")
      consumeFromKafka("quick-start")
   }

   def consumeFromKafka(topic: String): Unit = {
      val properties = new Properties()
      properties.put("bootstrap.servers", "localhost:9094")
      properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
      properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
      properties.put("auto.offset.reset", "latest")
      properties.put("group.id", "consumer-group")

      val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](properties)

      consumer.subscribe(util.Arrays.asList(topic))
      while (true) {
         val record = consumer.poll(Duration.ofMillis(1000))
//         for (data <- record.iterator) {
//            println(data)
//         }
      }
   }
}
