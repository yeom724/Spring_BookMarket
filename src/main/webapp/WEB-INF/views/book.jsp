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
			<h1 class="display-3">도서 정보</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>${book.name}</h3>
				<p>${book.description}</p>
				<br>
				<p><b>도서코드 : </b><span class="badge badge-info">${book.bookId}</span></p>
				<p><b>저자 : </b>${book.author}</p>
				<p><b>출판사 : </b>${book.publisher}</p>
				<p><b>출판일 : </b>${book.releaseDate}</p>
				<p><b>분류 : </b>${book.category}</p>
				<p><b>재고수 : </b>${book.unitsInStock}</p>
				<h4>${book.unitPrice}원</h4>
				<br>
				<p>	<a href="#" class="btn btn-primary">도서주문 &raquo;</a>
					<a href="/spring_BookMarket/books/all" class="btn btn-secondary">도서목록 &raquo;</a>
				</p>
			</div>
		</div>
		<footer class="container">
			<hr>
			<p>&copy; WebMarket</p>
		</footer>
	</div>
</body>
</html>