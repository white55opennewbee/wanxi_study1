<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/19
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        *{
            margin:0;
            padding:0;
        }
        a{
            text-decoration: none;
        }
        li{
            list-style: none;
        }
        img{
            border: none;
        }
        body{
            position: relative;
            height: 130px;
        }
        nav{
            height: 122px;
        }
        ul{
            text-align: center;
            line-height: 122px;
            position: absolute;
            left: 700px;
        }
        li{
            float: left;
            margin-right: 70px;
        }
        ul li a{
            color: gray;
        }
        ul li a:hover{
            color: aqua;
        }
        .logo img{
            float: left;
            position: absolute;
            width: 200px;
            left: 350px;
            z-index: 1;
        }
    </style>
</head>
<body>
<header>
    <div>
        <nav>
            <div class="logo">
                <img src="../${companyLogo.imgUrl}" >
                <p style="position: absolute;left: 370px;padding-top:20px;z-index: 2;color: rgb(255, 255, 255); font-size: 22px; font-family: Microsoft YaHei; line-height: 122%;">
                    ${companyLogo.companyName}
                </p>
                <p style="position: absolute;left: 355px;padding-top:50px;z-index: 2;color: rgb(93, 106, 127); text-transform: uppercase; line-height: 100%; font-family: Times New Roman;">
                    ${companyLogo.symbol}
                </p>
            </div>
            <ul>
                <c:forEach items="${navList}" var="item">
                    <li><a href="${item.href}" title="${item.title}" target="_blank">${item.describe}</a></li>
                </c:forEach>


            </ul>
        </nav>
    </div>
</header>
</body>
</html>
