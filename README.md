# apache-kafka-with-spring-boot

Download Kafka
https://www.apache.org/dyn/closer.cgi?path=/kafka/2.2.0/kafka_2.12-2.2.0.tgz
https://www-us.apache.org/dist/kafka/2.2.0/kafka_2.12-2.2.0.tgz (Download)
Extract downloaded zipped folder 
Go to extracted folder

Type: $ bin/zookeeper-server-start.sh config/zookeeper.properties 
To start zookeeper server

Open new terminal tab and type: $ bin/kafka-server-start.sh config/server.properties 
To start actual Kafka server

--------------------------------------------------------------------------------------------------------------------------------

Creating Spring Boot with Kafka
Create a post controller
In terminal, type: $ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic myTopic // myTopic: what we have set in Spring Boot project when POST
Test post in Postman then check terminal in 7.
Add Gson for Serialize and Deserialize, see in project
