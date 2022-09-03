package com.techouts.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.techouts.entities.Cart;
import com.techouts.entities.OrdersData;
import com.techouts.entities.Product;
import com.techouts.services.ProductService;

public class OrderDao {

	 @Autowired
	 ProductDao productDao;
	
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void save(OrdersData order)
	{
		this.template.save(order);
	}

	public List<OrdersData> loadAll() {

		List<OrdersData> orderList=this.template.loadAll(OrdersData.class);
		
		return orderList;
	}

	public OrdersData getOrderById(int orderId) {
  
		OrdersData orderObj=this.template.get(OrdersData.class, orderId);
		return orderObj;
	}

	public void deleteCartObj(OrdersData orderObj) {

		this.template.delete(orderObj);
	}

	public List<OrdersData> getCartByName(String username) {

		String query="from OrdersData where username= :username";
		List<OrdersData> orderList=(List<OrdersData>) this.template.findByNamedParam(query, "username", username);
		return orderList;
	}

	public void saveOrderData(String username, int productId, int quantity) {

		Product product=productDao.getProductById(productId);
		OrdersData order=new OrdersData();
		order.setUsername(username);
		order.setProductId(productId);
		order.setProductName(product.getProductName());
		order.setProductDesc(product.getProductDesc());
		order.setProductImage(product.getProductImage());
		float price=product.getProductPrice();
		order.setProductPrice(price);
		order.setQuantity(quantity);
		float totalPrice=price*quantity;
		order.setTotalPrice(totalPrice);
		save(order);
	}

}
