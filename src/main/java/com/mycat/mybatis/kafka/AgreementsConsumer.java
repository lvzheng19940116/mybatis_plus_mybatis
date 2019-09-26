package com.mycat.mybatis.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 以动手实践为荣,以只看不练为耻.
 * 以打印日志为荣,以出错不报为耻.
 * 以局部变量为荣,以全局变量为耻.
 * 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻.
 * 以多态应用为荣,以分支判断为耻.
 * 以定义常量为荣,以魔法数字为耻.
 * 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng
 * 创建时间：2019/7/4 3:35 PM
 */
@Slf4j
@Component
public class AgreementsConsumer {

    @KafkaListener(topics = "${agreements_topic}", groupId = "${kafka.agreements_group}", containerFactory = "kafkaListenerContainerFactory1")
    public void agreements(ConsumerRecord<?, ?> record) {

        ObjectMapper mapper = new ObjectMapper();
        String value = (String) record.value();
        log.info("agreements{}", value);
        //  kafkaForm = mapper.readValue(value, KafkaForm.class);

    }


}
