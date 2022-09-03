package com.techouts.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techouts.dao.PersonDao;
import com.techouts.dao.ProductDao;
import com.techouts.entities.Cart;
import com.techouts.entities.Person;
import com.techouts.entities.Product;
import com.techouts.services.CartService;
import com.techouts.services.OrderService;
import com.techouts.services.ProductService;

@Controller
@Transactional
public class CartController {

	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;

	@RequestMapping("cart/{id}/{quantity}")
	public ModelAndView cart(@PathVariable("id") int productId, @PathVariable("quantity") int quantity,
			ModelAndView model, HttpSession session) {
		String username = (String) session.getAttribute("name");
		if (username == null) {
			String cartMessage = "Please login!!!";
			model.addObject("cartMessage", cartMessage);
			model.setViewName("login");
			return model;
		} else {
			List<Cart> cartList = cartService.getCartByName(username);
			System.out.println(cartList.size());
			if (!cartList.isEmpty()) {
				Cart cart = cartService.validate(cartList, productId, quantity);
				if (cart != null) {
					cartService.update(cart.getCartId(), quantity);
					String AddtoCartMessage = "Your product added to cart, check cartList/" + "continue shopping";
					model.addObject("AddtoCartMessage", AddtoCartMessage);
					model.setViewName("pdp");
					return model;
				}
			}

	
				Cart newCart = cartService.getCart(username, productId, quantity);
				cartService.save(newCart);

				String AddtoCartMessage = "Your product added to cart, check cartList/" + "continue shopping";
				model.addObject("AddtoCartMessage", AddtoCartMessage);
				model.setViewName("pdp");
				return model;
			
		}
		
	}

	@RequestMapping("/cart")
	public ModelAndView cartDirect(HttpSession session, ModelAndView model) {
		String username = (String) session.getAttribute("name");
		if (username == null) {
			String LoginMessage = "Please login!!!";
			model.addObject("LoginMessage", LoginMessage);
			model.setViewName("login");
			return model;
		} else {
			List<Cart> cartList = cartService.getCartByName(username);
			if (cartList.isEmpty()) {
				String cartEmpty = "Your cart is empty";
				model.addObject("cartEmpty", cartEmpty);
				model.setViewName("cart");
			} else {
				float cartAmount = cartService.getCartAmount(cartList);
				model.addObject("cartAmount", cartAmount);
				model.addObject("cartList", cartList);
				model.setViewName("cart");
			}
		}
		return model;
	}

	@RequestMapping("cart/remove/{cartId}")
	public ModelAndView remove(@PathVariable("cartId") int cartId, HttpSession session, ModelAndView model) {
		Cart cartObj = cartService.getCartById(cartId);
		cartService.deleteCartObj(cartObj);
		String username = (String) session.getAttribute("name");
		List<Cart> cartList = cartService.getCartByName(username);
		float cartAmount = cartService.getCartAmount(cartList);
		model.addObject("cartAmount", cartAmount);
		model.addObject("cartList", cartList);
		model.setViewName("cart");

		return model;
	}
	
	@RequestMapping("/cartPlus/{cartId}/{price}/{quantity}")
	public ModelAndView updateCartPlus(@PathVariable("cartId") int cartId,
			@PathVariable("price") float price,
			@PathVariable("quantity") int quantity,ModelAndView model,
			HttpSession session)
	{
		quantity=quantity+1;
		cartService.updateCart(cartId,price,quantity);
		String username=(String) session.getAttribute("name");
		List<Cart> cartList=cartService.getCartByName(username);
		float cartTotalAmount=cartService.getCartAmount(cartList);
        model.addObject("cartTotalAmount",cartTotalAmount );
		model.addObject("cartList", cartList);
		model.setViewName("cart");
		return model;
		
	}
	
	@RequestMapping("/cartMinus/{cartId}/{price}/{quantity}")
	
	public ModelAndView updateCartMinus(@PathVariable("cartId") int cartId,
			@PathVariable("price") float price,
			@PathVariable("quantity") int quantity,ModelAndView model,
			HttpSession session)
	{
		quantity=quantity-1;
		cartService.updateCart(cartId,price,quantity);
		String username=(String) session.getAttribute("name");
		List<Cart> cartList=cartService.getCartByName(username);
		float cartTotalAmount=cartService.getCartAmount(cartList);
        model.addObject("cartTotalAmount",cartTotalAmount );
		model.addObject("cartList", cartList);
		model.setViewName("cart");
		return model;
		
	}
}
