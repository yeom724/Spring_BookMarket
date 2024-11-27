<%@page import="com.springmvc.exception.BookIdException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 처리</title>
<link href="/spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<% 
	String bookId = (String)request.getAttribute("invalidBookId");
	String url = (String)request.getAttribute("url");
	BookIdException exception = (BookIdException)request.getAttribute("exception");
	%>
	
	<div class="container">
		<p> <%= url %> </p>
		<p> <%= exception %> </p>
	</div>
	
	<div class="container">
		<p>
			<a href="/spring_BookMarket/books" class="btn btn-secondary" >도서 목록으로 돌아가기</a>
		</p>
	</div>
</body>
</html>