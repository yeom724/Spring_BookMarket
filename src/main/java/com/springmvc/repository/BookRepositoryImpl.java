package com.springmvc.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Book;
import com.springmvc.exception.BookIdException;

// 레파지토리 지정하여 미리 생성될 수 있도록 함
// 이렇게 생성된 객체는 모두 자동적으로 static(유일한 하나의 객체)이 되기 때문에 별도 생성자로 생성하지 않은 것을 확인할 수 있다.
@Repository
public class BookRepositoryImpl implements BookRepository {

	private List<Book> listOfBook = new ArrayList<Book>();
	
	private JdbcTemplate template;
	
	@Autowired //dataSource에 주입하여 함수실행
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public BookRepositoryImpl() { 
		
		System.out.println("책 목록을 불러오는중...");
		
	        Book book1 = new Book("ISBN1234", "C# 교과서", 30000);
	        book1.setAuthor("박용준");
	        book1.setDescription("C# 교과서는 생애 첫 프로그래밍 언어로 C#을 시작하는 독자를 대상으로 한다. 특히 응용 프로그래머를 위한 C# 입문서로, C#을 사용하여 게임(유니티), 웹, 모바일, IoT 등을 개발할 때 필요한 C# 기초 문법을 익히고 기본기를 탄탄하게 다지는 것이 목적이다.");
	        book1.setPublisher("길벗");
	        book1.setCategory("IT전문서");
	        book1.setUnitsInStock(1000);
	        book1.setReleaseDate("2020/05/29");
	        
	        Book book2 = new Book("ISBN1235", "Node.js 교과서", 36000);
	        book2.setAuthor("조현영");
	        book2.setDescription("이 책은 프런트부터 서버, 데이터베이스, 배포까지 아우르는 광범위한 내용을 다룬다. 군더더기 없는 직관적인 설명으로 기본 개념을 확실히 이해하고, 노드의 기능과 생태계를 사용해 보면서 실제로 동작하는 서버를 만들어보자. 예제와 코드는 최신 문법을 사용했고 실무에 참고하거나 당장 적용할 수 있다.");
	        book2.setPublisher("길벗");
	        book2.setCategory("IT전문서");
	        book2.setUnitsInStock(1000);
	        book2.setReleaseDate("2020/07/25");
	        
	        Book book3 = new Book("ISBN1236", "어도비 XD CC 2020", 25000);
	        book3.setAuthor("김두한");
	        book3.setDescription("어도비 XD 프로그램을 통해 UI/UX 디자인을 배우고자 하는 예비 디자이너의 눈높이에 맞게 기본적인 도구를 활용한 아이콘 디자인과 웹&앱 페이지 디자인, UI 디자인, 앱 디자인에 애니메이션과 인터랙션을 적용한 프로토타이핑을 학습합니다.");
	        book3.setPublisher("길벗");
	        book3.setCategory("IT활용서");
	        book3.setUnitsInStock(1000);
	        book3.setReleaseDate("2019/05/29");

	        listOfBook.add(book1);
	        listOfBook.add(book2);
	        listOfBook.add(book3);
	        
	    }
	
	
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		System.out.println("전체 목록을 반환하기 위한 SQL문 작성 중...");
		String SQL = "SELECT * FROM book";
		List<Book> listOfBooks = template.query(SQL, new BookRowMapper());
		
