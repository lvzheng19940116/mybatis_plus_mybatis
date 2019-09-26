package com.mycat.mybatis.kafka;//package pcsd.financialstatement.task.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LvZheng
 * 创建时间：2019/9/26 2:16 PM
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {


    @Autowired
    private EvnConfig evnConfig;

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory1() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerFactory1());
        factory.setConcurrency(4);
        factory.getContainerProperties().setPollTimeout(4000);
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory2() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerFactory2());
        factory.setConcurrency(4);
        factory.getContainerProperties().setPollTimeout(4000);
        return factory;
    }

    Map<String, Object> getCommonPropertis() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, evnConfig.getBootstrapServers());
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, evnConfig.getAutoCommit());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, evnConfig.getKeyDeserializer());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, evnConfig.getValueDeserializer());
        //  properties.put(ConsumerConfig.GROUP_ID_CONFIG, evnConfig.getAgreementsGroup());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, evnConfig.getAutoOffsetReset());
        return properties;
    }


    ConsumerFactory<String, String> consumerFactory1() {
        Map<String, Object> properties = getCommonPropertis();
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, evnConfig.getAgreementsGroup());
        return new DefaultKafkaConsumerFactory<String, String>(properties);
    }


    ConsumerFactory<String, String> consumerFactory2() {
        Map<String, Object> properties = getCommonPropertis();
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, evnConfig.getPurchaseGroup());
        return new DefaultKafkaConsumerFactory<String, String>(properties);
    }

    @Bean
    public AgreementsConsumer listener() {
        return new AgreementsConsumer();
    }

    @Bean
    public PurchaseConsumer listener1() {
        return new PurchaseConsumer();
    }
}
