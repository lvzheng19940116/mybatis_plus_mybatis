package com.mycat.mybatis.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author LvZheng
 * 创建时间：2019/9/26 2:27 PM
 */

@Data
@Component
@ConfigurationProperties(prefix = "kafka")
public class EvnConfig {
    private String bootstrapServers;
    private String keyDeserializer;
    private String valueDeserializer;
    private String autoOffsetReset;
    private String autoCommit;
    private String agreementsGroup;
    private String purchaseGroup;

}
