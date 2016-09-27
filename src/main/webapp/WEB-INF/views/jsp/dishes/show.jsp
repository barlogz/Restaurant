<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body style="background-color:#c3f3f9;">

<div style="width: 50%; margin-left: 20px">
    <h1 style="text-align: center; color: #23527c">Detailed information
        about dish: ${dish.name} </h1>
    <table border="1" style="align-items: center" class="table table-striped">
        <tr>
            <th>Name</th>
            <th>Dish Category</th>
            <th>Price</th>
            <th>Weight</th>
        </tr>

        <tr>
            <td>${dish.name}</td>
            <td>${dish.dishCategory}</td>
            <td>${dish.price}</td>
            <td>${dish.weight}</td>
        </tr>


    </table>
</div>

<div style="margin-left: 20%">
    <spring:url value="/dishes/list" var="BackToListUrl"/>
    <button class="btn btn-info" onclick="location.href='${BackToListUrl}'">Back to list of dishes</button>
</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>

