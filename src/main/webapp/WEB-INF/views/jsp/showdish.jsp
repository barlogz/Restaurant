<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../jsp/fragments/header.jsp" />

<body style="background-color:#c3f3f9;">

<h2 style="margin-left: 50px; color: #23527c">${dish.name}</h2>
<div style="width: 75%; margin-left: 20px">

    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:#4387d0">
        <tr>
            <th width="200px">Dish name</th>
            <th width="100px">Price, UAH.</th>
            <th width="100px">Weight, gr.</th>
            <th width="100px">Category</th>
            <th>Description</th>
        </tr>
        </thead>

        <tr>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td>${dish.weight}</td>
            <td>${dish.dishCategory}</td>
            <td>${dish.description}</td>
        </tr>
    </table>
</div>

<hr>
<h3 style="margin-left: 50px; color: #23527c">Dish ingredients:</h3>

<div style="width: 20%; margin-left: 20px">
    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:#a947e4">
        <tr>
            <th>Name of the ingredient</th>
        </tr>
        </thead>

        <c:forEach items="${ingredients}" var="ingredient">
        <tr>
            <td>${ingredient.name}</td>
        </tr>

        </c:forEach>

</div>


<jsp:include page="../jsp/fragments/footer.jsp"/>
</body>
</html>

