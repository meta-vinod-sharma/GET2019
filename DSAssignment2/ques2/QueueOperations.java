package ques2;

/**
 * @author Vinod
 *
 *class QueueOperations contains method addElementToQueue ,deQueue, emptyQueue and fullQueue and show the circular queue.
 */
public class QueueOperations implements Queue {

	int queue[];
	int size, front, rear;

	/**
	 * constructor to initilize front,rear and queue
	 * @param size  // size of queue
	 */
	public QueueOperations(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		queue = new int[size];
	}

	
	/* (non-Javadoc)
	 * @see ques2.Queue#addElementToQueue(int)
	 * @param data   insert data to queue
	 */
	@Override
	public boolean addElementToQueue(int data) {
		if (fullQueue()) {
			System.out.println("Queue is full");
			return false;
		} else if (front == -1) {
			front = rear = 0;
			queue[rear] = data;
		}

		else if (rear == size - 1 && front != 0) {
			rear = 0;
			queue[rear] = data;
		}

		else {
			rear++;
			queue[rear] = data;
		}
		return true;

	}

	/* 
	 * this method delete the top element
	 */
	@Override
	public boolean deQueue() {
		if (emptyQueue()) {
			System.out.println("Queue is Empty");
			return false;
		} else {
			queue[front] = -1;
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == size - 1)
				front = 0;
			else
				front++;
		}
		return true;
	}

	/* 
	 * this emptyQueue method returns true if queue is empty else false 
	 */
	@Override
	public boolean emptyQueue() {
		if (front == -1) {
			return true;
		}
		return false;

	}
	/* 
	 * this emptyQueue method returns true if queue is full else false 
	 */

	@Override
	public boolean fullQueue() {
		if ((front == rear + 1) || (front == 0 && rear == size - 1))
			return true;
		return false;
	}

	/*
	 * this show method shows elements of queue
	 */
	public void show() {
		if (front == -1) {
			System.out.println("\nQueue is Empty");
		}
		if (rear >= front) {
			for (int i = front; i <= rear; i++)
				System.out.println("-->" + queue[i]);
		} else {
			for (int i = front; i < size; i++)
				System.out.println("-->" + queue[i]);

			for (int i = 0; i <= rear; i++)
				System.out.println("-->" + queue[i]);
		}
	}

}
