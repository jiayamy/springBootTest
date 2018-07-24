package com.servant.wiki.gateway.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servant.wiki.gateway.entity.Secrity;

@Transactional(rollbackOn=Exception.class)
@Repository
public interface SecrityDao extends JpaRepository<Secrity, Integer>{

}
