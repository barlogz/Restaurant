<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body style="background-color:#c3f3f9;">

<div style="width: 50%; margin-left: 20px">
    <h1 style="text-align: center; color: #23527c">Detailed information
        about dish: ${dish.name} </h1>
    <table border="1" style="align-items: center" class="table table-striped">
        <tr>
            <th width="120px">Dish Category</th>
            <th>Name</th>
            <th width="100px">Price</th>
            <th width="100px">Weight</th>
            <th>Description</th>
        </tr>

        <tr>
            <td>${dish.dishCategory}</td>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td>${dish.weight}</td>
            <td>${dish.description}</td>
        </tr>
    </table>
</div>


<hr/>
<%--<h3 style="margin-left: 50px; color: #23527c; background-color:#ffffff">Ingredients:</h3>--%>

<div style="width: 20%; margin-left: 20px">
    <table border="0.2" style="align-items: center; background-color:#ffffff" class="table table-hover">
        <thead style="color: #23527c; background-color:#ffffff">
        <tr>
            <th>Ingredients:</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${ingredients}" var="ingredient">
            <tr>
                <td>${ingredient.name}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/dishes/${dish.id}/deleteIngredient/${ingredient.id}"
                                var="deleteIngredientFromDishUrl"/>
                    <a href="${deleteIngredientFromDishUrl}">
                        <img src="<c:url value="/resources/images/delete_button_30.jpg"/>"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<hr/>
<%--<br>--%>


<div>
    <h2 style="margin-left: 30px; color: #23527c">Add ingredient to dish:</h2>
    <hr/>


    <spring:url value="/dish/${dish.id}/addIngredient" var="dishActionUrl"/>

    <form:form action="${dishActionUrl}" modelAttribute="ingredient" method="post">

        <spring:bind path="ingredient">
            <label class="col-sm-2 control-label"><h4>Choose ingredient:</h4></label>
            <div class="col-sm-2">

                <form:select path="name" class="form-control" multiple="false">
                    <form:option value="NONE" label="--SELECT--"/>
                    <form:options items="${ingredientNames}"/>
                </form:select>
            </div>
        </spring:bind>

        <button type="submit" class="btn-lg btn-primary ">Add</button>
    </form:form>

</div>

<div style="margin-left: 20%">
    <spring:url value="/dishes/list" var="BackToListUrl"/>
    <button class="btn btn-info" onclick="location.href='${BackToListUrl}'">Back to list of dishes</button>
</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>

