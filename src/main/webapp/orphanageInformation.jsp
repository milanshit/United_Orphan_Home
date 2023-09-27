<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Orphanage Information Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #4070f4">
  <div class="container-fluid">
    <a  href="HomePage"  class="navbar-brand nav-link text-white fs-3">ORPHAN</a>

	<a href="Logout" class="nav-link text-white fs-3">
      <button class="btn btn-outline-light" type="button">LogOut</button>
	</a>
  	</div>
	</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Child</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/AddChildPage" class="btn btn-success">Add
					New Child</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>orphanage ID</th>
						<th>child id</th>
						<th>name</th>
						<th>dob</th>
						<th>age</th>
						<th>gender</th>
						<th>religion</th>
						<th>Physically_disable</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="child" items="${listChild}">

						<tr>
							<td><c:out value="${child.getOrphanage_id()}" /></td>
							<td><c:out value="${child.getChild_id()}" /></td>
							<td><c:out value="${child.getName()}" /></td>
							<td><c:out value="${child.getDob()}" /></td>
							<td><c:out value="${child.getAge()}" /></td>
							<td><c:out value="${child.getGender()}" /></td>
							<td><c:out value="${child.getReligion()}" /></td>
							<td><c:out value="${child.getPhysically_disable()}" /></td>							
			
							<td><a href="UpdateChildPage?id=<c:out value='${child.getChild_id()}' />">Update</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="DeleteChild?id=<c:out value='${child.getChild_id()}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>