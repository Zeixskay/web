package servlet;

import entity.Student;
import service.impl.studentServiceImpl;
import service.studentService;
import utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/find")
public class findServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start=0;
        int count=10;
        int total=0;
        int totalNum=0;
        int pageNum= 1;
        req.setCharacterEncoding("utf-8");
        String find = req.getParameter("find");
        studentService studentService=new studentServiceImpl();
        PageUtils pageUtils=new PageUtils(start,count);
        pageUtils.setCount(count);
        List<Student> list=new ArrayList<>();
        try {
            totalNum = pageUtils.getTotalNum1(find);
            total = pageUtils.getTotal1(find);
            list= studentService.findStudent(find);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("list",list);
        req.setAttribute("total",total);
        req.setAttribute("totalNum",totalNum);
        req.setAttribute("start",start);
        req.setAttribute("count",count);
        req.setAttribute("pageNum",pageNum);
        req.getRequestDispatcher("main.jsp").forward(req,resp);
    }
}
