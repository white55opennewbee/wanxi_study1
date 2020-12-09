<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/25
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        background-image:url(img/bak.jpg);
    }
    #div-form {
        margin:0 auto;
        height:600px;
        width:600px;
        border-style:dashed;
        position:relative;
    }
    #register {
        position:absolute;
        border-style:dashed;
    }
    table {
        width:600px;
        text-align:center;
    }
    label {
        font-size:36px;
    }
    .erromessage {
        font-size:18px;
        color:white;
    }
    .input-text {
        line-height:30px;
        text-height:25px;
    }
    .changeerror {
        font-size:18px;
        color:red;
    }

</style>
<body>
<div id="div-form">
    <form id="register" action="/register" method="post" onsubmit="return check()">
        <table>
            <thead>
            <tr>
                <td colspan="3"><label>注册</label></td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><label>账号</label></td>
                <td><input type="text" class="input-text" name="account" id="accountvalue" value="admin"></td>
                <td><label class="erromessage" id="account">用户名不能为空</label></td>
            </tr>
            <tr>
                <td><label>密码</label></td>
                <td><input type="password" class="input-text" id="pass" placeholder="6位（数字字母组合）"></td>
                <td><label class="erromessage" id="passone">6位（数字字母组合）</label></td>
            </tr>
            <tr>
                <td><label>确认密码</label></td>
                <td><input type="password" class="input-text" name="userpass" id="passnew"></td>
                <td><label class="erromessage" id="repass">密码不能为空</label></td>
            </tr>
            <tr>
                <td><label>真实姓名</label></td>
                <td><input type="text" class="input-text" name="name" id="namevalue"></td>
                <td><label class="erromessage" id="name">真实姓名不能为空</label></td>
            </tr>
            <tr>
                <td><label>电话</label></td>
                <td><input type="text" name="phnumber" class="input-text" id="phonevalue"></td>
                <td><label class="erromessage" id="phone">用户名不能为空</label></td>
            </tr>
            <tr><td colspan="3"><input type="submit" value="确认" style="font-size:24px;"></td>
            </tr>
            </tbody>
        </table>


    </form></div>

</body>
</html>
