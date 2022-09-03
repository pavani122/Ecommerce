package com.techouts.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techouts.dao.OrderDao;
import com.techouts.entities.Cart;
import com.techouts.entities.OrdersData;
import com.techouts.entities.Product;

@Service
public class OrderService {

   @Autowired
	private OrderDao orderDao;
	
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void save(OrdersData order)
	{
		orderDao.save(order);
	}

	public List<OrdersData> loadAll() {

		List<OrdersData> orderList=orderDao.loadAll();
		
		return orderList;
	}

	public OrdersData getOrderById(int orderId) {

		OrdersData orderObj=orderDao.getOrderById(orderId);
		
		return orderObj;
	}

	public void deleteOrderObj(OrdersData orderObj) {
		orderDao.deleteCartObj(orderObj);
	}

	public List<OrdersData> getCartByName(String username) {
		List<OrdersData> orderList=orderDao.getCartByName(username);
		return orderList;
	}

	public void saveOrderData(String username, int productId, int quantity) {

		orderDao.saveOrderData(username,productId,quantity);
	}



	
}
