<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/header.jsp"/>

<body>

<div style="width: 50%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">Список заказов</h1>


    <spring:url value="/order/add" var="addUrl"/>
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Add Order</button>
    <br>
    <br>

    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Waiter</th>
            <th>Number of table</th>
            <th>Date</th>
            <th>Status</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${ordersAttr}" var="order">
            <tr>
                <td><a href="/order/show/${order.id}">${order.id}</a></td>
                <td>${order.waiter.name}</td>
                <td>${order.tableNumber}</td>
                <td>${order.orderDate}</td>
                <td>${order.orderStatus}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/order/${order.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">
                        <img src="<c:url value="/resources/images/garbage24.jpg"/>"/>
                    </a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/order/${order.id}/update" var="updateUrl"/>
                    <a href="${updateUrl}">
                        <img src="<c:url value="/resources/images/edit24.png"/>"/>
                    </a>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
<br/>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
