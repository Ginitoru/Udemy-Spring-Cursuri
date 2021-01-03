<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
    <title>luv2code Company name</title>
</head>

<body>
    <h2>luv2 code Company Home Page</h2>
    <hr>
        <p>
            Welcome to the luv2code company name Page!!! xxx
        </p>

        <hr>


        <%-- Display username and role--%>
        <p>
            User: <security:authentication property="principal.username"/>
            <br><br>
            Role(s): <security:authentication property="principal.authorities"/>
        </p>

        <hr>


            <%--doar MANAGE acces roll va vedea cest link --%>
        <security:authorize access="hasRole('MANAGER')">
            <%-- add a link to point to /leaders ... this is for the managers--%>
            <p>
                <a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
                (Only for Manager Peeps)
            </p>
        </security:authorize>



            <%--doar ADMIN acces roll va vedea cest link --%>
        <security:authorize access="hasRole('ADMIN')">
            <p>
                <%-- add a link to point to /systems .. this is for admins--%>
            <a href="${pageContext.request.contextPath}/systems">Admin Page</a>
            (Only for admin)
            <p>
            </security:authorize>


        <hr>



        <%--Add logout button--%>
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">


        <input type="submit" value="Logout"/>




    </form:form>


</body>


</html>