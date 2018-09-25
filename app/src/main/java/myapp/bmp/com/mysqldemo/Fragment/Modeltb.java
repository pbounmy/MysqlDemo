package myapp.bmp.com.mysqldemo.Fragment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Modeltb implements ActionDB {
    private String name;
    private String surname;
    Connection c;

    public Modeltb(Connection c) {
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public ResultSet SelectData() throws Exception {
        String sql=String.format("Select * from %s",datainfo.tbname);
        ResultSet rs = c.createStatement().executeQuery(sql);
        return rs;
    }

    @Override
    public int InsertData() throws Exception {
        String sql=String.format("Insert Into %s(%s,%s) values(?,?)",datainfo.tbname,datainfo.column.name,datainfo.column.surname);
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,surname);
        int r = ps.executeUpdate();
        return r;
    }

    @Override
    public int DeleteData() throws Exception {
        return 0;
    }

    @Override
    public int UpdateData() throws Exception {
        return 0;
    }
}
