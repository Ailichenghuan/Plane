import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Charge extends JFrame implements  ActionListener{
	private static JLabel l1=new JLabel("������",JLabel.CENTER);
	private static JLabel l2=new JLabel("������",JLabel.CENTER);
	private static JLabel l3=new JLabel("Ŀ�ĵ�",JLabel.CENTER);
	private static JLabel l4=new JLabel("����ʱ��",JLabel.CENTER);
	private static JLabel l5=new JLabel("����ʱ��",JLabel.CENTER);
	private static JLabel l6=new JLabel("�ɻ�����",JLabel.CENTER);
	private static JTextField x1=new JTextField();
	private static JTextField x2=new JTextField();
	private static JTextField x3=new JTextField();
	private static JTextField x4=new JTextField();
	private static JTextField x5=new JTextField();
	private static JTextField x6=new JTextField();
	
	private static JButton b1=new JButton("���");
	private static JButton b2=new JButton("�޸�");
	private static JButton b3=new JButton("ɾ��");
	private static JButton b4=new JButton("��ѯ");
	private static JButton b5=new JButton("����");
	private static Connection conn = null;
	private static	ResultSet rs = null;
	private static Statement stmt=null;
	private static PreparedStatement ps=null;
	static String s1;
	static String s2;
	static String s3;
	static String s4;
	static String s5;
	static String s6;
	
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	public Charge(){
		super("�������");
		this.setSize(300,450);
		this.setLayout(null);
		this.setTitle("������Ϣ");
		l1.setBounds(10, 20,70, 30);
		x1.setBounds(80, 20, 60, 30);
		l2.setBounds(120, 20, 80, 30);
		x2.setBounds(190, 20,80, 30);
		l3.setBounds(10, 70, 60, 30);
		x3.setBounds(70, 70, 50, 30);
		l4.setBounds(120, 70, 60, 30);
		x4.setBounds(180, 70, 80, 30);
		l5.setBounds(10, 120, 80, 30);
		x5.setBounds(90, 120, 135, 30);
		l6.setBounds(10, 220, 60, 30);
		x6.setBounds(70, 220, 50, 30);
		b1.setBounds(20, 270, 110, 30);
		b2.setBounds(160, 270, 110, 30);
		b3.setBounds(20, 320, 110, 30);
		b4.setBounds(160, 320, 110, 30);
		b5.setBounds(85, 370, 110, 30);
		this.add(l1);
		this.add(x1);
		this.add(l2);
		this.add(x2);
		this.add(l3);
		this.add(x3);
		this.add(l4);
		this.add(x4);
		this.add(l5);
		this.add(x5);
		this.add(l6);
		this.add(x6);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	//���
	public static  void add(String x,String y,String x1,String y1,String x2,String y2){
		String sql="SELECT * FROM fly WHERE Fno=?";
	String in="INSERT INTO fly (Fno,������,Ŀ�ĵ�,����ʱ��,����ʱ��,�ɻ�����)"+"VALUES (?,?,?,?,?,?);";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if (x==null||x.equals("")||y==null||y.equals("")||x1==null||x1.equals("")||y1==null||y1.equals("")||x2==null||x2.equals("")||y2==null||y2.equals("")) {
			JOptionPane.showMessageDialog( null, "�����������Ϣ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
			return;
			}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		//stmt=conn.createStatement();
		ps=conn.prepareStatement(sql);
		ps.setString(1, "num");
		rs=ps.executeQuery();
		//rs=stmt.executeQuery(sql);
		while(rs.next()){
			s1=rs.getString("Fno");
			s2=rs.getString("������");
			s3=rs.getString("Ŀ�ĵ�");
			s4=rs.getString("����ʱ��");
			s5=rs.getString("����ʱ��");
			s6=rs.getString("�ɻ�����");
		}
		ps=conn.prepareStatement(in);
		ps.setString(1, x);
		ps.setString(2, y);
		ps.setString(3, x1);
		ps.setString(4, y1);
		ps.setString(5, x2);
		ps.setString(6, y2);
		ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
			return;
	} catch (Exception e) {
		e.printStackTrace();
		}
finally {
	try {
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(conn!=null)
			conn.close();
	} catch (Exception e2) {
		// TODO: handle exception
		e2.printStackTrace();
	}
}
			}
	}
// ��ѯ
	public  void get(String s){
	 String sql="SELECT * FROM fly WHERE Fno='"+s+"'";
	 if (s.equals("")) {
			JOptionPane.showMessageDialog(null, "�����뺽���Ų�ѯ��Ϣ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		while(rs.next()){
			s1=rs.getString("Fno");
			s2=rs.getString("������");
			s3=rs.getString("Ŀ�ĵ�");
			s4=rs.getString("����ʱ��");
			s5=rs.getString("����ʱ��");
			s6=rs.getString("�ɻ�����");
			
		} 
		if (s1==null) {
			JOptionPane.showMessageDialog(null, "�����ݲ����ڣ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
			return;
		}
		conn.close();	
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
	//�޸�
	public static  void update(String r){//,String t,String r1,String t1,String r2,String r3
		String sql="SELECT * FROM fly WHERE Fno=?";
	String up="UPDATE fly SET ������ = '" + x2.getText() + "',Ŀ�ĵ�='" + x3.getText() + "',����ʱ��='" + x4.getText() + "',����ʱ��='" + x5.getText() + "',�ɻ�����='" + x6.getText() + "'WHERE Fno='" + r + "'";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if(r==null||r.equals("")){
			JOptionPane.showMessageDialog(null, "�������޸���Ϣ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		//stmt=conn.createStatement();
		ps=conn.prepareStatement(sql);
		ps.setString(1,r);
		rs=ps.executeQuery();
		//rs=stmt.executeQuery(sql);
		while(rs.next()){
			s1=rs.getString("Fno");
			s2=rs.getString("������");
			s3=rs.getString("Ŀ�ĵ�");
			s4=rs.getString("����ʱ��");
			s5=rs.getString("����ʱ��");
			s6=rs.getString("�ɻ�����");
		}
		if (s1==null) {
			JOptionPane.showMessageDialog(null, "�����ݲ����ڣ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
			
		ps=conn.prepareStatement(up);
			//ps.setString(1, r);
			//ps.setString(2, t);
			//ps.setString(3, r1);
			//ps.setString(4, t1);
			//ps.setString(5, r2);
			//ps.setString(6, r3);
		//ps=conn.prepareStatement(up2);
	ps.executeUpdate();
	JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
	return;
	}
	} catch (Exception e) {
		e.printStackTrace();
		}
finally {
	try {
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(conn!=null)
			conn.close();
	} catch (Exception e2) {
		// TODO: handle exception
		e2.printStackTrace();
	}
}
		}
	}
//ɾ��
	public static  void del(String r){
		String sql="SELECT * FROM fly WHERE Fno=?";
	String up="DELETE FROM  fly  WHERE Fno=?";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if(r==null||r.equals("")){
	 JOptionPane.showMessageDialog(null, "���Ȳ�ѯ��Ϣ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
		return;}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		//stmt=conn.createStatement();
		ps=conn.prepareStatement(sql);
		ps.setString(1,r);
		rs=ps.executeQuery();
		//rs=stmt.executeQuery(sql);
		while(rs.next()){
			s1=rs.getString("Fno");
			s2=rs.getString("������");
			s3=rs.getString("Ŀ�ĵ�");
			s4=rs.getString("����ʱ��");
			s5=rs.getString("����ʱ��");
			s6=rs.getString("�ɻ�����");
		}
		if (s1==null) {
			JOptionPane.showMessageDialog(null, "�����ݲ����ڣ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
		ps=conn.prepareStatement(up);
		ps.setString(1, r);
		//ps=conn.prepareStatement(up2);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
		return;
		}
	} catch (Exception e) {
		e.printStackTrace();
		}
finally {
	try {
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(conn!=null)
			conn.close();
	} catch (Exception e2) {
		// TODO: handle exception
		e2.printStackTrace();
	}
}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Charge t=new Charge();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
Object x = e.getSource();
if (x==b1) {
	add(x1.getText(),x2.getText(),x3.getText(),x4.getText(),x5.getText(),x6.getText());
	x1.setText(null);
	x2.setText(null);
	x3.setText(null);
	x4.setText(null);
	x4.setText(null);
	x5.setText(null);
	x6.setText(null);
}
if (x==b2) {
	update(x1.getText());//,x2.getText(),x3.getText(),x4.getText(),x5.getText(),x6.getText()
	
	x1.setText(null);
	x2.setText(null);
	x3.setText(null);
	x4.setText(null);
	x4.setText(null);
	x5.setText(null);
	x6.setText(null);
	s1=null;
	s2=null;
	s3=null;
	s4=null;
	s5=null;
	s6=null;
}
if (x==b3) {
	del(x1.getText());
	x1.setText(null);
	x2.setText(null);
	x3.setText(null);
	x4.setText(null);
	x4.setText(null);
	x5.setText(null);
	x6.setText(null);
	s1=null;
	s2=null;
	s3=null;
	s4=null;
	s5=null;
	s6=null;
}
		if (x==b4) {
			get(x1.getText());
			x1.setText(s1);
			x2.setText(s2);
			x3.setText(s3);
			x4.setText(s4);
			x4.setText(s4);
			x5.setText(s5);
			x6.setText(s6);
			s1=null;
			s2=null;
			s3=null;
			s4=null;
			s5=null;
			s6=null;
		}
		if(x.equals(b5)){
			Main d=new Main();
			this.dispose();
		}
	}

}

