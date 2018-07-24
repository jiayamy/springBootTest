package com.servant.wiki.gateway.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servant.wiki.gateway.entity.Config;

@Transactional(rollbackOn=Exception.class)
@Repository
public interface ConfigDao extends JpaRepository<Config, Integer>{

}
