package com.jk.controller;

import com.jk.model.ProBean;
import com.jk.model.TypeBean;
import com.jk.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping("queryUserList")
    public HashMap<String,Object> queryList(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestBody ProBean proBean){
        return userServiceFeign.queryList(page,rows,proBean);
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

    //产品批量上架
    @PutMapping("updstate1")
    public void updState(@RequestParam("ids") Integer[] ids ,@RequestParam("productState") Integer productState){
        userServiceFeign.updState(ids,productState);
    }
    @GetMapping("findProById")
    public ProBean findProById( Integer productId){
        ProBean pro=userServiceFeign.findProById(productId);
        return pro;
    }

    @PutMapping("updatePro")
    @ResponseBody
    public void updatePro(@RequestBody ProBean proBean){
        userServiceFeign.updatePro(proBean);
    }

  @GetMapping("findAreaId")
    @ResponseBody
    public List<TypeBean> findAreaId(@RequestParam("pid") Integer pid){
        return userServiceFeign.findAreaId(pid);
  }


}
