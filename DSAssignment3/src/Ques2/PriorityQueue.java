package Ques2;

/**
 * @author Vinod
 *
 *class PriorityQueue contains methods to enque,deque ,show elements of queue
 */
public class PriorityQueue implements PriorityQue{
	
	Queue priorityQueue[];  //  priorityQueue[] stores elements of Queue type
	static int size, capacity;
	
	public PriorityQueue(int maxSize){
		capacity = maxSize;
		this.priorityQueue = new Queue[capacity];
		size = -1;
	}
	
	
	public static void main(String args[]){
		PriorityQueue priQue = new PriorityQueue(7);
		priQue.enque(10, 7);
		priQue.enque(11, 8);
		priQue.enque(12, 1);
		priQue.enque(13, 82);
		priQue.enque(14, 65);
		priQue.enque(15, 35);
		priQue.enque(16, 11);
		priQue.show();
		System.out.println("----------------------------");
		System.out.println("deleted item = "+priQue.deque());
		priQue.show();
	}
	
	/**
	 * @param data   is values to be inserted in queue
	 * @param priority   priority of that value 
	 * @return  returns boolean that insertion is successful or not
	 */
	@Override
	public boolean enque(int data, int priority){
		if(size == capacity - 1){
			System.out.println(" Priority Queue is Full");
			return false;
		}
		Queue element = new Queue(data, priority);
		priorityQueue[++size] = element;
		return true;
	}
	
	
	/**
	 * @return   returns deleted element which has highest priority
	 */
	@Override
	public int deque(){
		
		if(size == -1){
			System.out.println(" Priority Queue is Empty");
			return -1;
		}
		int pos = maxPriority();
		
		while(pos < size ){
			Queue temp = priorityQueue[pos];
			priorityQueue[pos] = priorityQueue[pos + 1];
			priorityQueue[pos + 1] = temp;
			pos++;
		}
		return priorityQueue[size--].data;
		
		
	}
	
	
	/**
	 * @return  returns position of values that has heighest priority
	 */
	@Override
	public  int maxPriority(){
		int i = 1;
		int max = priorityQueue[0].priority;
		int pos = 0;
		while(i <= size){
			if(priorityQueue[i].priority > max){
				max = priorityQueue[i].priority;
				pos = i;
			}
			i++;
			
		}
		return pos;
	}
	
	
	/**
	 * @return  return queue elements array
	 */
	@Override
	public int[] show(){
		int[] arr = new int [size + 1];
		for(int i = 0; i <= size; i++){
			arr[i] = priorityQueue[i].data;
			System.out.print("-->"+priorityQueue[i].data);
			
		}
		System.out.println();
		for(int i = 0; i <= size; i++){
			System.out.print("-->"+priorityQueue[i].priority);
			
		}
		return arr;
		
	}


	@Override
	public boolean isEmpty() {
		
		return size == -1;
	}


	@Override
	public boolean isFull() {
		
		return size == capacity - 1;
	}
	
}
