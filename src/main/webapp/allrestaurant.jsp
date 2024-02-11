<%@ page import="zuci.rms.model.Restaurant,java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
  	
  	<c:if test="${not empty requestScope.rest}">
    <h1>Restaurant Details</h1>
    
    <table class="table">
  <thead>
    <tr>
      <!-- <th scope="col">#</th> -->
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">Phone</th>
      <th scope="col">DOE</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="restaurant" items="${requestScope.rest}">
    <tr>
      <!--  <th scope="row">1</th>-->
      <td>${restaurant.getRestaurantId()}</td>
      <td>${restaurant.getRestaurantName()}</td>
      <td>${restaurant.getRestaurantAddress()}</td>
      <td>${restaurant.getRestaurantPhone()}</td>
      <td>${restaurant.getRestaurantDeo()}</td>
    </tr>
    </c:forEach>
   
  </tbody>
</table>
</c:if>	
<c:if test="${empty requestScope.rest}">
	<p>Restaurant details not found</p>
</c:if>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>