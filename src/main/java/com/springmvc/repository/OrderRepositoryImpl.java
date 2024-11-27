package com.springmvc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Order;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
	
	private Map<Long, Order> listOfOrders;
	private long nextOrderId;
	
	public OrderRepositoryImpl() {
		listOfOrders = new HashMap<Long, Order>();
		nextOrderId = 2000;
	}


	@Override
	public Long saveOrder(Order order) {
		System.out.println("주문 정보를 저장합니다.");
		order.setOrderId(getNextOrderId());
		listOfOrders.put(order.getOrderId(), order);
	
		return order.getOrderId();
	}


	private synchronized Long getNextOrderId() {
		// TODO Auto-generated method stub
		System.out.println("nextOrderId 1 증가");
		
		
		return nextOrderId++;
	}

}
