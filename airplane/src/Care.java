import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Care extends JFrame implements ActionListener{
	static JButton b1=new JButton("备份");
	static JButton b2=new JButton("还原");
	static JButton b3=new JButton("返回");
	private Connection conn = null;
	private	ResultSet rs = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	 String url = "jdbc:mysql://localhost:3306/airplane";
	 String user = "root";
	String password = "liuyang";
	public Connection get(){
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
	} catch (Exception e) {
		e.printStackTrace();
		}
	return conn;
}
	public static void capy(){
		try {
Runtime rt=Runtime.getRuntime();
String cmd="mysqldump -h localhost -u root -p liuyang airplane >d:/test.sql";
rt.exec("cmd /c"+cmd);
JOptionPane.showMessageDialog( null, "备份成功！（路径为d盘）", "提示", JOptionPane.WARNING_MESSAGE);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	JOptionPane.showMessageDialog( null, "备份失败！", "提示", JOptionPane.WARNING_MESSAGE);
}
	}
	public static void restore(){
		try {
			String str="mysql -u root -p liuyang airplane<c:/test.sql";
			Runtime rt=Runtime.getRuntime();
				rt.exec("cmd /c"+str);
JOptionPane.showMessageDialog( null, "还原成功！", "提示", JOptionPane.WARNING_MESSAGE);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	JOptionPane.showMessageDialog( null, "还原失败！", "提示", JOptionPane.WARNING_MESSAGE);
}
	}
	public Care(){
		super("系统维护");
		this.setLayout(null);
		this.setSize(250,200);
		b1.setBounds(80, 60, 80, 30);
		b2.setBounds(80, 100, 80, 30);
		b3.setBounds(80, 20, 80, 30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Care C=new Care();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object d=e.getSource();
		if(d==b1){
			capy();
		}
		if(d==b2){
			restore();
		}
		if(d==b3){
			new Main();
		}
	}

}
