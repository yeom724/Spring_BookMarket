package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springmvc.domain.Book;
import com.springmvc.domain.Cart;
import com.springmvc.domain.CartItem;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;
import com.springmvc.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private BookService bookservice;
	
	
	@GetMapping
	public String requesetCartId(HttpServletRequest req) {
		System.out.println("세션을 생성합니다.");
		String session = req.getSession(true).getId();
		return "redirect:/cart/" + session;
		
	}
	
	@PostMapping
	public @ResponseBody Cart create(@RequestBody Cart cart) {
		return cartService.create(cart);
	}
	
	@GetMapping("/{cartId}")
	public String requestCartList(@PathVariable String cartId, Model model) {
		
		Cart cart = cartService.read(cartId);
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@PutMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable String cartId) {
		System.out.println("PutMapping 진입, 카트를 읽어옵니다.");
		return cartService.read(cartId);
	}
	
	@PutMapping("/add/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT) //오류 응답 상태 코드 설정
	public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest req) {
		
		String session = req.getSession().getId();
		Cart cart = cartService.read(session);
		System.out.println("장바구니 세션 정보를 불러옵니다. -등록함수-");
		
		if(cart == null) { 
			cart = cartService.create(new Cart(session));
			System.out.println("장바구니 세션이 존재하지 않습니다, 새로 생성합니다.");
		}
		
		Book book = bookservice.getBookById(bookId);
		System.out.println("도서 정보를 불러옵니다.");
		
		if(book == null) {
			System.out.println("해당 도서정보는 존재하지 않습니다.");
			throw new IllegalArgumentException(new BookIdException(bookId));
		}
		
		cart.addCartItem(new CartItem(book));
		cartService.update(session, cart);
		System.out.println("장바구니에 도서 추가를 완료하였습니다.");
		
	}
	
	@PutMapping("/remove/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeCartByItem(@PathVariable String bookId, HttpServletRequest req, Model model) {
		
		String session = req.getSession().getId();
		Cart cart = cartService.read(session);
		System.out.println("장바구니 세션 정보를 불러옵니다. -삭제함수-");
		
		if(cart == null) { 
			cart = cartService.create(new Cart(session));
			System.out.println("장바구니 세션이 존재하지 않습니다, 어떻게 들어왔음?");
		}
		
		Book book = bookservice.getBookById(bookId);
		System.out.println("도서 정보를 불러옵니다.");
		
		if(book == null) {
			System.out.println("해당 도서정보는 존재하지 않습니다.");
			throw new IllegalArgumentException(new BookIdException(bookId));
		}
		
		System.out.println("해당 도서를 장바구니에서 삭제했습니다.");
		cart.removeCartItem(new CartItem(book));
		cartService.update(session, cart);
	}
	
	@DeleteMapping("/{cartId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCartList(@PathVariable String cartId) {
		cartService.delete(cartId);
		System.out.println("전체 삭제를 완료했습니다.");
	}
	
}
