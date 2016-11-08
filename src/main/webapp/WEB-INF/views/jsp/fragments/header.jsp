<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <title>Restaurant Una Pizza Napoletana</title>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/mystyle.css" var="myCss"/>
    <link href="${myCss}" rel="stylesheet"/>

    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/login" var="login"/>
<spring:url value="/logout" var="logout"/>
<spring:url value="/users/add" var="urlAddUser"/>
<spring:url value="/" var="index"/>
<spring:url value="/admin/menus/list" var="admin"/>

<img src="<c:url value="/resources/images/logo_small_blue.png"/>" class="img-responsive center-block"/>


<nav class="navbar navbar-light" style="background-color: #f3eca5; border: solid #658eff">
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <h4>Main</h4>
                <span class="sr-only">(current)</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/schema/tables">
                <h4>Pizzeria scheme</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ouremployees/list">
                <h4>Our Staff</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/contact/info">
                <h4>Contacts</h4>
            </a>
        </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li class="nav-item">
            <a class="nav-link" href="/admin/menus/list">
                <h4 style="font-weight: bold"><span style="margin-right: 100px">Admin</span></h4>
            </a>
        </li>
    </ul>

</nav>

