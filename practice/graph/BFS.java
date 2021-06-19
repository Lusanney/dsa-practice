package practice.graph;

import java.util.*;


public class BFS {
    public static void BFS(Graph graph, Vertex start){
        if(!graph.getVertices().contains(start))
            throw new IllegalArgumentException("Vertex not exist");

        Set<Vertex> visited = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.push(start);
        visited.add(start);
        System.out.print(start + " ");

        while(!queue.isEmpty()){
            Vertex visiting = queue.poll();

            Iterator<Vertex> vertexIterator = graph.getAdjVertices().get(visiting).iterator();
            while(vertexIterator.hasNext()){
                Vertex adjVertex = vertexIterator.next();
                if(!visited.contains(adjVertex)){
                    queue.push(adjVertex);
                    visited.add(adjVertex);
                    System.out.print(adjVertex + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Init a graph
        Graph graph = new Graph();
        graph.addEdge(new Vertex("A"), new Vertex("B"));
        graph.addEdge(new Vertex("A"), new Vertex("C"));
        graph.addEdge(new Vertex("A"), new Vertex("D"));
        graph.addEdge(new Vertex("A"), new Vertex("E"));
        graph.addEdge(new Vertex("A"), new Vertex("F"));
        graph.addEdge(new Vertex("D"), new Vertex("F"));
        graph.addEdge(new Vertex("D"), new Vertex("N"));
        graph.addEdge(new Vertex("D"), new Vertex("X"));
        graph.addEdge(new Vertex("D"), new Vertex("K"));
        graph.addEdge(new Vertex("K"), new Vertex("X"));
        graph.addEdge(new Vertex("K"), new Vertex("T"));
        graph.addEdge(new Vertex("K"), new Vertex("Z"));
        graph.addEdge(new Vertex("K"), new Vertex("H"));
        graph.addEdge(new Vertex("K"), new Vertex("M"));
        graph.addEdge(new Vertex("X"), new Vertex("O"));
        graph.addEdge(new Vertex("H"), new Vertex("Z"));
        graph.addEdge(new Vertex("H"), new Vertex("O"));
        graph.addEdge(new Vertex("M"), new Vertex("O"));

        BFS(graph, new Vertex("A"));
    }
}

