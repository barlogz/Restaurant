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
        <c:when test="${warehouseForm['new']}">
            <h1 style="text-align: center; color: #23527c">Add Ingredient to Warehouse</h1>
        </c:when>
        <c:otherwise>
            <h1 style="text-align: center; color: #23527c">Update</h1>
        </c:otherwise>
    </c:choose>
    <br />


    <spring:url value="/warehouses/list" var="warehouseActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="warehouseForm" action="${warehouseActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="ingredient">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Select ingredient</label>
                <div class="col-sm-10">

                    <form:select path="ingredient.name" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${ingredientNameList.values()}"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>



        <spring:bind path="quantity">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Quantity</label>
                <div class="col-sm-10">
                    <form:input path="quantity" type="text" class="form-control " id="name" placeholder="Quantity"  required="required"/>
                    <form:errors path="quantity" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="measure">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Measure</label>
                <div class="col-sm-10">

                    <form:select path="measure" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${measures}"  />
                    </form:select>
                </div>
            </div>
        </spring:bind>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${warehouseForm['new']}">
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
    <spring:url value="/warehouses/list" var="addUrl2"/>
    <button class="btn btn-info" onclick="location.href='${addUrl2}'">Back to warehouse</button>
</div>


<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
