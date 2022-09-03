package com.techouts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.dao.CategoryDao;
import com.techouts.entities.Category;
import com.techouts.entities.SlidingImage;
@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public void save(Category category) {
		categoryDao.save(category);
	}
	
	public List<Category> getAllCategories()
	{
	List<Category> list=categoryDao.getAllCategories();
    return list;
	}

	
	
}
