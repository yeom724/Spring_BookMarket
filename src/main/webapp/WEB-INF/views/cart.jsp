<%@page import="com.springmvc.domain.CartItem"%>
<%@page import="java.util.Map"%>
<%@page import="com.springmvc.domain.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
	<% 	
		Cart cart = null;
		Map<String, CartItem> cartList = null;
		
		String userId = request.getSession().getId();
		
		if(request.getAttribute("cart") != null){
			
			cart = (Cart)request.getAttribute("cart");
			cartList = cart.getCartItems();
			
		}
		
	%>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">장바구니</h1>
		</div>
	</div>
	
	<div class="container">
		<div>
			<form:form name="clearForm" method="delete">
				<a href="javascript:clearCart()" class="btn btn-danger pull-left">삭제하기</a>
			</form:form>
			<a href="#" class="btn btn-success float-right">주문하기</a>
		</div>
		<div style="padding-top: 50px;">
			<table class="table table-hover">
				<tr>
					<th>도서</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>
				</tr>
					<form:form name="removeForm" method="PUT">
					<% 
						if(cartList != null){
							
						
							for (String key : cartList.keySet()){
								CartItem item = cartList.get(key);
					%>
					
						<tr>
							<td><%= item.getBook().getBookId() %> - <%= item.getBook().getName() %> </td>
							<td><%= item.getBook().getUnitPrice() %></td>
							<td><%= item.getQuantity() %></td>
							<td><%= item.getTotalPrice() %></td>
							
								<td>
									<a href="javascript:removeFromCart('/spring_BookMarket/cart/remove/<%= item.getBook().getBookId() %>')" class="badge badge-danger">삭제</a>
								</td>
						</tr>
					
					<%
							}
						}
					%>
					</form:form>
				
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th>${cart.grandTotal }</th>
					<th></th>
				</tr>
			</table>
			<a href="/spring_BookMarket/books" class="btn btn-secondary">쇼핑 계속하기</a>
		</div>
	</div>
	
		<footer class="container">
			<hr>
			<p>&copy; WebMarket</p>
		</footer>

<script type="text/javascript">
	function removeFromCart(action) {
		document.removeForm.action = action;
		document.removeForm.submit();
		
		console.log("삭제 진행")
		
		setTimeout(function() {
			console.log("리로드 함수 접속")
            window.location.reload(); // 약간의 지연 후 페이지 새로 고침
        }, 200);
	}
	
	function clearCart() {
		document.clearForm.submit();
		console.log("전체 삭제 진행")
		
		setTimeout(function() {
			console.log("리로드 함수 접속")
            window.location.reload(); // 약간의 지연 후 페이지 새로 고침
        }, 200);
	}
</script>
</body>

</html>