package com.techouts.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.dao.CartDao;
import com.techouts.entities.Cart;
import com.techouts.entities.OrdersData;
import com.techouts.entities.Person;
import com.techouts.entities.Product;
@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}


	public int save(Cart cart)
	{
	int i=cartDao.save(cart);
	return i;
	}


	public List<Cart> getCartByName(String name) {
		
		List<Cart> cart=cartDao.getCartByName(name);
		
		return cart;
	}
	
	public List<Cart> loadAll()
	{
		List<Cart> cartList=cartDao.loadAll();
		return cartList;
		
	}


	public Cart getCart(String username,int productId,int quantity) {
		Cart cart= cartDao.getCart(username,productId,quantity);
		return cart;
	}

	public void update(int cartId,int quantity) {
		cartDao.update(cartId,quantity);
	}

	public float getCartAmount(List<Cart> cartList) {
		float cartAmount=cartDao.getCartAmount(cartList);
		return cartAmount;
	}

	public Cart getCartById(int cartId) {

		Cart cartObj=cartDao.getCartById(cartId);
		return cartObj;
	}

	public void deleteCartObj(Cart cartObj) {
		cartDao.deleteCartObj(cartObj);
	}

	public Cart validate(List<Cart> cartList, int productId, int quantity) {
		Cart cart=cartDao.validate(cartList,productId,quantity);
		return cart;
	}

	public void update(Cart cart) {
		cartDao.update(cart);		
	}

	public void getOrder(List<Cart> cartList) {
		cartDao.getOrder(cartList);
	}

	public void deleteAll(List<Cart> cartList) {
		cartDao.deleteAll(cartList);
		
	}

	public void updateCart(int cartId, float price, int quantity) {
		cartDao.updateCart(cartId,price,quantity);
	}

	

	

	
	

}
