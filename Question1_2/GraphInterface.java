package Question1_2;

import java.util.ArrayList;

/**
 * It is a graph interface
 * @author Vinod
 *
 */
public interface GraphInterface {
	public boolean isConnected();
	public ArrayList<Integer> isReachable(int a);
	public Graph mst(int sourceVertex);
	public int shortestPath(int sourceVertex, int destinationVertex);

}
