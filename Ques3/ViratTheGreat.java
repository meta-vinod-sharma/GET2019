package Ques3;

/**
 * It is a class used to implement heap and to find sequence of bowlers.
 * 
 * @author Vinod
 *
 */
public class ViratTheGreat {

	private Bumrah[] Heap;
	private int size;
	static int index = 0;

	/**
	 * It is a constructor to intialize heap.
	 * 
	 * @param maxSize
	 *            maximum size of heap.
	 */
	ViratTheGreat(int maxSize) {
		
		this.size = -1;
		Heap = new Bumrah[maxSize];
	}

	/**
	 * It is a method used to return position of parent.
	 * 
	 * @param pos
	 *            element position whose parent position to be return.
	 * @return parent position
	 */
	private int parent(int pos) {
		return pos / 2;
	}

	/**
	 * It is a method used to return left child position.
	 * 
	 * @param pos
	 *            element position whose left child position to be return.
	 * @return left child position.
	 */
	private int leftChild(int pos) {
		return (2 * pos) + 1;
	}

	/**
	 * It is a method used to return rigth child position.
	 * 
	 * @param pos
	 *            element position whose right child position to be return.
	 * @return right child position.
	 */
	private int rightChild(int pos) {
		return (2 * pos) + 2;
	}

	/**
	 * It is a method for swapping
	 * 
	 * @param fpos
	 *            first element position
	 * @param spos
	 *            second element position
	 */
	private void swap(int fpos, int spos) {
		Bumrah tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	/**
	 * It is a method used to check leaf or not.
	 * 
	 * @param pos
	 *            element position to be check.
	 * @return boolean value.
	 */
	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	/**
	 * It is a method used to insert value into heap.
	 * 
	 * @param ballsArray
	 */
	public void insert(Bumrah ballsArray[]) {
		for (int i = 0; i < ballsArray.length; i++) {
			Heap[++size] = ballsArray[i];
			int current = size;
			while (Heap[current].getNumberOfBalls() > Heap[parent(current)]
					.getNumberOfBalls()) {
				swap(current, parent(current));
				current = parent(current);
			}
		}
	}

	/**
	 * It is a method to place max element at the root.
	 * 
	 * @param pos
	 *            element position where we have to check.
	 */
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;

		if (Heap[pos].getNumberOfBalls() < Heap[leftChild(pos)]
				.getNumberOfBalls()
				|| Heap[pos].getNumberOfBalls() < Heap[rightChild(pos)]
						.getNumberOfBalls()) {

			if (Heap[leftChild(pos)].getNumberOfBalls() > Heap[rightChild(pos)]
					.getNumberOfBalls()) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	/**
	 * It is a method to find sequence of bowlers.
	 * 
	 * @param numberOfBalls
	 *            balls to be played.
	 * @return bowlers sequence.
	 */
	public int[] extractMax(int numberOfBalls) {
		int bowlerSeq[] = new int[numberOfBalls];
		while (size != -1) {
			bowlerSeq[index] = Heap[0].getId();
			index++;
			if (Heap[0].getNumberOfBalls() >= 1) {
				int balls = Heap[0].getNumberOfBalls();
				Heap[0].setNumberOfBalls(balls - 1);
				if ((balls - 1) == 0) {
					Heap[0] = Heap[size];
					size = size - 1;
				}
			}
			maxHeapify(0);
		}
		return bowlerSeq;
	}
}
