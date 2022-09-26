package prueba;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Producer {
	
public static void main(String[] args) {
		
		
		Properties properties = new Properties();
		
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		
		//declaramos la instancia de kafka producer y le pasamos las properties
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		
	      String key_pares="key-pares";
	      String key_impares="key-impares";
		
		for(int i=0; i<20; i++) {
			
			if(i % 2 == 0) {
				
	            ProducerRecord<String, String> record = new ProducerRecord<String, String>("PARES-IMPARES",   key_pares , ""+i);
	            try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
	            producer.send(record);
				
				
				
			}else {
				
				 ProducerRecord<String, String> record = new ProducerRecord<String, String>("PARES-IMPARES",   key_impares , ""+i);
		            try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
		            producer.send(record);
				
				
			}
			

        }

        producer.flush(); // wait for data to send the data
        producer.close(); // flush and close producer

    }

}
