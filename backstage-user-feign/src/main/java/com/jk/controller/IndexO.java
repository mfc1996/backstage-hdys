package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexO {
    @RequestMapping("index")
    public String index(){
        return  "main";
    }
}
