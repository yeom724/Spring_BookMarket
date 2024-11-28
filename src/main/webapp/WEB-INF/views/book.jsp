<%@page import="com.springmvc.domain.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<%
					Book book = (Book)request.getAttribute("book");
					
					if(book.getFileName() == null){
				%>
						<img src="/spring_BookMarket/resources/images/<%= book.getBookId() %>.png" style="width: 100%;">
				<%
					} else {
				%>
						<img src="/spring_BookMarket/resources/images/<%= book.getFileName() %>" style="width: 100%;">
				<%
					}
				%>
			</div>
		
			<div class="col-md-8">
				<h3> <%= book.getName() %> </h3>
				<p><%= book.getDescription() %></p>
				<br>
				<p><b>도서코드 : </b><span class="badge badge-info"><%= book.getBookId() %></span></p>
				<p><b>저자 : </b> <%= book.getAuthor() %> </p>
				<p><b>출판사 : </b> <%= book.getPublisher() %> </p>
				<p><b>출판일 : </b> <%= book.getReleaseDate() %> </p>
				<p><b>분류 : </b> <%= book.getCategory() %> </p>
				<p><b>재고수 : </b> <%= book.getUnitsInStock() %></p>
				<h4><%= book.getUnitPrice() %>원</h4>
				<br>
				<form:form name="addForm" method="put">
					<p>	<a href="#" onclick="addToCart('/spring_BookMarket/cart/add/<%= book.getBookId() %>')" class="btn btn-primary">도서주문 &raquo;</a>
						<a href="/spring_BookMarket/cart" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="/spring_BookMarket/books/all" class="btn btn-secondary">도서목록 &raquo;</a>
						<sec:authorize access="isAuthenticated()">
							<a href="/spring_BookMarket/books/update?bookId=<%=book.getBookId()%>" class="btn btn-success">수정 &raquo;</a>
							<a href="javascript:deleteConfirm('<%=book.getBookId()%>')" class="btn btn-danger">삭제 &raquo;</a>
						</sec:authorize>
					</p>
				</form:form>
			</div>
		</div>
	</div>
</body>
<script src="/spring_BookMarket/resources/js/controllers.js"></script>
</html>