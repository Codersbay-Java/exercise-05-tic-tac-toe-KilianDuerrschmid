package application;

import java.util.Scanner;

import static application.Board.board;
import static application.GameMoves.playerOne;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Board.setBoard();

        System.out.println("Welcome to Tic Tac Toe!");

        System.out.print("Player, please enter your name: ");
        String name = scanner.nextLine();

        Player player = new Player(name, 'X');
        Player computer = new Player("Computer", 'O');

        Board.printBoard(board);

        System.out.println();

        playerOne(board, player, computer);

    }

}


