import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Airplane extends JFrame implements  ActionListener{
	private static JLabel l1=new JLabel("型号",JLabel.CENTER);
	private static JLabel l2=new JLabel("座数",JLabel.CENTER);
	private static JLabel l3=new JLabel("工作年数",JLabel.CENTER);
	private static JTextField x1=new JTextField();
	private static JTextField x2=new JTextField();
	private static JTextField x3=new JTextField();

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

	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	public Airplane(){
		super("飞机管理");
		this.setSize(300,450);
		this.setLayout(null);
		this.setTitle("飞机信息");
		l1.setBounds(20, 20, 30, 30);
		x1.setBounds(50, 20, 70, 30);
		l2.setBounds(110, 20, 80, 30);
		x2.setBounds(190, 20,80, 30);
		l3.setBounds(10, 70, 60, 30);
		x3.setBounds(70, 70, 70, 30);
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
	public static  void add(String x,String y,String x1){
		String sql="SELECT * FROM airplane WHERE 型号=?";
	String in="INSERT INTO airplane (型号,座数,工作年数)"+"VALUES (?,?,?);";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if (x==null||x.equals("")||y==null||y.equals("")||x1==null||x1.equals("")) {
			JOptionPane.showMessageDialog( null, "请输入添加信息！", "提示", JOptionPane.WARNING_MESSAGE);
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
			s1=rs.getString("型号");
			s2=rs.getString("座数");
			s3=rs.getString("工作年数");
		}
		ps=conn.prepareStatement(in);
		ps.setString(1, x);
		ps.setString(2, y);
		ps.setString(3, x1);
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
}
			}
	}
// 查询
	public  void get(String s){
	 String sql="SELECT * FROM airplane WHERE 型号='"+s+"'";
	 if (s.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入型号查询信息！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		while(rs.next()){
			s1=rs.getString("型号");
			s2=rs.getString("座数");
			s3=rs.getString("工作年数");
			
		} 
		if (s1==null) {
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
	public static  void update(String r){//,String t,String r1
		String sql="SELECT * FROM airplane WHERE 型号 = ?";
	String up="UPDATE airplane SET 座数= '" + x2.getText() + "' ,工作年数= '" + x3.getText() + "'" + "WHERE 型号='" + r + "'";
		//String up = "UPDATE airplane SET 座数 = '130' , 工作年数 = '9'WHERE 型号 = '002'";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if(r==null||r.equals("")){
			JOptionPane.showMessageDialog(null, "请输入修改信息！", "提示", JOptionPane.WARNING_MESSAGE);
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
			s1=rs.getString("型号");
			s2=rs.getString("座数");
			s3=rs.getString("工作年数");
		}
		if (s1==null) {
			JOptionPane.showMessageDialog(null, "该数据不存在！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
			
		ps=conn.prepareStatement(up);
		//ps.setString(1, r);
		//ps.setString(2, t);
		//ps.setString(3, r1);
		//ps=conn.prepareStatement(up2);
	ps.executeUpdate();
	JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.WARNING_MESSAGE);
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
//删除
	public static  void del(String r){
		String sql="SELECT * FROM airplane WHERE 型号=?";
	String up="DELETE FROM  airplane  WHERE 型号=?";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT&useSSL=false";
	 String user = "root";
	 String password = "liuyang";
	 if(r==null||r.equals("")){
	 JOptionPane.showMessageDialog(null, "请先查询信息！", "提示", JOptionPane.WARNING_MESSAGE);
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
			s1=rs.getString("型号");
			s2=rs.getString("座数");
			s3=rs.getString("工作年数");
		}
		if (s1==null) {
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
		Airplane t=new Airplane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
Object x = e.getSource();
if (x==b1) {
	add(x1.getText(),x2.getText(),x3.getText());
	x1.setText(null);
	x2.setText(null);
	x3.setText(null);
}
if (x==b2) {
	update(x1.getText());//,x2.getText(),x3.getText()
	
	x1.setText(null);
	x2.setText(null);
	x3.setText(null);
	s1=null;
	s2=null;
	s3=null;
}
if (x==b3) {
	del(x1.getText());
	x1.setText(null);
	x2.setText(null);
	x3.setText(null);
	s1=null;
	s2=null;
	s3=null;
}
		if (x==b4) {
			get(x1.getText());
			x1.setText(s1);
			x2.setText(s2);
			x3.setText(s3);
			s1=null;
			s2=null;
			s3=null;
		}
		if(x.equals(b5)){
			Main d=new Main();
			this.dispose();
		}
	}

}


