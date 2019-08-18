package Question1_2;

/**
 * It is a class that has attributes for edges 
 * @author Vinod
 *
 */
public class Edge {
	private int sourceVertex;
	private int destinationVertex;
	private int weight;
	
	
	/**
	 * It is a constructor to initialize edge
	 * @param souceVertex
	 * @param destinationVertex
	 * @param weight
	 */
	public Edge(int souceVertex,int destinationVertex,int weight) {
		 this.sourceVertex=souceVertex;
		 this.destinationVertex = destinationVertex;
		 this.weight = weight;
	 }


	/**
	 * getter method for destinationVertex
	 * @return destinationVertex
	 */
	public int getDestinationVertex() {
		return destinationVertex;
	}

	

	/**
	 * getter method for weight
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}

	
}
