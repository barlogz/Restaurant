<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<jsp:include page="../fragments/adminheader.jsp"/>

<body style="background-color:#c3f3f9;">

<div style="width: 50%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">List of ingredients</h1>

    <spring:url value="/admin/ingredients/search" var="ingredientsActionUrl"/>
    <form:form class="form-horizontal" method="get" action="${ingredientsActionUrl}">
        <div class="container">
            <div class="row">
                <h4> Search by name</h4>
                <div class="search">
                        <%--<form:input path="searchingName" type="text" class="form-control input-sm" id="searchingName" placeholder="Search" />--%>
                    <input type="text" class="form-control input-sm" name="name" placeholder="Search"/>
                    <button type="submit" class="btnn btn-primary btn-sm">Search</button>
                </div>
            </div>
        </div>
    </form:form>

    <br>

    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach items="${ingredients}" var="ingredient">
        <tr>
            <td>${ingredient.name}</td>

            <td style="align-items: center; width: 20px">
                <spring:url value="/admin/ingredients/${ingredient.id}/delete" var="deleteUrl"/>
                <a href="${deleteUrl}">
                    <img src="<c:url value="/resources/images/delete_button_30.jpg"/>"/>
                </a>
            </td>
            <td style="align-items: center; width: 20px">
                <spring:url value="/admin/ingredients/${ingredient.id}/update" var="updateUrl"/>
                <a href="${updateUrl}">
                    <img src="<c:url value="/resources/images/edit_button_30.jpg"/>"/>
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
