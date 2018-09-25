package myapp.bmp.com.mysqldemo.Fragment;
import java.sql.*;
public class DBConnet {
    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://192.168.8.105:3306/db1";
            String user="root";
            String pwd="bounmy1234";
            Connection c = DriverManager.getConnection(url,user,pwd);
            return c;

        }catch (Exception e){
            return null;
        }
    }
}
