package com.mycat.mybatis.plus;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.SQLException;
import java.util.ArrayList;

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
 * 创建时间：2019/6/20 4:15 PM
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) throws SQLException {
        String projectPath = System.getProperty("user.dir");
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("LvZheng") // 作者
                .setSwagger2(true)
                .setOutputDir(projectPath + "/src/main/java")
                .setFileOverride(true)  // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略

                // .setMapperName("%sRepository")//jpa需要 如果使用MP  注释该代码
                .setControllerName("%sController")
                // IEmployeeService
                .setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I
                //.setServiceImplName("%sServiceImpl")
                .setMapperName("%sDao")
                .setXmlName("%sMapper")
                // .setEntityName("%sVo")
                .setBaseResultMap(true)//生成基本的resultMap
                .setBaseColumnList(true);//生成基本的SQL片段


        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();


//        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
//                .setDriverName("com.mysql.jdbc.Driver")
//                .setUrl("jdbc:mysql://192.168.205.233:3307/all_antifraud?characterEncoding=utf-8&useSSL=false")
//                .setUsername("root")
//                .setPassword("eversec123098");
        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3307/lz8")
                .setUsername("root")
                .setPassword("root");

        //3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        //自动填充
        ArrayList<TableFill> tableFill = new ArrayList();
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        tableFill.add(createTime);
        tableFill.add(updateTime);

        stConfig.setCapitalMode(true) //全局大写命名
//                    .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                //.setTablePrefix("tbl_")  //去除表前缀
                //  .setFieldPrefix("") //去除字段前缀
                .setEntityLombokModel(true)
                //   .setTableFillList(tableFill)   //自动填充
                // .setVersionFieldName("version")    //乐观锁的列
                // 生成的表
//                .setInclude(new String[]{"base_gab_hx", "base_gab_hx_history", "base_kab_hx", "base_kab_hx_history"});
                .setInclude(new String[]{"opc_result","point"});


        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.mycat.mybatis.plus")
                .setMapper("mapper")//dao
                .setService("service")//servcie
                .setServiceImpl("service.impl")
                .setController("controller")//controller
                .setEntity("bean")
                .setXml("mapper");//mapper.xml


        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
    }

}



