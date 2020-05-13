package com.example.client;

import com.example.client.entity.Country;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {
    private final static String CREATE_TOPIC = "create.entity";
    private final static String UPDATE_TOPIC = "update.entity";
    private final static String BOOTSTRAP_SERVERS = "kafka:9092";

    private static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return new KafkaProducer<>(props);
    }

    public static void sendCreateMessage(Country country){
        final Producer<Long, String> producer = createProducer();

        try {
            final ProducerRecord<Long, String> record = new ProducerRecord<>(
                    CREATE_TOPIC, country.getId(), country.getName());
            RecordMetadata metadata = producer.send(record).get();
            System.out.printf(
                    "sent record(key=%s value=%s) meta(partition=%d, offset=%d)",
                    record.key(),
                    record.value(),
                    metadata.partition(),
                    metadata.offset()
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            producer.flush();
            producer.close();
        }
    }

    public static void sendUpdateMessage(Country country){
        final Producer<Long, String> producer = createProducer();

        try {
            final ProducerRecord<Long, String> record = new ProducerRecord<>(
                    UPDATE_TOPIC, country.getId(), country.getName());
            RecordMetadata metadata = producer.send(record).get();
            System.out.printf(
                    "sent record(key=%s value=%s) meta(partition=%d, offset=%d)",
                    record.key(),
                    record.value(),
                    metadata.partition(),
                    metadata.offset()
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            producer.flush();
            producer.close();
        }
    }

}
