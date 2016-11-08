<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../fragments/adminheader.jsp" />

<body>

<div style="width: 60%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">REST API</h1>


    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:#419641">
        <tr>
            <th style="text-align: center; width: 40%">Task</th>
            <th style="text-align: center">Get JSON</th>
        </tr>
        </thead>

        <tr>
            <td>Get list of all employees (just names and surnames)</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-employee">
                    <img src="<c:url value="/resources/images/json.jpg"/>"/>
                </a>
            </td>
        </tr>

        <tr>
            <td>Get employee by ID</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8030/get-json-employeeById/{id}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8030/get-json-employeeById/2
            </td>
        </tr>

        <tr>
            <td>Find employee by name</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8030/get-json-employeeByName/{firstName}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8030/get-json-employeeByName/Antonio
            </td>
        </tr>

        <tr>
            <td>Find employee by surname</td>
            <td>
                <span style="font-weight: bold">enter URL: </span>
                http://localhost:8030/get-json-employeeBySurname/{lastName}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8030/get-json-employeeBySurname/Petrenko
            </td>
        </tr>

        <tr>
            <td>Find employee by name and surname</td>
            <td><span style="font-weight: bold">enter URL: </span>
                http://localhost:8030/get-json-employeeByNameAndSurname/{firstName}/{lastName}
                <br>
                <span style="font-weight: bold">example: </span>
                http://localhost:8030/get-json-employeeByNameAndSurname/Antonio/Moreno
            </td>
        </tr>

        <tr>
            <td>Get list of all orders</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-order">
                    <img src="<c:url value="/resources/images/json.jpg"/>"/>
                </a>
            </td>

        <tr>
            <td>Get order by id</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8030/get-json-orderById/{id}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8030/get-json-orderById/1
            </td>
        </tr>

        <tr>
            <td>Get list of orders in status "OPENED"</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-openedOrder">
                    <img src="<c:url value="/resources/images/json.jpg"/>"/>
                </a>
            </td>
        </tr>

        <tr>
            <td>Get list of orders in status "CLOSED"</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-closedOrder">
                    <img src="<c:url value="/resources/images/json.jpg"/>"/>
                </a>
            </td>
        </tr>

        <tr>
            <td>Get list of all menus (without dishes)</td>
            <td style="align-items: center; width: 20px">
                <a href="/get-json-menu">
                    <img src="<c:url value="/resources/images/json.jpg"/>"/>
                </a>
            </td>
        </tr>

        <tr>
            <td>Get menu by name</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8030/get-json-menuByName/{firstName}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8030/get-json-menuByName/Dinner
            </td>
        </tr>

        <tr>
            <td>Get menu by ID (with list of dishes in it)</td>
            <td>
                <span style="font-weight: bold">enter URL: </span> http://localhost:8030/get-json-menuById/{id}
                <br>
                <span style="font-weight: bold">example: </span> http://localhost:8030/get-json-menuById/2
            </td>
        </tr>


    </table>
</div>
<br/>
<br/>
<br/>
<br/>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>


