<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 22-Nov-20
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    First name: ${customer.firstName}
    <br><br>
    Last name: ${customer.lastName}
    <br><br>
    Course: ${customer.course}

</body>
</html>
