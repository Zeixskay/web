package entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Student implements HttpSessionBindingListener  {
    private Integer id;
    private  String userName;
    private  String  passWord;
    private  String  className;

    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("绑定");
        studentInfo.online++;
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解绑");
        studentInfo.online--;
    }
    public Student(Integer id, String userName, String passWord, String className) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.className = className;
    }
public Student(){

}
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
