<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 22-Nov-20
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student Confirmation</title>
    <style>
        .error {color: red}

    </style>
</head>
<body>

    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>

        <br><br>

        Last name: <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>

        <br><br>

        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}"/>


        </form:select>
        <br><br>

        Language:
        <form:radiobuttons path="favoriteLanguage" items="${student.languages}"/>

        <br><br>





        <input type="submit" value="Submit">


    </form:form>


</body>
</html>
