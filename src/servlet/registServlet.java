package servlet;


import service.impl.studentServiceImpl;
import service.studentService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;


@WebServlet("/regist")
public class registServlet extends HttpServlet {
    //    初始化编码格式
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        try{
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String uname=request.getParameter("uuname");
        String upwd=request.getParameter("uupwd");

        studentService userService=new studentServiceImpl();
        boolean flag= false;
        try {
            flag = userService.regist(uname,upwd);
            System.out.println(flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(flag){
           response.getWriter().write("success");
        }else{
            response.sendRedirect("regist.jsp");
        }


    }

}
