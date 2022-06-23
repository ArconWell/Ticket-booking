<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<h3>Welcome</h3>
<hr>
Hello, ${user_name}
<hr>
<form name="logoutForm" method="POST" action="frontController">
    <input type="hidden" name="command" value="logout"/>
    <input type="Submit" value="Log out">
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
</form>
    <h2>Список рейсов:</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Id города прибытия</th>
            <th>Время отправления</th>
            <th>Цена</th>
        </tr>
        <c:forEach var="flight" items="${flights}">
            <tr>
                <td>${flight.id}</td>
                <td>${flight.city_id}</td>
                <td>${flight.departure_date_time}</td>
                <td>${flight.cost}</td>
                <td>
                    <form name="buyTicketForm" method="POST" action="frontController">
                        <input type="hidden" name="command" value="add_ticket">
                        <input type="hidden" name="flight_id" value="${flight.id}">
                        <input type="submit" value="Купить">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
