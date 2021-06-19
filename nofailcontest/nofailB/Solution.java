package nofailcontest.nofailB;

import java.util.*;

public class Solution {
    private static int MAX_COL;
    private static int MAX_ROW;
    private static int [][] graph;
    private static boolean[][] isVisited;
    private static int ISLAND = 1;

    private static int[] dRow = new int[]{-1, 0, 0, 1};
    private static int[] dCol = new int[]{0, -1, 1, 0};
    private static int ADJ_NUM = 4;

    private static boolean isInsideGraph(int row, int col){
        return (row >= 0) && (row < MAX_ROW) && (col >= 0) && (col <MAX_COL);
    }

    private static int BFS(int row, int col){
        int islandSize = 1;
        LinkedList<Integer> queueRow = new LinkedList<>();
        LinkedList<Integer> queueCol = new LinkedList<>();

        queueRow.push(row);
        queueCol.push(col);
        isVisited[row][col] = true;

        while(!queueRow.isEmpty() && !queueCol.isEmpty()){
            int currentRow = queueRow.poll();
            int currentCol = queueCol.poll();

            for(int adjIdx = 0; adjIdx< ADJ_NUM; adjIdx++){
                int nextRow = currentRow + dRow[adjIdx];
                int nextCol = currentCol + dCol[adjIdx];

                // Check if this cell is valid
                if(isInsideGraph(nextRow, nextCol)
                && !isVisited[nextRow][nextCol]
                && graph[nextRow][nextCol] == ISLAND){
                    islandSize++;
                    queueRow.push(nextRow);
                    queueCol.push(nextCol);
                    isVisited[nextRow][nextCol] = true;
                }
            }
        }

        return islandSize;
    }

    private static void solve(){
        isVisited = new boolean[MAX_ROW][MAX_COL];
        for(int row = 0; row <MAX_ROW; row++)
            Arrays.fill(isVisited[row], false);

        int maxSize = 0;
        for(int row=0; row < MAX_ROW; row++)
            for(int col=0; col < MAX_COL; col++){
                if(graph[row][col] == ISLAND && !isVisited[row][col]){
                    int size = BFS(row, col);

                    if(maxSize < size)
                        maxSize = size;
                }
            }

        System.out.println(maxSize);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sizeString = scanner.nextLine();
        String[] size = sizeString.split(" ");
        MAX_ROW = Integer.parseInt(size[0]);
        MAX_COL = Integer.parseInt(size[1]);

        graph = new int[MAX_ROW][MAX_COL];

        int currentInputRow = 0;
        while(currentInputRow < MAX_ROW){
            String line = scanner.nextLine();
            String[] cells = line.split("");
            for(int col=0; col < MAX_COL; col++)
                graph[currentInputRow][col] = Integer.parseInt(cells[col]);

            currentInputRow++;
        }

        solve();
    }
}
