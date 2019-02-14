package com.servant.wiki.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.servant.wiki.core.entity.Demo;

public interface HelloDao {

	public Integer insert(Demo demo);

	public Integer deleteEnrollById(@Param(value = "id") Integer id);

	public List<Demo> selectParam(Map param);
}
