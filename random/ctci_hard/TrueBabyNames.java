import java.util.*;
import static java.util.Map.*;

public class TrueBabyNames
{

    private static class GraphNode
    {
        private String name;
        private int frequency;
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        private boolean visited = false;

        public void addNeighbor(GraphNode neighbor) {neighbors.add(neighbor); }

        public String getName() { return name; }
        public int getFrequency(){ return frequency; }
        public ArrayList<GraphNode> getNeighbors() { return neighbors; }

        public GraphNode(String nm, int freq) { this.name = nm; this.frequency = freq; }

        public boolean isVisited() { return visited; }
        public void setVisited(boolean visited) { this.visited = visited; }
    }

    private static class Graph
    {
        HashMap<String, GraphNode> graphNodes = new HashMap<>();

        public void addGraphNodes(GraphNode node) { graphNodes.put(node.getName(), node); }

        public HashMap<String, GraphNode> getGraphNodes() { return graphNodes; }
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph();

        HashMap<String, Integer> nameFreq = new HashMap<>();
        String[][] synonyms = new String[][] {{"Jonathan", "John"}, {"Jon", "Johnny"},
                                              {"Johnny", "John"}, {"Kari", "Carrie"}, {"Carleton", "Carlton"}};

        nameFreq.put("John", 10);
        nameFreq.put("Jon", 3);
        nameFreq.put("Davis", 2);
        nameFreq.put("Kari", 3);
        nameFreq.put("Johnny", 11);
        nameFreq.put("Carlton", 8);
        nameFreq.put("Carleton", 2);
        nameFreq.put("Jonathan", 9);
        nameFreq.put("Carrie", 5);

        createGraph(graph, nameFreq);
        addEdge(graph, synonyms);
        HashMap<String, Integer> map = getMap(graph);

        System.out.println(map);
    }

    static void createGraph(Graph graph, HashMap<String, Integer> nameFreq)
    {
        for (Entry<String, Integer> entry : nameFreq.entrySet()) {
            graph.addGraphNodes(new GraphNode(entry.getKey(), entry.getValue()));
        }
    }

    static void addEdge(Graph graph, String[][] synonyms)
    {
        HashMap<String, GraphNode> graphNodes = graph.getGraphNodes();
        for (String[] synonym : synonyms) {
            String name1 = synonym[0];
            String name2 = synonym[1];

            GraphNode node1 = graphNodes.get(name1);
            GraphNode node2 = graphNodes.get(name2);

            if (node1 != node2) {
                node1.addNeighbor(node2);
                node2.addNeighbor(node1);
            }
        }
    }

    static HashMap<String, Integer> getMap(Graph graph)
    {
        HashMap<String, Integer> trueFreq = new HashMap<>();
        HashMap<String, GraphNode> graphNodes = graph.getGraphNodes();

        for (GraphNode node : graphNodes.values()) {
            if (!node.isVisited()) {
                int freq = getFrequency(node);
                trueFreq.put(node.getName(), freq);
            }
        }

        return trueFreq;

    }

    static int getFrequency(GraphNode node)
    {
        if (node.isVisited()) return 0;
        node.setVisited(true);
        int frequency = node.getFrequency();

        for (GraphNode neighbor : node.getNeighbors()) {
            frequency += getFrequency(neighbor);
        }

        return frequency;
    }
}
