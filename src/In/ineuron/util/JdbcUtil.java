//package In.ineuron.util;
//
//public class JdbcUtil {
//
//}

package In.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;




//Using hikaricp configuration for connection pooling



//@SuppressWarnings("unused")
public class JdbcUtil {

	private JdbcUtil() {

	}                                                      
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws FileNotFoundException, SQLException, IOException  {
//		FileInputStream fis = new FileInputStream("src\\In\\ineuron\\properties\\db.properties");
//		Properties properties = new Properties();
//		properties.load(fis);
//		String url = properties.getProperty("url");
//		String username = properties.getProperty("user");
//		String password = properties.getProperty("password");
//		Connection connection = DriverManager.getConnection(url, username, password);
		HikariConfig Config =  new HikariConfig("src\\\\In\\\\ineuron\\\\properties\\\\db.properties");
		HikariDataSource dataSource = new HikariDataSource(Config);
		Connection connection = dataSource.getConnection();
		return connection;
		
	}
	
	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		FileInputStream fis = new FileInputStream("src\\In\\ineuron\\properties\\db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
}

