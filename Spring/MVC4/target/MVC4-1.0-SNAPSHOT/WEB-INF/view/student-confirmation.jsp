<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
    <title>Student Confirmation</title>
</head>
    <body>
        The student is confirmed: ${student.lastName} ${student.firstName}
        <br><br>

    Country: ${student.country}

        <br><br>

    Favorite language: ${student.favoriteLanguage}

    Favorite Language 2:  ${student.favoriteLanguage2}

    Operaing Systems:

    <ul>
        <c:forEach var = "temp" items = "${student.operatingSystems}">

            <li>${temp}</li>

        </c:forEach>




    </ul>

    </body>
</html>