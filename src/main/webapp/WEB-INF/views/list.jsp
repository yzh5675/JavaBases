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
<title>员工列表页面</title>
<script type="text/javascript">
	function del(){
		var msg = "您确定要删除这条记录吗？";
		if(confirm(msg) == true){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<h1>欢迎来到XXXXX管理系统</h1>
	<h4>员工列表页面    </h4>
	<h4>当前用户是: ${user.name} <a href="${pageContext.request.contextPath}/logout">退出</a></h4>
	
	<hr/>
	<form action="${pageContext.request.contextPath}/emps/1" method="get">
		<label>模糊查询: </label><input type="text" name="searchName" />
		<input type="submit" value="查询"/>
	</form>
	<br/>	
	<table border="1">
		<tr >
			<td colspan="8"><a href="${pageContext.request.contextPath}/toadd">添加</a></td>
		</tr>
		<tr>
			<th>#ID</th>
			<th width="100px">姓名</th>
			<th>性别</th>
			<th width="200px">Email</th>
			<th>工资</th>
			<th width="100px">职务</th>
			<th width="100px">部门名称</th>
			<th width="150px">操作</th>
		</tr>
		<c:forEach items="${emps}" var="emp">
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.empName}</td>
			<td>${emp.gender}</td>
			<td>${emp.email}</td>
			<td>${emp.salary}</td>
			<td>${emp.jobTitle}</td>
			<td>${emp.deptId}</td>
			<td align="center"><a href="${pageContext.request.contextPath}/toedit/${emp.empId}/${pageNum}">编辑</a>
			<a href="${pageContext.request.contextPath}/delete/${emp.empId}/${pageNum}" 
			onclick="javascript:return del();">删除</a></td>
		</tr>
		</c:forEach>
		
		<tr align="center">
			<td colspan="8">
			第<c:out value="${pageNum}"></c:out>页/共<c:out value="${totalPage}"></c:out>页
			
			<a href="${pageContext.request.contextPath}/emps/1">首页</a>   
			
			<a href="${pageContext.request.contextPath}/emps/${pageNum -1}">上一页</a>
			
			<a href="${pageContext.request.contextPath}/emps/${pageNum + 1}">下一页</a>
			
			<a href="${pageContext.request.contextPath}/emps/${totalPage}">尾页</a>
			</td>
		</tr>
		
	</table>
</body>
</html>