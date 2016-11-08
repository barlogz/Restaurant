<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body style="background-color:#c3f3f9;">

<div style="width: 50%; margin-left: 20px; align-items: center">

    <h1 style="text-align: center; color: #23527c">Our restaurant dishes</h1>

    <spring:url value="/admin/dishes/add" var="addUrl" />
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Add Dish</button>
    <br>
    <br>

    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th>Dish Category</th>
            <th>Name</th>
            <th>Price</th>
            <th>Weight</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${dish}" var="dish">
            <tr>
                <td>${dish.dishCategory}</td>
                <td><a href="/admin/dishes/show/${dish.id}">${dish.name}</a></td>
                <td>${dish.price}</td>
                <td>${dish.weight}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/dishes/${dish.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">
                        <img src="<c:url value="/resources/images/delete_button_30.jpg"/>"/>
                    </a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/dishes/${dish.id}/update" var="updateUrl"/>
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
