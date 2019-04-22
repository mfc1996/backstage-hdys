package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserServiceImpl implements UserService{
    @Autowired
    protected UserMapper userMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @ResponseBody
    public HashMap<String, Object> queryList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestBody ProBean proBean) {
        HashMap<String ,Object> hashMap=new HashMap<>();
        //查询总条数
        Integer count=userMapper.queryCount(proBean);
        //分页查询
        Integer start=(page-1)*rows;
        List<User> list=userMapper.queryList(page,rows,proBean);
        hashMap.put("total",start);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    @ResponseBody
    public HashMap<String, Object> queryProList(@RequestParam("page")Integer page,  @RequestParam("rows")Integer rows) {
        String key ="keys"+"1";
        HashMap<String ,Object> hashMap=new HashMap<>();
        //查询总条数
        int count=userMapper.queryProCount();
        //分页查询
        int start=(page-1)*rows;
        List<User> list=userMapper.queryProList(start,rows);
        hashMap.put("total",count);
        hashMap.put("rows",list);
        redisTemplate.opsForList().leftPush(key,hashMap);
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
       int productId = proBean.getProductId();

        userMapper.saveProType(proBean.getTypeId(),productId);
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

    @Override
    @ResponseBody
    public List<TypeBean> findAreaId(@RequestParam("pid")Integer pid) {
        return userMapper.findAreaId(pid);
    }

    @Override
    public void stockUpdate(@RequestParam("ids") Integer ids) {
        userMapper.stockUpdate(ids);
    }

    @ResponseBody
    @Override
    public HashMap<String, Object> mongodList(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        HashMap<String,Object> hashMap=new HashMap<>();
        Query query = new Query();
        //查询总条数
        long count = mongoTemplate.count(query, ComBean.class);
        //查询分页
        //计算开始条数
        int start = (page-1)*rows;
        query.skip(start).limit(rows);


        List<ComBean> list = mongoTemplate.find(query, ComBean.class);
        hashMap.put("total", count);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public void saveMongod(@RequestBody ComBean comBean) {
        mongoTemplate.save(comBean);
    }

    @Override
    public List<LunBean> queryLun() {
        return userMapper.queryLun();
    }


}
