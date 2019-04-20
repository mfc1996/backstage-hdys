package com.jk.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("page")
public class PageController {
    @RequestMapping("toMain")
    public String toMain(){
      return "main";
    }

    @RequestMapping("toUser")
    @RequiresPermissions("admin:query")
    public String toUser(){
      return "user";
    }
    @RequiresPermissions("admin:query")
    @RequestMapping("toRole")
    public String toRole(){
      return "role";
    }
    @RequestMapping("notPower")
    public String notPower(){
      return "notPower";
    }

    @RequestMapping("openUserGetRole")
    public String openUserGetRole(){
      return "getRole";
    }
    @RequestMapping("getPower")
    public String getPower(){
      return "getPower";
    }
    /**
     *设置拦截跳转的页面
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request, Model model){
        String msg="";
        ////获得验证的异常信息的名称，提示用户是账号错误还是密码错误
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equals(exceptionClassName)|| AuthenticationException.class.getName().equals(exceptionClassName)){
            model.addAttribute("message","账号错误或不存在：");

        }else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            model.addAttribute("message","密码错误");
        }
        //登录失败之后 再跳转回登录页面
        //访问其他页面时 只要不是登录成功状态 都会跳转到登录页面
        return "login";
    }
}
