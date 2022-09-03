package com.techouts.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.techouts.entities.SlidingImage;

public class ImageDao {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void save(SlidingImage image)
	{
		this.template.save(image);
	}
	
	public List<SlidingImage> getAllImages()
	{
		List<SlidingImage> list=this.template.loadAll(SlidingImage.class);
		return list;
	}
}
