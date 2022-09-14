/**
 * The <code>Node</code> class that creates a node object
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 * <dt><b>Assignment:</b></dt>
 *      Homework #7 for CSE 214, Recitation 04, Fall 2021
 */

import java.util.HashSet;
import java.util.LinkedList;

public class Node {
    String name;
    HashSet<Edge> edges;
    boolean visited;
    LinkedList<String> path;
    int distance;

    /**
     * Empty constructor which creates an object of class Node.
     * <dt><b>Postcondition:</b><dd>
     *     This <CODE>Node</CODE> has been initialized as a node.
     */
    public Node(){
        name = null;
        edges = new HashSet<Edge>();
        visited = false;
        path = null;
        distance = 0;
    }

    /**
     * Gives the name of the node
     * @return
     *      The string value of the name
     */
    public String getName() {
        return name;
    }

    /**
     * The lsit of all edges adjacent to the node
     * @return
     *      The HashSet of Edges.
     */
    public HashSet<Edge> getEdges() {
        return edges;
    }

    /**
     * Checks whether the node was visited
     * @return
     *      Boolean value of if the node was visited
     */
    public boolean getVisited() {
        return visited;
    }

    /**
     * The path of the node
     * @return
     *      The list of strings that give the path of the node.
     */
    public LinkedList<String> getPath(){
        return path;
    }

    /**
     * The value of the distance
     * @return
     *  Thee integer value of the distance of the node
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets the name of the node
     * @param name
     *      Changes the string name of the node to the given string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes the list of the edges adjacent to the node
     * @param edges
     *      Linked List of edges
     */
    public void setEdges(HashSet<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Changes the boolean visited of the node
     * @param visited
     *      Boolean value of visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * 
     * @param path
     */
    public void setPath(LinkedList<String> path) {
        this.path = path;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name + ' ';
    }
}
