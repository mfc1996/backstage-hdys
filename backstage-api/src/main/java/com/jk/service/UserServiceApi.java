package com.jk.service;

import com.jk.model.PowerBean;
import com.jk.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public interface UserServiceApi {
    //查询左侧树
    @GetMapping(value  ="/queryPowerList")  //@RequestMapping(value = "/hi",method = RequestMethod.GET)  查询
    List<PowerBean> queryPowerList(@RequestParam("id") Integer id);
    //查询权限树
    @GetMapping(value  ="/queryRolePowerByRoleId")  //@RequestMapping(value = "/hi",method = RequestMethod.GET)  查询
    List<PowerBean> queryRolePowerByRoleId(@RequestParam("roleId") Integer roleId);


    //查询所有用户
    @PostMapping(value  ="/queryUserList")  //@RequestMapping(value = "/hi",method = RequestMethod.GET)  查询
    HashMap<String,Object> queryUserList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestBody User user);
    //删除用户
    @DeleteMapping(value  ="/deleteManyUser")  //@RequestMapping(value = "/hi",method = RequestMethod.GET)  查询
    void deleteManyUser(@RequestParam("ids") String[] ids);
    //查询用户通过用户名
    @GetMapping(value  ="/queryUserByName")
    User queryUserByName(@RequestParam("username") String username);
    //查找用户的角色权限通过用户名
    @GetMapping(value  ="/queryRolePowerByUserName")
    List<String> queryRolePowerByUserName(@RequestParam("userCode")String userCode);


    //查询角色
    @PostMapping(value  ="/queryRoleList")
    HashMap<String, Object> queryRoleList(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);
    //删除角色
    @DeleteMapping(value  ="/deleteManyRole")  //@RequestMapping(value = "/hi",method = RequestMethod.GET)  查询
    void deleteManyRole(@RequestParam("ids")String[] ids);
       //修改用户角色通过角色id和用户id
    @PutMapping("updateUserRoleByUserIdAndRoleId")
    void updateUserRoleByUserIdAndRoleId(@RequestParam("roleId")Integer roleId,@RequestParam("userId") Integer userId);
    @PutMapping("updateRolePowerByRoleIdAndPowerIds")
    void updateRolePowerByRoleIdAndPowerIds(@RequestParam("powerIds")Integer[] powerIds,@RequestParam("roleId") Integer roleId);


}
