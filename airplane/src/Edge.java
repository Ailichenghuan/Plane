import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edge extends JFrame implements ActionListener {
	Font title = new Font("宋体", Font.BOLD, 15);
	static JLabel l1 = new JLabel("用户名");
	static JLabel A = new JLabel("机票预订系统");
	static JLabel l2 = new JLabel("密码");
	static JTextField f1 = new JTextField();
	static JPasswordField f2 = new JPasswordField();
	static JButton b1 = new JButton("登陆");
	static JButton b2 = new JButton("取消");

	public Edge() {
		super();
		
		this.setTitle("登陆");
		this.setLayout(null);
		b1.addActionListener(this);
		b2.addActionListener(this);
		this.setSize(300, 200);
		A.setBounds(80, 0, 100, 30);
		l1.setBounds(80, 30, 80, 30);
		f1.setBounds(120, 30, 80, 30);
		l2.setBounds(80, 60, 80, 30);
		f2.setBounds(120, 60, 80, 30);
		b1.setBounds(60, 90, 80, 30);
		b2.setBounds(150, 90, 80, 30);
		this.add(A);
		A.setFont(title);
		A.setForeground(Color.BLUE);
		this.add(l1);
		this.add(l2);
		this.add(f1);
		this.add(f2);
		this.add(b1);
		this.add(b2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Edge h = new Edge();
		h.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object d = e.getSource();
		if (d == b1) {
			if (f1.getText().equals("yang") && String.valueOf(f2.getPassword()).equals("1358"))
				new Main();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.dispose();

		}
		if (d == b2) {
			System.exit(0);
		}

	}

}

