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

}