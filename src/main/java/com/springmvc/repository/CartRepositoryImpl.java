package com.springmvc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Cart;

@Repository
public class CartRepositoryImpl implements CartRepository{
	
	private Map<String, Cart> listOfCarts;
	
	public CartRepositoryImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		System.out.println("장바구니 생성중...");
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("장바구니를 생성할 수 없습니다. 장바구니 id(%)가 존재합니다.", cart.getCartId()));
		}
		
		listOfCarts.put(cart.getCartId(), cart);
		
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		// TODO Auto-generated method stub
		System.out.println("장바구니 불러 오는중...");
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		
		System.out.println("모델에서 장바구니 업데이트를 진행합니다.");
		
		//유효성 검사
		if(!(listOfCarts.keySet().contains(cartId))) {
			System.out.println("세션 아이디가 존재하지 않습니다.");
			throw new IllegalArgumentException(String.format("장바구니 목록을 갱신할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다.", cartId));
		}
		
		listOfCarts.put(cartId, cart);
		
	}

	@Override
	public void delete(String cartId) {
		// TODO Auto-generated method stub
		
		if(!(listOfCarts.keySet().contains(cartId))) {
			System.out.println("세션 아이디가 존재하지 않습니다.");
			throw new IllegalArgumentException(String.format("장바구니 목록을 갱신할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다.", cartId));
		}
		
		listOfCarts.remove(cartId);
		
	}

}
