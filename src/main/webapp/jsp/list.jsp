<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- jQuery和bootstrap的js文件需要按固定顺序引入 -->
    <!-- bootstrap的js是基于jQuery，所以这二者的版本需要相对应 -->
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/css/bootstrap3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap3/css/bootstrap.css"/>
</head>
<body>
<form action="/user/selectAll" method="get">
    姓名：<input type="text" name="name" value="${userQo.name}">
    性别：
    <select name="sex">
    <option value="-1" <c:if test="${userQo.sex=='-1'}">selected</c:if>>请选择</option>
    <option value="1" <c:if test="${userQo.sex=='1'}">selected</c:if>>男</option>
    <option value="0" <c:if test="${userQo.sex=='0'}">selected</c:if>>女</option>
    </select>
    <input type="submit" value="提交">
</form>
<%--性别：<select>--%>
<%--<option></option>--%>
<%--<option></option>--%>
<%--<option></option>--%>
<%--</select>--%>
<a href="/jsp/add.jsp" class="btn btn-success">添加</a>
<table class="table table-bordered">
    <tr>
        <td>id</td>
        <td>名字</td>
        <td>年龄</td>
        <td>性别</td>
        <td>创建时间</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${user}" var="user" varStatus="status">
        <tr>
            <%--<td>${status.index+1}</td>--%>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>
                <c:choose>
                    <c:when test="${user.sex==1}">男</c:when>
                    <c:when test="${user.sex==0}">女</c:when>
                    <c:otherwise>非人类</c:otherwise>
                </c:choose>
            </td>
            <td>
                <fmt:parseDate value="${user.createTime}" var="date" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                <fmt:formatDate value="${date}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate>
            </td>
            <td>
                <a href="/user/toUpdate?id=${user.id}" class="btn btn-primary" value="修改"/>修改
            </td>
            <td>
                <a href="/user/delete?id=${user.id}" class="btn btn-danger" value="删除"/>删除
            </td>
        </tr>
    </c:forEach>
</table>
当前页数：${userQo.page},总页数：${userQo.pageTotal},总记录数：${userQo.count}
<a class="btn btn-success" href="/user/selectAll?page=${userQo.page-1}&name=${userQo.name}&sex=${userQo.sex}">上一页</a>
<a class="btn btn-success" href="/user/selectAll?page=${userQo.page+1}&name=${userQo.name}&sex=${userQo.sex}">下一页</a>
<%--<a href="/user/selectAll?page=${userQo.page>=userQo.pageTotal?userQo.pageTotal:userQo.page+1}">下一页</a>--%>
<%--<a href="/user/selectAll?page=2">2</a>--%>
<%--<a href="/user/selectAll?page=3">3</a>--%>
</body>
</html>
