package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

// 컨트롤 객체, 디스패처 서블렛이 미리 생성할 수 있도록 지정함
@Controller
//함수가 매핑될 주소를 지정함, /books/product 등 연속적으로도 구현이 가능하다.
@RequestMapping("/books") //value="/books", method = RequestMethod.GET방식일 경우 생략가능
public class BookController {
	
	// 참조변수, 디스패처 서블렛이 지정된 변수에 객체를 담을 수 있도록 지정함
	// BookService를 사용하기 위해서는 해당 객체도 미리 컴포너트 스캔이 되어있어야 한다.
	@Autowired
	private BookService bookService;
	
	//클래스에 매핑되면 기본값으로 호출될 함수 위에 @RequestMapping을 표시해준다. (아무런 밸류값을 주지 않으면)
	@GetMapping
	public String requestBookList(Model model) {
		System.out.println("requestBookList 입장");
		
		// 레파지토리 > 서비스 > 컨트롤러
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		
		System.out.println("도서 목록을 model에 저장했습니다.");
		
		// 이동할 뷰 파일 이름을 리턴한다.
		return "books";
	}
	
	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		System.out.println("requestAllBooks 입장");
		ModelAndView mav = new ModelAndView();
		
		// 레파지토리 > 서비스 > 컨트롤러
		List<Book> list = bookService.getAllBookList();
		mav.addObject("bookList", list);
		mav.setViewName("books");
		
		System.out.println("도서 목록을 modelAndView 에 저장했습니다.");
		
		// 이동할 뷰 파일 이름을 리턴한다.
		return mav;
	}
	
	// 파라미터를 중괄호{}를 활용하여 변수처리가 가능하다.
	
	// 변수처리 된 값을 함수의 매개변수로 활용하기 위해서 @PathVariable를 사용한다. (파라미터가 두 개 이상일 경우 @PathVariable도 변수마다 두번 써야한다)
	// 만약 매개변수에서 활용할 변수 이름을 바꾸고 싶다면 @PathVariable("category") String bookCategory 이런 방식으로 해당 파라미터임을 명시해주어야 한다.
	@GetMapping("/{category}")
	public String requestBookByCategory(@PathVariable String category, Model model) {
		System.out.println(category + " 입력한 정보를 추출하러 이동중...");
		List<Book> booksByCategory = bookService.getBookListByCategory(category);
		model.addAttribute("bookList", booksByCategory);
		
		System.out.println("정보 도착, 반환 시작.");
		
		return "books";
	}
	
	// 요청발생 주소 : /books/filter/bookFilter;publisher=길벗;category=IT전문서,IT활용서
	// {bookFilter} 는 변수를 선언한 것이지 주소창에 꼭 bookFilter 똑같이 입력되어 오지 않아도 작동된다.
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model) {
		
		//매트릭스 변수를 Map에 담는 과정임.
		//category=IT전문서,IT활용서 category가 String, List<String>에는 IT전문서, IT활용서가 담긴다.
		//key가 String이며 value가 List<String> 형식인 Map을 파라미터로 받는다.
		
		// HashSet에 저장된 요소는 순서가 보장되지 않는다, 그래서 뷰에 반영하면 순서가 뒤섞인다.
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList",booksByFilter);
		
		System.out.println("필터 처리 완료! 뷰어로 돌아갑니다.");
		return "books";
	}
	
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		
		System.out.println("도서 정보를 표시합니다.");
		return "book";
	}
}
