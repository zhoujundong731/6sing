import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zhoujundong
 *
 */
public class DaoTest {
	
	private String name;
	public DaoTest(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DaoTest() {
	}
	public static void main(String[] args) {
		DaoTest dao=new DaoTest("name");
		/*dao.jdbc();
		List<String> arr=dao.getList("text");*/
		ArrayList<text> test=dao.getAllTest(text.class);
		for (text text : test) {
			System.out.println(text.getId());
			System.out.println(text.getPassword());
		}
	}
	
	/**
	 * 获取数据库表的列数，列名
	 *
	 */
	public void jdbc(){
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/6sing", "root", "1");
			//Properties pros=con.getClientInfo();
			PreparedStatement statement=null;
			ResultSet rs=null;
			statement=con.prepareStatement("select * from text where 1=2");
			rs=statement.executeQuery();
			ResultSetMetaData date=rs.getMetaData();
			int count=date.getColumnCount();
			System.out.println("count:"+count);
			for (int i = 1; i<=count; i++) {
				System.out.println(date.getColumnName(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getList(String tableName){
		ArrayList<String> arr=new ArrayList<>();
		Connection con;
		ResultSet cols=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/6sing", "root", "1");
			System.out.println("连接成功！");
			java.sql.DatabaseMetaData dbm=con.getMetaData();
			cols=dbm.getColumns(null, "%", tableName, "%");
			while(cols.next()){
				String cloumnName=cols.getString("COLUMN_NAME");
				String columnType=cols.getString("TYPE_NAME");
				int dataSize=cols.getInt("COLUMN_SIZE");
				int digits=cols.getInt("DECIMAL_DIGITS");
				int nullAble=cols.getInt("NULLABLE");
				arr.add(cloumnName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public ArrayList getAllTest(Class clazz){
		ArrayList<Object> arrs=new ArrayList<>();
		Connection con;
		PreparedStatement ps=null;
		ResultSet set=null;
		Field[] fi=clazz.getDeclaredFields();
		ArrayList<String> col=getList(clazz.getSimpleName());
		StringBuffer sql=new StringBuffer();
		sql.append("select ");
		for (int i = 0; i < col.size(); i++) {
			sql.append(col.get(i));
			if(i!=col.size()-1){
				sql.append(",");
			}
		}
		sql.append(" from ");
		sql.append(clazz.getSimpleName());
		System.out.println(sql.toString());
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/6sing", "root", "1");
			ps=con.prepareStatement(sql.toString());
			set=ps.executeQuery();
			while(set.next()){
				Object ob=clazz.newInstance();
				for (int i = 0; i < col.size(); i++) {
					for ( Field ff:fi) {
						if(col.get(i).equalsIgnoreCase(ff.getName())){
							ff.setAccessible(true);
							ff.set(ob, set.getObject(col.get(i)));
							break;
						}
						
					}
				}
				arrs.add(ob);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrs;
	}
}
