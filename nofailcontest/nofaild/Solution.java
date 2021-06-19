package nofailcontest.nofaild;

import java.util.*;

public class Solution {
    private static int MAX_EDGES;
    private static int MAX_VERTICES;
    private static HashMap<Integer, LinkedList<Edge>> adjMap;

    private static class Edge{
        public int label;
        public long weight;

        public Edge(int label, long weight){
            this.label = label;
            this.weight = weight;
        }
    }

    private static void solve(){
        HashSet<Integer> visitedList = new HashSet<>();
        long [] distanceFromQuang = new long[MAX_VERTICES];
        Arrays.fill(distanceFromQuang, Long.MAX_VALUE);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((x, y) -> Long.compare(distanceFromQuang[x], distanceFromQuang[y]));

        // Start from 0
        minHeap.add(0);
        visitedList.add(0);
        distanceFromQuang[0] = 0;

        while(!minHeap.isEmpty()){
            int currentVertex = minHeap.poll();

            // Visiting adjEdges
            Iterator<Edge> edgeIterator = adjMap.get(currentVertex).iterator();
            while(edgeIterator.hasNext()){
                Edge edge = edgeIterator.next();

                distanceFromQuang[edge.label] = Math.min(distanceFromQuang[edge.label],
                        Math.max(distanceFromQuang[currentVertex], edge.weight));

                if(!visitedList.contains(edge.label)){
                    // Add to the queue
                    minHeap.add(edge.label);
                    visitedList.add(edge.label);
                }
            }
        }

        System.out.println(distanceFromQuang[MAX_VERTICES - 1]);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] meta = scanner.nextLine().split(" ");
        MAX_EDGES = Integer.parseInt(meta[1]);
        MAX_VERTICES = Integer.parseInt(meta[0]);

        adjMap = new HashMap<>();
        for(int row=0; row < MAX_EDGES; row ++){
            String input = scanner.nextLine();
            String[] edgeInput = input.split(" ");
            int source = Integer.parseInt(edgeInput[0]);
            int destination = Integer.parseInt(edgeInput[1]);
            long weight = Long.parseLong(edgeInput[2]);

            if(adjMap.get(source) == null)
                adjMap.put(source, new LinkedList<>(Collections.singletonList(new Edge(destination, weight))));
            else
                adjMap.get(source).push(new Edge(destination, weight));

            if(adjMap.get(destination) == null)
                adjMap.put(destination, new LinkedList<>(Collections.singletonList(new Edge(source, weight))));
            else
                adjMap.get(destination).push(new Edge(source, weight));
        }

        solve();
    }
}
