<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<html lang="en">
<head>
<title>AddingNew</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</head>



<body background="${images}/bg-01.jpg">

	<nav class="navbar navbar-default" style="background-color: #404040">
		<div class="navbar-header" >
			<a href="${contextRoot}/home">
				<button type="button" class="btn btn-info">See Hotels</button>
			</a>
		</div>
	</nav>

	<div class="row" >
		<div class="col-sm-4"></div>


		<div class="col-sm-4"
			style="background-color: rgba(245, 245, 245, 1); width: 100%; height: 100%">
			<h4>Enter Hotel Details</h4>

			<form action="${contextRoot}/insert/add" method="POST"
				enctype="multipart/form-data">

				<label>Hotel Name </label> <input type="text" name="name"
					class="form-control" id="name">
				
				<label>Hotel Address </label> <input type="text" name="address"
					class="form-control" id="address">
				
				<label>Image </label> 
				
				<input type="file" name="file"
					class="form-control" id="file">
		

				<label>City </label> <br><select name="city_code">
					<c:forEach var="city" items="${cityInfo}" varStatus="status">
						<option value="${city.getCity_code()}"
							id="${city.getCity_code()} class="dropdown-header"">
							${city.getCity_name()}</option>
					</c:forEach>
				</select> <input type="submit" value="Insert" class="btn btn-primary" />

			</form>
			<h4>Adding A New City</h4>

			<form action="${contextRoot}/insert/add/city" method="POST"
				enctype="multipart/form-data">

				<label>City Name </label> <input type="text" name="name"
					class="form-control" id="name">
				
				<label>City Code </label> <input type="text" name="city_code"
					class="form-control" id="city_code">
				<input type="submit" value="Insert" class="btn btn-primary" />

			</form>



		</div>


		
	</div>
	</div>

</body>
</html>
