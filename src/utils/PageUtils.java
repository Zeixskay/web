package utils;

import entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageUtils extends DBUtils{
    private int start;
    private int count;

    public PageUtils( int start, int count) {
        this.start = start;
        this.count = count;
    }
    List<Student> list=new ArrayList<Student>();
    Student student=null;
    public List<Student> getStudent(int start,int count) throws SQLException {
        String sql="select * from student limit ?,?";
        ResultSet rs=selectSQL(sql,new Object[]{start,count});
        while (rs.next()){
            student =new Student();
            student.setId(rs.getInt("id"));
            student.setUserName(rs.getString("userName"));
            student.setPassWord(rs.getString("passWord"));
            list.add(student);
        }
        return list;
    }
    public PageUtils(){}
    public int getTotalNum() throws SQLException {
        int pageSize=getTotal();
        if(pageSize%count==0){
            return pageSize/count;
        }else {
            return (int) Math.ceil((double) pageSize/count);
        }
    }
    public int getTotalNum1(String find) throws SQLException {
        int pageSize=getTotal1(find);
        if(pageSize%count==0){
            return pageSize/count;
        }else {
            return (int) Math.ceil((double) pageSize/count);
        }
    }

    public int getTotal() throws SQLException {
        int total=0;
        String sql="select * from student";
        ResultSet rs = selectSQL(sql, null);
        while (rs.next()){
            total++;
        }
        return total;
    }
    public int getTotal1(String find) throws SQLException {
        int total=0;
        String sql="select * from student where userName like ?";
        String append="%"+find+"%";
        ResultSet rs = selectSQL(sql,new Object[]{append});
        while (rs.next()){
            total++;
        }
        return total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
