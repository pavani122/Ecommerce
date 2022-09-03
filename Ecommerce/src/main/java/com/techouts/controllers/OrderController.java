package com.techouts.controllers;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techouts.entities.Cart;
import com.techouts.entities.OrdersData;
import com.techouts.entities.Product;
import com.techouts.services.CartService;
import com.techouts.services.OrderService;
import com.techouts.services.ProductService;

@Controller
@Transactional
public class OrderController {

	@Autowired
	ProductService productService;
	@Autowired
	CartService cartService;
	@Autowired
	OrderService orderService;
	
	
	
	@RequestMapping("/cartBuy")
	public ModelAndView buy(ModelAndView model,HttpSession session)
	{
		String paymentMessage="Your payment successfull";
		model.addObject("paymentMessage", paymentMessage);
		String username=(String) session.getAttribute("name");
        List<Cart> cartList= cartService.getCartByName(username);
        cartService.getOrder(cartList);
		cartService.deleteAll(cartList);
		model.setViewName("buy");
		return model;	
	}
	
	@RequestMapping("/buy/{productId}/{quantity}")
	public ModelAndView buyFromPdp(@PathVariable("productId") int productId,
			@PathVariable("quantity") int quantity,ModelAndView model,HttpSession session)
	{
		String username = (String) session.getAttribute("name");
		if (username == null) {
			String LoginMessage = "Please login!!!";
			model.addObject("LoginMessage", LoginMessage);
			model.setViewName("login");
			return model;
		}
		String paymentMessage="Your payment successfull";
		model.addObject("paymentMessage", paymentMessage);
		orderService.saveOrderData(username,productId,quantity);
		model.addObject("paymentMessage", paymentMessage);
		model.setViewName("buy");
		return model;
		
	}
	
	@RequestMapping("/order")
	public ModelAndView orders(ModelAndView model,HttpSession session)
	{
		String username=(String) session.getAttribute("name");
		List<OrdersData> orderList=orderService.getCartByName(username);
		model.addObject("orderList", orderList);
		model.setViewName("orders");
		return model;	
	}
	
	@RequestMapping("order/remove/{orderId}/{productId}")
	public ModelAndView remove(@PathVariable("orderId") int orderId,@PathVariable("productId") int productId,
			HttpSession session,ModelAndView model)
	{
		OrdersData orderObj=orderService.getOrderById(orderId);
		orderService.deleteOrderObj(orderObj);
		
		int quantity=orderObj.getQuantity();
		String username=orderObj.getUsername();
		
		Cart cart=cartService.getCart(username, productId, quantity);
		cartService.save(cart);
		String name=(String) session.getAttribute("name");
		List<OrdersData> orderList=orderService.getCartByName(username);
		model.addObject("orderList", orderList);
		model.setViewName("orders");
		return model;
	}
	
	
}
