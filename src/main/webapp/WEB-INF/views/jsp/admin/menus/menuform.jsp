<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<body style="background-color:#c3f3f9;">

<jsp:include page="../fragments/adminheader.jsp" />

<div class="container" style="width: 50%; margin-left: 20px; align-items: center">

    <c:choose>
        <c:when test="${menuForm['new']}">
            <h1 style="text-align: center; color: #23527c">Add Menu</h1>
        </c:when>
        <c:otherwise>
            <h1 style="text-align: center; color: #23527c">Update Menu</h1>
        </c:otherwise>
    </c:choose>
    <br />


    <spring:url value="/admin/menus/list" var="menuActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="menuForm" action="${menuActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control " id="name" placeholder="Name"  required="required"/>
                    <form:errors path="name" class="control-label" />
                </div>
            </div>
        </spring:bind>

       <%-- <spring:bind path="dishCategory">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Dish Category</label>
                <div class="col-sm-10">
                    
                    <form:select path="dishCategory" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${listOfDishCategory}"/>
                    </form:select>
                    
                </div>
            </div>
        </spring:bind>--%>



        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${menuForm['new']}">
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
    <spring:url value="/admin/menus/list" var="BackToListUrl"/>
    <button class="btn btn-info" onclick="location.href='${BackToListUrl}'">Back to list of menu</button>
</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
