<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/css/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/bootstrap3/css/bootstrap.css"/>
<body>
<%--<a href="/user/selectAll">查询</a>--%>

<form action="/login/login" method="post">
    姓名：<input type="text" name="name"><br/>
    密码：<input type="text" name="password"><br/>
    <%--验证码：<img id="img" src="/pic/getCode" alt="正在加载..."><br/>--%>
    <%--//第一次请求中没有显示验证码--%>
    <img id="img" src="/pic/getCode" alt="正在加载..." onclick="imge()"><br/>
    验证码：<input type="text" name="code"><br/>
    <input type="submit" value="登录">
</form>
</body>
<script>
    window.onload=function () {
        //获取图片对象
        var img=document.getElementById("img");
        img.onclick=function () {
            //加时间戳
            var date=new Date().getTime();
            img.src="/pic/getCode?"+date;
            // console.log(img.src)
        }
    }
</script>
</html>
