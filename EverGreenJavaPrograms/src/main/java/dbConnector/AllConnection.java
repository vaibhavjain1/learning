package dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AllConnection {

	public static void main(String[] args) throws SQLException {
		String serverName = "localhost";
		Integer serverPort = 3306;
		String databaseName = "wordpress";
		String userName = "admin";
		String password= "admin";
		boolean isWindowAuth = false;
		String domain = "EMBARCADERO";
		
		String sqlJdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String sqlJtdsDriver = "net.sourceforge.jtds.jdbc.Driver";
		String mySqlDriver = "com.mysql.jdbc.Driver";
		String postgresDriver = "org.postgresql.driver";
		String oracleDriver = "oracle.jdbc.driver.oracledriver";
		
		String sqlJdbcUrl = "jdbc:sqlserver://"+serverName+":"+serverPort+";databaseName="+databaseName+";";
		String sqlJtdsUrl = "jdbc:jtds:sqlserver://"+serverName+":"+serverPort+";databaseName="+databaseName+";useNTLMv2=true";
		
		if(isWindowAuth)
		{
			sqlJdbcUrl += "Trusted_Connection=true;domain="+domain+"";
			sqlJtdsUrl += "Trusted_Connection=true;domain="+domain+"";
		}
		
		Connection con = null;
		try {
			System.out.println("ConnectionURL:"+ sqlJtdsUrl);
			Class.forName(mySqlDriver);
			con = DriverManager.getConnection(sqlJtdsUrl, userName, password);
			System.out.println("Connection created successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(con!=null)
				con.close();
		}
	}

}
