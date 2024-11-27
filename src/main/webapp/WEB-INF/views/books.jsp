<%@page import="java.util.List"%>
<%@page import="com.springmvc.domain.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<div class="row" align="center">
			<%
				List<Book> list = (List<Book>)request.getAttribute("bookList");
			
				for(int i=0; i<list.size(); i++){
					Book book = list.get(i);
			%>
				<div class="col-md-4">
			<%
				if(book.getFileName() == null){
					
			%>
					<p>파일이 없는뎅?</p>
					<img src="<%= book.getBookId() %>" style="width: 60%;">
			<%					
				} else {
			%>
					<img src="/spring_BookMarket/resources/images/<%= book.getFileName() %>" style="width: 60%;">
			<%
				}
			%>
					<h3><%= book.getName() %></h3>
					<p><%= book.getAuthor() %></p>
					<%= book.getPublisher() %> | <%= book.getReleaseDate() %>
					<p align=left><%= book.getDescription() %>...</p>
					<p><%= book.getUnitPrice() %>원</p>
					<p><a href="/spring_BookMarket/books/book?id=<%= book.getBookId() %>" class="btn btn-secondary" role="button">상세정보 &raquo;</a></p>
				</div>
				
			<%
				}
			%>
		</div>

	</div>
</body>
</html>