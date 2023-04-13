package com.hry.demo.controller;

import com.hry.demo.mapper.DepartMentMapper;
import com.hry.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DepartMentMapper departMentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("query")
    public Map<String, Object> query(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM department");
        return list.get(0);
    }

    @GetMapping("dept/{id}")
    public String queryDeptById(@PathVariable("id") Integer id){
        return departMentMapper.getDeptById(id).toString();
    }

    @GetMapping("emp/{id}")
    public String queryEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id).toString();
    }

    @RequestMapping("/testSentinel")
    public void testSentinel () {
        int i = 1;
        while (true) {
            try {
                stringRedisTemplate.opsForValue().set("zming" + i, i + "rong");
                System.out.println("设置key:zming" + i);
                i++;
                Thread.sleep(1000);
            } catch (Exception e) {
                e.getLocalizedMessage();
            }
        }
    }
}
