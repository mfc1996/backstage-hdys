package com.jk.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("toQueryList")
    public String queryUserLists() {
        return "querylist";
    }
    @RequestMapping("addPro")
    public String addPro() {
        return "addpro";
    }

    @RequestMapping("updatePro")
    public String updatePro() {
        return "updatePro";
    }

}
