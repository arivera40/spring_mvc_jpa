<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Manager</title>
</head>
<body>
	<div align="center">
		<h2>Customer Manager</h2>
		<form method="get" action="/spring_mvc_jpa/search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
		<h3>
			<a href="/spring_mvc_jpa/new">New Customer</a>
		</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>E-mail</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listCustomer}" var="customer">
				<tr>
					<td>${customer.customerId}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
					<td><a href="/spring_mvc_jpa/edit?id=${customer.customerId}">Edit</a>
						&nbsp;&nbsp;&nbsp; <a href="/spring_mvc_jpa/delete?id=${customer.customerId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>