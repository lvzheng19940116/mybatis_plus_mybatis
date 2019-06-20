package com.mycat.mybatis.mapper;

import com.mycat.mybatis.bean.EmpUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wolfcode-lanxw
 */
@Mapper
public interface EmpUserMapper {
    @Insert("insert into emp_user(id,eid,uid) value (#{id},#{eid},#{uid})")
    int insert(EmpUser empUser);
    @Select("select * from emp_user")
    List<EmpUser> selectAll();

    @Select("select * from emp_user where uid= #{uid}")
    EmpUser selectById(String uid);
}
