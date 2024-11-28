<%@page import="com.springmvc.domain.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<% Book book = (Book)request.getAttribute("book"); %>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<img src="/spring_BookMarket/resources/images/<%= book.getFileName() %>" style="width: 100%;">
			</div>
		
			<div class="col-md-7">
				<form:form modelAttribute="updateBook" action="update?${_csrf.parameterName }=${_csrf.token }" class="form-horizontal" enctype="multipart/form-data">
					<fieldset>
					
						<div class="form-group row">
							<label class="col-sm-2 control-label">도서 ID</label>
							<div class="col-sm-6" style="padding-top:10px;">
								<form:input id="bookId" path="bookId" value="<%=book.getBookId() %>" type="hidden"/>
								<span class="badge badge-info"><%=book.getBookId() %></span>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">도서명</label>
							<div class="col-sm-6">
								<form:input class="form-control" path="name" value="<%=book.getName() %>"/>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">가격</label>
							<div class="col-sm-6">
								<form:input class="form-control" path="unitPrice" value="<%=book.getUnitPrice() %>"/>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">저자</label>
							<div class="col-sm-6">
								<form:input class="form-control" path="author" value="<%=book.getAuthor() %>"/>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">상세정보</label>
							<div class="col-sm-10">
								<form:textarea text="<%=book.getDescription() %>" path="description" cols="50" rows="2" class="form-control" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">출판사</label>
							<div class="col-sm-6">
								<form:input class="form-control" path="publisher" value="<%=book.getPublisher() %>"/>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">분류</label>
							<div class="col-sm-6">
								<form:input class="form-control" path="category" value="<%=book.getCategory() %>"/>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">재고수</label>
							<div class="col-sm-6">
								<form:input class="form-control" path="unitsInStock" value="<%=book.getUnitsInStock() %>"/>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">출판일</label>
							<div class="col-sm-6">
								<form:input class="form-control" path="releaseDate" value="<%=book.getReleaseDate() %>"/>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">상태</label>
							<div class="col-sm-6">
								<form:radiobutton path="condition" value="New"/>New
								<form:radiobutton path="condition" value="Old"/>Old
								<form:radiobutton path="condition" value="E-Book"/>E-Book
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">이미지</label>
							<div class="col-sm-6">
								<form:input class="form-control" path="bookImage" type="file"/>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-offset-2 col-sm-10"></label>
							<div class="col-sm-6">
								<input type="submit" class="btn btn-primary" value="수정">
								<a href="/spring_BookMarket/books" class="btn btn-primary">취소</a>
							</div>
						</div>
					
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>