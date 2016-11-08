<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<jsp:include page="../jsp/fragments/header.jsp"/>
<body style="background-color:#c3f3f9;">

<div style="margin-left: 15px">
    <table style="width: 600px">

        <tr style="vertical-align:top">
            <td>
                <img style="margin-right: 15px" src="<c:url value="/resources/images/logo_pizza.jpg"/>">


        <%--<tr style="vertical-align:top">--%>
            <%--<td style="margin-top: 25px">--%>
                <div style="margin-top: 5px">
                    <div style="text-align: center">
                    </div>
                    <h4 style="width: 600px">
                        <p style="text-align: justify"> &nbsp; Una Pizza Napoletana opened its doors in Ukraine in 1992.
                            A
                            classical Italian pizza retains its taste for only 15 minutes after it’s prepared.
                            That’s why restaurants which specialise in making thin crust pizza often don’t have
                            home delivery of their products.</p>
                        <p style="text-align: justify"> &nbsp; Because of our original recipes, which were developed by
                            well
                            known chefs in Italy, Canada and Ukraine, Vesuvio Pizza is the best. Our pizzas are great,
                            whether eaten fresh or even out of the fridge.</p>
                        <p style="text-align: justify"> &nbsp; Our first pizzeria opened in the summer of 1994. Located
                            at
                            Reitarska 25, it is near Kyiv’s historical sites – the St. Sophia Cathedral and the
                            Golden Gates.</p>
                        <p style="text-align: justify"> &nbsp; Una Pizza Napoletana is a favourite of Kyivans and
                            visitors to
                            this city, who appreciate our Italian kitchen, good music and great service. And even
                            though a great deal has changed over the 20 years since we first started, our
                            quality continues to retain its high level.</p>
                    </h4>
                    <table>
                        <tr>
                            <td>
                                <img src="<c:url value="/resources/images/book_a_table_sm.jpg"/>">
                            </td>
                            <td>
                                <h4 style="color: #0b0776">
                                    &nbsp; (044) 278-30-28
                                </h4>
                            </td>
                        </tr>
                    </table>


                </div>
            <%--</td>--%>

        <%--</tr>--%>
        </td>

        <td width="65%">
            <div style="text-align: center">
                <img src="<c:url value="/resources/images/text-menu-ourmenu_283.png"/>">
            </div>
            <%--<br>--%>

            <div style="text-align: left">
                <spring:url value="/search" var="indexActionUrl"/>
                <form:form class="form-horizontal" method="get" action="${indexActionUrl}">
                    <div class="container">
                        <div class="row">
                                <%-- <h4>  Search by name</h4>--%>
                            <div class="search">
                                    <%--<form:input path="searchingName" type="text" class="form-control input-sm" id="searchingName" placeholder="Search" />--%>
                                <input type="text" class="form-control input-sm" name="name"
                                       placeholder="Input the name"/>
                                <button type="submit" class="btnn btn-primary btn-sm">Search dish</button>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>

            <br>
            <table border="0.2" style="align-items: center" class="table table-striped">
                <thead style="color:#0b0776;background-color:#f3eca5">
                <tr>
                    <th width="200px">Dish name</th>
                    <th width="100px">Price, UAH.</th>
                    <th width="100px">Weight, gr.</th>
                    <th>Description</th>
                </tr>
                </thead>
                    <tr>
                        <td><a href="/showdish/${dishes.name}">${dishes.name}</a></td>
                        <td>${dishes.price}</td>
                        <td>${dishes.weight}</td>
                        <td>${dishes.description}</td>
                    </tr>
            </table>
        </td>
        </tr>
    </table>

</div>


</body>
</html>
