<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form:form action="${pageContext.request.contextPath}/logout" method="post">
				<input type="submit" class="btn btn-sm btn-success" value="Logout" />
			</form:form>
</body>
</html>