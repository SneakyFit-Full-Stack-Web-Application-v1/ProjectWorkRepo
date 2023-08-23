package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojo.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {
	
	public Category findByName(String name);
	
	@Query("select c from Category c where c.name=:name and c.parentCategory.name=:parentCategoryName")
	public Category findByNameAndParant(@Param("name") String name, @Param("parentCategoryName")String parentCategoryName);
	

}
