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
<title>员工编辑页面</title>
</head>
<body>
	<h1>欢迎来到XXXXX管理系统</h1>
	<h4>员工编辑页面    </h4>
	<h4>当前用户是: ${user.name} <a href="${pageContext.request.contextPath}/logout">退出</a></h4>
	<hr/>
	<form action="${pageContext.request.contextPath}/edit" method="post">
		<input type="hidden" name="empId" value="${emp.empId}"/>
		<input type="hidden" name="pageNum" value="${pageNum}"/>
    	员工姓名<input type="text" id="empName"  name="empName" value="${emp.empName}"/><br><br>
		员工性别<select name="gender">
				<option value="男" <c:if test="${emp.gender=='男'}">selected</c:if>>男</option>
				<option value="女" <c:if test="${emp.gender=='女'}">selected</c:if>>女</option>
			</select><br><br>
		员工邮箱<input type="text" name="email" value="${emp.email}" /><br><br>
		员工工资<input type="text" name="salary" value="${emp.salary}"/><br><br>
		员工职务<input type="text" name="jobTitle" value="${emp.jobTitle}"/><br><br>
		员工部门<select name="deptId">
				<c:forEach items="${depts}" var="dept">
				<option value="${dept.deptId}" <c:if test="${emp.deptId==dept.deptId}">selected</c:if>>${dept.deptName}</option>
				</c:forEach>
		</select>
		
		<br/>
		<input type="submit" value="编辑"/>
    </form>

</body>
</html>