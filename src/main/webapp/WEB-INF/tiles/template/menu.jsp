<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/spring_BookMarket/">Book Market</a>
			</div>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/spring_BookMarket/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/spring_BookMarket/books">Books</a></li>
				<li class="nav-item"><a class="nav-link" href="/spring_BookMarket/books/add">AddBook</a></li>
				<li class="nav-item"><a class="nav-link" href="/spring_BookMarket/cart">Cart</a></li>

				<li class="nav-item">
					<sec:authorize access="isAuthenticated()">
						<form:form action="/spring_BookMarket/logout" method="post">
							<input type="submit" class="btn btn-success" value="Logout">
						</form:form>
					</sec:authorize>
				</li>
				
				<li class="nav-item">
					<sec:authorize access="!(isAuthenticated())">
						<a class="nav-link" href="/spring_BookMarket/login">Login</a>
					</sec:authorize>
				</li>
			</ul>
		</div>
</nav>