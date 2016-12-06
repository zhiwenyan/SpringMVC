<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springDispatcherServlet</title>
</head>
<body>
	<a href="helloworld">Hello World</a>
	<br />

	<a href="springmvc/testRequestMapping">Hello World</a>
	<br />

	<a href="springmvc/testMethod">Hello World</a>
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="提交">
	</form>

	<a href="springmvc/testParamsAndHeaders?username=steven&age=11">testParamsAndHeaders</a>
	<br />
	<a href="springmvc/testAnt/seteve/abc">通配符</a>
	<br />

	<a href="springmvc/testPathVariable/01">TestPathVariable</a>
	<br />

	<form action="springmvc/testPut/1" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="TestRest PUT" />
	</form>
	<br>
	<br>


	<form action="springmvc/testDelete/1" method="post">
		<input type="hidden" name="_method" value="DELETE" /> <input
			type="submit" value="TestRest DELETE" />
	</form>
	<br>
	<br>

	<form action="springmvc/testRest" method="post">
		<input type="submit" value="TestRest POST" />
	</form>
	<br>
	<br>

	<a href="springmvc/testRest/1">Test Rest Get</a>
	<br />




	<a href="springmvc/testRequestParam?username=steven">testRequestParam</a>

	<br />
	<a href="springmvc/testRequestHeader">testRequestHeader</a>


	<br />
	<a href="springmvc/testCookieValue">testCookieValue</a>
	<br />


	<form action="springmvc/testpojo" method="get">

		username:<input type="text" name="username"> <br /> password:<input
			type="password" name="password"> <br /> province:<input
			type="text" name="address.province"> <br />
		<!-- 级联属性 -->
		city:<input type="text" name="address.city"> <br /> <input
			type="submit" value="submit">
	</form>
	<br />
	<a href="springmvc/testServletApi">testServletApi</a>
	<br />
	<a href="springmvc/testModelAndView">testModelAndView</a>
	<br />
	<a href="springmvc/testMap">testMap</a>
	<br />
	<a href="springmvc/testSessionAttributes">testSessionAttributes</a>
	<br />

	<!-- 模拟修改数据   原始数据 001  Tom 123456 -->
	<form action="springmvc/testModelAttributes" method="post">
		<input type="hidden" name="id" value="2"> <br /> username:<input
			type="text" name="username" value="Tom"><br> <input
			type="submit" value="submit">
	</form>
	<a href="springmvc/testView">testView</a>
	<br />
	<a href="springmvc/testRedrict">testRedrict</a>
	<a href="springmvc/i18n">PAGE</a>
	<a href="springmvc/testi18n">testi18n</a>

	<form:form action="springmvc/emp" method="POST">
		<form:errors path="*"></form:errors>
		<br>
		<!-- path 属性对应 html 表单标签的 name 属性值 -->
			LastName: <form:input path="lastName" />
		<form:errors path="lastName"></form:errors>

		<br>
		Email: <form:input path="email" />
		<form:errors path="email"></form:errors>
		<br>
		Birth: <form:input path="birth" />
		<form:errors path="birth"></form:errors>
		<br>
		Salary: <form:input path="salary" />
		<br>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>