package com.mycat.mybatis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mycat.mybatis.bean.Emp;
import com.mycat.mybatis.mapper.EmpMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wolfcode-lanxw
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Resource
    private EmpMapper empMapper;

    @RequestMapping("/save")
    public String save(@RequestBody Emp emp) {
        Emp emp1 =new Emp();


        empMapper.insert(emp);
        return "保存成功";
    }

    @RequestMapping("/list")
    public Object list() {
        List<Emp> emps = empMapper.selectList(null);

        //page中的1代表当前页，5代表每页条数。要想实现mybatis-plus分页首先需要确定配置了分页插件配置方法如下

        QueryWrapper<Emp> qw=new QueryWrapper<Emp>();
        //直接连着  .  是且的关系。使用 .or()是或者
        qw.in("eid",1,2)
                .or()//或者
          .eq("ename","lili");
       // qw.eq("","");
        Page<Emp> page = new Page<>(1,2);
        IPage<Emp> lstUser = empMapper.selectPage(page, qw);

        return lstUser;
    }


//    HashMap<String, Object> map = new HashMap<>(16);
//        map.put("email", "lqf@163.com");
//        map.put("age", 12);
//
//    Integer insert = mapper.deleteByMap(map);


//    @RequestMapping("/save")
//    public String save(Emp emp) {
//        empMapper.insert(emp);
//        return "保存成功";
//    }
//
//    @RequestMapping("/list")
//    public List<Emp> list() {
//        return empMapper.selectAll();
//    }
//
//    @RequestMapping("/get")
//    public Emp get(@RequestParam("eid") String eid) {
//        return empMapper.selectById(eid);
//    }
//
//    @RequestMapping("/geteu")
//    public Object get() {
//        Object select = empMapper.select();
//        return select;
//    }

}
