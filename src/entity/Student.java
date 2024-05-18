package entity;

public class Student {
    private Integer id;
    private  String userName;
    private  String  passWord;
    private  String  className;

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
