<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/19
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="../css/frontCss/foot.css">
    <meta charset="UTF-8">
    <title>foot</title>
</head>
<body>
<div class="fixed">
        <span style="position:relative;top: 40%;padding-left:20%;color: rgb(169, 169, 171); font-size: 26px; font-family: Microsoft YaHei; line-height: 122%; ">
            <strong>${name}</strong><br>
        </span>
    <span style="position:relative;top:40%;padding-left:20%;font-size: 16px; line-height: 122%; color: rgb(169, 169, 171);">
                ${symbol}
            </span>
    <div style="position: relative;left: 70%;bottom: 30%">
        <c:forEach items="${logos}" var="logo">
            <img src="../${logo.fooIimgurl}" name="${logo.footImgname}">
        </c:forEach>
<%--        <img src="../img/wei2_03_aus0.png">--%>
<%--        <img src="../img/wei2_05_fc2e.png">--%>
<%--        <img src="../img/wei2_07_hodz.png">--%>
<%--        <img src="../img/wei2_09_v87t.png">--%>
    </div>


</div>
</body>
</html>
