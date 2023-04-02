<%--
  Created by IntelliJ IDEA.
  User: wch
  Date: 2023/3/25
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/axios.js"></script>
</head>
<body>


<script>
    window.onload=function (){
        axios({
            method:"post",
            url:"http://localhost:8080/quick15",
            data:[{name:"wch",age:18,addr:"南京"},{name:"dsa",age:18,addr:"芜湖"}]
        }).then(function(resp) {
        })
    }
</script>
</body>
</html>
