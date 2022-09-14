/**
 * The <code>LunarSystem</code> class is the main driver code
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 * <dt><b>Assignment:</b></dt>
 *      Homework #6 for CSE 214, Recitation 04, Fall 2021
 */

import big.data.DataSource;

import java.util.*;

public class RoadCalculator {
    private static HashMap<String, Node> graph;
    private static LinkedList<Edge> mst = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter graph URL: ");
        String URL = in.nextLine();
        buildGraph(URL);
        buildMST(graph);
    }

    public static HashMap<String, Node> buildGraph(String location){
        HashMap<String, Node> cities = new HashMap<String, Node>();
        DataSource ds = DataSource.connectXML(location);
        System.out.println("Loading Map...");
        ds.load();
        String cityNamesStr = ds.fetchString("cities");
        String[] cityNames = cityNamesStr.substring(1, cityNamesStr.length() - 1).replace("\"", "").split(",");
        String roadNamesStr = ds.fetchString("roads");
        String[] roadNames = roadNamesStr.substring(2, roadNamesStr.length() - 2).split("\",\"");
        System.out.println("Cities:");
        for (int i = 0; i < cityNames.length; i++) {
            Node node = new Node();
            node.setName(cityNames[i]);
            System.out.println(node.getName());
            cities.put(cityNames[i], node); //hopefully loads the hashmap with city nodes and its name
        }
        graph = cities;
        System.out.println('\n');
        //System.out.println(roadNames[0]);
        System.out.println("Roads: ");
        HashSet<Edge> e = new HashSet<>();
        for (int i = 0; i < roadNames.length; i++) {
            String A;
            String B;
            String num;
            int n;
            Edge edge = new Edge();
            String[] roads = roadNames[i].split(",", -1);
                A = roads[0];
                B = roads[1];
                if(cities.containsKey(A) && cities.containsKey(B)){
                    edge.setA(cities.get(A));
                    edge.setB(cities.get(B));
                    num = roads[2];
                    n = Integer.parseInt(num);
                    edge.setCost(n);
                    System.out.println(edge);
                    graph.get(A).getEdges().add(edge);
                    graph.get(B).getEdges().add(edge);
                }
        }
        System.out.println();
        return graph;
    }
    public static LinkedList<Edge> buildMST(HashMap<String, Node> graph){
        System.out.println("Building mst...");
        int size = graph.size();
        Iterator it = graph.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry element = (Map.Entry) it.next();
            Node E = (Node) element.getValue();
            //System.out.println(E);
            Iterator ei = E.getEdges().iterator();
            Edge v = (Edge) ei.next();
            while(ei.hasNext()) {
                int C[] = new int[size];
                for (int i = 0; i < size; i++) {
                    C[i] = Integer.MAX_VALUE;
                    E.setVisited(false);
                    E.setVisited(false);
                }
                C[0] = 0;
                //System.out.println(E.getEdges());
                Object min = ei.next();
                    while(ei.hasNext()) {
                        for(int k = 0; k<E.getEdges().size(); k++) {
                            if (v.compareTo(min) < 0) {
                                min = v;
                                if(!E.getVisited()) {
                                    mst.add(v);
                                    System.out.println(v);
                                    E.setVisited(true);
                                }
                            }
                        }
                        v = (Edge) ei.next();
                    }
            }
        }
        return mst;
    }
    public static int Djikstra(HashMap<String,Node> graph, String source, String dest){
        //returns cheapest cost
        int cost = 0;
        return cost;
    }
}
