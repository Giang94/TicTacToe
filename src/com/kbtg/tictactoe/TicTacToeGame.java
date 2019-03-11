package com.kbtg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TicTacToe ticTacToe = new TicTacToe();
		while (!ticTacToe.isGameEnd()) {
			System.out.print(String.format("Player %s choose: ", ticTacToe.getCurrentPlayer() == 0 ? "A" : "B"));
			int choice = scanner.nextInt();
			if (ticTacToe.isValidInput(choice) && !ticTacToe.isPositionOccupied(choice)) {
				ticTacToe.saveStep(choice);
				ticTacToe.checkWinner();
				ticTacToe.switchPlayer();
			} else {
				System.out.println("Please choose again!");
			}
		}

		if (ticTacToe.getWinner() > 0) {
			System.out.println(String.format("Game Over! Player %s Wins!", ticTacToe.getWinner()));
		} else {
			System.out.println("It's a Draw!!!");
		}

		scanner.close();
	}
}
