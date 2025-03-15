package in.jdbcmvc.util;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
//usin hikaricp configuration for connecton pooling
public class JdbcUtil {
	static {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private JdbcUtil() {	
		}
		public static Connection getJdbcConnection() throws SQLException, IOException {
			HikariConfig config=new HikariConfig("C:\\\\Users\\\\jashw\\\\eclipse-workspace\\\\JDBCMVCMarch5\\\\src\\\\main\\\\java\\\\in\\\\jdbcmvc\\\\properties\\\\db.properties");
			HikariDataSource dataSource = new HikariDataSource(config); 
				Connection connection=dataSource.getConnection();
				return connection;
			
			
		}
		public static Connection getPhysicalConnection() throws SQLException, IOException{
			FileInputStream fis=new FileInputStream("C:\\Users\\jashw\\eclipse-workspace\\JDBCMVCMarch5\\src\\main\\java\\in\\jdbcmvc\\properties\\db.properties");
			Properties properites=new Properties();
			properites.load(fis);
			String url=properites.getProperty("url");
			String username=properites.getProperty("username");
			String password=properites.getProperty("password");
			
			Connection connection=DriverManager.getConnection(url,username,password);
			return connection;
			
		}
}
