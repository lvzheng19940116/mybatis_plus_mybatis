package com.mycat.mybatis.mapper;

import com.mycat.mybatis.bean.User;
import com.mycat.mybatis.bean.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wolfcode-lanxw
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(uid,uname) value (#{uid},#{uname})")
    int insert(User user);
    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where uid= #{uid}")
    User selectById(String uid);


    @Select("select u.uid,u.uname,e.id from user u left join emp_user e on u.uid=e.id")
    List<UserDTO> select();

}
