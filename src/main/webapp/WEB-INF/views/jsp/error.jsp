<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="admin/fragments/adminheader.jsp" />

<body style="background-color:#c3f3f9;">


<div class="container">

    <h1>Error Page</h1>

    <h3 style="color: #a92a27">${exception.message}</h3>
    <%--Exception: ${exception.message}.
          <c:forEach items="${exception.stackTrace}" var="stackTrace">
            ${stackTrace}
        </c:forEach>--%>


</div>

<jsp:include page="../jsp/fragments/footer.jsp" />

</body>
</html>