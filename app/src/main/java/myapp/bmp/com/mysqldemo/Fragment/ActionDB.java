package myapp.bmp.com.mysqldemo.Fragment;

import java.sql.*;

public interface ActionDB {
    public ResultSet SelectData() throws Exception;
    public int InsertData() throws Exception;
    public int DeleteData() throws Exception;
    public int UpdateData() throws Exception;



}
