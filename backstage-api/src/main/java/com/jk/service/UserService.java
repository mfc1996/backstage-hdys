package com.jk.service;

import com.jk.model.ProBean;
import com.jk.model.TypeBean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


public interface UserService {

    @GetMapping("queryUserList")
    @ResponseBody
    HashMap<String, Object> queryList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestBody ProBean proBean);

    @GetMapping("queryProList")
    @ResponseBody
    HashMap<String, Object> queryProList(@RequestParam("page")Integer page,@RequestParam("rows") Integer rows);

    @DeleteMapping("delPro/{ids}")
    @ResponseBody
    void deleteProById(@PathVariable("ids") Integer[] ids);

   @PostMapping("savePro")
    void savePro(ProBean proBean);


    @PutMapping("updstate1")
    void updState(@RequestParam("ids")Integer[] ids,@RequestParam("productState")Integer productState);

   @GetMapping("findProById")
   @ResponseBody
    ProBean findProById(@RequestParam("productId") Integer productId);

   @PutMapping("updatePro")
   @ResponseBody
    void updatePro( ProBean proBean);

   @GetMapping("productId")
   @ResponseBody
    List<TypeBean> findAreaId(@RequestParam("pid") Integer pid);

}
