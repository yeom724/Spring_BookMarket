<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
	
	<div class="container col-md-4">
		<div class="text-center">
			<h3 class="form-signin-heading">Please login</h3>
		</div>
		
		<%
			//Boolean error = (Boolean)request.getAttribute("error");
			String error = (String)request.getAttribute("error");
			// String으로 받은 이유는 로그인에 실패 했을 때만 ture값을 받아오고, 성공했을 때는 null을 받아오기 때문이다.
			// 따라서 Stirng으로 제어문에 사용하려면 != null 로 해당 참조객체가 null인지 아닌지로 판단해야 한다.
			
			// 그냥... model로 넘긴 값도 리퀘스트에서 꺼내서 사용할 수 있다... (jsp)
			// jsp는 내장객체로 리퀘스트를 사용하기 때문에 스프링 자체에서 리퀘스트에 넣어줌 (모델에서 리퀘스트에 쏙)
			
			//Boolean code = Boolean.parseBoolean(error);
			// 만약 논리값으로 하고자 하면 형변환을 통해 해주면된다.
			// 불린 형변환은 null값도 false로 자동 치환해준다고 한다. 강제형변환으로는 못하는 듯?
			// 애초 리퀘스트에서 받을 때부터 강제형변환이 적용되지 않는 이유는 Boolean객체 자체는 true와 false만 받기 때문이다.
			
			if(error != null){
		%>
			<div class="alert alert-danger">
				UserName과 Password가 올바르지 않습니다. <br>
			</div>
		<%
			}
		%>
		
		<form class="form-signin" method="post" action="/spring_BookMarket/login">
			<div class="form-group row">
				<input type="text" name="username" class="form-control" placeholder="User Name" required autofocus />
			</div>
			<div class="form-group row">
				<input type="password" name="password" class="form-control" placeholder="Password" required />
			</div>
			<div class="form-group row">
				<button class="btn btn-lg btn-success btn-block" type="submit" > 로그인 </button>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
		</form>
	</div>

</body>
</html>