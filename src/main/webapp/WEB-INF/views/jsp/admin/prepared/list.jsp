<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body style="background-color:#c3f3f9;">

<div style="width: 50%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">Cooked dishes</h1>

    <spring:url value="/admin/prepared/add" var="addUrl" />
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Add Dish</button>
    <br>
    <br>

    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Dish Category</th>
            <th>Price</th>
            <th>Weight</th>
            <th>Cook date</th>
            <th>Cook Name</th>

            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${preparedDishes}" var="preparedDish">
            <tr>
                <td><a href="/admin/dishes/show/${preparedDish.dish.id}">${preparedDish.dish.name}</a></td>
                <td>${preparedDish.dish.dishCategory}</td>
                <td>${preparedDish.dish.price}</td>
                <td>${preparedDish.dish.weight}</td>
                <td>${preparedDish.cookingDate}</td>
                <td>${preparedDish.cook.firstName}</td>


                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/prepared/${preparedDish.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">
                        <img src="<c:url value="/resources/images/delete_button_30.jpg"/>"/>
                    </a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/prepared/${preparedDish.id}/update" var="updateUrl"/>
                    <a href="${updateUrl}">
                        <img src="<c:url value="/resources/images/edit_button_30.jpg"/>"/>
                    </a>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
<br/>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>
