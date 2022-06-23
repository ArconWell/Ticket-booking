<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Administrator page</title>
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

<form name="addUserForm" method="POST" action="frontController">
    <input type="hidden" name="command" value="add_user"/>
    <br/>Фамилия:<br/>
    <input type="text" name="surname"/>
    <br/>Имя:<br/>
    <input type="text" name="name"/>
    <br/>Отчество:<br/>
    <input type="text" name="patronymic"/>
    <br/>Дата рождения:<br/>
    <input type="date" name="date_of_birth"/>
    <br/>ID группы пользователя:<br/>
    <input type="text" name="user_group_id"/>
    <br/>Логин:<br/>
    <input type="text" name="login"/>
    <br/>Пароль:<br/>
    <input type="text" name="password"/>

    <input type="submit" value="Добавить"/>
</form>

<hr>

<h2>Авторизированные пользователи:</h2>
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
    <c:forEach var="user" items="${authorized_users}">
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
            <form name="deleteUserForm" method="POST" action="frontController">
                <input type="hidden" name="command" value="delete_user">
                <input type="hidden" name="user_id" value="${user.id}">
                <input type="submit" value="Удалить">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
    <hr>

    <h2>Все пользователи:</h2>
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
        <c:forEach var="user" items="${users}">
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
                    <form name="deleteUserForm" method="POST" action="frontController">
                        <input type="hidden" name="command" value="delete_user">
                        <input type="hidden" name="user_id" value="${user.id}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
