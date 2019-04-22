package com.jk.mapper;

import com.jk.model.LunBean;
import com.jk.model.ProBean;
import com.jk.model.TypeBean;
import com.jk.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserMapper {

//人员查询条数
    Integer queryCount(@Param("proBean")ProBean proBean);
//人员分页查询
    List<User> queryList(@Param("start") Integer start, @Param("rows") Integer rows,@Param("proBean")ProBean proBean);

    //产品信息查询
    int queryProCount();
   //产品分页查询
    List<User> queryProList(@Param("start") Integer start, @Param("rows") Integer rows);
  //产品列表删除
    void deleteProById(Integer[] ids);
//新增
    void savePro(ProBean proBean);

    void updatestate(Integer id);

    void updState(@RequestParam("ids") Integer[] ids,@RequestParam("productState") Integer productState);

    ProBean findProById(Integer productId);

    void updatePro( ProBean proBean);


    List<TypeBean> findAreaId(Integer pid);

    void saveProType(@RequestParam("typeId") Integer typeId, @RequestParam("productId") int productId);

    void stockUpdate(Integer ids);

    List<LunBean> queryLun();
}
