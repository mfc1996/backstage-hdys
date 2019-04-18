package com.jk.controller;

import com.jk.model.ProBean;
import com.jk.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public HashMap<String,Object> queryProList(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){
        HashMap<String,Object> hash= userServiceFeign.queryProList(page,rows);

        return hash;
    }
//产品列表删除
    @DeleteMapping("delPro/{ids}")
    public void deleteProById(@PathVariable("ids") Integer[] ids){
        userServiceFeign.deleteProById(ids);
    }

    //产品列表新增
    @PostMapping("savePro")
    public void addProList(@RequestBody ProBean proBean){

            userServiceFeign.savePro(proBean);


    }
}
