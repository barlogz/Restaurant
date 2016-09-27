<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body style="background-color:#c3f3f9;">

<div style="width: 50%; margin-left: 20px">
    <h1 style="text-align: center; color: #23527c">Detailed information about
        staff: ${employee.firstName} ${employee.lastName} </h1>
    <table border="1" style="align-items: center" class="table table-striped">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birthday</th>
            <th>Phone Number</th>
            <th>Position</th>
            <th>Salary</th>
        </tr>

        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.birthday}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.position}</td>
            <td>${employee.salary}</td>
        </tr>

    </table>

</div>

<div style="margin-left: 20%">
    <spring:url value="/employees/list" var="addUrl2"/>
    <button class="btn btn-info" onclick="location.href='${addUrl2}'">Back to list of staff</button>
</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
