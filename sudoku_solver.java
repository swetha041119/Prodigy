import java.util.Scanner;

public class SudokuSolver {

    // Method to print the Sudoku grid
    public static void printGrid(int[][] grid) {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(grid[r][d] + " ");
            }
            System.out.println();
        }
    }

    // Method to check if placing a number is valid according to Sudoku rules
    public static boolean isValid(int[][] grid, int row, int col, int num) {
        // Check if the number is already in the row
        for (int x = 0; x < 9; x++) {
            if (grid[row][x] == num) {
                return false;
            }
        }

        // Check if the number is already in the column
        for (int x = 0; x < 9; x++) {
            if (grid[x][col] == num) {
                return false;
            }
        }

        // Check if the number is in the 3x3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Method to find an empty location in the grid
    public static int[] findEmptyLocation(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    return new int[] {row, col}; // Return the row and column of the empty cell
                }
            }
        }
        return null; // Return null if no empty cell is found
    }

    // Method to solve the Sudoku puzzle using backtracking
    public static boolean solveSudoku(int[][] grid) {
        int[] emptyLocation = findEmptyLocation(grid);
        if (emptyLocation == null) {
            return true; // Puzzle is solved if there are no empty cells
        }

        int row = emptyLocation[0];
        int col = emptyLocation[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(grid, row, col, num)) {
                grid[row][col] = num; // Tentatively place the number

                if (solveSudoku(grid)) {
                    return true; // If the puzzle is solved, return true
                }

                grid[row][col] = 0; // Backtrack and remove the number
            }
        }

        return false; // Trigger backtracking
    }

    // Method to read a Sudoku grid from user input
    public static void readGrid(int[][] grid) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Sudoku grid (9 rows of 9 numbers, use 0 for empty cells):");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int[][] sudokuGrid = new int[9][9];

        // Read the grid from user input
        readGrid(sudokuGrid);

        if (solveSudoku(sudokuGrid)) {
            System.out.println("Sudoku puzzle solved:");
            printGrid(sudokuGrid);
        } else {
            System.out.println("No solution exists.");
        }
    }
}

