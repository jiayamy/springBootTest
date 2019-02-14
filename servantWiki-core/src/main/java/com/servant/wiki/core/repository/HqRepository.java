package com.servant.wiki.core.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servant.wiki.core.entity.HqDemo;

/**
 * 
 * @author lijia
 *
 */
@Transactional(rollbackOn=Exception.class)
@Repository
public interface HqRepository extends JpaRepository<HqDemo, Integer>{

//	@Query(value = "getData")
//	List<HqDemo> getData();
}
