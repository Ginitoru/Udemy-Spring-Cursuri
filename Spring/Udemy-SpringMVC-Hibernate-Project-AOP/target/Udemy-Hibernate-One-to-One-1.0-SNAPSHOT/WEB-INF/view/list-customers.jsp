<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>

    <title>List Customers</title>
<%--    reference our style sheet--%>

    <link type ="text/css"
          rel = "stylesheet"
          href="${pageContext.request.contextPath}/resourcesx/css/style.css"/>


</head>
    <body>

        <div id="wrapper">
            <div id = "header">
                <h2>CRM - Customer Relationship Manager</h2>


            </div>
        </div>

        <div id = "container">

            <div id = "content">

            <%-- put new Buton: Add Csutomer    --%>

                <input type="button" value="Add Customer"
                        onclick="window.location.href='showFormForAdd'; return false;"
                       class = "add-button" <%--  css style --%>

                />

            <%-- add out html table here--%>

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>

                <%--loop over and print our customers--%>

                    <c:forEach var="theCustomers" items="${customers}">

                        <tr>
                            <td>${theCustomers.firstName}</td>
                            <td>${theCustomers.lastName}</td>
                            <td>${theCustomers.email}</td>
                        </tr>

                    </c:forEach>

                </table>





            </div>
        </div>

    </body>




</html>