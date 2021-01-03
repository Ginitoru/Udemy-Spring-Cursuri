<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 19-Nov-20
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>


<html>
<head>
    <title>Student Registration Form</title>
</head>

<body>

    <form:form action="processForm" modelAttribute="student">

        First name: <form:input path="firstName"/>

        <br><br>
<%--lastName este chiar atributul din clasa Student--%>
        Last name: <form:input path="lastName"/>

        <br><br>

        Country:
<%--country este chiar atributul din clasa Student--%>
        <form:select path="country">
<%--            <form:option value="Brazil" label="Brazil"/>--%>
<%--            <form:option value="France" label="France"/>--%>
<%--            <form:option value="Germany" label="Germany"/>--%>
<%--            <form:option value="India" label="India"/>--%>

<%--            ia direct lista din clasa Student si o afiseaza--%>
            <form:options items="${student.coutryOptions}"/>

        </form:select>

        <br><br>

        Favorite Language:

        Java <form:radiobutton path="favoriteLanguage" value="Java"/>
        C#<form:radiobutton path="favoriteLanguage" value="C#"/>
        PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
        RUBY<form:radiobutton path="favoriteLanguage" value="RUBY"/>

        <br><br>

        Favorite Language 2:



        <form:radiobuttons path="favoriteLanguage2" items="${student.languages}"/>


        <br><br>

        Linux <form:checkbox path="operatingSystems" value="Linux"/>
        Mac Os <form:checkbox path="operatingSystems" value="Mac Os"/>
        Ms Wind <form:checkbox path="operatingSystems" value="Ms Wind"/>


        <br><br>



        <input type="submit" value="Submit">

    </form:form>






</body>

</html>
