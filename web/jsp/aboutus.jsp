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
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/aboutus.css">
    <title>Title</title>
</head>
<body>
<div style="width: 100%;height: 130px">
    <object id="head" style="border:0px" type="text/x-scriptlet" data="/nav" width=100% height=130px>
    </object>
</div>

<div>
    <div class="bg" style="position: relative;top:-30px;margin: 0 auto;z-index: -1">
        <div style="position: relative;top:20%;left:75%">
            <span style="font-size: 25px;color: white;">&nbsp;&nbsp;&nbsp;&nbsp;${pagename}</span><br>
            <span style="font-size: 25px;color: white;">${pageusname}</span>
        </div>
    </div>

    <div style="position:relative;padding-top: 20px;padding-left:20%;">
        <span style="color: #0accce">当前位置: 网站首页 | ${pagename}</span><br>
        <span>----------------------------------------------------------------------------------- --------------------------------------------------------------------------</span>
    </div>

<%--    <img src="../${imgurl}" width="1100" style="position: relative;padding-left: 20%">--%>
<%--    <div class="info" style="position: relative;padding-left: 20%; width: 1100px;height: auto;font-size: 25px">--%>
<%--        ${companyinfo.introduce}--%>
<%--    </div>--%>
    ${companyinfo}

<%--    <h:outputText escape="false" value="${companyinfo}"/>--%>


</div>
<object id="foot" style="border:0px" type="text/x-scriptlet" data="/foot" width=100% height=130px>
</object>
</body>
</html>
