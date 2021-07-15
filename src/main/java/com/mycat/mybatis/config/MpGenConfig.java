package com.mycat.mybatis.config;

import lombok.Data;

/**
 * @author LvZheng
 * 创建时间：2019/1/21 下午2:52
 */

@Data
public class MpGenConfig {
    private String author;
    private String dburl;
    private String dbusername;
    private String dbpassword;
    private String table;
    private String parentpackage;
    private String customizepackage;

}


