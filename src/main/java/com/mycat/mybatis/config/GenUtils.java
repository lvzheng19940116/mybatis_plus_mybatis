package com.mycat.mybatis.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author LvZheng
 * @since 2021/7/15
 */
public class GenUtils {
    static MpGenConfig mpGenConfig;
    static Properties pro;

    static {
        pro = new Properties();
        InputStream in = null;
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.yml");
            pro.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        mpGenConfig = new MpGenConfig();
        mpGenConfig.setAuthor(pro.getProperty("gen.author"));
        mpGenConfig.setDburl(pro.getProperty("gen.dburl"));
        mpGenConfig.setDbusername(pro.getProperty("gen.dbusername"));
        mpGenConfig.setDbpassword(pro.getProperty("gen.dbpassword"));
        mpGenConfig.setTable(pro.getProperty("gen.table"));
        mpGenConfig.setParentpackage(pro.getProperty("gen.parentpackage"));
        mpGenConfig.setCustomizepackage(pro.getProperty("gen.customizepackage"));
    }

    public static String getPropertiesByKey(String key) {
        return pro.getProperty(key);
    }

    public static MpGenConfig getAll() {
        return mpGenConfig;
    }
}
