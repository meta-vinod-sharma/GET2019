package Question1_2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The class containing main method
 * @author Vinod
 *
 */
public class GraphMain {
	public static void main( String args[]){
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		try {
			System.out.println("Enter the no of vertices :");
			int noOfVertices = sc.nextInt();
			if ( noOfVertices <= 0 ){
				System.out.println("Not a valid option");
				main(args);
			}
			Graph graph = new Graph(noOfVertices);
			LinkedList<Edge> adjacentVertices;
			Edge newEdge;
			int weight;
			int destinationVertex;
			do {
				System.out.println("1.Insert adjacent vertices for a source");
				System.out.println("2.Show the edge list of the graph");
				System.out.println("3.Graph is connected?");
				System.out.println("4.reachability");
				System.out.println("5.minimum spanning tree");
				System.out.println("6.shortest path");
				System.out.println("7.Exit");
				int choice = sc.nextInt();
				switch(choice){
				case Constant.ONE:
						for(int i = 1; i <= noOfVertices; i++){
							System.out.println("Enter the no of neighbours of "+ i + " vertex :");
							int noOfNeighbours = sc.nextInt();
							adjacentVertices = new LinkedList<Edge>();
							for ( int j = 0; j < noOfNeighbours; j++){
								System.out.println("Vertex name :");
								destinationVertex = sc.nextInt();
								System.out.println("Weight of the edge :");
								weight = sc.nextInt();
								newEdge = new Edge(i,destinationVertex,weight);
								adjacentVertices.add(newEdge);
							}
							graph.addEdge(i, adjacentVertices);
						}
						break;
				case Constant.TWO:
					System.out.println("The graph is as follows");
					graph.showGraph();
					break;
				case Constant.THREE:
					boolean result=graph.isConnected();
					if( result ){
						System.out.println("The graph is connected.");
					} else {
						System.out.println("The graph is not connected");
					}
					break;
				case Constant.FOUR:
					System.out.println("Enter the vertex for which you want information :");
					int source = sc.nextInt();
					ArrayList<Integer> reachableNodes = graph.isReachable(source);
					System.out.println("Reachable nodes are :");
					for( int i : reachableNodes){
						System.out.print(i+" ");
					}
					break;
				case Constant.FIVE:
					System.out.println("Minimum spanning tree is as follows :");
					Graph mst=graph.mst(1);
					mst.showGraph();
					break;
				case Constant.SIX:
					System.out.println("Enter the sourceVertex :");
					int sourceVertex = sc.nextInt();
					System.out.println("Enter the destinationVertex :");
					int destination = sc.nextInt();
					System.out.println("The shortest distance from "+sourceVertex+" to "+destination+" is :"+ graph.shortestPath(sourceVertex, destination));
					System.out.printf("%n");
					break;
				case Constant.SEVEN:
					isExit = true;
					System.out.println("Exit!!!");
					break;
				default:
					System.out.println("Invalid input");
				}
			}while(!isExit);
		} catch ( InputMismatchException e){
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}
