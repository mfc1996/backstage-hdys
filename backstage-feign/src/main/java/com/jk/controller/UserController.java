package com.jk.controller;

import com.jk.model.ProBean;
import com.jk.model.User;
import com.jk.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping("queryUserList")
    public HashMap<String,Object> queryList(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){
        return userServiceFeign.queryList(page,rows);
    }

    @GetMapping("queryProList")
    public HashMap<String,Object> queryProList( Integer page, Integer rows){
        HashMap<String,Object> hash= userServiceFeign.queryProList(page,rows);

        return hash;
    }

}
