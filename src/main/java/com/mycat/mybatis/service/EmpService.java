package com.mycat.mybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycat.mybatis.mapper.EmpMapper;
import com.mycat.mybatis.bean.Emp;
import org.springframework.stereotype.Service;
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
 * 创建时间：2019/2/19 下午3:14
 */
@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class EmpService extends ServiceImpl<EmpMapper,Emp>  {


//    @Resource
//    private EmpMapper empMapper;
//
//
//
//    public Object add(){
//
////        1.EntityWrapper<T>更名为QueryWrapper<T>
////        2.新增一个实现类UpdateWrapper<T>用于update方法
//        QueryWrapper<Emp> qw=new QueryWrapper<Emp>();
//        qw.isEmptyOfWhere();
//        qw.in("","");
//        qw.eq("","");
////        EntityWrapper<Emp> ew = new EntityWrapper<Emp>();
////        ew.where("deleted={0}", 1);
////        ew.in("user_type", "1");
////        ew.eq("role", "1");
////        ew.eq("status", "1");
////        ew.orderBy("id");
////        ew.orderBy("created_time", true);
////        log.info("selectList condition:{}", ew.getSqlSegment());
////        List<User> userList = this.selectList(ew);
//
//        return null;
//    }


}
