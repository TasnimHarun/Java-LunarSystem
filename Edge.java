
/**
 * The <code>LunarSystem</code> class is the main driver code
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 * <dt><b>Assignment:</b></dt>
 *      Homework #6 for CSE 214, Recitation 04, Fall 2021
 */

public class Edge implements Comparable {
    Node A;
    Node B;
    int cost;

    public Edge(){
        A = null;
        B = null;
        cost = 0;
    }

    public Node getA() {
        return A;
    }

    public Node getB() {
        return B;
    }

    public int getCost() {
        return cost;
    }

    public void setA(Node a) {
        A = a;
    }

    public void setB(Node b) {
        B = b;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int compareTo(Object otherEdge){
        Edge e = (Edge) otherEdge;
        if(cost==e.getCost()){
            return 0;
        }else if(cost < e.getCost()){
            return -1;
        }else{
            return 1;
        }
    }
    @Override
    public String toString() {
        return A + " to " + B + " " + cost;
    }
}
