
<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 22-Nov-20
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Customer-Form</title>
    <style>
        .error {color: red}
    </style>
</head>
<body>

    <form:form action="confirmationForm" modelAttribute="customer">

        First name: <form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>

        <br><br>

        Last name: <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
        <br><br>

        Course:<form:input path="course"/>
        <form:errors path="course" cssClass="error"/>

        <br><br>

        <input type="submit" value="Enter">
    </form:form>


</body>
</html>
