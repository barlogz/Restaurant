<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <title>Spring MVC Form Handling Example</title>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/mystyle.css" var="myCss"/>
    <link href="${myCss}" rel="stylesheet"/>

    <style>
        .error {
            color: #ffa91b;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ffce29;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/login" var="login"/>
<spring:url value="/logout" var="logout"/>
<spring:url value="/users/add" var="urlAddUser"/>

<%--<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${login}">Log in</a>
		</div>
		<div id="logbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${logout}">Log out</a></li>
			</ul>
		</div>
	</div>
</nav>--%>


<img src="<c:url value="/resources/images/logo_small.jpg"/>" class="img-responsive center-block"/>
<hr>

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
            <a class="nav-link" href="/employees/list">
                <h4>Our Staff</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/menus/list">
                <h4>Меню</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/dishes/list">
                <h4>Блюда</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/prepared/list">
                <h4>Приготовленные блюда</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ingredients/list">
                <h4>Ингридиенты</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/orders/list">
                <h4>Заказы</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/warehouses/list">
                <h4>Склад</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/contact/info">
                <h4>Контакты</h4>
            </a>
        </li>
    </ul>

</nav>