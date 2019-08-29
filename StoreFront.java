import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/* This class uses SQLConnection class which returns Connection object and establishes
 * connections between the  database i.e MySQL and JAVA using JDBC.
 * It consists of methods used for executing SQL queries.
 * @author Vinod
 */
public class StoreFront { 
	
	// Instance variables.
	private SQLConnection sql;
	private Connection cn;
	private Statement stmt;
	ResultSet rs;
	
	// Constructor.
	public StoreFront() {
		try {
			 sql = new SQLConnection("store_front");
			 cn = sql.getConnection();
			 stmt = sql.getStatement();
			 cn.setAutoCommit(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Query : Given the id of a user, fetch all orders ( Id, Order Date, Order Total ) of that user which are in 
	 * shipped state. Orders should be sorted by order date column in chronological order.
	 * @param userEmail - id of user.
	 * @return list of otders
	 */
	public List<Orders> fetchOrder(String userEmail) {
		Orders ord;
		List<Orders> ordersList = new ArrayList<Orders>();
		String query = "SELECT o.order_id, o.order_timestamp, o.total_amount "
				+ "FROM orders o "
				+ "LEFT JOIN order_items oi ON o. order_id = oi.order_id "
				+ "LEFT JOIN user u ON o.shopper_mail = u.email_id "
				+ "WHERE u.email_id = \"" + userEmail + "\""
				+ "AND oi.ordr_status = \"Pending\" "
				+ "ORDER BY o.order_timestamp DESC;";
		try {
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				ord = new Orders();
				ord.setOrderId(rs.getInt(1));
				ord.setDate(rs.getDate(2));
				ord.setTotalAmount(rs.getDouble(3));
				ordersList.add(ord);
			}
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				System.out.println("Transaction is being rolled back.");
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return ordersList;
	}
	
	/*Query - Insert five or more images of a product using batch insert technique.
	 * @return Number of rows inserted.
	 */
	public int batchInsert(Images images) {
		int affectedRows = 0;
		String query = "INSERT INTO images( p_id, image_link) VALUES (?, ?);";
		
		// Array of inputs for batch insertion.
		int productIdArray[] = images.getProductIdArray();
		String imageLinkArray[] = images.getImageLinkArray();
		
		// Prepared statement used for insertion.
		try {
			PreparedStatement prepStmt = cn.prepareStatement(query);
			for(int i = 0; i < productIdArray.length; i++) {
				prepStmt.setInt(1, productIdArray[i]);
				prepStmt.setString(2, imageLinkArray[i]);
				affectedRows += prepStmt.executeUpdate();
			}
			cn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				System.out.println("Transaction is being rolled back.");
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return affectedRows;
	}
	
	/*Query - Delete all those products which were not ordered by any Shopper in last 1 year.
	 * @return number of products deleted.
	 */
	public	int deleteProducts() {
		int affectedRows = 0;
		String query = "DELETE from products "
				+ "WHERE p_id not in "
				+ "( select product_id from order_items "
				+ "left join orders on order_items.order_id = orders.Order_id "
				+ " AND TIMESTAMPDIFF(year,orders.order_timestamp, CURRENT_TIMESTAMP) < 1 )";
		try {
			affectedRows = stmt.executeUpdate(query);
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				System.out.println("Transaction is being rolled back.");
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return affectedRows;
	}
	
	/*Query -4 Select and display the category title of all top parent categories sorted
	 * alphabetically and the count of their child categories.
	 * @return list of top categories 
	 */
	public List<TopCategory> displayCategory() {
		TopCategory topCategory;
		List<TopCategory> topCatList = new ArrayList<TopCategory>();
		String query = "SELECT p.category_Name , count(p.category_Name) "
				+ "FROM categories p "
				+ "LEFT JOIN categories c ON p.category_Name = c.parent_category "
				+ "WHERE p.parent_category = \"Top category\" "
				+ "AND p.category_Name != \"Top category\" "
				+ "GROUP BY p.category_Name "
				+ "ORDER BY p.category_Name ASC;";
		try {
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				topCategory = new TopCategory();
				topCategory.setCategoryName(rs.getString(1));
				topCategory.setNumberOfChilds(rs.getInt(2));
				topCatList.add(topCategory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topCatList;
	}
	
	// Closes all the resources used.
	public boolean closeAll() throws SQLException {
		stmt.close();
		cn.close();
		return true;
	}
}
