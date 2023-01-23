<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Application</title>
<link rel="stylesheet" 
	href = "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: blue">
			<div>
				<a href="http://www.xadmin.net" class="navbar-brand">
				User Management Application</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%= request.getContextPath() %>/list"
				class="nav-link">Users List</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="row">
		<!-- <div class="alert alert-success *ngIf='message'>{{message}}</div> -->
		
		<div class="container"></div>
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container-text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Country</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUser}">
						<tr>
							<td><c:out value="${user.id}"></c:out></td>
							<td><c:out value="${user.name}"></c:out></td>
							<td><c:out value="${user.email}"></c:out></td>
							<td><c:out value="${user.country}"></c:out></td>
							<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>