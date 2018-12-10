package adbook;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LookAll extends JFrame {
	private JLabel all ;
	private JTable list;
	private JScrollPane sp;
	private static String url = "jdbc:mysql://localhost:3306/adbook?useSSL=false&serverTimezone=UTC";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String username = "root";
	private static String passworld = "123456";
	private Connection conn;
	private DefaultTableModel dtm;
	private Vector r,datatl;
	

	public LookAll() throws SQLException {
		super("查看所有联系人");
		datatl = new Vector();
		datatl.add("姓名");
		datatl.add("手机");
		datatl.add("email");
		datatl.add("qq");
		datatl.add("备注");
		all = new JLabel("所有联系人",JLabel.CENTER);
		list = new JTable(new DefaultTableModel(r,datatl));
		sp = new JScrollPane();
		setLayout(new FlowLayout());
		add(all);
		sp.setViewportView(list);
		add(sp);
		String sql ="select * from adbook1";
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = s.executeQuery(sql);
        Vector data = new Vector();
        while(rs.next()) {
        	Vector v = new Vector();
         v.add(rs.getString("name"));
   		 v.add(rs.getString("phone"));
   		 v.add(rs.getString("email"));
   		 v.add(rs.getString("qq"));
   		 v.add(rs.getString("remark"));
   		 data.add(v);
        }
        list.setModel(new DefaultTableModel(data,datatl));
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.pack();
		this.setSize(520,520);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public void select() throws SQLException {
		String sql ="select * from adbook1";
        conn = (Connection) DriverManager.getConnection(url, username, passworld);
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = s.executeQuery(sql);
        Vector data = new Vector();
        while(rs.next()) {
        	Vector v = new Vector();
         v.add(rs.getString("name"));
   		 v.add(rs.getString("phone"));
   		 v.add(rs.getString("email"));
   		 v.add(rs.getString("qq"));
   		 v.add(rs.getString("remark"));
   		 data.add(v);
        }
        list.setModel(new DefaultTableModel(data,datatl));
		
	}

}
