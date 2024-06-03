import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Person extends JFrame implements  ActionListener{
	private static String str;
	private static JLabel l1=new JLabel("姓名");
	private static JLabel l2=new JLabel("性别");
	private static JLabel l3=new JLabel("身份证号");
	private static JLabel l4=new JLabel("联系电话");
	private static JLabel l5=new JLabel("籍贯");
	private static JLabel l6=new JLabel("旅客类型");
	
	private static JTextField x1=new JTextField();
	private static JTextField x2=new JTextField();
	private static JTextField x3=new JTextField();
	private static JTextField x4=new JTextField();
	private static JTextField x5=new JTextField();
	private static JTextField x6=new JTextField();
	
	private static JButton b1=new JButton("添加");
	private static JButton b2=new JButton("修改");
	private static JButton b3=new JButton("删除");
	private static JButton b4=new JButton("查询");
	private static JButton b5=new JButton("返回");
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
	public Person(){
		super("顾客资料管理");
		this.setSize(300,450);
		this.setLayout(null);
		this.setTitle("顾客信息");
		l1.setBounds(50, 20, 30, 30);
		x1.setBounds(85, 20, 80, 30);
		l2.setBounds(175, 20, 30, 30);
		x2.setBounds(205, 20,40, 30);
		l3.setBounds(50, 70, 60, 30);
		x3.setBounds(110, 70, 135, 30);
		l4.setBounds(50, 120, 60, 30);
		x4.setBounds(110, 120, 135, 30);
		l5.setBounds(50, 170, 60, 30);
		x5.setBounds(110, 170, 135, 30);
		l6.setBounds(50, 220, 60, 30);
		x6.setBounds(110, 220, 135, 30);
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
	
	//添加
	public static  void add(String x,String y,String x1,String y1,String x2,String y2){
		String sql="SELECT * FROM person WHERE 身份证号=?";
	String in="INSERT INTO person (姓名,性别,身份证号,联系电话,籍贯,旅客类型)"+"VALUES (?,?,?,?,?,?);";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if (x==null||x.equals("")||y==null||y.equals("")||x1==null||x1.equals("")||y1==null||y1.equals("")||x2==null||x2.equals("")||y2==null||y2.equals("")) {
			JOptionPane.showMessageDialog( null, "请输入添加信息！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
			}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		//stmt=conn.createStatement();
		ps=conn.prepareStatement(sql);
		ps.setString(1, "身份证号");
		rs=ps.executeQuery();
		//rs=stmt.executeQuery(sql);
		while(rs.next()){
			s1=rs.getString("姓名");
			s2=rs.getString("性别");
			s3=rs.getString("身份证号");
			s4=rs.getString("联系电话");
			s5=rs.getString("籍贯");
			s6=rs.getString("旅客类型");
		}
		ps=conn.prepareStatement(in);
		ps.setString(1, x);
		ps.setString(2, y);
		ps.setString(3, x1);
		ps.setString(4, y1);
		ps.setString(5, x2);
		ps.setString(6, y2);
		ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.WARNING_MESSAGE);
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
}}
			}
 //查询
	public  void get(String s){
	 String sql="SELECT * FROM person WHERE 身份证号='"+s+"'";
	 if (s.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入身份证号查询信息！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()){
			s1=rs.getString("姓名");
			s2=rs.getString("性别");
			s3=rs.getString("身份证号");
			s4=rs.getString("联系电话");
			s5=rs.getString("籍贯");
			s6=rs.getString("旅客类型");
			
		} 
		if (s3==null) {
			JOptionPane.showMessageDialog(null, "该数据不存在！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
		}
		conn.close();	
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
	//修改
	public static  void update(String r1){//String r,String t,,String t1,String r2,String r3
		String sql="SELECT * FROM person WHERE 身份证号=?";
	String up="UPDATE person SET 姓名='" + x1.getText() + "' ,性别='" + x2.getText() + "',联系电话='" + x4.getText() + "',籍贯='" + x5.getText() + "',旅客类型='" + x6.getText() + "'WHERE 身份证号='" + r1 + "'";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if(r1==null||r1.equals("")){
			JOptionPane.showMessageDialog(null, "请输入修改信息！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		//stmt=conn.createStatement();
		ps=conn.prepareStatement(sql);
		ps.setString(1,r1);
		rs=ps.executeQuery();
		//rs=stmt.executeQuery(sql);
		while(rs.next()){
			s1=rs.getString("姓名");
			s2=rs.getString("性别");
			s3=rs.getString("身份证号");
			s4=rs.getString("联系电话");
			s5=rs.getString("籍贯");
			s6=rs.getString("旅客类型");
		}
			if (s3==null) {
			JOptionPane.showMessageDialog(null, "该数据不存在！", "提示", JOptionPane.WARNING_MESSAGE);
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
	JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.WARNING_MESSAGE);
	return;}
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
//删除
	public static  void del(String r){
		String sql="SELECT * FROM person WHERE 身份证号=?";
	String up="DELETE  FROM  person  WHERE 身份证号=?";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if(r==null||r.equals("")){
	 JOptionPane.showMessageDialog(null, "请先通过身份证号查询信息！", "提示", JOptionPane.WARNING_MESSAGE);
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
			s1=rs.getString("姓名");
			s2=rs.getString("性别");
			s3=rs.getString("身份证号");
			s4=rs.getString("联系电话");
			s5=rs.getString("籍贯");
			s6=rs.getString("旅客类型");
		}
		if (s3==null&&x3.getText()!=null) {
			JOptionPane.showMessageDialog(null, "该数据不存在！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
		ps=conn.prepareStatement(up);
		ps.setString(1, r);
		//ps=conn.prepareStatement(up2);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.WARNING_MESSAGE);
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
		Person t=new Person();
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
	update(x3.getText());//x1.getText(),x2.getText(),,x4.getText(),x5.getText(),x6.getText()

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
	del(x3.getText());
	
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
			get(x3.getText());

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
