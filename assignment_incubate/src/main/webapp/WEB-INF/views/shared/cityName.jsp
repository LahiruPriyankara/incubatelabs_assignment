<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<div class="card my-4">
	<h5 class="card-header">Cities</h5>
	<div class="card-body">
		<div class="row">
			<div class="col-lg-6">
				<ul class="list-unstyled mb-0">
					<li style="width: 100%">
					<a href="#" id="0" class="list-group-item city-search">All</a>
					</li>
					<c:forEach items="${cityInfo}" var="cityInfo">
						<li style="width: 100%"><a
							href="#"
							
							id="${cityInfo.getCity_code()}" class="list-group-item city-search">${cityInfo.getCity_name()}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>