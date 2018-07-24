package com.servant.wiki.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servant.wiki.gateway.dao.ConfigDao;
import com.servant.wiki.gateway.entity.Config;

@Service
public class ConfigService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ConfigDao configDao;
	
	public Config getConfig(Integer id){
		return configDao.findOne(id);
	}
}
