<%@page import="com.springmvc.exception.BookIdException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
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
	<% 
		Exception exception = (Exception)request.getAttribute("exception");
	%>
	<div class="jumbotron">
		<div class="container">
			<h2 class="alert alert-danger">요청한 도서가 존재하지 않습니다.</h2>
		</div>
	</div>
	
	<div class="container">
		<p> <%= exception %> </p>
	</div>
	
	<div class="container">
		<p>
			<a href="/spring_BookMarket/books" class="btn btn-secondary" >도서 목록으로 돌아가기</a>
		</p>
	</div>
</body>
</html>