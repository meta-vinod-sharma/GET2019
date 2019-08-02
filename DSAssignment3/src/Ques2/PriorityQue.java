package Ques2;

public interface PriorityQue {
	public boolean enque(int data, int priority);
	public int deque();
	public int[] show();
	public  int maxPriority();
	public boolean isEmpty();
	public boolean isFull();

}
