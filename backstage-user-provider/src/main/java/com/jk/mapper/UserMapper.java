package com.jk.mapper;

import com.jk.PowerBean;

import java.util.List;

public interface UserMapper {
    public List<PowerBean> queryPowerList(Integer id);
}
