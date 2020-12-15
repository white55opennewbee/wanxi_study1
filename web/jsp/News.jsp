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
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="margin: 0 auto;display: table">
    <div style="width: 100%;height: 130px;">
        <object id="head" style="border:0px" type="text/x-scriptlet" data="/nav" width=100% height=130px>
        </object>
    </div>
    <div class="bg" style="position: relative;top: -30px;margin: 0 auto;z-index: -1" >
        <div style="position: relative;top:20%;left:75%" >
            <span style="font-size: 25px;color: white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${pagename}</span><br>
            <span style="font-size: 25px;color: white;">${pageusname}</span>
        </div>
    </div>
    <div style="position:relative;padding-top: 20px;padding-left:20%;">
        <span style="color: #0accce">当前位置: 网站首页 | ${pagename}</span><br>
        <span>-------------------------------------------------------------------------------------------------------------------------------------------------------------</span>
    </div>
    <div style="position: relative;left:20%;top: 30px;width: 300px;height: 30px;background-color: #07192f">
        <c:forEach items="${newstypes}" var="item">
            <div style="position:relative;width: 100px;color: white;float: left;text-align: center">
                <label style="width:100px;margin: 0 auto;text-align: center">${item}</label>
            </div>

        </c:forEach>
<%--        <div style="position:relative;width: 100px;color: white;float: left;text-align: center">--%>
<%--            <label style="width:100px;margin: 0 auto;text-align: center">公司新闻</label>--%>
<%--        </div>--%>
<%--        <div style="position:relative;width: 100px;color: white;float: left;text-align: center">--%>
<%--            <label style="width:100px;margin: 0 auto">行业动态</label>--%>
<%--        </div>--%>
<%--        <div style="position:relative;width: 100px;color: white;float: left;text-align: center">--%>
<%--            <label style="width:100px;margin: 0 auto">校新公告</label>--%>
<%--        </div>--%>
    </div>
    <div >
        <ul style="position: relative;margin: 50px auto;width: 1100px;height:auto;">
            <c:forEach items="${news}" var="item">
                <li style="list-style: none;border-bottom: 1px dotted #dbd4cd;">
                    <div style="display: flex">
                        <div style="background-color: orangered;margin: 20px 5px;width: 60px;height: 60px;">
                        <span style="display:inline-block;line-height:41px;color:#fff;font-size:24px;margin: 0 auto;text-align:center;width: inherit;height: auto">
                            ${item.date.date}
                        </span>
                            <span style="color:#fff;font-size:13px;display:block;height: 18px;line-height: 18px;text-align: center ">
                            ${item.date.year}-${item.date.month}
                        </span>
                        </div>
                        <div style="margin-left: 20px" >
                            <p style="display: inline-block;font-family: Microsoft YaHei;font-size: 14px;color: #000000;font-weight: bold;text-decoration: none;line-height: 140%;">
                                ${item.title}
                            </p>
                            <p style="line-height: 120%;margin-top:0;display: inline-block;font-family: Microsoft YaHei;font-size: 12px;color: #666666;font-weight: normal;text-decoration: none;text-align: justify;width: 99%;overflow: hidden;">
                                ${item.body}
                            </p>
                        </div>
                    </div>
                </li>

            </c:forEach>


<%--            <li style="list-style: none;border-bottom: 1px dotted #dbd4cd;">--%>
<%--                <div style="display: flex">--%>
<%--                    <div style="background-color: orangered;margin: 20px 5px;width: 60px;height: 60px;">--%>
<%--                        <span style="display:inline-block;line-height:41px;color:#fff;font-size:24px;margin: 0 auto;text-align:center;width: inherit;height: auto">--%>
<%--                            13--%>
<%--                        </span>--%>
<%--                        <span style="color:#fff;font-size:13px;display:block;height: 18px;line-height: 18px;text-align: center ">--%>
<%--                            2014-10--%>
<%--                        </span>--%>
<%--                    </div>--%>
<%--                    <div style="margin-left: 20px" >--%>
<%--                        <p style="display: inline-block;font-family: Microsoft YaHei;font-size: 14px;color: #000000;font-weight: bold;text-decoration: none;line-height: 140%;">--%>
<%--                            高血压因素有哪些--%>
<%--                        </p>--%>
<%--                        <p style="line-height: 120%;margin-top:0;display: inline-block;font-family: Microsoft YaHei;font-size: 12px;color: #666666;font-weight: normal;text-decoration: none;text-align: justify;width: 99%;overflow: hidden;">--%>
<%--                            1.高钠盐饮食   盐与高血压有关的主要证据，来自人群间的比较研究。限制高血压病人摄钠（食盐与含钠食品）则血压下降，服用利尿剂、排钠利水，血压也下降。在某些钠摄入量很低的人群，根本不知道高血压病例，而像日本人均钠摄入量约为美国人的2~4倍，人群中几乎三分之一患有高血压。据我们调查黑龙江居民平均摄盐量17~17g/d，明显高于生理需要量和全国平均水平，高血压发病率高于全国平均发病率。--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>

