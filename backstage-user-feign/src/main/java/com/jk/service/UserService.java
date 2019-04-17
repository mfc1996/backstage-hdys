package com.jk.service;

import com.jk.PowerBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "SERVICE-PROVIDER")
public interface UserService {
    @GetMapping(value  ="/queryPowerList")  //@RequestMapping(value = "/hi",method = RequestMethod.GET)  查询
    List<PowerBean> queryPowerList();
}
