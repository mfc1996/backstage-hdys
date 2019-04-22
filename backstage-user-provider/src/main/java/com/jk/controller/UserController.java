package com.jk.controller;

import com.jk.model.OrderBean;
import com.jk.model.PowerBean;
import com.jk.model.RoleBean;
import com.jk.model.User;
import com.jk.mapper.UserMapper;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController implements UserServiceApi {
    @Autowired
    private UserMapper userMapper;
    /**
     *
     *左侧树展示
     */
    @GetMapping("queryPowerList")
    public List<PowerBean> queryPowerList(Integer id){
        PowerBean  bean=new PowerBean();
        List<PowerBean> list =getNodes(0,id);
        return list;
    }

    /**
     *
     *角色的权限展示
     */
    @Override
    public List<PowerBean> queryRolePowerByRoleId(Integer roleId) {
          List<Integer> list2=userMapper.getRolePower(roleId);
        System.out.println(list2);

        Integer aa=0;
        System.out.println("============================================================");
        List<PowerBean> list=getPowerNodes(aa,list2);
        System.out.println(list);
        return list;
    }

    private List<PowerBean> getPowerNodes(Integer id,List<Integer> list2) {
        List<PowerBean> list=userMapper.queryRolePowerByRoleId(id);
        for(PowerBean bean:list){
            int  id2=bean.getId();
            List<PowerBean> nodes= getPowerNodes(id2,list2);
                bean.setChildren(nodes);
            for(Integer b:list2){
                if(id2==b&&nodes.size()==0){
                    bean.setChecked(true);
                }
            }

        }
        return list;
    }

    /**
     *
     *获取树的子节点并返回
     */
    public List<PowerBean>  getNodes(Integer id, Integer userId){
        List<PowerBean> list =userMapper.queryPowerList(id,userId);
        for (PowerBean bean : list) {
            Integer id1 = bean.getId();
            final List<PowerBean> nodes = getNodes(id1, userId);
            if(nodes.size()!=0){
                bean.setNodes(nodes);
                bean.setSelectable(false);
            }else{
                bean.setSelectable(true);
            }
        }

        return list;
    }
    /**
     *
     *用户展示
     */
    @PostMapping("queryUserList")
   public HashMap<String,Object>    queryUserList(Integer page, Integer rows, @RequestBody User user){
        System.out.println("77========================================================================");
       HashMap<String,Object> map=new HashMap<>();
       map.put("user",user);
       //查询用户的数量
       Integer userCount=userMapper.getUserCount(map);
       System.out.println(userCount);
       //计算开始条数
       Integer start=(page-1)*rows;
       map.put("start",start);
       //放入每页条数
       map.put("rows",rows);
       List< User> list=userMapper.queryUserList(map);
        System.out.println(list);
       //将数据放到map中返回
       map.put("total",userCount);
       map.put("rows",list);

      return  map;
    }
    /**
     * 查找用户通过用户账号
     */
    @Override
    public User queryUserByName(String username) {
        User user = userMapper.queryUserByName(username);
        return user;
    }
    //通过用户名查找用户的角色权限
    @Override
    public List<String> queryRolePowerByUserName(String userCode) {
        return userMapper.queryRolePowerByUserName(userCode);
    }

    /**
     * 删除用户列表 通过ids
     * @param ids
     */
    @Override
    public void deleteManyUser(String[] ids) {
        userMapper.deleteManyUser(ids);
    }

    /**
     *
     *查找角色
     */
    @Override
    public HashMap<String, Object> queryRoleList(Integer page, Integer rows) {
        HashMap<String,Object> map=new HashMap<>();
        //查询角色的数量
        Integer roleCount=userMapper.getRoleCount(map);
        System.out.println(roleCount);
        //计算开始条数
        Integer start=(page-1)*rows;
        map.put("start",start);
        //放入每页条数
        map.put("rows",rows);
        List<RoleBean> list=userMapper.queryRoleList(map);
        System.out.println(list);
        //将数据放到map中返回
        map.put("total",roleCount);
        map.put("rows",list);
            return map;
    }
    /**
     * 删除角色
     */
    @Override
    public void deleteManyRole(String[] ids) {
         userMapper.deleteManyRole(ids);
    }

    @Override
    public void updateUserRoleByUserIdAndRoleId(Integer roleId, Integer userId) {
        userMapper.updateUserRoleByUserIdAndRoleId(roleId,userId);
    }

    @Override
    public void updateRolePowerByRoleIdAndPowerIds(Integer[] powerIds, Integer roleId) {
        userMapper.deleteRolePower(roleId);
        userMapper.addRolePowers(roleId,powerIds);


    }

    @Override
    public HashMap<String, Object> queryOrderList(Integer page, Integer rows,  @RequestBody OrderBean order) {
        System.out.println("77========================================================================");
        HashMap<String,Object> map=new HashMap<>();
        map.put("user",order);
        //查询用户的数量
        Integer userCount=userMapper.getOrderCount(map);
        System.out.println(userCount);
        //计算开始条数
        Integer start=(page-1)*rows;
        map.put("start",start);
        //放入每页条数
        map.put("rows",rows);
        List< User> list=userMapper.queryOrderList(map);
        System.out.println(list);
        //将数据放到map中返回
        map.put("total",userCount);
        map.put("rows",list);

        return  map;
    }
   //删除订单
    @Override
    public void deleteManyOrder(String[] ids) {
        userMapper.deleteManyOrder(ids);

    }
    //修改订单的状态 由未发货到待收货
    @Override
    public void updateOrderStatus(String id) {

       userMapper.updateOrderStatus(id);
    }


}
