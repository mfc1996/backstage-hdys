package com.jk.service;


import com.jk.model.LunBean;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value = "SERVICE-PROVIDER")
public interface UserServiceFeign extends UserService{



}
