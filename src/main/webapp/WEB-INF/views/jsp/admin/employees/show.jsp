<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/adminheader.jsp"/>

<body style="background-color:#c3f3f9;">

<div style="width: 50%; margin-left: 20px">
    <h1 style="text-align: center; color: #23527c">Detailed <info></info>rmation about
        staff: ${employee.firstName} ${employee.lastName} </h1>
    <table border="1" style="align-items: center" class="table table-striped">
        <tr>
            <th>Photo</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birthday</th>
            <th>Phone Number</th>
            <th>Position</th>
            <th>Salary</th>
            <th>Info</th>

        </tr>

        <tr>
            <c:choose>
                <c:when test="${not empty photo}">
                    <td style="vertical-align: middle" width="150px"> <img src="data:image/jpeg;base64,${photo}" width="145" height="169"/> </td>
                </c:when>
                <c:otherwise>
                    <td style="vertical-align: middle" width="150px">  <img src="<c:url value="/resources/images/no-thumb.jpg"/>" width="145" height="169"/> </td>
                </c:otherwise>
            </c:choose>

            <td style="vertical-align: middle">${employee.firstName}</td>
            <td style="vertical-align: middle">${employee.lastName}</td>
            <td style="vertical-align: middle">${employee.birthday}</td>
            <td style="vertical-align: middle">${employee.phoneNumber}</td>
            <td style="vertical-align: middle">${employee.position}</td>
            <td style="vertical-align: middle">${employee.salary}</td>
            <td style="vertical-align: middle">${employee.biography}</td>

        </tr>

    </table>

</div>

<div style="margin-left: 20%">
    <spring:url value="/admin/employees/list" var="BackToListUrl"/>
    <button class="btn btn-info" onclick="location.href='${BackToListUrl}'">Back to list of staff</button>
</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
