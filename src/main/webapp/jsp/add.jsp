<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/add" method="post">
    姓名：<input type="text" name="name"><br/>
    密码：<input type="text" name="password"><br/>
    年龄：<input type="text" name="age"><br/>
    性别：
    <select name="sex">
    <option value="1">男</option>
    <option value="0">女</option>
    </select><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
