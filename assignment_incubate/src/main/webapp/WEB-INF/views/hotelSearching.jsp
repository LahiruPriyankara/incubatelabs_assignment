 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<c:choose>
    <c:when test="${allHotels.size()>0}">
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
    </c:when>    
    <c:otherwise>
		<div class="card mb-4">

		<div class="card-body">
			<h2 class="card-title">No Hotels</h2>
		</div>
	</div>
    </c:otherwise>
</c:choose>
