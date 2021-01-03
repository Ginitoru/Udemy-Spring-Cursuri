<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 22-Nov-20
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

    Student first name: ${student.firstName}
    <br><br>
    Student last name: ${student.lastName}

    <br><br>
    Country: ${student.country}
    <br><br>

    Language: ${student.favoriteLanguage}


</body>
</html>
