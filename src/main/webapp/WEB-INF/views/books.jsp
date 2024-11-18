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
			<c:forEach items="${bookList}" var="book">
				<div class="col-md-4">
					<h3>${book.name}</h3>
					<p>${book.author}</p>
					${book.publisher} | ${book.releaseDate}
					<p align=left>${fn:substring(book.description, 0, 100)}...</p>
					<p>${book.unitPrice}원</p>
					<p><a href="/spring_BookMarket/books/book?id=${book.bookId}" class="btn btn-secondary" role="button">상세정보 &raquo;</a></p>
				</div>
			</c:forEach>
		</div>

		<footer class="container">
			<hr>
			<p>&copy; WebMarket</p>
		</footer>
	</div>
</body>
</html>