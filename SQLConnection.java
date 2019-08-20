import java.sql.*;

/* This is a component class. This class provides connection from the database i.e MySQL.
 * @author Vinod
 */
public class SQLConnection {
	
	// Reference variables.
	private Connection connection;
	private Statement statement;
	
	// Constructor.
	public SQLConnection(String dbName) {
		String url = "jdbc:mysql://localhost/" + dbName;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "root");
			statement = connection.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* This method returns Connection class object.
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/* This method return Statement class object.
	 * @return
	 */
	public Statement getStatement() {
		return statement;
	}
}
