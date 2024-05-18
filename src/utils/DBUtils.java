package utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;


    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    static {
        Properties properties =new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Zeixskay\\Desktop\\源码\\servlet\\src\\db.properties"));
            DRIVER=properties.getProperty("driver");
            URL=properties.getProperty("url");
            USER=properties.getProperty("user");
            PASSWORD=properties.getProperty("password");

            Class.forName(DRIVER);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getConn() throws SQLException {
        conn  = DriverManager.getConnection(URL, USER, PASSWORD);
        return true;
    }
    public void closeResource() throws SQLException {
        if(conn!=null){
            conn.close();
        }
        if(ps!=null){
            ps.close();
        }
        if(rs!=null){
            rs.close();
        }
    }

    public ResultSet selectSQL(String sql,Object[] objs) throws SQLException {
        ResultSet rs=null;
        if(getConn()){
            ps=conn.prepareStatement(sql);
            if(objs!=null){
                for (int i = 0; i < objs.length; i++) {
                    ps.setObject((i + 1), objs[i]);
                }
            }
            rs= ps.executeQuery();
        }
        return rs;
    }

    public Integer cudSQL(String sql,Object[] objs) throws SQLException {
        int i=0;
        if(getConn()){
            ps=conn.prepareStatement(sql);
            if(objs!=null){
                for (int j = 0; j < objs.length; j++) {
                    ps.setObject((j + 1), objs[j]);
                }
            }
            i=ps.executeUpdate();
        }
        return i;
    }

}