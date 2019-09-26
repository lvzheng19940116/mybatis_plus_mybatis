package com.mycat.mybatis.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author LvZheng
 * 创建时间：2019/9/26 4:48 PM
 */
@Slf4j
@Component
public class PurchaseConsumer {


    @KafkaListener(topics = "${purchase_topic}", groupId = "${kafka.purchase_group}", containerFactory = "kafkaListenerContainerFactory2")
    public void purchase(ConsumerRecord<?, ?> record) {

        ObjectMapper mapper = new ObjectMapper();
        String value = (String) record.value();
        log.info("purchase{}", value);
        //  kafkaForm = mapper.readValue(value, KafkaForm.class);

    }

}
