<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todo's for ${name }</title>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

<%@ include file="common/navigation.jspf" %>

	<div class="container">

		<h1>Your todos</h1>

		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate }" pattern="dd/MM/yyyy"/> </td>
						<td>${todo.done }</td>
						<td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id }">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id }">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div><a class="button" href="/add-todo">Add a todo</a></div> 
	</div>
</body>
</html>