package servlet;

import entity.Student;
import service.impl.studentServiceImpl;
import service.studentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        String spwd = request.getParameter("spwd");
        studentService studentService=new studentServiceImpl();
        int start=0;
        int count=10;
        int total=0;
        int totalNum=0;
        int pageNum= 1;

        Integer flag = null;
        try {
            flag = studentService.updateStudent(sid, sname, spwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("flag",flag);
        List<Student> list=new ArrayList<>();
        if(flag==1){
            try {
                 list= studentService.listUser(start, count);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("list",list);
            request.setAttribute("total",total);
            request.setAttribute("totalNum",totalNum);
            request.setAttribute("start",start);
            request.setAttribute("count",count);
            request.setAttribute("pageNum",pageNum);
            request.getRequestDispatcher("/student").forward(request,response);
        }

    }
}
