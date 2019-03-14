import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class JDBC_DMLTest {
	public static void main(String[] args) throws Exception {
		add(1,"张三","160705110","男");
	}
	public static void add(int id,String name,String num,String sex) throws Exception{
		//获取数据库连接对象
		Connection connection=JDUtil.getConnection();
		//预准备对象和sql语句，操作数据库
		String sql="insert into stu_info(id,name,num,sex) values(?,?,?,?)";
		PreparedStatement pStatement=connection.prepareStatement(sql);
		//添加值的方法
		pStatement.setInt(1,id);
		pStatement.setString(2,name);
		pStatement.setString(3,num);
		pStatement.setString(4,sex);
		int count=pStatement.executeUpdate();//执行上面的语句，并返回影响了多少条数据。
		System.out.println("影响了"+count+"条数据");
		//关闭资源
		JDUtil.close(pStatement);
		JDUtil.close(connection);
	}
}
