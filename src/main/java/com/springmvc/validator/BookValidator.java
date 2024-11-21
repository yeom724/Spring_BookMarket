package com.springmvc.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.domain.Book;

public class BookValidator implements Validator {
	
	@Autowired
	//@Qualifier("validator") //빈이 자꾸 중복된다고 떠서 직접 빈아이디를 입력해서 넣어줬더니 작동함
	private javax.validation.Validator beanValidator;
	// 왜 이런 힘든길을가나 했는데 패키지가 다르네
	
	private Set<Validator> springValidators;
	
	public BookValidator() { springValidators = new HashSet<Validator>(); }
	
	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Bean Validation 설정
		
		Set<ConstraintViolation<Object>> violations = beanValidator.validate(target);
		
		for(ConstraintViolation<Object> violation : violations) {
			//오류 발생한 필드를 반복문으로 저장
			
			String propertyPath = violation.getPropertyPath().toString();
			String msg = violation.getMessage();
			
			errors.rejectValue(propertyPath,"",msg);
			
		}
		
		for(Validator validator: springValidators) {
			validator.validate(target, errors); //발생된 오류 정보를 전달
		}
	}

}
