package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.ProBean;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserServiceImpl implements UserService {
    @Autowired
    protected UserMapper userMapper;

    @Override
    @ResponseBody
    public HashMap<String, Object> queryList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        HashMap<String ,Object> hashMap=new HashMap<>();
        //查询总条数
        Integer count=userMapper.queryCount();
        //分页查询
        Integer start=(page-1)*rows;
        List<User> list=userMapper.queryList(page,rows);
        hashMap.put("total",start);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    @ResponseBody
    public HashMap<String, Object> queryProList(@RequestParam("page")Integer page,  @RequestParam("rows")Integer rows) {
        HashMap<String ,Object> hashMap=new HashMap<>();
        //查询总条数
        int count=userMapper.queryProCount();
        //分页查询
        int start=(page-1)*rows;
        List<User> list=userMapper.queryProList(start,rows);
        hashMap.put("total",count);
        hashMap.put("rows",list);
        return hashMap;
    }

    //产品列表删除
    @Override
    @ResponseBody
    public void deleteProById(Integer[] ids) {
        userMapper.deleteProById(ids);
    }

    @Override
    @ResponseBody
    public void savePro(@RequestBody ProBean proBean) {
        userMapper.savePro(proBean);
    }


    @Override
    @ResponseBody
    public void updState(@RequestParam("ids") Integer[] ids,@RequestParam("productState") Integer productState) {
        userMapper.updState(ids,productState);
    }

    @Override
    @ResponseBody
    public ProBean findProById(@RequestParam("productId") Integer productId) {
        return userMapper.findProById(productId);
    }

    @Override
    @ResponseBody
    public void updatePro(@RequestBody ProBean proBean) {
        userMapper.updatePro(proBean);
    }


}
