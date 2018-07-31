package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.UserLoginFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface UserLoginMapper extends BaseMapper{
	public List<UserLoginFormMap> findUserLoginByPage(UserLoginFormMap formMap);
}
