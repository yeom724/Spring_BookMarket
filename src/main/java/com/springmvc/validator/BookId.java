package com.springmvc.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy = BookIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BookId {
	String message() default "{BookId.NewBook.bookId}";
	//메세지에 설정해두면 메세지 문구가 출력, 없으면 디폴트값이 반영되는 것을 확인함.
	
	Class<?>[] groups() default {};
	Class<?>[] payload() default {};
	//반드시 필요한 함수들이다
}
