<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="logoutForm" method="POST" action="frontController">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login"/>
    <br/>Password:<br/>
    <input type="password" name="password"/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${userBlockedMessage}
    <br/>
    ${notAllowedActionForUser}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <input type="submit" value="Log in"/>
</form>
<hr>
</body>
</html>
