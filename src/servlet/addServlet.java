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

@WebServlet("/add")
public class addServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentService studentService=new studentServiceImpl();
        String addname = req.getParameter("addname");
        String addpwd = req.getParameter("addpwd");
        int start=0;
        int count=10;
        int total=0;
        int totalNum=0;
        int pageNum= 1;
        req.setCharacterEncoding("utf-8");
        PageUtils pageUtils=new PageUtils(start,count);
        pageUtils.setCount(count);
        List<Student> list=new ArrayList<>();
        if(addname.trim()!=null&&addpwd.trim()!=null){
            try {
                boolean regist = studentService.regist(addname, addpwd);
                if(regist){
                    req.setAttribute("flag2",1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            list= studentService.listUser(pageUtils.getStart(),pageUtils.getCount());
            total = pageUtils.getTotal();
            totalNum = pageUtils.getTotalNum();

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
