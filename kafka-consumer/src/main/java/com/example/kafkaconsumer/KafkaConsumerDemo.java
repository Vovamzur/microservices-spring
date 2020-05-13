package com.example.kafkaconsumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.Arrays;

public class KafkaConsumerDemo {

    private final static String CREATE_TOPIC = "create.entity";
    private final static String UPDATE_TOPIC = "update.entity";
    private final static String BOOTSTRAP_SERVERS = "kafka:9092";

    private static Consumer<String, String> createConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaExampleConsumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        final Consumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(CREATE_TOPIC, UPDATE_TOPIC));
        return consumer;
    }

    public static void runConsumer() {
        final Consumer<String, String> consumer = createConsumer();
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Consumer Record:(%s, %s, %d, %d)\n",
                            record.key(),
                            record.value(),
                            record.partition(),
                            record.offset()
                    );
                }
                consumer.commitAsync();
            }
        } finally {
            consumer.close();
        }
    }
}
