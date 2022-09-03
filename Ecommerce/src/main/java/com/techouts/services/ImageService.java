package com.techouts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.dao.ImageDao;
import com.techouts.entities.SlidingImage;

@Service
public class ImageService {

	@Autowired
	private ImageDao imageDao;
	
	public void save(SlidingImage image)
	{
		imageDao.save(image);
	}
	
	public List<SlidingImage> getAllImages()
	{
	List<SlidingImage> list=imageDao.getAllImages();
    return list;
	}
}
