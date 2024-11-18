<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
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
			<h1 class="display-3"> ${greeting} </h1>
		</div>
	</div>
	
	<div class="container">
		<div class="text-center">
			<h3> ${strapline} </h3>
		</div>
	</div>
	
	<footer class="container">
		<hr>
		<p>&copy; WebMarket</p>
	</footer>
	
</body>
</html>