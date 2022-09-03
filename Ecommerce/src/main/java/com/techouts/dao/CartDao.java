package com.techouts.dao;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.techouts.entities.Cart;
import com.techouts.entities.OrdersData;
import com.techouts.entities.Person;
import com.techouts.entities.Product;
import com.techouts.services.ProductService;

public class CartDao {

	
	private HibernateTemplate template;	
	@Autowired
	private ProductDao productDao;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public int save(Cart cart) {
		int i=(int) this.template.save(cart);
		return i;
	}

	

	public List<Cart> getCartByName(String username) {

		String query="from Cart where username= :username";
		List<Cart> cart=(List<Cart>) this.template.findByNamedParam(query, "username", username);
		
		return cart;
	}

	public List<Cart> loadAll() {
		
		List<Cart> cartList=this.template.loadAll(Cart.class);
		
		return cartList;
	}

	
	public Cart getCartById(int cartId) {
		Cart cart=this.template.get(Cart.class, cartId);
		return cart;
	}

	public Cart getCart(String username, int productId, int quantity) {
		
		Cart cart=new Cart();
		cart.setUsername(username);
		cart.setProductId(productId);
		Product productData=productDao.getProductById(productId);
		cart.setProductName(productData.getProductName());
		cart.setProductDesc(productData.getProductDesc());
		cart.setProductImage(productData.getProductImage());
		cart.setProductPrice(productData.getProductPrice());
		cart.setQuantity(quantity);
		float totalPrice=quantity*(productData.getProductPrice());
		cart.setTotalPrice(totalPrice);
		
		return cart;
	}


	public void update(int cartId, int quantity) 
	{
		Cart cart=this.template.get(Cart.class, cartId);
		float price=cart.getProductPrice();
		float totalPrice=quantity*price;
		cart.setQuantity(cart.getQuantity()+quantity);
		cart.setTotalPrice(cart.getTotalPrice()+totalPrice);
		this.template.update(cart);
	}

	public void updateCart(int cartId, float price,int quantity)
	{
		Cart cart=this.template.get(Cart.class, cartId);
	    float totalPrice=price*quantity;
	    cart.setQuantity(quantity);
	    cart.setTotalPrice(totalPrice);
	    this.template.update(cart);
	}
	
	public float getCartAmount(List<Cart> cartList) {
		float cartAmount=0;
		for(Cart c:cartList)
		{
			cartAmount=cartAmount+c.getTotalPrice();
		}
		return cartAmount;
	}

	public void deleteCartObj(Cart cartObj) {

		this.template.delete(cartObj);
	}

	public Cart validate(List<Cart> cartList, int productId, int quantity) {

		Cart cart =null;
 
		System.out.println(cartList.size());
		if(!cartList.isEmpty())
		{
		for(Cart c:cartList)
		{
			if(c.getProductId()==productId)
			{
				cart = new Cart();

				System.out.println(c.getCartId());
				cart.setCartId(c.getCartId());
				cart.setUsername(c.getUsername());
				cart.setProductId(c.getProductId());
				cart.setProductName(c.getProductName());
				cart.setProductDesc(c.getProductDesc());
				cart.setProductImage(c.getProductImage());
				cart.setProductPrice(c.getProductPrice());
				cart.setQuantity(c.getQuantity());
				cart.setTotalPrice(c.getTotalPrice());
				return cart;
			}
		}
		}
		return cart;
	}

	public void update(Cart cart) {
		this.template.update(cart);
	}

	public void getOrder(List<Cart> cartList) {
		
		
		for(Cart c:cartList)
		{
			OrdersData order=new OrdersData();
			order.setUsername(c.getUsername());
			order.setProductId(c.getProductId());
			order.setProductName(c.getProductName());
			order.setProductDesc(c.getProductDesc());
			order.setProductImage(c.getProductImage());
			order.setProductPrice(c.getProductPrice());
			order.setQuantity(c.getQuantity());
			order.setTotalPrice(c.getTotalPrice());
			this.template.save(order);
			System.out.println("....."+order);
		}
		
	}

	public void deleteAll(List<Cart> cartList) {

		this.template.deleteAll(cartList);
	}

	

	
	

	

}
