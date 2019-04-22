package com.jk.mapper;

import com.jk.model.PowerBean;
import com.jk.model.RoleBean;
import com.jk.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    //用户表
    public List<PowerBean> queryPowerList(@RequestParam("id") Integer id, @RequestParam("userId") Integer userId);
    Integer getUserCount(HashMap<String, Object> map);
    List<User> queryUserList(HashMap<String,Object > map);
    void deleteManyUser(String[] ids);
    //根据用户账号查找用户
    User queryUserByName(String username);
    //通过用户名查找用户的角色权限
    List<String> queryRolePowerByUserName(String userCode);
    //修改用户的角色
    void updateUserRoleByUserIdAndRoleId(@RequestParam("roleId") Integer roleId,@RequestParam("userId") Integer userId);

    //角色表
    Integer getRoleCount(HashMap<String, Object> map);
    List<RoleBean> queryRoleList(HashMap<String, Object> map);
    //删除角色
    void deleteManyRole(String[] ids);
    //通过角色获得权限
    List<Integer> getRolePower(Integer roleId);
    //修改角色权限通过角色
    List<PowerBean> queryRolePowerByRoleId(int id);
    //删除角色的权限
    void deleteRolePower(Integer roleId);

    void addRolePowers(@RequestParam("roleId") Integer roleId, @RequestParam("powerIds") Integer[] powerIds);
    //查询订单数量
    Integer getOrderCount(HashMap<String, Object> map);
    //查询订单
    List<User> queryOrderList(HashMap<String, Object> map);
    //修改订单的状态
    void updateOrderStatus(String id);
    //批量删除订单
    void deleteManyOrder(String[] ids);
}
