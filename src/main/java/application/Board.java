package application;

import static application.GameMoves.playerOne;
import static application.GameMoves.playerTwo;

public class Board {
    public static final int BOARD_SIZE = 3;
    public static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public Board() {
    }

    public static void setBoard() {
        //make array empty
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void printBoard(int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print("|" + (char) board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static void Bounds(int[][] board, int col, int row, Player player, Player computer) {
        if (col > 2 || col < 0) {
            System.out.println("Not a valid move, try again.");
            playerOne(board, player, computer);
            System.out.println();
        }
        if (row > 2 || row < 0) {
            System.out.println("Not a valid move, try again.");
            playerOne(board, player, computer);
            System.out.println();
        }
    }

    static void isSpotTakenPlayerOne(int[][] board, int row, int col, Player player, Player computer) {
        if (board[row][col] == 'X' || board[row][col] == 'O') {
            System.out.println("Not a valid move, try again.");
            playerOne(board, player, computer);
            System.out.println();
        }
    }

    static void isComputerSpotFree(int[][] board, int row, int col, Player player, Player computer) {
        if (board[row][col] == 'X' || board[row][col] == 'O') {
            playerTwo(board, player, computer);
            System.out.println();
        }
    }
}
