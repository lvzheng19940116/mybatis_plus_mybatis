package com.mycat.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


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
 * 创建时间：2019/2/19 下午2:22
 */
@EnableTransactionManagement
@Configuration
@MapperScan("example.data.diversion.mapper*")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    /**
     * 注册执行分析插件    stopProceed 发现执行全表 delete update 语句是否停止执行
     */
    /**
     * <plugins>
     *      SQL 执行分析拦截器 stopProceed 发现全表执行 delete update 是否停止运行 -->
     *     <plugin interceptor="com.baomidou.mybatisplus.plugins.SqlExplainInterceptor">
     *         <property name="stopProceed" value="false" />
     *     </plugin>
     * </plugins>
     */
    /**
     * SQL执行效率插件
     */
    @Bean
    //@Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
    /**
     *  <plugins>
     *     SQL 执行性能分析，开发环境使用，线上不推荐。maxTime 指的是sql 最大执行时长 -->
     *     <plugin interceptor="com.baomidou.mybatisplus.plugins.PerformanceInterceptor">
     *         <property name="maxTime"value="100"/>
     *         <!--
     *     SQL是否格式化 默认false-->
     *         <property name="format"value="true"/>
     *     </plugin>
     * </plugins>
     */


}
