<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

                <!--  add a search box -->
                <form:form action="search" method="GET">
                    Search customer: <input type="text" name="theSearchName" />

                    <input type="submit" value="Search" class="add-button" />
                </form:form>

            <%-- add out html table here--%>

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>

                <%--loop over and print our customers--%>

                    <c:forEach var="theCustomers" items="${customers}">
                    <%-- contruct an "update" link with customer id --%>
                        <c:url var = "updateLink" value ="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${theCustomers.id}"/>
                        </c:url>

                        <%-- construct an "delete" link with customer id--%>

                        <c:url var = "deleteLink" value ="/customer/delete">
                            <c:param name="customerId" value="${theCustomers.id}"/>
                        </c:url>


                        <tr>
                            <td>${theCustomers.firstName}</td>
                            <td>${theCustomers.lastName}</td>
                            <td>${theCustomers.email}</td>

                            <td>
                                <%-- display the update link--%>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                        <%--codul de jos este cod Java Script --%>
                                    onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>

                            </td>
                        </tr>

                    </c:forEach>

                </table>





            </div>
        </div>

    </body>




</html>