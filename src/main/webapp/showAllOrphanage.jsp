<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
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


		<div class="container-fluid">
			<h3 class="text-center">List of Orphanages</h3>
			<hr>
		</div>
		<br>
		
		
		<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Orphanage Details</th>
      <th scope="col">Orphanage Address</th>
      <th scope="col">Description</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
  <c:forEach var="orphanage" items="${listOrphanage}">
    <tr>
      <th scope="row"></th>
      <td>
      						<label><b>Registration Id :- </b></label><c:out value="${orphanage.getRegistration_id()}" />
							<label><b>Name :- </b></label><c:out value="${orphanage.getName()}" /><br>
							<label><b>Email :- </b></label><c:out value="${orphanage.getEmail()}" /><br>
							<label><b>PH Number 1 :- </b></label><c:out value="${orphanage.getPhone_number_1()}" />
							<label><b>PH Pumber 2 :- </b></label><c:out value="${orphanage.getPhone_number_2()}" /><br>
	 </td>
      <td>
    						 <label><b>Address :- </b></label><c:out value="${orphanage.getAddress()}" /><br>
							<label><b>Country :- </b></label><c:out value="${orphanage.getCountry()}" />						
							<label><b>State :- </b></label><c:out value="${orphanage.getState()}" />
							<label><b>City :- </b></label><c:out value="${orphanage.getCity()}" />
      </td>
      <td>
      						<c:out value="${orphanage.getDescription()}" />
      </td>
      <td><a href="Click?id=<c:out value='${orphanage.getId()}' />">View</a>
    </tr>
    
   
    </c:forEach>
  </tbody>
</table>
		
		
		
		
		
		
		
		
		
		
</body>
</html>