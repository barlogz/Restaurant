<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<body style="background-color:#c3f3f9;">

<jsp:include page="../fragments/adminheader.jsp"/>

<div class="container" style="width: 50%; margin-left: 20px; align-items: center">

    <c:choose>
        <c:when test="${orderForm['new']}">
            <h1 style="text-align: center; color: #23527c">Add Order</h1>
        </c:when>
        <c:otherwise>
            <h1 style="text-align: center; color: #23527c">Update Order</h1>
        </c:otherwise>
    </c:choose>
    <br/>


    <spring:url value="/admin/orders/list" var="orderActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="orderForm" action="${orderActionUrl}">

        <form:errors path="*" cssClass="errorblock" element="div"/>

        <form:hidden path="id" />


        <spring:bind path="waiter.firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Waiter's name</label>
                <div class="col-sm-10">

                    <form:select path="waiter.firstName" class="form-control">
                        <form:options items="${waiterNames}"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="tableNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Number of table</label>
                <div class="col-sm-10">
                    <form:input path="tableNumber" type="text" class="form-control " id="tableNumber"
                                placeholder="Number of table"/>
                    <form:errors path="tableNumber" class="control-label">
                        <div id="tableNumber.errors" class="error">Incorrect value!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="orderDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Date</label>
                <div class="col-sm-10">
                    <form:input path="orderDate" type="date" class="form-control " id="orderDate" placeholder="Date" required="required"/>
                    <form:errors path="orderDate" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="orderStatus">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Status of order</label>
                <div class="col-sm-10">

                    <form:select path="orderStatus" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${listOfOrderStatus}"/>
                    </form:select>
                    <form:errors path="orderStatus" class="control-label">
                        <div id="orderStatus.errors" class="error">Please select status!</div>
                    </form:errors>

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
    <spring:url value="/admin/orders/list" var="BackToListUrl"/>
    <button class="btn btn-info" onclick="location.href='${BackToListUrl}'">Back to list of orders</button>
</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
