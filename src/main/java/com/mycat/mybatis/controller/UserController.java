package com.mycat.mybatis.controller;

import com.mycat.mybatis.bean.EmpUser;
import com.mycat.mybatis.bean.User;
import com.mycat.mybatis.mapper.EmpUserMapper;
import com.mycat.mybatis.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wolfcode-lanxw
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private EmpUserMapper empUserMapper;

    @RequestMapping("/save")
    public String save(User user) {
        userMapper.insert(user);
        return "保存成功";
    }


    @RequestMapping("/saveeu")
    public String saveeu(EmpUser empUser) {
        empUserMapper.insert(empUser);
        return "保存成功";
    }

    @RequestMapping("/list")
    public List<User> list() {
        return userMapper.selectAll();
    }

    @RequestMapping("/get")
    public User get(@RequestParam("uid") String uid) {
        return userMapper.selectById(uid);
    }

    @RequestMapping("/geteu")
    public Object get() {
        Object select = userMapper.select();


        return select;
    }


}
