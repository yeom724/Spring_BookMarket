package com.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.domain.Book;

@Component
public class UnitsInStockValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("유효성 검사 진입중...");
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		System.out.println("재고 및 가격에 대한 유효성 검사를 실시합니다.");
		
		Book book = (Book) target;
		//target은 폼에서 전송되어 온 데이터, Book객체로 보냈기 때문에 Book으로 받을 수 있다.
		
		if(book.getUnitPrice()>=10000 && book.getUnitsInStock()>100) {
			errors.rejectValue("unitsInStock", "UnitsInStockValidator.message");
		}
		
	}

}
