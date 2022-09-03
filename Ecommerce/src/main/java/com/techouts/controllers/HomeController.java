package com.techouts.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
import com.techouts.entities.Cart;
import com.techouts.entities.Person;
import com.techouts.services.CartService;
import com.techouts.services.PersonService;

@Controller
public class HomeController {

	@Autowired
	PersonService service;
	@Autowired
	CartService cartService;
	Person person = new Person();

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("person", person);
		return "register";
	}

	@RequestMapping("/registered")
	@Transactional
	public ModelAndView registered(@Valid @ModelAttribute("person") Person person,BindingResult result) {
		ModelAndView model=new ModelAndView();
		model.addObject(person);
	    System.out.println(person.getEmail());
		int num = service.ifRegistered(person.getEmail());
		System.out.println(num);
		if(result.hasErrors())
		{
			model.addObject("model", model);
			model.setViewName("register");
			return  model;
		}
			
			if (num == 1) {
				String message = "User already registered with this email";
				model.addObject("message", message);
				model.setViewName("login");
				return  model;
				
			}
			service.save(person);
			model.setViewName("registered");
			return  model;
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/welcome")
	@Transactional
	public String welcome(@RequestParam("name") String name, @RequestParam("password") String password, Model model,
			HttpSession session) {

		List<Person> list = service.getPersonByName(name);
		System.out.println(list.size());
		if (list.isEmpty()) {
			String notRegistered = "Need to register first";
			model.addAttribute("notRegistered", notRegistered);
			Person person = new Person();
			model.addAttribute("person", person);

			return "register";

		}
		for (Person person : list) {
			if (person.getName().equalsIgnoreCase(name) && person.getPassword().equals(password)) {
				model.addAttribute("name", name);
				session.setAttribute("name", name);
				return "home";
			}
		}
		String error = "Password wrong, try again!!!";
		model.addAttribute("error", error);
		return "login";

	}

	@RequestMapping("/main")
	public String main(HttpSession session) {
		return "home";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {

		session.removeAttribute("name");
		session.removeAttribute("cartId");
		return "home";
	}

}
