<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Moderator page</title>
</head>
<body>
<form name="logoutForm" method="POST" action="frontController">
    <input type="hidden" name="command" value="logout"/>
    <input type="Submit" value="Log out">
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
</form>

<hr>

<h2>Заблокированные пользователи:</h2>
<table style="border: 1px solid black">
    <tr>
        <th>Id</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Дата рождения</th>
        <th>Группа пользователя</th>
        <th>Логин</th>
        <th>Пароль</th>
    </tr>
    <c:forEach var="user" items="${blocked_users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.surname}</td>
            <td>${user.name}</td>
            <td>${user.patronymic}</td>
            <td>${user.date_of_birth}</td>
            <td>${user.user_group_id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>
                <form name="blockUserForm" method="POST" action="frontController">
                    <input type="hidden" name="command" value="unblock_user">
                    <input type="hidden" name="user_id" value="${user.id}">
                    <input type="submit" value="Разблокировать">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<hr>

<h2>Незаблокированные пользователи:</h2>
<table style="border: 1px solid black">
    <tr>
        <th>Id</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Дата рождения</th>
        <th>Группа пользователя</th>
        <th>Логин</th>
        <th>Пароль</th>
    </tr>
    <c:forEach var="user" items="${not_blocked_users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.surname}</td>
            <td>${user.name}</td>
            <td>${user.patronymic}</td>
            <td>${user.date_of_birth}</td>
            <td>${user.user_group_id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>
                <form name="notBlockUserForm" method="POST" action="frontController">
                    <input type="hidden" name="command" value="block_user">
                    <input type="hidden" name="user_id" value="${user.id}">
                    <input type="submit" value="Заблокировать">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<hr>

<form name="addFlightForm" method="POST" action="frontController">
    <input type="hidden" name="command" value="add_flight"/>
    <br/>ID города прибытия:<br/>
    <input type="text" name="city"/>
    <br/>Время вылета:<br/>
    <input type="datetime-local" name="departure_date_time"/>
    <br/>Цена:<br/>
    <input type="text" name="cost"/>

    <input type="submit" value="Добавить"/>
</form>

<h2>Список городов:</h2>
<table style="border: 1px solid black">
    <tr>
        <th>Id</th>
        <th>Название</th>
    </tr>
    <c:forEach var="city" items="${cities}">
        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
        </tr>
    </c:forEach>
</table>
<hr>
</body>
</html>
