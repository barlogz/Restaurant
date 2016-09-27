<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<body style="background-color:#c3f3f9;">

<jsp:include page="../fragments/header.jsp" />

<div class="container" style="width: 50%; margin-left: 20px; align-items: center">

    <c:choose>
        <c:when test="${preparedDishForm['new']}">
            <h1 style="text-align: center; color: #23527c">Add prepared dish</h1>
        </c:when>
        <c:otherwise>
            <h1 style="text-align: center; color: #23527c">Update prepared dish</h1>
        </c:otherwise>
    </c:choose>
    <br />


    <spring:url value="/prepared/list" var="preparedDishActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="preparedDishForm" action="${preparedDishActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="dish.name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Dish name</label>
                <div class="col-sm-10">
                    <form:select path="dish.name" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${dishNames}"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="cook.firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Cook's name</label>
                <div class="col-sm-10">

                    <form:select path="cook.firstName" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${cookerNames}"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>


        <spring:bind path="cookingDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Cooking Date</label>
                <div class="col-sm-10">
                    <form:input path="cookingDate" type="date" class="form-control " id="cookingDate" placeholder="Date"  required="required"/>
                    <form:errors path="cookingDate" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${preparedDishForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update
                        </button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>


    </form:form>

</div>

<div style="margin-left: 20%">
    <spring:url value="/prepared/list" var="addUrl2"/>
    <button class="btn btn-info" onclick="location.href='${addUrl2}'">Back to list of prepared dishes</button>
</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>

