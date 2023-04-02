<%--
  Created by IntelliJ IDEA.
  User: wch
  Date: 2023/3/25
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/quick14" method="get">
        <h1>1</h1>
        <input type="text" name="userList[0].name"><br>
        <input type="text" name="userList[0].age"><br>
        <input type="text" name="userList[0].addr"><br>
        <h1>2</h1>
        <input type="text" name="userList[1].name"><br>
        <input type="text" name="userList[1].age"><br>
        <input type="text" name="userList[1].addr"><br>
        <input type="submit">
    </form>
</body>
</html>
