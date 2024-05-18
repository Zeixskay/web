<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 赵祥凯
  Date: 2024/5/18
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户更新</title>
</head>
<body>

    <%
        Student student = (Student) request.getAttribute("student");
    %>
    <div class="a">
        <span>修改信息</span>
        <form action="/updateServlet" method="post" class="e">
            <p>ID:</p>
            <input type="text" name="sid" placeholder="请输入要更改的ID值" readonly value="<%=student.getId()%>"/>
            <P>用户名:</P>
            <input type="text" name="sname" placeholder="请输入要更改的用户名"  value="<%=student.getUserName()%>"/>
            <p>密码:</p>
            <input type="text" name="spwd" placeholder="请输入要更改的密码"  value="<%=student.getPassWord()%>"/>
            <br>
            <input type="submit" value="修改"/>

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
