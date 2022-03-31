package application;

import java.util.Scanner;

public class Main {
    public static final int BOARD_SIZE = 3;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        System.out.println("Welcome to Tic Tac Toe!");

        printBoard(board);

        System.out.println();

        playerOne(board);

    }

    public static void playerOne(int[][] board) {

        System.out.println("Player 1, please choose a row and column (1-3):");
        System.out.print("Row: ");
        int row = scanner.nextInt() - 1;

        rowBounds(board, row);

        System.out.print("Column: ");
        int col = scanner.nextInt() - 1;

        colBounds(board, col);

        System.out.println();

        if (board[row][col] == 'X' || board[row][col] == 'O') {
            System.out.println("Not a valid move, try again.");
            playerOne(board);
            System.out.println();
        }

        board[row][col] = 'X';


        printBoard(board);
        System.out.println();


        if (isPlayerOneWinner(board)) {
            System.out.println("Player 1 wins!");
            gameOver();

        } else if (isTie(board)) {
            System.out.println("It's a tie!");
            gameOver();
        } else {
            playerTwo(board);
        }


    }



    public static void playerTwo(int[][] board) {

        System.out.println("Player 2, please choose a row and column (1-3):");
        System.out.print("Row: ");
        int row = scanner.nextInt() - 1;

        rowBounds(board, row);

        System.out.print("Column: ");
        int col = scanner.nextInt() - 1;

        colBounds(board, col);

        System.out.println();

        if (board[row][col] == 'X' || board[row][col] == 'O') {
            System.out.println("Not a valid move, try again.");
            playerTwo(board);
        }

        board[row][col] = 'O';

        printBoard(board);
        System.out.println();

        if (isPlayerTwoWinner(board)) {
            System.out.println("Player 2 wins!");
            gameOver();
        } else if (isTie(board)) {
            System.out.println("It's a tie!");
            gameOver();
        } else {
            playerOne(board);
        }


    }

    static void printBoard(int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print("|" + (char) board[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static void colBounds(int[][] board, int col) {
        if(col > 2 || col < 0){
            System.out.println("Not a valid move, try again.");
            playerOne(board);
            System.out.println();
        }
    }

    private static void rowBounds(int[][] board, int row) {
        if(row > 2 || row < 0){
            System.out.println("Not a valid move, try again.");
            playerOne(board);
            System.out.println();
        }
    }


    public static boolean isTie(int[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sum += board[i][j];
            }
        }
        if (sum == 756) {
            return true;
        }
        return false;
    }

    public static void gameOver() {

        System.out.println("The game is over!!");
        System.exit(0);


    }

    public static boolean isPlayerOneWinner(int[][] board) {
        if      ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||

                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||

                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {
            return true;
        }
        return false;
    }

    public static boolean isPlayerTwoWinner(int[][] board) {
        if      ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||

                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
                (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||

                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
                (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
            return true;
        }
        return false;
    }
}