<%--            <li style="list-style: none;border-bottom: 1px dotted #dbd4cd;">--%>
<%--                <div style="display: flex">--%>
<%--                    <div style="background-color: orangered;margin: 20px 5px;width: 60px;height: 60px;">--%>
<%--                        <span style="display:inline-block;line-height:41px;color:#fff;font-size:24px;margin: 0 auto;text-align:center;width: inherit;height: auto">--%>
<%--                            13--%>
<%--                        </span>--%>
<%--                        <span style="color:#fff;font-size:13px;display:block;height: 18px;line-height: 18px;text-align: center ">--%>
<%--                            2014-10--%>
<%--                        </span>--%>
<%--                    </div>--%>
<%--                    <div style="margin-left: 20px" >--%>
<%--                        <p style="display: inline-block;font-family: Microsoft YaHei;font-size: 14px;color: #000000;font-weight: bold;text-decoration: none;line-height: 140%;">--%>
<%--                            高血压因素有哪些--%>
<%--                        </p>--%>
<%--                        <p style="line-height: 120%;margin-top:0;display: inline-block;font-family: Microsoft YaHei;font-size: 12px;color: #666666;font-weight: normal;text-decoration: none;text-align: justify;width: 99%;overflow: hidden;">--%>
<%--                            1.高钠盐饮食   盐与高血压有关的主要证据，来自人群间的比较研究。限制高血压病人摄钠（食盐与含钠食品）则血压下降，服用利尿剂、排钠利水，血压也下降。在某些钠摄入量很低的人群，根本不知道高血压病例，而像日本人均钠摄入量约为美国人的2~4倍，人群中几乎三分之一患有高血压。据我们调查黑龙江居民平均摄盐量17~17g/d，明显高于生理需要量和全国平均水平，高血压发病率高于全国平均发病率。--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>

<%--            <li style="list-style: none;border-bottom: 1px dotted #dbd4cd;">--%>
<%--                <div style="display: flex">--%>
<%--                    <div style="background-color: orangered;margin: 20px 5px;width: 60px;height: 60px;">--%>
<%--                        <span style="display:inline-block;line-height:41px;color:#fff;font-size:24px;margin: 0 auto;text-align:center;width: inherit;height: auto">--%>
<%--                            13--%>
<%--                        </span>--%>
<%--                        <span style="color:#fff;font-size:13px;display:block;height: 18px;line-height: 18px;text-align: center ">--%>
<%--                            2014-10--%>
<%--                        </span>--%>
<%--                    </div>--%>
<%--                    <div style="margin-left: 20px" >--%>
<%--                        <p style="display: inline-block;font-family: Microsoft YaHei;font-size: 14px;color: #000000;font-weight: bold;text-decoration: none;line-height: 140%;">--%>
<%--                            高血压因素有哪些--%>
<%--                        </p>--%>
<%--                        <p style="line-height: 120%;margin-top:0;display: inline-block;font-family: Microsoft YaHei;font-size: 12px;color: #666666;font-weight: normal;text-decoration: none;text-align: justify;width: 99%;overflow: hidden;">--%>
<%--                            1.高钠盐饮食   盐与高血压有关的主要证据，来自人群间的比较研究。限制高血压病人摄钠（食盐与含钠食品）则血压下降，服用利尿剂、排钠利水，血压也下降。在某些钠摄入量很低的人群，根本不知道高血压病例，而像日本人均钠摄入量约为美国人的2~4倍，人群中几乎三分之一患有高血压。据我们调查黑龙江居民平均摄盐量17~17g/d，明显高于生理需要量和全国平均水平，高血压发病率高于全国平均发病率。--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>


