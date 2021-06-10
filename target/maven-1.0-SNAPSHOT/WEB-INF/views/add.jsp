<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style type="text/css">
	* {
		margin: 0 auto;
		padding: 0 auto;
		text-align: center;
	}
</style>
<head>
<meta charset="UTF-8">
<title>员工添加页面</title>
</head>
<body>
	<h1>欢迎来到XXXXX管理系统</h1>
	<h4>员工添加页面    </h4>
	<h4>当前用户是: ${user.name} <a href="${pageContext.request.contextPath}/logout">退出</a></h4>
	<hr/>
	<form action="${pageContext.request.contextPath}/add" method="post">
    	员工姓名<input type="text" id="empName"  name="empName"/><br><br>
		员工性别<select name="gender">
				<option value="男">男</option>
				<option value="女">女</option>
			</select><br><br>
		员工邮箱<input type="text" name="email" /><br><br>
		员工工资<input type="text" name="salary" /><br><br>
		员工职务<input type="text" name="jobTitle" /><br><br>
		员工部门<select name="deptId">
				<c:forEach items="${depts}" var="dept">
				<option value="${dept.deptId}">${dept.deptName}</option>
				</c:forEach>
		</select>
		
		<br/>
		<input type="submit" value="添加"/>
    </form>

</body>
</html>