package Ques2;

/**
 * @author Vinod
 *
 */
public class EmployeeList {
	Node head;

	public static void main(String args[]) {

		EmployeeList list = new EmployeeList();
		Employee emp1 = new Employee(1, "Vinod", 23000, 25);
		Employee emp2 = new Employee(2, "Vinay", 23000, 24);
		Employee emp3 = new Employee(3, "Bhupendra", 25000, 25);
		Employee emp4 = new Employee(4, "Surendra", 26000, 26);
		Employee emp5 = new Employee(5, "Sur", 23000, 18);
		Employee emp6 = new Employee(6, "Sura", 23000, 16);
		list.insert(emp4);
		list.insert(emp1);
		list.insert(emp6);
		list.insert(emp3);
		list.insert(emp2);
		list.insert(emp5);
		list.insert(emp6);

		list.printList();

		System.out.println("---------------");
		sort(list);
		list.printList();

	}

	/**
	 * @param emp   is an oject of employee to be inserted in list
	 */
	public void insert(Employee emp) {
		Node node = new Node(emp);

		if (head == null) {
			head = node;
		} else {

			Node node1 = head;
			while (node1 != null) {
				if (node1.emp.getEmpId() == node.emp.getEmpId()) {
					System.out.println("Employee already exits!!");
					return;
				}
				node1 = node1.next;
			}
			Node node2 = head;
			while (node2.next != null) {
				node2 = node2.next;
			}
			node2.next = node;
		}
	}

	/**
	 * printList()  prints deatils of employee in the list
	 */
	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.println("-->" + node.emp.getEmpId() + "  "
					+ node.emp.getName() + "  " + node.emp.getSalary() + "  "
					+ node.emp.getAge());
			node = node.next;
		}
	}

	/**
	 * @param list  list is arrayList of employess
	 * 
	 * this function sorts employee according to salary.if two employee has same salary the less age will be considered greater
	 */
	public static void sort(EmployeeList list) {
		Node node1 = list.head;

		while (node1.next != null) {
			Node node2 = node1.next;

			while (node2 != null) {

				if (node1.emp.getSalary() == node2.emp.getSalary()) {
					if (node1.emp.getAge() > node2.emp.getAge()) {
						Employee node3 = node1.emp;
						node1.emp = node2.emp;
						node2.emp = node3;
						continue;
					}
				}

				if (node1.emp.getSalary() < node2.emp.getSalary()) {

					Employee node3 = node1.emp;
					node1.emp = node2.emp;
					node2.emp = node3;
				}

				node2 = node2.next;
			}
			node1 = node1.next;

		}

		// public EmployeeList sort(EmployeeList list) {
		// EmployeeList newList = new EmployeeList();
		//
		// newList.head = list.head;
		// list.head = list.head.next;
		// newList.head.next = null;
		//
		//
		// Node currentMain = list.head;//
		//
		//
		// // Runs for main list till end.
		// while(currentMain != null){
		// Node currentNew = newList.head;
		// Node prevNew = newList.head;
		// while(currentNew != null && currentNew.emp.getSalary() >=
		// currentMain.emp.getSalary()){
		// while(currentNew.emp.getSalary() == currentMain.emp.getSalary()){
		//
		// }
		// prevNew = currentNew;
		// currentNew = currentNew.next;
		// }
		// list.head = currentMain.next;
		// currentMain.next = currentNew;
		// prevNew.next = currentMain;
		// currentMain = list.head;
		//
		// }
		//
		//
		// return newList;

	}
}
