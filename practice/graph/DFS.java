package practice.graph;


import java.util.*;

public class DFS {

    private static void DFSIterative(Graph graph, Vertex start){
        Set<Vertex> visitedSet = new HashSet<>();
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(start);

        while(!stack.isEmpty()){
            Vertex topVertex = stack.pop();

            if(!visitedSet.contains(topVertex)){
                System.out.print(topVertex + " ");
                visitedSet.add(topVertex);
            }

            Iterator<Vertex> vertexIterator = graph.getAdjVertices().get(topVertex).iterator();
            while(vertexIterator.hasNext()){
                Vertex adjVertex = vertexIterator.next();
                if(!visitedSet.contains(adjVertex)){
                    stack.push(adjVertex);
                }
            }
        }
    }

    private static void DFSRecursion(Graph graph, Vertex visitingVertex, Set<Vertex> visitedSet){
        visitedSet.add(visitingVertex);
        System.out.print(visitingVertex + " ");

        for(Vertex adjVertex: graph.getAdjVertices().get(visitingVertex))
            if(!visitedSet.contains(adjVertex))
                DFSRecursion(graph, adjVertex, visitedSet);
    }

    private static void DFSRecursion(Graph graph, Vertex start){
        DFSRecursion(graph, start, new HashSet<>());
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

        DFSRecursion(graph, new Vertex("A"));
        DFSIterative(graph, new Vertex("A"));
    }
}
