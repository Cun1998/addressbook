package adbook;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;

public class Link {
    private static String url = "jdbc:mysql://localhost:3306/adbook?useSSL=false&serverTimezone=UTC";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String passworld = "123456";
    private Connection conn;
    private DefaultTableModel dtm;
    
    public void Link() throws Exception, Exception, Exception {
        Class.forName(driver);
        conn = (Connection) DriverManager.getConnection(url, username, passworld);// 连续数据库
        //如果能连接成功，则打印连接
    }
    
    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String showphone(String s) throws SQLException{
        String sql ="select * from adbook1 Where name LIKE "+"'"+s+"'";
        String phone = null;
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s1 = conn.createStatement();
        ResultSet rs1 = s1.executeQuery(sql);
        while (rs1.next()) {
            // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
          phone =  rs1.getString("phone");
        }

			return phone;
        }
    
    public String showemail(String s) throws SQLException{
        String sql ="select * from adbook1 Where name LIKE "+"'"+s+"'";
        String email = null;
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s1 = conn.createStatement();
        ResultSet rs1 = s1.executeQuery(sql);
        while (rs1.next()) {
            // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
        	email =  rs1.getString("email");
        }

			return email;
        }
    
    public String showeqq(String s) throws SQLException{
        String sql ="select * from adbook1 Where name LIKE "+"'"+s+"'";
        String qq = null;
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s1 = conn.createStatement();
        ResultSet rs1 = s1.executeQuery(sql);
        while (rs1.next()) {
            // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
        	qq =  rs1.getString("qq");
        }

			return qq;
        }
    public String showeremark(String s) throws SQLException{
        String sql ="select * from adbook1 Where name LIKE "+"'"+s+"'";
        String remark = null;
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s1 = conn.createStatement();
        ResultSet rs1 = s1.executeQuery(sql);
        while (rs1.next()) {
            // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
        	remark =  rs1.getString("remark");
        }

			return remark;
        }
	public  void del(String s) throws SQLException{
        String sql ="DELETE from adbook1 Where name LIKE "+"'"+s+"'";
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s1 = conn.prepareStatement(sql);
        s1.executeUpdate(sql);
        }
	
	public  void add(String s1,String s2,String s3,String s4,String s5) throws SQLException{
        String sql ="INSERT into adbook1(name,phone,email,qq,remark) VALUES("+"'"+s1+"'"+","+"'"+s2+"'"+","+"'"+s3+"'"+","+"'"+s4+"'"+","+"'"+s5+"'"+")";
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s = conn.prepareStatement(sql);
        s.executeUpdate(sql);
        }
	
	public  void updata(String s1,String s2,String s3,String s4,String s5) throws SQLException{
        String sql ="UPDATE adbook1 set name='"+s1+"',phone='"+s2+"',email='"+s3+"',qq='"+s4+"',remark='"+s5+"' WHERE id in(SELECT id from (SELECT * FROM adbook1 WHERE name LIKE '"+s1+"')AS a )";
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s = conn.prepareStatement(sql);
        s.executeUpdate(sql);
        }
	
	

	

}