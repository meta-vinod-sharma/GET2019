import java.util.*;

/* This is a POJO class. This class consists of getters and setters.
 * @author Vinod
 *
 */
public class Orders {
	
	// Instance variables.
	private int orderId;
	private Date Date;
	private double totalAmount;
	
	// Getters and setters.
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}	
}
