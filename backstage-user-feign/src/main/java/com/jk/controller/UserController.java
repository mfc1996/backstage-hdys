package com.jk.controller;

import com.jk.model.PowerBean;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * 左侧树的展示
     */
    @GetMapping("/queryPowerList")
    public List<PowerBean> queryPowerList(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null){
           user= new User();
           user.setUserId(7);
        }

        List<PowerBean> list = userService.queryPowerList(user.getUserId());

        return list;
    }
    /**
     *
     * //角色的权限展示
     */
    @GetMapping("/queryRolePowerByRoleId")
    public List<PowerBean> queryRolePowerByRoleId(Integer roleId){
        if(roleId==null){
            roleId=-1;
        }
        List<PowerBean> list = userService.queryRolePowerByRoleId(roleId);

        return list;
    }
    //修改角色的权限
    @PutMapping("updateRolePowerByRoleIdAndPowerIds")
    public  Boolean updateRolePowerByRoleIdAndPowerIds(Integer[] powerIds,Integer roleId){
        try {
            userService.updateRolePowerByRoleIdAndPowerIds(powerIds,roleId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     *
     * 用户的展示
     */

    @GetMapping("/queryUserList")
    @ResponseBody
    public HashMap<String,Object> queryUserList( Integer page, Integer rows,User user){
        HashMap<String,Object> list = userService.queryUserList(page,rows,user);

        return list;
    }
    /**
     *
     * 删除角色
     */
    @GetMapping("deleteManyRole")
    @ResponseBody
    public Boolean deleteManyRole( String[] ids){
        try {
            userService.deleteManyRole(ids);
            System.out.println(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     *
     * 修改用户的角色
     */
    @PutMapping("updateUserRoleByUserIdAndRoleId")
    @ResponseBody
    public Boolean updateUserRoleByUserIdAndRoleId(Integer roleId,Integer userId){
        try {
            userService.updateUserRoleByUserIdAndRoleId(roleId,userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     *
     * 删除用户
     */
    @GetMapping("deleteManyUser")
    @ResponseBody
    public Boolean deleteManyUser( String[] ids){
        try {
            userService.deleteManyUser(ids);
            System.out.println(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     *
     * 角色的展示
     */
    @GetMapping("/queryRoleList")
    @ResponseBody
    public HashMap<String,Object> queryRoleList( Integer page, Integer rows){
        if(page==null||page==0){
            page=1;
        }
        if(rows==null||rows<=0){
            rows=7;
        }
        HashMap<String,Object> list = userService.queryRoleList(page,rows);

        return list;
    }


}