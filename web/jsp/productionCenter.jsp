<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/18
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="../css/frontCss/aboutus.css">
    <link rel="stylesheet" href="../css/frontCss/production.css">
    <meta charset="UTF-8">
    <title>产品中心</title>
</head>
<body>
<div style="display: table;margin: 0 auto">
    <div style="width: 100%;height: 130px;">
        <object id="head" style="border:0px" type="text/x-scriptlet" data="/nav" width=100% height=130px>
        </object>
    </div>
    <div class="bg" style="position: relative;top: -30px;margin: 0 auto;z-index: -1" >
        <div style="position: relative;top:20%;left:75%" >
            <span style="font-size: 25px;color: white;">&nbsp;&nbsp;&nbsp;${pagename}</span><br>
            <span style="font-size: 25px;color: white;">${pageusname}</span>
        </div>
    </div>

    <div style="position:relative;padding-top: 20px;padding-left:20%;">
        <span style="color: #0accce">当前位置: 网站首页 | ${pagename}</span><br>
        <span>-------------------------------------------------------------------------------------------------------------------------------------------------------------</span>
    </div>

    <div style="position: relative;left:20%;top: 30px;width: 600px;height: 30px;background-color: #07192f">
        <c:forEach items="${alltypes}" var="item">
            <div style="position:relative;width: 100px;color: white;float: left;text-align: center">
                <label style="width:100px;margin: 0 auto">${item}</label>
            </div>
        </c:forEach>
    </div>

    <div style="width: 1200px;height: 600px;position: relative;top: 50px;left: 17%">
        <ul style="margin: 0px">

            <c:forEach items="${productions}" var="item">
                <li class="production" style="vertical-align:top;width:260px;margin-right:10px;list-style:none;float: left	">
                    <div style="margin-bottom: 8px;overflow: hidden;position: relative;height:200px;width:260px;text-align:center;vertical-align:middle;display:table-cell;">
                        <img src="../img/${item.productionImgUrl}" style="position: relative; max-width: 260px; margin: 0px auto; max-height: 200px; height: 200px; width: 260px; display: inline;">
                    </div>
                    <div  style="padding: 0 3px 0 6px;height: 70px;">

                        <p style="position:relative;font: normal 100% 'Microsoft yahei', Arial, Verdana;margin:0 auto;"><a href="#">${item.productionName}</a></p>
                        <span style="margin: 0 auto;padding: 0;"><a href="#">${item.type}</a></span>
                        <div style="display: block;font-family: Microsoft YaHei;font-size: 13px;line-height: 136%;">
                            出口:${item.exportPlace}
                            国内：${item.incountryPlace}
                            交货：${item.tradeTime}天 </div>

                    </div>
                </li>
            </c:forEach>

        </ul>


    </div>
    <div style="clear: both;height: 25px;text-align: center; position: relative;margin-top: 100px; bottom: auto; width: 100%;">
        <span style="border: 1px solid #EEE;
    padding: 2px 5px;
    margin: 2px;
    color: #DDD;"> &lt; </span>
<%--        <span style="border: 1px solid #000;--%>
<%--    padding: 2px 5px;--%>
<%--    font-weight: bold;--%>
<%--    margin: 2px;--%>
<%--    color: #FFF;--%>
<%--    background-color: #000;">1</span>--%>
    <c:forEach begin="1" end="${pages}" var="item">
        <a href="/product?currentPage=${item}">${item}</a>
    </c:forEach>

<%--        <a href="###3">3</a>--%>
<%--        <a href="###4">4</a>--%>
<%--        <a href="###5">5</a>--%>
<%--        ...&nbsp;--%>
<%--        <a href="###6">6</a>--%>
<%--        <a href="###7">7</a>--%>
        <a href="#"> &gt; </a></div>

</div>
</div>
<object id="foot" style="border:0px" type="text/x-scriptlet" data="/foot" width=100% height=130px>
</object>
</body>
</html>
