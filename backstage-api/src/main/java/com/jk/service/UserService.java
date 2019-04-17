package com.jk.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


public interface UserService {

    @GetMapping("queryUserList")
    @ResponseBody
    HashMap<String, Object> queryList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @GetMapping("queryProList")
    @ResponseBody
    HashMap<String, Object> queryProList(@RequestParam("page")Integer page,@RequestParam("rows") Integer rows);
}
