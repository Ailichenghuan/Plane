

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
	static JTextField d = new JTextField();
	static boolean h = true;
	JMenu t = new JMenu("�ɻ�����");
	JMenu t2 = new JMenu("�������");
	JMenu t1 = new JMenu("�˿͹���");
	JMenu t4 = new JMenu("���ݹ���");
	JMenu t5 = new JMenu("ϵͳ����");
	JMenu t3 = new JMenu("��Ʊ����");

	static JMenuItem A = new JMenuItem("�ͺź���������");
	static JMenuItem B = new JMenuItem("�˿����ϵǼǺͲ�ѯ");
	static JMenuItem C = new JMenuItem("������Ϣ��ӺͲ�ѯ");
	static JMenuItem D = new JMenuItem("ά��");
	static JMenuItem E = new JMenuItem("�˳�");
	static JMenuItem F = new JMenuItem("��Ʊ��Ϣ��ӺͲ�ѯ");

	static JLabel l1 = new JLabel("�ͺ�");
	JLabel l2 = new JLabel("����");

	static JPanel g=new JPanel();

	public Main() {
		super("��ƱԤ��ϵͳ");
		
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
		// TODO �Զ����ɵķ������
		Main f = new Main();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
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
			int t=JOptionPane.showConfirmDialog(this, "�Ƿ��˳���",null, JOptionPane.YES_NO_OPTION);
			if(t==JOptionPane.YES_OPTION)
			System.exit(0);
			else if (t==JOptionPane.NO_OPTION) {
				new Main();
				this.dispose();
			}
		}

	}

}
