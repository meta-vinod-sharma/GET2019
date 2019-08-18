package Question1_2;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

/**
 * It is a test case for the shortestPath() of Graph
 * @author Vinod
 *
 */
public class TestShortestPath {

	//first test case
	@Test
	public void testShortestPath() {
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
	
		assertEquals(6,graph.shortestPath(1,4));
	}
	
	//second test case
	@Test(expected=AssertionError.class)
	public void testShortestPathNegativeCase() {
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
	
		assertEquals(6,graph.shortestPath(1,7));
	}
}
