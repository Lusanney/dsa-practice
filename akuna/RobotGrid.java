import java.util.*;

class Result {
    private static final char BLOCKED_GRID = '#';

    private static final int [] dRow = new int[]{1, 0, -1, 0};
    private static final int [] dCol = new int[]{0, 1, 0, -1};
    private static final int adjGridSize = 4;

    private static class Cell{
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    column == cell.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        public int row;
        public int column;
        public char grid;
        public int remainingTime;

        public Cell(int row, int column, char grid, int remainingTime){
            this.row = row;
            this.column = column;
            this.grid = grid;
            this.remainingTime = remainingTime;
        }
    }

    private static boolean isInsideTable(int currentRow, int currentCol, int maxRow, int maxCol){
        return (currentRow >= 0) && (currentRow < maxRow) && (currentCol >= 0) && (currentCol < maxCol);
    }


    public static String reachTheEnd(List<String> grid, int maxTime) {
        LinkedList<Cell> queue = new LinkedList<>();
        Set<Cell> visitedCells = new HashSet<>();

        Cell start = new Cell(0,0, '.', maxTime);

        queue.push(start);
        visitedCells.add(start);

        int maxRow = grid.size();
        int maxCol = grid.get(0).length();

        if(maxRow == 0 || maxCol == 0)
            return "Yes";

        if(maxRow == maxCol & maxRow == 1)
            return "Yes";

        while (!queue.isEmpty()){
            Cell currentCell = queue.poll();

            for(int adjCellIdx = 0; adjCellIdx < adjGridSize; adjCellIdx++){
                int newRow = currentCell.row + dRow[adjCellIdx];
                int newCol = currentCell.column + dCol[adjCellIdx];

                if(!isInsideTable(newRow, newCol, maxRow, maxCol)){
                    continue;
                }

                Cell adjCell = new Cell(
                        newRow,
                        newCol,
                        grid.get(newRow).charAt(newCol),
                        currentCell.remainingTime - 1
                        );

                // If it is the destination
                if(adjCell.row == maxRow -1
                    && adjCell.column == maxCol - 1
                    && adjCell.remainingTime >= 0)
                    return "Yes";

                // If it is not the destination
                if(adjCell.grid != BLOCKED_GRID
                && !visitedCells.contains(adjCell)
                && adjCell.remainingTime > 0){
                    visitedCells.add(adjCell);
                    queue.push(adjCell);
                }
            }
        }

        return "No";
    }

}