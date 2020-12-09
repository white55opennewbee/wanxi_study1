<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        }
        nav{
            height: 122px;
        }
        ul{
            text-align: center;
            line-height: 122px;
            position: absolute;
            left: 800px;
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
            left: 350px;
            z-index: 1;
        }
        #banner img{
            position: absolute;
            top:100px;
            width: 100%;
        }
        #p2 img{
            position: absolute;
            top:650px;
            width: 100%;
        }
        #p3 .nav_p{
            position: absolute;
            top: 800px;
        }
        #p3 .nav_p ul li:nth-child(1){
            position: absolute;
            right: 270px;
        }
        #p3 .nav_p ul li:nth-child(2){
            position: absolute;
            right: 110px;
        }
        #p3 .nav_p ul li:nth-child(3){
            position: absolute;
            right: 270px;
            top:90px;
        }
        #p3 .nav_p ul li:nth-child(4){
            position: absolute;
            right: 110px;
            top: 90px;
        }
        #p3 .nav_p ul li:nth-child(5){
            position: absolute;
            right: 270px;
            top: 180px;
        }
        #p3 .nav_p ul li:nth-child(6){
            position: absolute;
            right: 110px;
            top: 180px;
        }
        #p3 .nav_p ul li:nth-child(7){
            position: absolute;
            right: 270px;
            top: 270px;
        }
        #p3 .nav_p ul li:nth-child(8){
            position: absolute;
            right: 110px;
            top: 270px;
        }
        #p3 .p41{
            position: absolute;
            top: 800px;
            right: 380px;
        }
        #p5{
            position: absolute;
            top: 1200px;
            left: 310px;
            width: 1215px;
            height: 500px;
            background-color: rgb(243,248,251);
        }
        #p5 p:nth-child(1){
            font-size: 25px;
            font-weight: 1000;
            position: absolute;
            top: 90px;
            left: 450px;
        }
        #p5 p:nth-child(2){
            font-size: 10px;
            position: absolute;
            top: 130px;
            left: 420px;
        }
        #p5 .text3{
            font-size: 15px;
            position: absolute;
            top: 450px;
            left: 150px;
        }
        #p5 div img:nth-child(1){
            position: absolute;
            top:250px;
            left: 300px;
        }
        #p5 div img:nth-child(2){
            position: absolute;
            top:250px;
            left: 400px;
        }
        #p5 div img:nth-child(3){
            position: absolute;
            top:250px;
            left: 500px;
        }
        #p5 div img:nth-child(4){
            position: absolute;
            top:250px;
            left: 600px;
        }
        #p5 div img:nth-child(5){
            position: absolute;
            top:250px;
            left: 700px;
        }
        #btn{
            position: absolute;
            top: 330px;
            left: 290px;
        }
        #btn a{
            font-size: 15px;
            color: rgb(3,96,137);
            margin-right: 15px;
        }
        #p61 p:nth-child(1){
            font-size: 25px;
            font-weight: 1000;
            position: absolute;
            top: 1750px;
            left: 800px;
        }
        #p61 p:nth-child(2){
            font-size: 10px;
            position: absolute;
            top: 1780px;
            left: 750px;
        }
        #p71{
            position: absolute;
            top:1850px;
            left:0px;
        }
        #bottom{
            position: absolute;
            top: 2200px;
        }
        #bottom img{
            width: 1920px;
        }

    </style>

</head>
<body>

<header>

    <div style="width: 100%;height: 130px;">
        <object id="head" style="border:0px" type="text/x-scriptlet" data="/nav" width=100% height=130px>
        </object>
    </div>
</header>
<div id="banner" style="z-index: -1">
    <img src="../img/banner1.jpg" >
</div>
<div id="p2">
    <img src="../img/p2.jpg" >
</div>
<div id="p3">
    <div class="nav_p">
        <ul>
            <c:forEach items="${equipment}" var="item">
                <li>
                    <a href="">
                        <img src="../${item.imgUrl}"/>

                    </a>
                    <span style="position: absolute; bottom:35px; left: 10px;font-size: 18px;color: white">
                                ${item.name}
                            </span>
                </li>

            </c:forEach>


            <li>
                <a href="">
                    <img src="../img/在线留言.jpg" />
                </a>
                <span style="position: absolute; bottom:35px; left: 10px;font-size: 18px;color: white">
                                在线留言
                            </span>
            </li>
            <li>
                <a href="">
                    <img src="../img/call.jpg" />
                </a>
                <span style="position: absolute; bottom:35px; left: 10px;font-size: 18px;color: white">
                                全国预约热线
                            </span>
            </li>
        </ul>
    </div>
    <div class="p41">
        <img src="../img/p4.jpg" >
    </div>
</div>
<div id="p5">
    <p class="text1">
        希望健康服务优势
    </p>
    <p class="text2">
        MOU MOU HEALTH SERVICE ADVANTAGES
    </p>
    <div class="imgs">
        <c:forEach items="${advance}" var="item">
            <img src="../${item.imgUrl}" >
        </c:forEach>


    </div>
    <div id="btn">
        <c:forEach items="${advance}" var="item">

            <a href="">${item.info}</a>
        </c:forEach>

    </div>
    <p class="text3">
        ....................................................我们专注于国内医疗，为国内客户提供优质的医疗服务，减轻排解患者的痛苦....................................................
    </p>
</div>
<div id="p61">
    <p>走进希望医疗</p>
    <p>INTO A CERTAIN MEDICAL MOU MOU</p>
</div>
<div id="p71">
    <img src="../img/p7.jpg" >
</div>

<object id="bottom" style="border:0px" type="text/x-scriptlet" data="/foot" width=100% height=130px>
</object>
</body>
</html>
