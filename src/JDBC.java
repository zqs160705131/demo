import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) throws ClassNotFoundException, Exception, IllegalAccessException {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		//创建连接数据库对象
		Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "zqs160705131");
		//创建语句传输对象
		Statement statement=connection.createStatement();
		//写操作数据库的sql语句
		String string="select * from stu_info";
		//接受结果集
		ResultSet set=statement.executeQuery(string);//执行sql语句并接收结果。
		//循环遍历输出查询的数据库结果
		while(set.next()){
			System.out.print(set.getInt("id")+" ");
			System.out.print(set.getString("name")+" ");
			System.out.print(set.getString("num")+" ");
			System.out.print(set.getString("sex")+" ");
			System.out.println();
		}
		//关闭资源，先开后关
		set.close();
		statement.close();
		connection.close();
	}
}
