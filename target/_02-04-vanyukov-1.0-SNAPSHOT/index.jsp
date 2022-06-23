<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
    <jsp:forward page="/jsp/login.jsp"></jsp:forward>
    <input type="hidden" name="command" value=""/>
</body>
</html>