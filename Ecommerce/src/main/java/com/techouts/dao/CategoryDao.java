package com.techouts.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.techouts.entities.Category;

public class CategoryDao {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void save(Category category) {
		this.template.save(category);
	}

	public List<Category> getAllCategories() {
		
		List<Category> list=this.template.loadAll(Category.class);	
		return list;
	}

}
