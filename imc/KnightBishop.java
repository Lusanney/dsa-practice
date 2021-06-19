import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class KnightBishop {
    // Moves that a knight can go
    private static final int [] knightPathRow = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int [] knightPathCol = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};

    private static class Cell{
        public int row;
        public int column;

        public Cell(int row, int column){
            this.row = row;
            this.column = column;
        }

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

        @Override
        public String toString() {
            return "(" + row + " , " + column + ")";
        }
    }

    private static class Move{
        public Cell cell;
        public int moves;
        public boolean isBishopActive;

        // For tracing the Path
        public LinkedList<Cell> preCells;

        public Move(Cell cell, int moves, boolean isBishopActive, LinkedList<Cell> preCells){
            this.cell = cell;
            this.moves = moves;
            this.isBishopActive = isBishopActive;
            this.preCells = preCells;
        }
    }

    // Check if Bishop could capture the Cell
    private static boolean checkBishop(Cell bishop, Cell visitingCell){
        return Math.abs(bishop.row - visitingCell.row) != Math.abs(bishop.column - visitingCell.column);
    }

    // Check if Cell is outside the table
    private static boolean isOutside(int tableSize, Cell visitingCell){
        return visitingCell.row >= tableSize || visitingCell.column >= tableSize || visitingCell.row < 0 || visitingCell.column < 0;
    }

    // Solutions
    private static Move minimumMoves(int tableSize, Cell knight, Cell bishop, Cell destination){
        // Visited Cells
        Set<Cell> visitedCells = new HashSet<>();

        // Visiting Queue
        LinkedList<Move> queue = new LinkedList<>();

        // Push the initial Move with a knight Cell
        queue.push(new Move(knight, 0, true, new LinkedList<Cell>()));
        visitedCells.add(knight);

        // Loop until there are no cell in the visit queue
        while(!queue.isEmpty()){
            Move visitingMove = queue.poll();

            // Loop through all possible Cell a knight can go
            for(int i=0; i<8; i++){

                // Adjacent Cell
                Cell adjCell = new Cell(
                        visitingMove.cell.row + knightPathRow[i],
                        visitingMove.cell.column + knightPathCol[i]);

                // Check if a bishop is active
                boolean isBishopActive = visitingMove.isBishopActive;

                // Check if current move will capture the Bishop
                if(bishop.equals(adjCell)){
                    isBishopActive = false;
                }

                //If a cell is safe to move
                if(!isOutside(tableSize, adjCell)
                    && !visitedCells.contains(adjCell)
                    && (!isBishopActive || checkBishop(bishop, adjCell))){

                    // Tracing, add a current cell to preCells (tracing Path)
                    LinkedList<Cell> newPreCells = new LinkedList<>(visitingMove.preCells);
                    newPreCells.add(adjCell);

                    // If it is the destination
                    if(destination.equals(adjCell)){
                        return new Move(adjCell, visitingMove.moves + 1, isBishopActive, newPreCells);
                    }

                    // Otherwise, add to the queue
                    visitedCells.add(adjCell);
                    queue.push(new Move(adjCell, visitingMove.moves + 1, isBishopActive, newPreCells));
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Cell knight = new Cell(4, 1);
        Cell bishop = new Cell(4, 4);
        Cell destination = new Cell(0, 6);

        Move result = minimumMoves(8, knight, bishop, destination);

        // Print the result & path
        System.out.println(result.moves);
        for(Cell cell: result.preCells){
            System.out.println(cell);
        }
    }
}
