package dao.impl;

import dao.studentDao;
import entity.Student;
import utils.DBUtils;
import utils.PageUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDaoImpl extends DBUtils implements studentDao {
    PreparedStatement ps=null;
    ResultSet rs=null;
    Student student=null;
    int i=0;
    PageUtils pageUtils=new PageUtils();
    @Override
    public Boolean loginStudent(String userName, String passWord) throws SQLException {
        String sql="select * from  student where userName=? and passWord=?";
        rs=selectSQL(sql,new Object[]{userName,passWord});
        while (rs.next()){
            return true;
        }
       return false;
    }

    List<Student> list=new ArrayList<Student>();
    @Override
    public List<Student> listUser(int start,int count) throws SQLException {
           list= pageUtils.getStudent(start,count);
        return list;
    }

    @Override
    public boolean registStudent(String uname, String upwd) throws SQLException {

        String sql="insert into student(userName,passWord) values(?,?)";
        Integer flag = cudSQL(sql, new Object[]{uname, upwd});
        if(flag==1){
            return true;
        }
        return false;
    }

    @Override
    public Student selectStudentById(Integer id) throws SQLException {
         String sql="select * from student where id=?";
        ResultSet rs = selectSQL(sql, new Object[]{id});
        while (rs.next()){
             student=new Student();
             student.setId(rs.getInt("id"));
             student.setUserName(rs.getString("userName"));
             student.setPassWord(rs.getString("passWord"));
        }
        return student;
    }

    @Override
    public Integer updateStudent(int sid, String sname, String spwd) throws SQLException {
        String sql ="update student set userName=?,passWord=? where id=?";
        Integer result = cudSQL(sql, new Object[]{sname, spwd, sid});
        return result;
    }

    @Override
    public Integer deleteStudent(int id) throws SQLException {
        String sql="delete from student where id=?";
        Integer result = cudSQL(sql, new Object[]{id});
        return result;
    }

    @Override
    public List<Student> findStudent(String find) throws SQLException {
         String sql="select * from student where userName like ?";
         String append="%"+find+"%";
        ResultSet rs = selectSQL(sql, new Object[]{append});
        while (rs.next()){
            student=new Student();
            student.setId(rs.getInt("id"));
            student.setUserName(rs.getString("userName"));
            student.setPassWord(rs.getString("passWord"));
            list.add(student);
        }
        return list;
    }

}
