package application;

import java.util.Random;

import static application.Main.scanner;

public class GameMoves {
    public GameMoves(){

    }

    public static void playerOne(int[][] board, Player player, Player computer) {

        char c = player.symbol;

        System.out.println(player + ", please choose a row and column (1-3):");
        System.out.print("Row: ");
        int row = scanner.nextInt() - 1;
        //make sure the rows are not above or below the size

        System.out.print("Column: ");
        int col = scanner.nextInt() - 1;
        //make sure the columns are not above or below the size
        Board.Bounds(board, col, row, player, computer);

        System.out.println();


        //checks if the spot is empty or not
        Board.isSpotTakenPlayerOne(board, row, col, player, computer);

        board[row][col] = c;


        Board.printBoard(board);
        System.out.println();

        //checks if player 1 won the game or if it is a tie
        if (winCondition(board, c)) {
            System.out.println(player.toString() + " wins!");
            gameOver();

        } else if (isTie(board)) {
            System.out.println("It's a tie!");
            gameOver();
        } else {
            playerTwo(board, player, computer);
        }


    }


    public static void playerTwo(int[][] board, Player player, Player computer) {

        char c = computer.symbol;

        Random rand = new Random();

        System.out.println(computer + " is choosing a position");

        System.out.println();

        int row = rand.nextInt(0, 3);
        int col = rand.nextInt(0, 3);
        //checks if the spot is empty or not
        Board.isComputerSpotFree(board, row, col, player, computer);


        board[row][col] = c;

        Board.printBoard(board);
        System.out.println();

        //checks if player 2 won the game or if it is a tie
        if (winCondition(board, c)) {
            System.out.println("The computer wins!");
            gameOver();
        } else if (isTie(board)) {
            System.out.println("It's a tie!");
            gameOver();
        } else {
            playerOne(board, player, computer);
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

    public static boolean winCondition(int[][] board, char c) {
        if ((board[0][0] == c && board[0][1] == c && board[0][2] == c) ||
                (board[1][0] == c && board[1][1] == c && board[1][2] == c) ||
                (board[2][0] == c && board[2][1] == c && board[2][2] == c) ||

                (board[0][0] == c && board[1][0] == c && board[2][0] == c) ||
                (board[0][1] == c && board[1][1] == c && board[2][1] == c) ||
                (board[0][2] == c && board[1][2] == c && board[2][2] == c) ||

                (board[0][0] == c && board[1][1] == c && board[2][2] == c) ||
                (board[0][2] == c && board[1][1] == c && board[2][0] == c)) {
            return true;
        }
        return false;
    }

}
