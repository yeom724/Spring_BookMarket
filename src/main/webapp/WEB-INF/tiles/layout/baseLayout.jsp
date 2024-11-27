<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <tiles:insertAttribute name="title"></tiles:insertAttribute> </title>
<link href="/spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<tiles:insertAttribute name="menu"></tiles:insertAttribute>
	<div class="jumbotron" align="center">
		<div class="container">
			<h1 class="display-3"> <tiles:insertAttribute name="heading"></tiles:insertAttribute> </h1>
			<p> <tiles:insertAttribute name="subheading"></tiles:insertAttribute> </p>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>