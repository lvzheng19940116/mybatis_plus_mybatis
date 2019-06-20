package com.mycat.mybatis.controller;

import com.mycat.mybatis.bean.Emp;
import com.mycat.mybatis.mapper.EmpMapper;
import com.mycat.mybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
 * 创建时间：2019/4/11 上午10:19
 */
@Controller
public class ThymeleafController {
    
    

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpService empService;


    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,Model model) {
        empService.listMaps();


        Emp emp = empMapper.selectByEid(1L);
        request.setAttribute("name","吕正");
        model.addAttribute("users", "郝雪云");
        model.addAttribute("emp", emp);
        return "index";
    }

}
