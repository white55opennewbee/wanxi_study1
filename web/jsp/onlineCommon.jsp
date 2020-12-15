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
    <title>在线留言</title>
</head>
<body>
<div style="margin: auto;display: table;">
    <div style="width: 100%;height: 130px;">
        <object id="head" style="border:0px" type="text/x-scriptlet" data="/nav" width=100% height=130px>
        </object>
    </div>
    <div class="bg" style="position: relative;top: -30px;margin: 0 auto;z-index: -1">
        <div style="position: relative;top:20%;left:75%">
            <span style="font-size: 25px;color: white;">&nbsp;&nbsp;&nbsp;在线留言</span><br>
            <span style="font-size: 25px;color: white;">MESSAGE</span>
        </div>
    </div>
    <div style="position:relative;padding-top: 20px;padding-left:20%;">
        <span style="color: #0accce">当前位置: 网站首页 | 在线留言</span><br>
        <span>-------------------------------------------------------------------------------------------------------------------------------------------------------------</span>
    </div>
    <div style="margin: 0px auto;width: 1100px;height: auto">
        <div>
            <p style="font-family: 'Microsoft YaHei'; font-size: 20px; color: rgb(102, 102, 102); line-height: 200%;">
                老潘医疗有限公司是一家专门从事临床检验设备的经营、开发以及国际技术合作的专业公司XXX在香港成立，迄今为止已陆续在北京、天津、上海、南京、杭州、广州、福州、昆明、成都、长沙、武汉等全国二十多城市设立了办事处，形成了高效率,覆盖全国的服务网络。
            </p>
            <p style="font-family: 'Microsoft YaHei'; font-size: 20px; color: rgb(102, 102, 102); line-height: 200%;">
                如果您对我们有什么建议、投诉、需求，可以通过留言告诉我们，
                <br>
                我们会在明年前了解并及时与您联系。
            </p>
        </div>
        <div style="margin-top: 50px">
            <form action="/comment" method="post">
                <div>
                    <div style="float:bottom;width:260px;height:34px;line-height:34px;background-color:transparent;background-image:none;font-size:20px;color:#00dcd9;text-align:left;word-spacing:0px;padding:0px;font-family:Microsoft YaHei;border:2px;border-color:transparent;border-style:none;clear:both; margin-top:8px; margin-left:0px;">
                        您的姓名:
                    </div>
                    <input name="comment_name" id="name" type="text"
                           style="float: bottom;width:700px;height:24px;line-height:24px;background-color:transparent;background-image:none;font-size:14px;color:#777777;text-align:left;word-spacing:0px;padding:4px;font-family:Microsoft YaHei;border:1px;border-color:#00dcd9;border-style:solid;clear:both; margin-top:0px; margin-left:0px;">
                </div>
                <div>
                    <div style="float:bottom;width:260px;height:34px;line-height:34px;background-color:transparent;background-image:none;font-size:20px;color:#00dcd9;text-align:left;word-spacing:0px;padding:0px;font-family:Microsoft YaHei;border:2px;border-color:transparent;border-style:none;clear:both; margin-top:8px; margin-left:0px;">
                        电子邮箱:
                    </div>
                    <input name="comment_email" id="email" type="text"
                           style="float: bottom;width:700px;height:24px;line-height:24px;background-color:transparent;background-image:none;font-size:14px;color:#777777;text-align:left;word-spacing:0px;padding:4px;font-family:Microsoft YaHei;border:1px;border-color:#00dcd9;border-style:solid;clear:both; margin-top:0px; margin-left:0px;">
                </div>
                <div>
                    <div style="float:bottom;width:260px;height:34px;line-height:34px;background-color:transparent;background-image:none;font-size:20px;color:#00dcd9;text-align:left;word-spacing:0px;padding:0px;font-family:Microsoft YaHei;border:2px;border-color:transparent;border-style:none;clear:both; margin-top:8px; margin-left:0px;">
                        留言内容:
                    </div>
                    <textarea name="comment_content" id="info"
                              style="float:bottom;resize:none;width:700px;height:122px;line-height:24px;background-color:transparent;background-image:none;font-size:14px;color:#777777;text-align:left;word-spacing:0px;padding:4px;font-family:Microsoft YaHei;border:1px;border-color:#00dcd9;border-style:solid;clear:both; margin-top:0px; margin-left:0px;"></textarea>
                </div>
                <input class="sub_message" id="sub_message" onclick="commit()"
                       style="float:bottom; cursor:pointer; width:710px;height:28px;line-height:28px;background-color:#00dcd9;background-image:none;font-size:14px;color:#FFFFFF;text-align:center;word-spacing:0px;padding:0px;font-family:Microsoft YaHei;border:1px;border-color:#00dcd9;border-style:dashed;clear:both; margin-top:20px; margin-left:0px;"
                       type="submit" value="提交">
                <%--            <div class="sub_message" onclick="commit()" id="sub_message"--%>
                <%--                 style="float:bottom; cursor:pointer; width:710px;height:28px;line-height:28px;background-color:#00dcd9;background-image:none;font-size:14px;color:#FFFFFF;text-align:center;word-spacing:0px;padding:0px;font-family:Microsoft YaHei;border:1px;border-color:#00dcd9;border-style:dashed;clear:both; margin-top:20px; margin-left:0px;">--%>

                <%--            </div>--%>
            </form>
        </div>
    </div>
</div>
<script>
    function commit() {
        alert("提交留言成功")
    }

</script>

<object id="foot" style="border:0px" type="text/x-scriptlet" data="/foot" width=100% height=130px>
</object>
</body>

</html>
