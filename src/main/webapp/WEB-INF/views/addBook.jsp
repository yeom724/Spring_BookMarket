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
	
	<div class="container">
<!--	<div class="float-right">
			<form:form action="/spring_BookMarket/logout" method="post">
				<input type="submit" class="btn btn-success" value="Logout">
			</form:form>
		</div>
 -->
		<div class="float-right" style="padding-right:30px;">
			<a href="?lang=ko">한국어</a> | <a href="?lang=en">English</a>
		</div>
		<form:form modelAttribute="NewBook" class="form-horizontal" enctype="multipart/form-data" action="add?${_csrf.parameterName }=${_csrf.token }" >
			<fieldset>
				<legend><spring:message code="subtitle.label" /></legend>
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="bookId.label" /></label>
					<div class="col-sm-3">
						<form:input path="bookId" class="form-control"/>
					</div>
					<div class="col-sm-6">
						<form:errors path="bookId" cssClass="text-danger"></form:errors>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="name.label" /></label>
					<div class="col-sm-3">
						<form:input path="name" class="form-control"/>
					</div>
					<div class="col-sm-6">
						<form:errors path="name" cssClass="text-danger"></form:errors>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="unitPrice.label" /></label>
					<div class="col-sm-3">
						<form:input path="unitPrice" class="form-control"/>
					</div>
					<div class="col-sm-6">
						<form:errors path="unitPrice" cssClass="text-danger"></form:errors>
					</div>
				</div>
						
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="author.label" /></label>
					<div class="col-sm-3">
						<form:input path="author" class="form-control"/>
					</div>
				</div>				

				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="description.label" /></label>
					<div class="col-sm-5">
						<form:textarea path="description" cols="50" rows="2" class="form-control"/>
					</div>
				</div>			

				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="publisher.label" /></label>
					<div class="col-sm-3">
						<form:input path="publisher" class="form-control"/>
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="category.label" /></label>
					<div class="col-sm-3">
						<form:input path="category" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="unitsInStock.label" /></label>
					<div class="col-sm-3">
						<form:input path="unitsInStock" class="form-control"/>
					</div>
					<div class="col-sm-6">
						<form:errors path="unitsInStock" cssClass="text-danger"></form:errors>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="releaseDate.label" /></label>
					<div class="col-sm-3">
						<form:input path="releaseDate" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="condition.label" /></label>
					<div class="col-sm-3">
						<form:radiobutton path="condition" value="New"/>New
						<form:radiobutton path="condition" value="Old"/>Old
						<form:radiobutton path="condition" value="E-Book"/>E-Book
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="bookImage.label" /></label>
					<div class="col-sm-7">
						<form:input path="bookImage" type="file" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-primary" value="<spring:message code="button.label" />"/>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>