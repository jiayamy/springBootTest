package com.servant.wiki.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author lijia
 *
 */
@NamedNativeQueries({
	@NamedNativeQuery(
			name = "HqDemo.getDataById",
			query = "SELECT * FROM demo where id = ?1",
			resultSetMapping = "getDataMapping"
			)
})
@SqlResultSetMapping(
		name = "getDataMapping",
		entities = {
				@EntityResult(
						entityClass = HqDemo.class,
						fields = {
								@FieldResult(name = "id", column = "id"),
								@FieldResult(name = "content", column = "content")
						}
						)
		}
		)
@Entity
@Table(name = "demo")
public class HqDemo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String content;
	
	@Transient
	private String content2;
	
	@Transient
	private String addition;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}
	
}
