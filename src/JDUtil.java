import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//jdbc工具类
public class JDUtil {
	//获取数据库连接对象
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String username="root";
		String password="zqs160705131";
		String url="jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8";//要设置数据库连接编码格式
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,username,password);
		return connection;
	}
	//关闭资源
	//AutoCloseable是所用资源的共有父类，通过多态：父类引用指向子类对象的操作实现多态，减少代码量。
	public static void close(AutoCloseable autoCloseable) throws Exception{
		if (autoCloseable != null) {
			autoCloseable.close();
		}
	}
}
