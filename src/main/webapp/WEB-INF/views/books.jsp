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
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/spring_BookMarket/">Home</a>
				<a class="navbar-brand" href="/spring_BookMarket/books">Books</a>
				<a class="navbar-brand" href="/spring_BookMarket/books/all">All</a>
				<a class="navbar-brand" href="/spring_BookMarket/books/add">NewBook</a>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="dispaly-3">도서 목록</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="row" align="center">
			<%
				List<Book> list = (List<Book>)request.getAttribute("bookList");
			
				for(int i=0; i<list.size(); i++){
					Book book = list.get(i);
			%>
				<div class="col-md-4">
			<%
				if(book.getBookImage() == null){	
			%>
					<img src="/spring_BookMarket/resources/images/<%= book.getBookId() %>.png" style="width: 60%;">
			<%					
				} else {
			%>
					<img src="/spring_BookMarket/resources/images/<%= book.getBookImage().getOriginalFilename() %>" style="width: 60%;">
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

		<footer class="container">
			<hr>
			<p>&copy; WebMarket</p>
		</footer>
	</div>
</body>
</html>