<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<c:if test="${userClickAllHotels == true }">
	<div class="container" id="hotel-list"> 
	<c:forEach items="${allHotels}" var="allHotels">
	<a href="${contextRoot}/show/hotel/${allHotels.getHotel_id()}"
		id="hotelsInCity.getHotel_name()" class="list-group-item">${allHotels.getHotel_name()}</a>


	<div class="card mb-4">
		<img class="card-img-top" src="${images}/${allHotels.getImage_name()}"
			alt="Card image cap">
		<div class="card-body">
			<h2 class="card-title">${allHotels.getHotel_name()}</h2>
			<p class="card-text">${allHotels.getHotel_address()}</p>
			<a href="${contextRoot}/show/hotel/${allHotels.getHotel_id()}" class="btn btn-primary">Read More &rarr;</a>
		</div>
	</div>


</c:forEach>
	</div>
</c:if>



<c:if test="${userSelectedCity == true }">
	<c:forEach items="${hotelsInCity}" var="hotelsInCity">
	<img class="card-img-top" src="${images}/${hotelsInCity.getImage_name()}.jpg"
			alt="Card image cap">


	<div class="card mb-4">
		<div class="card-body">
			<h2 class="card-title">${hotelsInCity.getHotel_name()}</h2>
			<p class="card-text">${hotelsInCity.getHotel_address()}</p>
			<a href="${contextRoot}/show/hotel/${hotelsInCity.getHotel_id()}" class="btn btn-primary">Read More &rarr;</a>
		</div>
	</div>


</c:forEach>
</c:if>






