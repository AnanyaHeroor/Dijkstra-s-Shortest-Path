// --== CS400 File Header Information ==--
// Name: Ananya Heroor
// Email: heroor@wisc.edu
// Team: LE
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: N/A
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<Integer> graph;
    @BeforeEach
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert verticies 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        // insert edges from Week 08. Dijkstra's Activity
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,7,2);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(3,7,2);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,0,2);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1);
        graph.insertEdge(7,0,3);
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled 0 to 8
     * (should be 15), and from the vertex labelled 9 to 8 (should be 17).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost(0,8) == 15);    
        assertTrue(graph.getPathCost(9,8) == 17);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled 0 to 8, and from the vertex labelled 9 to 8.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath(0, 8).toString().equals(
            "[0, 2, 6, 3, 1, 8]"
        ));
        assertTrue(graph.shortestPath(9, 8).toString().equals(
            "[9, 4, 5, 1, 8]"
        ));
    }
    /**
     * Checks the distance that I reported in #3 of last week's activity is correct
     * Should return 14 and the vertex at which this longest length is at 
     * Started at vertex 1, ended at vertex 5
     */
    @Test
    public void testToCheckActivityLength() {
      //create graph (auto from first method in this test class)
      assertTrue(graph.getPathCost(1, 5) == 14); //I know that the longest path starting from 1 to 5 should have a weight of 14
    }
    
    /**
     * Checks the sequence that I said was the longest path in last week's activity
     * Should return 1, 7, 0, 2, 4, 5 --> this is the shortest path of the longest path
     * Started at vertex 1, ended at vertex 5
     */
    @Test
    public void testToCheckActivitySequence() {
      //create graph (auto from first method in this test class)
      assertTrue(graph.shortestPath(1, 5).toString().equals(
          "[1, 7, 0, 2, 4, 5]"
      )); //confirm the shortest path from 1 to 5
      //FOR THE FOLLOWING TESTS: I divided my longest path into a few paths so I could gauge the correctness
      //of my longest path sequence
      //My longest path sequence was 1, 7, 6, 3, 8, 0, 2, 9, 4, 5
      //The following tests divide up that path sequence to check that my hand calculation was correct along
      //with my algorithm
      assertTrue(graph.shortestPath(1, 3).toString().equals(
          "[1, 7, 6, 3]"
      )); //Checks the beginning of the longest path 
      assertTrue(graph.shortestPath(7, 8).toString().equals(
          "[7, 6, 3, 1, 8]"
      )); //Checks the middle of the longest path to ensure that we go back through one to get to the other side
      assertTrue(graph.shortestPath(0, 9).toString().equals(
          "[0, 2, 4, 5, 9]"
      )); //Checks the later end of the middle of the longest path (ensure that 0 and 2 are in that order)
      assertTrue(graph.shortestPath(9, 1).toString().equals(
          "[9, 4, 5, 1]"
      )); //Checks the end of the longest path to ensure that we can get back to one
    } //Together the above 4 tests confirm that my longest path sequence was determined correctly
    
    /**
     * Checks removeVertex and getVertexCount when all vertices are removed
     * 
     */
    @Test
    public void testToCheckEmptyPath() {
      //remove all vertices 0-9 from the graph
      for(int i=0;i<10;i++)
        graph.removeVertex(i);
    
      //confirm that all vertices have been removed
      if (graph.getVertexCount() == 0) {
        System.out.println("This program successfully removed all vertices");
      } else {
        fail();
      }
    }
    /**
     * Checks isEmpty 
     */
    @Test
    public void testShortestEmptyPath() {
      for(int i=0;i<10;i++)
        graph.removeVertex(i);
      if (graph.isEmpty()) {
        System.out.println("The program successfully cleared the graph");
      } else {
        fail();
      }
    }

}