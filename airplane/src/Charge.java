import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Charge extends JFrame implements  ActionListener{
	private static JLabel l1=new JLabel("航班编号",JLabel.CENTER);
	private static JLabel l2=new JLabel("出发地",JLabel.CENTER);
	private static JLabel l3=new JLabel("目的地",JLabel.CENTER);
	private static JLabel l4=new JLabel("出发时间",JLabel.CENTER);
	private static JLabel l5=new JLabel("飞行时间",JLabel.CENTER);
	private static JLabel l6=new JLabel("飞机类型",JLabel.CENTER);
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
	public Charge(){
		super("航班管理");
		this.setSize(300,450);
		this.setLayout(null);
		this.setTitle("航班信息");
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
	
	//添加
	public static  void add(String x,String y,String x1,String y1,String x2,String y2){
		String sql="SELECT * FROM fly WHERE Fno=?";
	String in="INSERT INTO fly (Fno,出发地,目的地,出发时间,飞行时间,飞机类型)"+"VALUES (?,?,?,?,?,?);";
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
		ps.setString(1, "num");
		rs=ps.executeQuery();
		//rs=stmt.executeQuery(sql);
		while(rs.next()){
			s1=rs.getString("Fno");
			s2=rs.getString("出发地");
			s3=rs.getString("目的地");
			s4=rs.getString("出发时间");
			s5=rs.getString("飞行时间");
			s6=rs.getString("飞机类型");
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
}
			}
	}
// 查询
	public  void get(String s){
	 String sql="SELECT * FROM fly WHERE Fno='"+s+"'";
	 if (s.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入航班编号查询信息！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
		}else{
try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		while(rs.next()){
			s1=rs.getString("Fno");
			s2=rs.getString("出发地");
			s3=rs.getString("目的地");
			s4=rs.getString("出发时间");
			s5=rs.getString("飞行时间");
			s6=rs.getString("飞机类型");
			
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
	public static  void update(String r){//,String t,String r1,String t1,String r2,String r3
		String sql="SELECT * FROM fly WHERE Fno=?";
	String up="UPDATE fly SET 出发地 = '" + x2.getText() + "',目的地='" + x3.getText() + "',出发时间='" + x4.getText() + "',飞行时间='" + x5.getText() + "',飞机类型='" + x6.getText() + "'WHERE Fno='" + r + "'";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
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
			s1=rs.getString("Fno");
			s2=rs.getString("出发地");
			s3=rs.getString("目的地");
			s4=rs.getString("出发时间");
			s5=rs.getString("飞行时间");
			s6=rs.getString("飞机类型");
		}
		if (s1==null) {
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
		String sql="SELECT * FROM fly WHERE Fno=?";
	String up="DELETE FROM  fly  WHERE Fno=?";
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url ="jdbc:mysql://localhost:3306/airplane?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
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
			s1=rs.getString("Fno");
			s2=rs.getString("出发地");
			s3=rs.getString("目的地");
			s4=rs.getString("出发时间");
			s5=rs.getString("飞行时间");
			s6=rs.getString("飞机类型");
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

