package Question1_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * This class has methods to be performed on a graph
 * @author Vinod
 *
 */
public class Graph implements GraphInterface {
	
	private LinkedList<Edge> adjacencyList[];
	private int noOfVertices;
	
	/**
	 * It is a constructor to initialize the graph
	 * @param noOfVertices
	 */
	public Graph( int noOfVertices ) {
		this.noOfVertices = noOfVertices;
		adjacencyList = new LinkedList[noOfVertices+1];
		for(int i=1;i<=noOfVertices;i++) {
			adjacencyList[i]=new LinkedList<Edge>();
		}
	}

	/**
	 * This method is used to add edges in the graph
	 * 
	 * @param sourceVertex starting vertex
	 * @param adjacentVertices List of all the adjacent edges
	 */
	public void addEdge( int sourceVertex, LinkedList<Edge> adjacentVertices ) {
		adjacencyList[sourceVertex] = adjacentVertices;
	}

	/**
	 * This method is used to show the edge list representation of the graph
	 */
	public void showGraph() {
		for( int i = 1; i <= noOfVertices; i++ ) {
			LinkedList< Edge> adjacentVertices = adjacencyList[i];
			for(int j=0; j < adjacentVertices.size(); j++) {
				System.out.print(i+"->"+adjacentVertices.get(j).getDestinationVertex()+"("+adjacentVertices.get(j).getWeight()+")");
			} 
			System.out.printf("%n");
		}
	}
	
	/**
	 * This method traverses the graph in Depth First Search manner
	 * 
	 * @param sourceVertex starting vertex
	 * @return visited array that tells whether a node is visited
	 */
	private boolean[] performDFS ( int sourceVertex ) {
		boolean visited[] = new boolean[noOfVertices + 1];
		Stack<Integer> stack = new Stack<Integer>();
		visited[sourceVertex]=true;
		stack.push(sourceVertex);
		while(!stack.isEmpty()) {
			for(int i = 0; i < adjacencyList[sourceVertex].size(); i++) {
				if(!visited[adjacencyList[sourceVertex].get(i).getDestinationVertex()]) {
					visited[adjacencyList[sourceVertex].get(i).getDestinationVertex()] = true;
					stack.push(adjacencyList[sourceVertex].get(i).getDestinationVertex());
					sourceVertex = adjacencyList[sourceVertex].get(i).getDestinationVertex();
					i = 0;
				}
			}
			if(!stack.isEmpty()){
				stack.pop();
			}
			if(!stack.isEmpty()) {
				sourceVertex=stack.peek();
			}
		}
		return visited;
	}

	/**
	 * It will return true if the graph is a connected graph.
	 * @return boolean
	 */
	@Override
	public boolean isConnected() {
		boolean visited[] = this.performDFS(1);
		for(int i = 1; i <= noOfVertices; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * It will return all the nodes that are reachable from node a
	 * @param sourceVertex 
	 */
	@Override
	public ArrayList<Integer> isReachable(int sourceVertex) {
		if( sourceVertex < 1 || sourceVertex > noOfVertices) {
			throw new AssertionError("Invalid vertex");
		}
		ArrayList<Integer> reachableNodes = new ArrayList<Integer>();
		boolean visited[] = this.performDFS(1);
		for(int i = 1; i <= noOfVertices; i++) {
			if(visited[i]){
				reachableNodes.add(i);
			}
		}
		return reachableNodes;
	}

	/**
	 * It will return the shortest path from node source to destination node using Dijkstra’s algorithm. 
	 * @param sourceVertex
	 * @param destinationVertex
	 */
	@Override
	public int shortestPath(int sourceVertex, int destinationVertex) {
		if( sourceVertex < 1 || destinationVertex > noOfVertices || sourceVertex > noOfVertices || destinationVertex < 1) {
			throw new AssertionError("Invalid vertices");
		} 
		Set<Integer> shortestPathTree = new HashSet<Integer>();
		shortestPathTree.add(sourceVertex);
		int[] distance = new int[noOfVertices + 1];
		for ( int i = 1; i <= noOfVertices; i++) {
			if( i == sourceVertex ){
				distance[i] = 0;
			} else {
				distance[i] = Integer.MAX_VALUE;
			}
		}
		while(shortestPathTree.size() != noOfVertices) {
			LinkedList<Edge> srcAdjacentList = adjacencyList[sourceVertex];
			for( int i = 0; i <  srcAdjacentList.size(); i++ ) {
				if(!shortestPathTree.contains(srcAdjacentList.get(i).getDestinationVertex())) {
					if(	distance[srcAdjacentList.get(i).getDestinationVertex()] >(srcAdjacentList.get(i).getWeight() + distance[sourceVertex])) {
						distance[srcAdjacentList.get(i).getDestinationVertex()] = (srcAdjacentList.get(i).getWeight() + distance[sourceVertex]);
					}
				}
			}
			int destination = 0;
			int min = Integer.MAX_VALUE; 
			for( int i = 1; i <= noOfVertices; i++ ) {
				if(!shortestPathTree.contains(i)) {
					if( distance[i] < min ) {
						min = distance[i];
						destination = i;}
				}
			}
			shortestPathTree.add(destination);
			sourceVertex = destination;
		}
		return distance[destinationVertex];
	}

	/**
	 * It will return the minimum spanning tree for the graph using the greedy approach
	 * @param sourceVertex
	 * @return mst
	 */
	@Override
	public Graph mst(int sourceVertex) {
		Graph mst = new Graph(noOfVertices);
		Edge smallestEdge;
		int destination = 0;
		Set<Integer> shortestPathTree = new HashSet<Integer>();
		shortestPathTree.add(sourceVertex);
		int[] distance = new int[noOfVertices + 1];
		for ( int i = 1; i <= noOfVertices; i++) {
			if( i == sourceVertex ){
				distance[i] = 0;
			} else {
				distance[i] = Integer.MAX_VALUE;
			}
		}
		while(shortestPathTree.size() != noOfVertices) {
			LinkedList<Edge> srcAdjacentList = adjacencyList[sourceVertex];
			for( int i = 0; i <  srcAdjacentList.size(); i++ ){
				if(!shortestPathTree.contains(srcAdjacentList.get(i).getDestinationVertex())) {
					if(	distance[srcAdjacentList.get(i).getDestinationVertex()] >(srcAdjacentList.get(i).getWeight() )) {
						distance[srcAdjacentList.get(i).getDestinationVertex()] = (srcAdjacentList.get(i).getWeight() );
					}
				}
			}
			int min = Integer.MAX_VALUE; 
			for( int i = 1; i <= noOfVertices; i++ ) {
				if(!shortestPathTree.contains(i)) {
					for(int j = 0; j < srcAdjacentList.size(); j++) {
						if( distance[i] < min && srcAdjacentList.get(j).getDestinationVertex() == i ){
							min = distance[i];
							destination = i;
							break;
						}
					}
				}
			}
			for(int i = 0; i < srcAdjacentList.size(); i++) {
				if(srcAdjacentList.get(i).getDestinationVertex() == destination){
					smallestEdge = new Edge(sourceVertex, destination, min);
					mst.adjacencyList[sourceVertex].add(smallestEdge);
					shortestPathTree.add(destination);
					break;
				}
			}
			sourceVertex = destination;
		}
		return mst;
	}
}