		System.out.println("책 목록 서비스에 전달중...");
		return listOfBooks;
	}
	
	public List<Book> getBookListByCategory(String category){
		System.out.println("카테고리별 책을 추출합니다.");
		List<Book> bookByCategory = new ArrayList<Book>();
		
		String SQL = "select * from book where b_category LIKE '%" + category + "%'";
		bookByCategory = template.query(SQL, new BookRowMapper());
		
		System.out.println("서비스로 책을 보내는 중...");
		return bookByCategory;
		
	}


	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		
		System.out.println("필터 검색에 도착하셨습니다...");
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();
		Set<String> criterias = filter.keySet();
		// 가져온 Set에서 키만 가져온다, 키 값은 String으로 저장되어 있기 때문에 String형식으로 받는다.
		
		
		if(criterias.contains("publisher")) {
			System.out.println("publisher if문 진입");
			
			//filter.get("publisher").size() publisher key가 있는지 확인하고 그 크기를 계산하여 반영됨
			
			for(int j = 0; j < filter.get("publisher").size(); j++) {
				String publisherName = filter.get("publisher").get(j);
				System.out.println("publisher 검색어 : " + publisherName);
				
				String SQL = "select * from book where b_publisher LIKE '%"+publisherName+"%'";
				
				booksByPublisher.addAll(template.query(SQL, new BookRowMapper()));
				System.out.println("SQL에서 데이터 확보 완료 - publisher");
				
			}
			
			System.out.println("publisher - 책 정보 저장에 성공했습니다.");
			
		}
		
		if(criterias.contains("category")) {
			System.out.println("category if문 진입");
			
			for(int i = 0; i<filter.get("category").size(); i++) {
				
				String category = filter.get("category").get(i);
				System.out.println(i+"번째 category"+category);
				
				String SQL = "select * from book where b_category LIKE '%"+category+"%'";
				
				booksByCategory.addAll(template.query(SQL, new BookRowMapper()));
				System.out.println("SQL에서 데이터 확보 완료 - Category");
			}
			
			System.out.println("Category - 책 정보 저장에 성공했습니다.");
		}
		
		booksByCategory.retainAll(booksByPublisher);
		//퍼블리셔와 카테고리의 교집합을 가려내어 담아 이동
		System.out.println("서비스로 이동합니다.");
		return booksByCategory;
	}


	@Override
	public Book getBookById(String BookId) {
		// TODO Auto-generated method stub
		
		System.out.println("해당 도서를 찾습니다 : "+ BookId);
		
		Book bookInfo = null;
		
		String SQL = "select count(*) from book where b_bookId=?";
		int rowCount = template.queryForObject(SQL, Integer.class, BookId);
		
		if(rowCount != 0) {
			SQL = "select * from book where b_bookId=?";
			
			bookInfo = template.queryForObject(SQL, new Object[] { BookId }, new BookRowMapper());
		}
		
		if(bookInfo == null) {
			System.out.println("해당 도서를 발견할 수 없었습니다.");
			throw new BookIdException(BookId);
		}
		
		System.out.println("서비스로 넘어갑니다...");
		return bookInfo;
	}


	@Override
	public void setNewBook(Book book) {
		// TODO Auto-generated method stub
		System.out.println("레파지토리 도착, book 정보를 저장합니다.");
		
		String SQL = "insert into book values (?,?,?,?,?,?,?,?,?,?,?)";
		
		template.update(SQL, book.getBookId(), book.getName(), book.getUnitPrice(), book.getAuthor(), book.getDescription(), book.getPublisher(), book.getCategory(), book.getUnitsInStock(), book.getReleaseDate(), book.getCondition(), book.getFileName());
		
	}

	@Override
	public void setUpdateBook(Book book) {
		
		System.out.println("도서 정보를 수정합니다.");
		String SQL = "update book set b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=? where b_bookId=?";
		template.update(SQL, book.getName(), book.getUnitPrice(), book.getAuthor(), book.getDescription(), book.getPublisher(), book.getCategory(), book.getUnitsInStock(), book.getReleaseDate(), book.getCondition(), book.getBookId());
		
		
		if(book.getFileName() != null) {
			System.out.println("도서 이미지를 수정합니다.");
			SQL = "update book set b_fileName=? where b_bookId=?";
			template.update(SQL, book.getFileName());
			
		}
		
	}

	@Override
	public void setDeleteBook(String bookId) {
		// TODO Auto-generated method stub
		String SQL = "delete from Book where b_bookId=?";
		this.template.update(SQL, bookId);
		System.out.println("해당 도서의 정보 삭제를 완료했습니다.");
	}

}
