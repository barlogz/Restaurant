<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<jsp:include page="../jsp/fragments/header.jsp"/>
<body>

<div style="margin-left: 15px">
    <table style="width: auto">
        <tr style="vertical-align:top">
            <td>
                <img src="<c:url value="/resources/images/logo_pizza.jpg"/>">
            </td>

            <td style="margin-top: 25px">
                <div style="margin-top: 25px">
                    <div style="text-align: right">
                    </div>
                    <h4 style="width: 640px">
                        <p style="text-align: justify"> Una Pizza Napoletana opened its doors in Ukraine in 1992. A
                            classical Italian pizza retains its taste for only 15 minutes after it’s prepared.
                            That’s why restaurants which specialise in making thin crust pizza often don’t have
                            home delivery of their products.</p>
                        <p style="text-align: justify">  Because of our original recipes, which were developed by well
                            known chefs in Italy, Canada and Ukraine, Vesuvio Pizza is the best.  Our pizzas are great,
                            whether eaten fresh or even out of the fridge.</p>
                        <p style="text-align: justify">  Our first pizzeria opened in the summer of 1994.  Located at
                            Reitarska 25, it is near Kyiv’s historical sites – the St. Sophia Cathedral and the
                            Golden Gates.</p>
                        <p style="text-align: justify">  Una Pizza Napoletana is a favourite of Kyivans and visitors to
                            this city, who appreciate our Italian kitchen, good music and great service.  And even
                            though a great deal has changed over the 20 years since we first started Vesuvio, our
                            quality continues to retain its high level.</p>
                    </h4>
                    <table>
                        <tr>
                            <td>
                                <img src="<c:url value="/resources/images/book_a_table.jpg"/>">
                            </td>
                            <td>
                                <h4 style="color: #0b0776">
                                    (044) 123-45-54
                                </h4>
                            </td>
                        </tr>
                    </table>


                </div>
            </td>
        </tr>
    </table>

</div>


</body>
</html>
