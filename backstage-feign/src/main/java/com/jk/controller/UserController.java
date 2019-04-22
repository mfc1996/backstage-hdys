package com.jk.controller;

import com.jk.model.ComBean;
import com.jk.model.LunBean;
import com.jk.model.ProBean;
import com.jk.model.TypeBean;
import com.jk.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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


  //库存量改变
  @PutMapping("stockUp")
    public void stockUpdate(@RequestParam("ids") Integer ids){

    userServiceFeign.stockUpdate(ids);
}
   //评论
   @GetMapping("mongodList")
   @ResponseBody
   public HashMap<String, Object> findBookList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        System.out.println(page);
       return userServiceFeign.mongodList(page,rows);
   }

   //评论新增
  @PostMapping("saveMongod")
   public void saveMongod(@RequestBody ComBean comBean) {
        comBean.setTypeId(1);
        comBean.setTypeName("ssss");
        comBean.setCommentInfo("很好，经济实惠");
        comBean.setCommentTime(new Date());
       userServiceFeign.saveMongod(comBean);
   }

   //轮播图查询
    @GetMapping("queryLunList")
    @ResponseBody
    public List<LunBean> queryLun(){
        return userServiceFeign.queryLun();
    }
}
