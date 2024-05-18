package service.impl;

import dao.impl.studentDaoImpl;
import dao.studentDao;
import entity.Student;
import service.studentService;

import java.sql.SQLException;
import java.util.List;

public class studentServiceImpl implements studentService {
    studentDao studentDao=new studentDaoImpl();
    @Override
    public boolean login(String userName, String passWord) throws SQLException {
       boolean flag= studentDao.loginStudent(userName,passWord);
       return flag;
    }

    @Override
    public List<Student> listUser(int start,int count) throws SQLException {
        return  studentDao.listUser(start,count);
    }

    @Override
    public boolean regist(String uname, String upwd) throws SQLException {
        boolean flag=studentDao.registStudent(uname,upwd);
        return flag;
    }

    @Override
    public Student selectStudentById(Integer id) throws SQLException {
        return studentDao.selectStudentById(id);
    }

    @Override
    public Integer updateStudent(int sid, String sname, String spwd) throws SQLException {
        return studentDao.updateStudent(sid,sname,spwd);
    }

    @Override
    public Integer deleteStudent(int id) throws SQLException {
        return studentDao.deleteStudent(id);
    }

    @Override
    public List<Student> findStudent(String find) throws SQLException {
        return studentDao.findStudent(find);
    }
}
