import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*操作数据库完成增删改后，并进行查询操作。增删改这些动态操作sql语句用PreparedStatement预准备操作语句对象，如果为查询则通过Statement语句操作对象进行操作sql语句。
 *通过设置较大的变量范围完成在异常处理中的资源关闭操作。 
*/
 
public class JDBC_TryCatch {
	
	public static void main(String[] args) {
		add(2,"李四","160705111","女");
	}
	public static void add(int id,String name,String num,String sex){
		Connection connection=null;
		PreparedStatement p=null;	
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=JDUtil.getConnection();
			//取消自主向数据库提交数据。
			connection.setAutoCommit(false);			
			//增加
			//String sql="insert into stu_info(id,name,num,sex) values(?,?,?,?)";
			//删除
			//String sql="delete from stu_info where id=1";
			//更改
			String sql="update stu_info set sex='男' where id=2";
			p=connection.prepareStatement(sql);
			//增加
			/*p.setInt(1, id);
			p.setString(2,name);
			p.setString(3,num);
			p.setString(4,sex);*/
			int count=p.executeUpdate();
			//向数据库进行提交数据。实现事务机制。
			connection.commit();
			System.out.println("影响了"+count+"条数据");
			//查询
			statement=connection.createStatement();
			String sql1 = "select * from stu_info";
			resultSet=statement.executeQuery(sql1);
			while(resultSet.next()){
				System.out.print(resultSet.getInt("id")+" ");
				System.out.print(resultSet.getString("name")+" ");
				System.out.print(resultSet.getString("num")+" ");
				System.out.print(resultSet.getString("sex")+" ");
				System.out.println();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				JDUtil.close(resultSet);
				JDUtil.close(p);
				JDUtil.close(statement);
				JDUtil.close(connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
