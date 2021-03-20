<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/update" method="post">
    id:${users.id}<br/>
    <input type="text" name="id" value="${users.id}" style="display: none"/>
    名字:<input type="text" name="name" value="${users.name}"><br/>
    年龄:<input type="text" name="age" value="${users.age}"><br/>
    性别:<input type="radio" name="sex" value="1" <c:if test="${users.sex==1}"> checked </c:if>/>男
    <input type="radio" name="sex" value="0" <c:if test="${users.sex==0}"> checked </c:if>/>女<br/>
    <input type="submit" class="btn btn-success" value="提交">
</form>
</body>
</html>
