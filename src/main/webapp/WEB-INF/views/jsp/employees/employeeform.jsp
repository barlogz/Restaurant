<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<body style="background-color:#c3f3f9;">

<jsp:include page="../fragments/header.jsp" />

<div class="container"  style="width: 50%; margin-left: 20px; align-items: center">

    <c:choose>
        <c:when test="${employeeForm['new']}">
            <h1 style="text-align: center; color: #23527c">Add Employee</h1>
        </c:when>
        <c:otherwise>
            <h1 style="text-align: center; color: #23527c">Update User</h1>
        </c:otherwise>
    </c:choose>
    <br />


    <spring:url value="/employees/list" var="employeeActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="employeeForm" action="${employeeActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">First Name</label>
                <div class="col-sm-10">
                    <form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="First Name" required="required"/>
                    <form:errors path="firstName" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Last Name</label>
                <div class="col-sm-10">
                    <form:input path="lastName" class="form-control" id="lastName" placeholder="Last Name" required="required"/>
                    <form:errors path="lastName" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="birthday">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Birthday</label>
                <div class="col-sm-10">
                    <form:input path="birthday" type="date" class="form-control " id="birthday" placeholder="Date in format YYYY-MM-DD" required="required"/>
                    <form:errors path="birthday" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="phoneNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Phone Number</label>
                <div class="col-sm-10">
                    <form:input path="phoneNumber" class="form-control" id="phoneNumber" placeholder="Phone Number, like +38(0XX)XXX-XX-XX" />
                    <form:errors path="phoneNumber" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="position">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Position</label>
                <div class="col-sm-10">
                    <form:select path="position" class="form-control">
                        <form:option value="NONE">--SELECT--</form:option>
                        <form:options items="${listOfPositions}"/>
                    </form:select>
                    <form:errors path="position" class="control-label">
                        <div id="position.errors" class="error">Please select position!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="salary">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Salary</label>
                <div class="col-sm-10">
                    <form:input path="salary" rows="5" class="form-control" id="salary" placeholder="Salary" />
                    <form:errors path="salary" class="control-label">
                        <div id="salary.errors" class="error">Incorrect value!</div>
                    </form:errors>
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${employeeForm['new']}">
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
    <spring:url value="/employees/list" var="BackToListUrl"/>
    <button class="btn btn-info" onclick="location.href='${BackToListUrl}'">Back to list of staff</button>
</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
