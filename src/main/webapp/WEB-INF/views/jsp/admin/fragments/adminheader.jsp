<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>

    <title>Restaurant Una Pizza Napoletana</title>

    <spring:url value="/resources/css/bootstrap.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/search.css" var="search"/>
    <link href="${search}" rel="stylesheet"/>

    <link rel="stylesheet" type="text/css" href="/resources/css/table.css" media="all">

    <script type="text/javascript" src="/resources/js/table.js"></script>


   <%-- <link type="text/css" href="/resources/css/sort.css" rel="stylesheet" />--%>
    <%--<spring:url value="/resources/js/sort.js" var="sortJs"/>
    <script type="text/javascript" src="${sortJs}"></script>--%>

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


<nav class="navbar navbar-inverse ">
    <div class="container">
        <div id="logbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<a href="/">
    <img src="<c:url value="/resources/images/logo_small_blue.png"/>" class="img-responsive center-block"/>
</a>
<hr>

<nav class="navbar navbar-light" style="background-color: peachpuff; border: solid #0f1e6f">
    <ul class="nav navbar-nav">

        <li class="nav-item active">
            <a class="nav-link" href="/admin/menus/list">
                <h4 style="color: #0f1e6f; font-weight: bold">Меню</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/admin/dishes/list">
                <h4 style="color: #0000a7; font-weight: bold">Блюда</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/admin/employees/list">
                <h4 style="color: #0000a7; font-weight: bold">Персонал</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/admin/warehouses/list">
                <h4 style="color: #0000a7; font-weight: bold">Склад</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/admin/orders/list">
                <h4 style="color: #0000a7; font-weight: bold">История заказов</h4>
            </a>
        </li>


        <li class="nav-item">
            <a class="nav-link" href="/admin/prepared/list">
                <h4 style="color: #0000a7; font-weight: bold">Приготовленные блюда</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/admin/ingredients/list">
                <h4 style="color: #0000a7; font-weight: bold">Ингридиенты</h4>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/admin/rest/rest">
                <h4 style="color: #0000a7; font-weight: bold">REST</h4>
            </a>
        </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li class="nav-item">
            <a class="nav-link" href="/">
                <h4 style="font-weight: bold"><span style="margin-right: 100px; color: #0000a7">Site</span></h4>
            </a>
        </li>
    </ul>

</nav>

<%--<body class="news">
<header>
    <div class="nav">
        <ul>
            <li class="menus"><a href="/admin/menus/list">Меню</a></li>
            <li class="dishes"><a &lt;%&ndash;class="active"&ndash;%&gt; href="/admin/dishes/list">Блюда</a></li>
            <li class="employees"><a href="/admin/employees/list">Персонал</a></li>
            <li class="warehouse"><a href="/admin/warehouses/list">Склад</a></li>
            <li class="orders"><a href="/admin/orders/list">История заказов</a></li>
            <li class="prepared"><a href="/admin/prepared/list">Приготовленные блюда</a></li>
            <li class="ingredients"><a href="/admin/ingredients/list">Ингридиенты</a></li>
            <li class="rest"><a href="/admin/rest/rest">REST</a></li>
        </ul>

    </div>
</header>
</body>--%>
