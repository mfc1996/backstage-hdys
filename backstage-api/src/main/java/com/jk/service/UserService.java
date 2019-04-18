package com.jk.service;

import com.jk.model.ProBean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


public interface UserService {

    @GetMapping("queryUserList")
    @ResponseBody
    HashMap<String, Object> queryList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @GetMapping("queryProList")
    @ResponseBody
    HashMap<String, Object> queryProList(@RequestParam("page")Integer page,@RequestParam("rows") Integer rows);

    @DeleteMapping("delPro/{ids}")
    @ResponseBody
    void deleteProById(@PathVariable("ids") Integer[] ids);

   @PostMapping("savePro")
    void savePro(ProBean proBean);
}
