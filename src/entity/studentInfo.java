package entity;

public class studentInfo {
    public static int online=0;
    private static studentInfo studentInfo=new studentInfo();
    public static studentInfo getStudentInfo(){
        return studentInfo;
    }

}
