

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
	static JTextField d = new JTextField();
	static boolean h = true;
	JMenu t = new JMenu("飞机管理");
	JMenu t2 = new JMenu("航班管理");
	JMenu t1 = new JMenu("乘客管理");
	JMenu t4 = new JMenu("数据管理");
	JMenu t5 = new JMenu("系统管理");
	JMenu t3 = new JMenu("机票管理");

	static JMenuItem A = new JMenuItem("型号和座数管理");
	static JMenuItem B = new JMenuItem("乘客资料登记和查询");
	static JMenuItem C = new JMenuItem("航班信息添加和查询");
	static JMenuItem D = new JMenuItem("维护");
	static JMenuItem E = new JMenuItem("退出");
	static JMenuItem F = new JMenuItem("机票信息添加和查询");

	static JLabel l1 = new JLabel("型号");
	JLabel l2 = new JLabel("座数");

	static JPanel g=new JPanel();

	public Main() {
		super("机票预订系统");
		
		g.setBounds(20,100, 300, 300);
		
		setLayout(new BorderLayout());
		t.add(A);
		JMenuBar m = new JMenuBar();
		setJMenuBar(m);
		m.add(t);
		m.add(t1);
		m.add(t2);
		m.add(t3);
		m.add(t4);
		m.add(t5);
		t1.add(B);
		t2.add(C);
		t3.add(F);
		t4.add(D);
		t5.add(E);
		setJMenuBar(m);
		setSize(500, 500);
		A.addActionListener(this);
		B.addActionListener(this);
		C.addActionListener(this);
		D.addActionListener(this);
		E.addActionListener(this);
		F.addActionListener(this);
		this.add(g);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
setVisible(true);
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Main f = new Main();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object o = e.getSource();
		if (o == A) {
			Airplane M = new Airplane();
			M.setVisible(true);
			this.dispose();
		}
		if (o == B) {
			Person N = new Person();
			N.setVisible(true);
			this.dispose();
		}
		if (o == C) {
			Charge N = new Charge();
			N.setVisible(true);
			this.dispose();
		}
		if (o == D) {
			Care N = new Care();
			N.setVisible(true);
			this.dispose();
		}
		if (o == F) {
			Ticket N = new Ticket();
			N.setVisible(true);
			this.dispose();
		}
		if(o==E){
			int t=JOptionPane.showConfirmDialog(this, "是否退出？",null, JOptionPane.YES_NO_OPTION);
			if(t==JOptionPane.YES_OPTION)
			System.exit(0);
			else if (t==JOptionPane.NO_OPTION) {
				new Main();
				this.dispose();
			}
		}

	}

}
