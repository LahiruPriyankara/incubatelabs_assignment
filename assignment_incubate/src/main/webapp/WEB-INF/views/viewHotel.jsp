<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HOTEL SYSTEM</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- MyTheam -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<script>
		window.menu = '${title}';
		window.menuCity = '${city_id}';
	</script>
	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<!-- Blog Entries Column -->
			<div class="col-md-8">

				<h1 class="my-4"></h1>

				<!-- Blog Post -->

				<c:if test="${selectOneHotel == true}">

					<img class="card-img-top"
						src="${images}/${hotelInfo.getImage_name()}" alt="Card image cap">

					<h2 class="card-title">This is ${hotelInfo.getHotel_name()}</h2>
					<p class="card-text">Address is ${hotelInfo.getHotel_address()}</p>
				</c:if>

				<c:if
					test="${userClickAllHotels == true  or userSelectedCity == true}">
					<%@include file="./shared/hotelInfo.jsp"%>
				</c:if>


				<c:if test="${userClickHome == true }">
					<%@include file="./shared/homeSingleImage.jsp"%>
				</c:if>


				<c:if test="${userClickAbout == true }">
					<h1 class="card-title">This is About Page</h1><br/>
					<img class="card-img-top" src="${images}/About-Us.jpg" alt="Card image cap">

				</c:if>

				<c:if test="${userClickContact == true }">
					<h1 class="card-title">This is Contact Page</h1><br/>
					<img class="card-img-top" src="${images}/contactus.jpg" alt="Card image cap">
					
				</c:if>

			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Search Widget -->
				<c:if
					test="${userClickAllHotels == true  or userSelectedCity == true}">
					<%@include file="./shared/search.jsp"%>
				</c:if>

				<!-- Cities Widget -->
				<c:if
					test="${userClickAllHotels == true  or userSelectedCity == true}">
					<%@include file="./shared/cityName.jsp"%>
				</c:if>



				<!-- Side Widget -->
				<div class="card my-4">
					<h5 class="card-header">Side Widget</h5>
					<div class="card-body">Hotel is a superior building meant for
						accommodating 15 or more strangers temporarily for few days.
						Strangers are charged according to the nature & period of
						accommodation. Hotel provides both lodging (temporary habitation)
						& boarding facilities.</div>
				</div>

			</div>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
		<%-- <%@include file="./shared/footer.jsp"%> --%> 
		<div style=" position: fixed; left: 0; bottom: 0;height:3%; width: 100%;" class="bg-dark">
  <p>Footer</p>
</div>
		
	


	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>

	<script src="${js}/myapp.js"></script>

</body>

</html>
