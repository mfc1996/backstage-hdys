package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserMapper {

//人员查询条数
    Integer queryCount();
//人员分页查询
    List<User> queryList(@Param("page") Integer page, @Param("rows") Integer rows);

    //产品信息查询
    Integer queryProCount();
   //产品分页查询
    List<User> queryProList(@RequestParam("start") Integer start, @RequestParam("rows") Integer rows);
}
