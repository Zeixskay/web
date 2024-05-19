<%--
  Created by IntelliJ IDEA.
  User: 赵祥凯
  Date: 2024/5/19
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<div class="a">
    <span>新增信息</span>
    <form action="/add" method="post" class="e">
        <P>用户名:</P>
        <input type="text" name="addname" placeholder="请输入要新增的用户名"  />
        <p>密码:</p>
        <input type="text" name="addpwd" placeholder="请输入要新增用户的密码"/>
        <br>
        <input type="submit" value="新增"/>
    </form>
</div>

</body>
<style>
    span{
        text-align: center;
        font-size: 24px;
        display: block;
        margin-top: 30px;
    }
    .a{
        width: 420px;
        background: #eaeaee;
        position: absolute;
        top: 50%;
        left: 50%;
        border-radius: 10px;
        transform: translate(-50%,-50%);
    }
    .e {
        margin: 20px 30px;
        text-align: left;
    }

    .e input[type="text"]{
        width: 100%;
        height: 40px;
        border-radius: 3px;
        border: 1px solid #adadad;
        padding: 0 10px;
        box-sizing: border-box;
    }
    .e input[type="submit"]{
        margin-top: 40px;
        width: 100%;
        height: 40px;
        border-radius: 5px;
        color: white;
        border: 1px solid #adadad;
        background: #505458;
        cursor: pointer;
        letter-spacing: 4px;
        margin-bottom: 40px;
    }

</style>
</html>
