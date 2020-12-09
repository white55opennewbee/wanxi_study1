<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/23
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加产品</title>
    <style>
        .input>div{
            float: bottom;
        }

    </style>
</head>
<body>
<div>
    <form class="input" enctype="multipart/form-data" action="/addproduction" method="post">
        <div>产品名字：  <input type="text" name="productionName" value="产品名字"></div>
        <div>产品价格：  <input type="text" name="price" value="产品价格"></div>
        <div>产品类型：  <input type="text" name="type" value="产品类型"></div>
        <div>产品型号:   <input type="text" name="number" value="产品型号"></div>
        <div>产品图片:   <input type="file" name="img" value="产品图片"></div>
        <div><input type="submit"></div>
    </form>
</div>
</body>
</html>
