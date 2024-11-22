package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Cart;
import com.springmvc.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart create(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("서비스에서 카트 생성하는중...");
		return cartRepository.create(cart);
	}

	@Override
	public Cart read(String cartId) {
		// TODO Auto-generated method stub
		System.out.println("서비스에서 카트 목록 반환중...");
		return cartRepository.read(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		System.out.println("서비스에서 업데이트 함수를 실행하는중...");
		cartRepository.update(cartId, cart);
		
	}

	@Override
	public void delete(String cartId) {
		// TODO Auto-generated method stub
		cartRepository.delete(cartId);
		
	}

}
