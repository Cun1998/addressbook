package adbook;

import javax.swing.*;

import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	private JLabel lbId, lbPass;
	private JTextField txtId;
	private JTextField txtPass;
	private JButton btLogin, btExit;
	private JPanel p1,p2,p3,p4;
	Toolkit tool;
	public Login(){
		super("登入系统");
		tool=getToolkit();
		lbId = new JLabel("账户名");
		lbPass = new JLabel("密码");
		txtId = new JTextField(15);
		txtPass = new JTextField(15);
		btLogin = new JButton("Login");
		btExit = new JButton("Exit");
		btLogin.addActionListener(this);
		btExit.addActionListener(this);
		p1=new JPanel();p2=new JPanel();p3=new JPanel();
		p4=new JPanel();
	  	p3.setLayout(new java.awt.GridLayout(2,1));
	  	p1.add(lbId);p1.add(txtId);
	  	p2.add(lbPass);p2.add(txtPass);
		p3.add(p1);p3.add(p2);
		p4.add(btLogin);p4.add(btExit);
	  	Container con=getContentPane();
	  	con.add(p3,"Center");
	  	con.add(p4,"South");
	  	validate();
	  	
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(520,350);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	public void actionPerformed(ActionEvent evt){
		if (evt.getSource().equals(btExit)) {
			System.exit(0);	
		}
		if(evt.getSource().equals(btLogin)){
			if(txtId.getText().equals("2016013869")&&txtPass.getText().equals("123456")) {
				dispose();
				new MyClient();/*
				 * 新窗口*/
			}else
			{
				JOptionPane.showMessageDialog(this, "账号或密码错误！","错误！", JOptionPane.WARNING_MESSAGE, null);
				txtId.setText(null);
				txtPass.setText(null);
			}
		}
	}
}