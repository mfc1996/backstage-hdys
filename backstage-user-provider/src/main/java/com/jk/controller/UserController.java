package com.jk.controller;

import com.jk.PowerBean;
import com.jk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("queryPowerList")
    public List<PowerBean> queryPowerList(Integer pid){
        PowerBean  bean=new PowerBean();
        List<PowerBean> list =getNodes(0);
        return list;
    }
    public List<PowerBean>  getNodes(Integer id){
        List<PowerBean> list =userMapper.queryPowerList(id);
        for (PowerBean bean : list) {
            Integer id1 = bean.getId();
            final List<PowerBean> nodes = getNodes(id1);
            if(nodes.size()!=0){
                bean.setNodes(nodes);
                bean.setSelectable(false);
            }else{
                bean.setSelectable(true);
            }
        }

        return list;
    }
}
