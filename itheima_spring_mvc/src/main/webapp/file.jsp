<%--
  Created by IntelliJ IDEA.
  User: wch
  Date: 2023/3/26
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/quick20" enctype="multipart/form-data" method="post">
        名称:<input type="text" name="name"><br>
        文件:<input type="file" name="upload"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
