package com.jk.mapper;

import com.jk.model.ProBean;
import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

//人员查询条数
    Integer queryCount();
//人员分页查询
    List<User> queryList(@Param("start") Integer start, @Param("rows") Integer rows);

    //产品信息查询
    int queryProCount();
   //产品分页查询
    List<User> queryProList(@Param("start") Integer start, @Param("rows") Integer rows);
  //产品列表删除
    void deleteProById(Integer[] ids);
//新增
    void savePro(ProBean proBean);

}
