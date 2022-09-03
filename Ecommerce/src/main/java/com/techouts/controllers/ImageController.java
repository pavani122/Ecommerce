package com.techouts.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techouts.entities.Category;
import com.techouts.entities.SlidingImage;
import com.techouts.services.CategoryService;
import com.techouts.services.ImageService;

@Controller
public class ImageController {

	@Autowired
	private ImageService imageService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/manager")
	public String manager() {
		return "manager";
	}

	@RequestMapping("/addImage")
	public String addImage(Model model) {
		SlidingImage image = new SlidingImage();
		model.addAttribute("image", image);
		return "slidingImage";
	}

	@RequestMapping("/save")
	@Transactional
	public String slidingImage(@ModelAttribute("image") SlidingImage image) {
		imageService.save(image);
		return "manager";

	}

	@RequestMapping("/addCategory")
	public String addCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "addCategory";
	}

	@RequestMapping("/saveCategory")
	@Transactional
	public String saveCategory(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		return "manager";

	}

	@RequestMapping("/home")
	public ModelAndView home(ModelAndView model,HttpSession session) {
		List<SlidingImage> images = imageService.getAllImages();
		session.setAttribute("images", images);
		model.addObject("images", images);
		model.setViewName("home");
		List<Category> category=categoryService.getAllCategories();
		session.setAttribute("category", category);
		return model;
	}

	
}
