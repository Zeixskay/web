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
import java.util.List;

@WebServlet("/student")
public class studentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        int start=0;
        int count=10;
        int total=0;
        int totalNum=0;
        int pageNum= 1;
        String type = request.getParameter("type");
        if(request.getParameter("start")!=null
                &&request.getParameter("pageNum")!=null
                &&request.getParameter("count")!=null){
                start=Integer.parseInt(request.getParameter("start"));
                pageNum=Integer.parseInt(request.getParameter("pageNum"));
                count=Integer.parseInt(request.getParameter("count"));
        }
        request.setCharacterEncoding("utf-8");
        studentService userService=new studentServiceImpl();
        List<Student> list= null;
        PageUtils pageUtils=new PageUtils(start,count);
        pageUtils.setCount(count);
        try {
             totalNum = pageUtils.getTotalNum();
             total = pageUtils.getTotal();
             list = userService.listUser(pageUtils.getStart(),pageUtils.getCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if("update".equals(type)){
            int id =  Integer.parseInt(request.getParameter("id"));
            try {
                Student student = userService.selectStudentById(id);
                request.setAttribute("student",student);
                request.getRequestDispatcher("update.jsp").forward(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else if("delete".equals(type)){
            int id =  Integer.parseInt(request.getParameter("id"));
            int result= 0;
            try {
                result = userService.deleteStudent(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(result==1){
                request.setAttribute("flag1",result);
                try {
                    totalNum = pageUtils.getTotalNum();
                    total = pageUtils.getTotal();
                    list.clear();
                    list = userService.listUser(pageUtils.getStart(),pageUtils.getCount());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        request.setAttribute("list",list);
        request.setAttribute("total",total);
        request.setAttribute("totalNum",totalNum);
        request.setAttribute("start",start);
        request.setAttribute("count",count);
        request.setAttribute("pageNum",pageNum);
        request.getRequestDispatcher("main.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
