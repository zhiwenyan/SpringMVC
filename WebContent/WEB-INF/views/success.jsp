<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- V层 -->
	>
	<h2>success page</h2>
	time:${requestScope.time}
	<br /> names:${requestScope.names}
	<br />
	<!-- 请求域 -->
	person:${requestScope.person}
	<br />
	<!-- 请求域 -->
	person:${sessionScope.person}
	<br /> person:${sessionScope.school}
	<br /> user:${sessionScope.abc}
	<br />
	<!-- jstl 国际化-->
	<fmt:message key="i18n.username"></fmt:message>
	<br />
	<fmt:message key="i18n.password"></fmt:message>

</body>
</html>