<%--            <li style="list-style: none;border-bottom: 1px dotted #dbd4cd;">--%>
<%--                <div style="display: flex">--%>
<%--                    <div style="background-color: orangered;margin: 20px 5px;width: 60px;height: 60px;">--%>
<%--                        <span style="display:inline-block;line-height:41px;color:#fff;font-size:24px;margin: 0 auto;text-align:center;width: inherit;height: auto">--%>
<%--                            13--%>
<%--                        </span>--%>
<%--                        <span style="color:#fff;font-size:13px;display:block;height: 18px;line-height: 18px;text-align: center ">--%>
<%--                            2014-10--%>
<%--                        </span>--%>
<%--                    </div>--%>
<%--                    <div style="margin-left: 20px" >--%>
<%--                        <p style="display: inline-block;font-family: Microsoft YaHei;font-size: 14px;color: #000000;font-weight: bold;text-decoration: none;line-height: 140%;">--%>
<%--                            高血压因素有哪些--%>
<%--                        </p>--%>
<%--                        <p style="line-height: 120%;margin-top:0;display: inline-block;font-family: Microsoft YaHei;font-size: 12px;color: #666666;font-weight: normal;text-decoration: none;text-align: justify;width: 99%;overflow: hidden;">--%>
<%--                            1.高钠盐饮食   盐与高血压有关的主要证据，来自人群间的比较研究。限制高血压病人摄钠（食盐与含钠食品）则血压下降，服用利尿剂、排钠利水，血压也下降。在某些钠摄入量很低的人群，根本不知道高血压病例，而像日本人均钠摄入量约为美国人的2~4倍，人群中几乎三分之一患有高血压。据我们调查黑龙江居民平均摄盐量17~17g/d，明显高于生理需要量和全国平均水平，高血压发病率高于全国平均发病率。--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>


<%--            <li style="list-style: none;border-bottom: 1px dotted #dbd4cd;">--%>
<%--                <div style="display: flex">--%>
<%--                    <div style="background-color: orangered;margin: 20px 5px;width: 60px;height: 60px;">--%>
<%--                        <span style="display:inline-block;line-height:41px;color:#fff;font-size:24px;margin: 0 auto;text-align:center;width: inherit;height: auto">--%>
<%--                            13--%>
<%--                        </span>--%>
<%--                        <span style="color:#fff;font-size:13px;display:block;height: 18px;line-height: 18px;text-align: center ">--%>
<%--                            2014-10--%>
<%--                        </span>--%>
<%--                    </div>--%>
<%--                    <div style="margin-left: 20px" >--%>
<%--                        <p style="display: inline-block;font-family: Microsoft YaHei;font-size: 14px;color: #000000;font-weight: bold;text-decoration: none;line-height: 140%;">--%>
<%--                            高血压因素有哪些--%>
<%--                        </p>--%>
<%--                        <p style="line-height: 120%;margin-top:0;display: inline-block;font-family: Microsoft YaHei;font-size: 12px;color: #666666;font-weight: normal;text-decoration: none;text-align: justify;width: 99%;overflow: hidden;">--%>
<%--                            1.高钠盐饮食   盐与高血压有关的主要证据，来自人群间的比较研究。限制高血压病人摄钠（食盐与含钠食品）则血压下降，服用利尿剂、排钠利水，血压也下降。在某些钠摄入量很低的人群，根本不知道高血压病例，而像日本人均钠摄入量约为美国人的2~4倍，人群中几乎三分之一患有高血压。据我们调查黑龙江居民平均摄盐量17~17g/d，明显高于生理需要量和全国平均水平，高血压发病率高于全国平均发病率。--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>
        </ul>

    </div>

    <div style="margin-top: 0;text-align: center; position: absolute;  width: 100%;">
        <span style="border: 1px solid #EEE;padding: 2px 5px;margin: 2px;color: #DDD;">
            &lt;
        </span>
        <span style="border: 1px solid #000;padding: 2px 5px;font-weight: bold; margin: 2px;color: #FFF;background-color: #000;">
            1
        </span>
        <a href="###2">2</a>
        <a href="###3">3</a>
        <a href="###2">
            &gt;
        </a>
    </div>


</div>

<object id="foot" style="border:0px" type="text/x-scriptlet" data="/foot" width=100% height=130px>
</object>
</body>
</html>
