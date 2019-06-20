package com.mycat.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mycat.mybatis.bean.Emp;
import com.mycat.mybatis.bean.EmpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wolfcode-lanxw
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

    //int add(Emp emp);
    @Select("select * from emp")
    List<Emp> selectAll();

    @Select("select * from emp where eid= #{eid}")
    Emp selectByEid(Long eid);


    @Select("select ee.eid,ee.ename,e.id from emp ee left join emp_user e on ee.eid=e.id")
    List<EmpDTO> select();
}
