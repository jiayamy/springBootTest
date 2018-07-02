package com.servant.wiki.core.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servant.wiki.core.entity.Demo;

/**
 * 
 * @author lijia
 *
 */
@Transactional(rollbackOn=Exception.class)
@Repository
public interface HelloDao extends JpaRepository<Demo, Integer>, JpaSpecificationExecutor<Demo>{
	
	
	/**
	 * 模糊查询content
	 * @param content
	 * @return
	 */
	@Query(" from Demo where content like %?1%")
	List<Demo> findListByContent(String content);
}
