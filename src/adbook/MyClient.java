package adbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class MyClient extends JFrame  implements ActionListener {
	private JLabel welcome;
	private JButton lookupdel,add,lookall;
	private JMenuBar menubar;
	private JPanel p1;
	Toolkit tool;
	
	public MyClient() {
		super("通讯录");
		tool = getToolkit();
		welcome = new JLabel("欢迎使用本通讯录系统！",JLabel.CENTER);
		welcome.setFont(new Font("宋体",Font.PLAIN,20));
		lookupdel = new JButton("查找/删除/修改");
		add = new JButton("添加");
		lookall = new JButton("查看所有联系人");
		lookupdel.addActionListener(this);
		add.addActionListener(this);
		lookall.addActionListener(this);
		menubar =new JMenuBar();
		p1 = new JPanel();
		setJMenuBar(menubar);
		add(welcome,BorderLayout.CENTER);
		p1.add(lookupdel);p1.add(add);p1.add(lookall);
		add(p1,BorderLayout.SOUTH);
	                                      
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(520,220);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource().equals(lookupdel)) {
			new LookUp();
		}
		if(e.getSource().equals(add)) {
			new Add();
		}
		if(e.getSource().equals(lookall)) {
			try {
				new LookAll();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
		}
	}



}
