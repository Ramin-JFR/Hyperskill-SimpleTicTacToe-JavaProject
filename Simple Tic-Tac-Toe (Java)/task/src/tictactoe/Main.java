package tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = createGrid();

        printGrid(grid);

        char currentPlayer = 'X';
        boolean gameFinished = false;

        while (!gameFinished) {
            System.out.print("Enter the coordinates: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col, grid)) {
                makeMove(row, col, currentPlayer, grid);
                printGrid(grid);

                if (isGameOver(grid)) {
                    gameFinished = true;
                    System.out.println(getGameResult(grid));
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    public static char[][] createGrid() {
        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
        return grid;
    }

    public static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean isValidMove(int row, int col, char[][] grid) {
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        int rowIndex = 3 - row;
        int colIndex = col - 1;

        if (grid[rowIndex][colIndex] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }

    public static void makeMove(int row, int col, char player, char[][] grid) {
        int rowIndex = 3 - row;
        int colIndex = col - 1;
        grid[rowIndex][colIndex] = player;
    }

    public static boolean isGameOver(char[][] grid) {
        return hasPlayerWon('X', grid) || hasPlayerWon('O', grid) || isGridFull(grid);
    }

    public static boolean hasPlayerWon(char player, char[][] grid) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == player && grid[1][j] == player && grid[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isGridFull(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static String getGameResult(char[][] grid) {
        if (hasPlayerWon('X', grid)) {
            return "X wins";
        } else if (hasPlayerWon('O', grid)) {
            return "O wins";
        } else {
            return "Draw";
        }
    }
}
