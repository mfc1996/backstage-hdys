package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserServiceImpl implements UserService {
   @Autowired
    private UserMapper userMapper;

    @Override
    @ResponseBody
    public HashMap<String, Object> queryList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        HashMap<String ,Object> hashMap=new HashMap<>();
        //查询总条数
        Integer count=userMapper.queryCount();
        //分页查询
        Integer start=(page-1)*rows;
        List<User> list=userMapper.queryList(page,rows);
        hashMap.put("tobal",start);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    @ResponseBody
    public HashMap<String, Object> queryProList(@RequestParam("page")Integer page,  @RequestParam("rows")Integer rows) {
        HashMap<String ,Object> hashMap=new HashMap<>();
        //查询总条数
        Integer count=userMapper.queryProCount();
        //分页查询
        Integer start=(page-1)*rows;
        List<User> list=userMapper.queryProList(start,rows);
        hashMap.put("tobal",count);
        hashMap.put("rows",list);
        return hashMap;
    }
}
