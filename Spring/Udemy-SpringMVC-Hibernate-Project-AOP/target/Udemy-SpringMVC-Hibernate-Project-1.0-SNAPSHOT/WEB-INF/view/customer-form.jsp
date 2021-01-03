<%@taglib prefix="from" uri ="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>



<html>

<head>
    <title>Save Customer</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resourcesx/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resourcesx/css/add-customer-style.css">



</head>

<body>

    <div id="wrapper">
        <div id ="header">
            <h2>CRM-Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>

        <from:form action="saveCustomer" modelAttribute="customer" method="POST">

            <%--need to associate this adata with customer id foarte importatna linia de jos ->altfe nu face update --%>

            <form:hidden path="id" />

            <table>

                <tbody>
                    <tr>
                        <td><label>First Name:</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>

                    <tr>
                        <td><label>Last Name:</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>

                    <tr>
                        <td><label>Email:</label></td>
                        <td><form:input path="email"/> </td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class ="save"> </td>

                    </tr>


                </tbody>
            </table>



        </from:form>

        <div style="clear: both;"></div>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>

    </div>




</body>



</html>