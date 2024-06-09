<%@ page import="entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.studentInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<p>欢迎: ${sessionScope.student.userName} 登录！<a href="/out">退出登录</a></p>

<p>在线人数: <%=studentInfo.online%></p>
<body>
<div class="all">
    <span class="title">用户信息</span>
            <form action="/find" method="post">
        <input type="text" name="find" style="width: 300px;height: 30px;border: 1px solid">&nbsp;
        <input type="submit" value="查询" style="width: 50px;height: 30px;text-align: center;">
                &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;&nbsp;
                 &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp;
                &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;&nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
                &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;&nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
        <input type="button" value="新增用户"  id="add" style="width: 80px;height: 40px;text-align: center;">
    </form>

    <table>
        <tr style="text-align: center">
            <th>行号</th>
            <th>id</th>
            <th>姓名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
            <tbody style="text-align: center">
                    <%--//上个页面设置了xlh 必须更换 不能再叫xlh--%>
              <%--  <td>${xxx.index+1}</td>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.passWord}</td>--%>

                        <%
                            List<Student> list = (List<Student>) request.getAttribute("list");
                            int index=0;
                            for(int i=0;i<list.size();i++){
                                Student student =list.get(i);
                                index++;
                        %>
                    <tr>
                        <td><%=index%></td>
                        <td><%=student.getId()%></td>
                        <td><%=student.getUserName()%></td>
                        <td><%=student.getPassWord()%></td>
                        <td><a href="/student?type=update&id=<%=student.getId()%>">修改</a> &nbsp;<a href="/student?type=delete&&id=<%=student.getId()%>">删除</a></td>
                    </tr>
                        <%
                            }
                        %>

            </tbody>
    </table>

    <%
        Object flag = request.getAttribute("flag");
        Object flag1 = request.getAttribute("flag1");
        Object flag2 = request.getAttribute("flag2");
    %>

    <input value="<%=flag%>"  id="flag" hidden="hidden">
    <input value="<%=flag1%>"  id="flag1" hidden="hidden">
    <input value="<%=flag2%>"  id="flag2" hidden="hidden">

    <div class="a">
        <span class="fenye">
             <a <c:if test="${pageNum>1}">
                 href="/student?start=${start-count}&pageNum=${pageNum-1}&count=${count} "
             </c:if>>上一页</a>
            &nbsp;
        &nbsp;<a <c:if test="${start+count<total}">
            href="/student?start=${start+count}&pageNum=${pageNum+1}&count=${count}"
        </c:if>>下一页</a>
         &nbsp; &nbsp;当前为第${pageNum}页，每页显示${count}条，当前共${totalNum}页，共有${total}条数据
        </span>

        <br>
        <span class="fenye">
            <form method="get" action="/student">
            从索引为 <input type="text" name="start"  style="width: 50px;text-align: center"> 开始查找，
            每页展示 <input type="text" name="count"  style="width: 50px;text-align: center"> 条
            <input type="hidden" value="1" name="pageNum" style="width: 20px;text-align: center">
            <input type="submit" value="GO">
        </form>
        </span>
        <span class="fenye"><a href="/student?start=0&pageNum=1&count=10" style="font-size: 14px;text-decoration: none">->回到默认</a></span>
    </div>
</div>
</body>

<style>
    table{
        border-collapse: collapse;
        display: block;
        text-align: center;
    }
    table tr th{
        padding: 5px 0;
        background: #eee;
        border: 1px solid #ccc;
    }
    table tr td{
        padding: 5px 10px;
        height: 50px;
        width: 300px;
        background: #eaeaee;
        border: 1px solid #ccc;
    }
    .a{
        width: 700px;
        height: auto;
        position: relative;
        left: 50%;
        top:50px;
        transform: translate(-50%,-50%);
        text-align: center;
    }

     a{
        text-decoration: none;
    }
    .title{
        display: block;
        width: 960px;
        height: 50px;
        text-align: center;
        font-size: 36px;
    }
    .fenye{
        font-size: 16px;
    }
    .all{
        position: absolute;
        top:50%;
        left: 50%;
        transform: translate(-50%,-50%);
    }
    input[type="button"]:hover{
        cursor: pointer;
        color: blue;
    }
</style>
<script>
    let flag=document.getElementById("flag").value;
    if(flag==1){
        alert("修改成功！");
    }
    let flag1=document.getElementById("flag1").value;
    if(flag1==1){
        alert("删除成功！");
    }
    let flag2=document.getElementById("flag2").value;
    if(flag2==1){
        alert("新增成功！");
    }
    document.getElementById("add").addEventListener('click',function () {
        window.location.href="/add.jsp";
    })

</script>
</html>
