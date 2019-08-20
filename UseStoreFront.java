import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/* This is an application class. It uses the functionality of StoreFront class.
 * @author Vinod
 *
 */
public class UseStoreFront {
	public static void main(String args[]) throws Exception {

		// StoreFront object for performing operations over database.
		StoreFront sf = new StoreFront();
		
		// Assignment - 1
		List<Orders> ordersList = sf.fetchOrder("bk9929@gmail.com");
		System.out.format("\n%5s%20s%20s\n", "Order_id", "Order_timestamp", "Order_amount");
		System.out.println("------------------------------------------------------");
		for(Orders o : ordersList)
			System.out.format("\n%5s%20s%20s\n", o.getOrderId(), o.getDate(), o.getTotalAmount());
		
		// Assignment - 2
		Images images = new Images();
		images.setProductIdArray(new int[] { 3, 3, 3, 4, 4, 5});
		images.setImageLinkArray(new String[] {
				"https://www.google.co/id=2113",
				"https://www.google.co/id=2114",
				"https://www.google.co/id=2131",
				"https://www.google.co/id=2166",
				"https://www.google.co/id=2154",
				"https://www.google.co/id=2167"
		});
		System.out.println("\nNumber of rows inserted to \"Images\": " + sf.batchInsert(images));
		
		// Assignment - 3
		System.out.println("\nNumber of records deleted from \"Products\": " + sf.deleteProducts());
		
		// Assignment - 4
		List<TopCategory> topCatList = sf.displayCategory();
		System.out.format("\n%5s%20s\n" , "Category_Name", "Child_count");
		System.out.println("------------------------------------------------------");
		for(TopCategory tc : topCatList)
			System.out.format("\n%12s%15s\n" ,tc.getCategoryName(), tc.getNumberOfChilds());

	}
}
