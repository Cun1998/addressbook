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
		super("ͨѶ¼");
		tool = getToolkit();
		welcome = new JLabel("��ӭʹ�ñ�ͨѶ¼ϵͳ��",JLabel.CENTER);
		welcome.setFont(new Font("����",Font.PLAIN,20));
		lookupdel = new JButton("����/ɾ��/�޸�");
		add = new JButton("���");
		lookall = new JButton("�鿴������ϵ��");
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
		// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			
		}
	}



}
