package practice.graph;

import java.util.*;

public class Graph {
    private Map<Vertex, LinkedList<Vertex>> adjVertices;

    private Set<Vertex> vertices;

    public Graph(){
        adjVertices = new HashMap<>();
        vertices = new HashSet<>();
    }

    public Map<Vertex, LinkedList<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public void addEdge(Vertex x, Vertex y){
        // Init if not already done
        adjVertices.computeIfAbsent(x, k -> new LinkedList<>());
        adjVertices.computeIfAbsent(y, k -> new LinkedList<>());

        // Add the edge
        adjVertices.get(x).add(y);
        adjVertices.get(y).add(x);

        // Add the vertices if not exists Set
        vertices.add(x);
        vertices.add(y);
    }
}
