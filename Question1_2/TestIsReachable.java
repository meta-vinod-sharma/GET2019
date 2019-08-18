package Question1_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

/**
 * It is a test case for isReachable() of Graph
 * @author Vinod
 *
 */
public class TestIsReachable {

	@Test
	public void testIsReachable() {
		Graph graph = new Graph(5);
		LinkedList<Edge> adjacentVertices;
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(1,2,2));
			add(new Edge(1,3,5));
		}};
		graph.addEdge(1, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(2,1,2));
			add(new Edge(2,4,4));
			add(new Edge(2,3,2));
			}
		};
		graph.addEdge( 2, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(3,1,5));
			add(new Edge(3,4,5));
			add(new Edge(3,2,2));
			add(new Edge(3,5,5));}
		};
		graph.addEdge(3, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(4,5,2));
			add(new Edge(4,3,5));
			add(new Edge(4,2,4));
			}
		};
		graph.addEdge(4, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(5,3,5));
			add(new Edge(5,4,2));}
		};
		graph.addEdge(5, adjacentVertices );
		ArrayList<Integer> actualListOfReachableNodes=graph.isReachable(1);
		ArrayList<Integer> expectedListOfReachableNodes=new ArrayList<Integer>();
		expectedListOfReachableNodes.add(1);
		expectedListOfReachableNodes.add(2);
		expectedListOfReachableNodes.add(3);
		expectedListOfReachableNodes.add(4);
		expectedListOfReachableNodes.add(5);
		for(int i=0;i<expectedListOfReachableNodes.size();i++)
		{
			assertEquals(expectedListOfReachableNodes.get(i),actualListOfReachableNodes.get(i));
		}
		
		
		
	}
	@Test(expected=AssertionError.class)
	public void testIsReachableNegativeCase() {
		Graph graph = new Graph(5);
		LinkedList<Edge> adjacentVertices;
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(1,2,2));
			add(new Edge(1,3,5));
		}};
		graph.addEdge(1, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(2,1,2));
			add(new Edge(2,4,4));
			add(new Edge(2,3,2));
			}
		};
		graph.addEdge( 2, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(3,1,5));
			add(new Edge(3,4,5));
			add(new Edge(3,2,2));
			add(new Edge(3,5,5));}
		};
		graph.addEdge(3, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(4,5,2));
			add(new Edge(4,3,5));
			add(new Edge(4,2,4));
			}
		};
		graph.addEdge(4, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(5,3,5));
			add(new Edge(5,4,2));}
		};
		graph.addEdge(5, adjacentVertices );
		graph.isReachable(7);
	}

}
