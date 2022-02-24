<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User historic</title>
</head>
<body>
<h1>Your purchases</h1>
     <c:forEach items ="${purchases}" var="purchase">
     <div>
		
		<p>${purchase.date}</p>	
	</div>
	
	<table>
            <tr>
                <td>Product name </td>
                <td>Category </td>
                <td>Price </td>
                <!--td>Quantity </td-->
            </tr>			
            <c:forEach items ="${purchase.products}" var="prod">
                <tr>
                    <td>${prod.productName}</td>
                    <td>${prod.category}</td>
                    <td>${prod.price}</td>
                </tr>
            </c:forEach>
            <tr><td>Total: ${purchase.total}</td></tr>
            		
        </table>

	</br>
	</hr>
     </c:forEach>
	</br>
	</hr>
                <td><a href="getProducts?userId=${userId}">Get back to the list of products</a></td>



</body>
</html>