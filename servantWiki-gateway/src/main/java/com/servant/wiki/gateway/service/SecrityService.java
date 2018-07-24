package com.servant.wiki.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servant.wiki.gateway.dao.SecrityDao;
import com.servant.wiki.gateway.entity.Secrity;

@Service
public class SecrityService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SecrityDao secrityDao;
	
	public Secrity getSecrity(Integer id){
		return secrityDao.findOne(id);
	}
}
