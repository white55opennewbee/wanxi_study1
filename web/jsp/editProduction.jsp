<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/25
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    .firstdiv{
        width: 1000px;
        margin: 0 auto;
        border: 1px solid black;
    }
    .headshow{
        border: 1px solid black;
    }
</style>
<body>
<div>
    <div style="font-size: 25px;background-color: #555555">
            <a href="/jsp/ManagerIndex.jsp">返回首页</a>
    </div>
    <div style="text-align: center;display: flex;justify-content: center">
        <div>
            <div class="headshow">
                <div>商品ID</div>
                <div>商品图片</div>
                <div>商品名称</div>
                <div>商品类型</div>
                <div>商品价格</div>
                <div>商品号</div>
                <div>出口地点</div>
                <div>国内发货时间</div>
                <div>交易时间</div>
            </div>

            <table border="1px" style="width: 1000px">

                <tbody>
                <c:forEach items="${productions}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td><img width="100px" height="100px" src="../img/${item.productionImgUrl}"></td>
                        <td>${item.productionName}</td>
                        <td>${item.type}</td>
                        <td>${item.price}</td>
                        <td>${item.number}</td>
                        <td>${item.exportPlace}</td>
                        <td>${item.incountryPlace}</td>
                        <td>${item.tradeTime}</td>
                        <td><button name="delete">删除</button></td>
                        <td><button name="update">编辑</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div style="margin: 20px 0 auto;text-align: center;">
        &lt;
        <c:forEach begin="1" end="${pages}" var="item">
            <a href="/back/updateproduction?currentPage=${item}">${item}</a>
        </c:forEach>
        &gt;
    </div>
</div>
</body>
</html>
