package com.techouts.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techouts.entities.Product;
import com.techouts.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/addproduct")
	public String addProduct(Model model)
	{
		Product product=new Product();
		model.addAttribute("product", product);
		return "productData";
	}
	
	@RequestMapping("/submit")
	@Transactional
	public String productData(@ModelAttribute("product") Product product)
	{
		productService.save(product);
		return "home";
		
	}
    
	@RequestMapping("/plp/{categoryname}")
	public ModelAndView category(@PathVariable("categoryname") String categoryname,ModelAndView model,HttpSession session)
	{
		List<Product> list =productService.getProductByCategory(categoryname);
		System.out.println(list.size());
		model.addObject("list",list);
		model.addObject("categoryname", categoryname);
		model.setViewName("plp");
		return model;
	}
	
	@RequestMapping("/plp/pdp/{id}")
	public ModelAndView pdp(@PathVariable("id") int id,ModelAndView model,HttpSession session)
	{
		Product productData=productService.getProductById(id);
		model.addObject("productData",productData);
		session.setAttribute("productData", productData);
		int quantity=1;
		model.addObject("quantity", quantity);
		model.setViewName("pdp");
		return model;	
	}
	
	@RequestMapping("/minus/{quantity}")
	public ModelAndView quantityMinus(@PathVariable("quantity") int quantity,ModelAndView model
			,HttpSession session)
	{
		String username = (String) session.getAttribute("name");
		if (username == null) {
			String LoginMessage = "Please login!!!";
			model.addObject("LoginMessage", LoginMessage);
			model.setViewName("login");
			return model;
		}
		quantity=quantity-1;
		model.addObject("quantity", quantity);
		Product productData=(Product)session.getAttribute("productData");
		model.addObject("productData", productData);
		model.setViewName("pdp");
		return model;
		
	}
	
	@RequestMapping("/plus/{quantity}")
	public ModelAndView quantityPlus(@PathVariable("quantity") int quantity,
			ModelAndView model,HttpSession session)
	{
		String username = (String) session.getAttribute("name");
		if (username == null) {
			String LoginMessage = "Please login!!!";
			model.addObject("LoginMessage", LoginMessage);
			model.setViewName("login");
			return model;
		}
		quantity=quantity+1;
		model.addObject("quantity", quantity);
		Product productData=(Product)session.getAttribute("productData");
		model.addObject("productData", productData);
		model.setViewName("pdp");
		return model;
		
	}
}
