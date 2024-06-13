package servlet;


import entity.Student;
import service.impl.studentServiceImpl;
import service.studentService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String uname=request.getParameter("uname");
        String upwd=request.getParameter("upwd");
        studentService userService=new studentServiceImpl();
        boolean flag= false;
        try {
            flag = userService.login(uname,upwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(flag){
            Student student =new Student();
            student.setUserName(uname);
            student.setPassWord(upwd);
            HttpSession session =request.getSession();
            session.setAttribute("student",student);
            response.getWriter().write("success");
        }else{
            response.sendRedirect("regist.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
