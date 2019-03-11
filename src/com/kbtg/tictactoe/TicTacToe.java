package com.kbtg.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {

	private ArrayList<Integer> playerASteps = new ArrayList<>(); // currentPlayer = 0
	private ArrayList<Integer> playerBSteps = new ArrayList<>(); // currentPlayer = 1
	public int currentPlayer;
	public int winner = -1;

	private List<ArrayList<Integer>> possibleResults = new ArrayList<>();

	public TicTacToe() {

		currentPlayer = 0;
		// Generate possible results
		// Horizontal
		possibleResults.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		possibleResults.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
		possibleResults.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

		// Vertical
		possibleResults.add(new ArrayList<Integer>(Arrays.asList(1, 4, 7)));
		possibleResults.add(new ArrayList<Integer>(Arrays.asList(2, 5, 8)));
		possibleResults.add(new ArrayList<Integer>(Arrays.asList(3, 6, 9)));

		// Diagonal
		possibleResults.add(new ArrayList<Integer>(Arrays.asList(1, 5, 9)));
		possibleResults.add(new ArrayList<Integer>(Arrays.asList(3, 5, 7)));
	}

	public boolean isValidInput(int pos) {
		// Input should be integer value between 1 - 9
		return (pos >= 1 && pos <= 9);
	}

	public boolean isPositionOccupied(int pos) {
		for (int stepPos : playerASteps) {
			// Step is chosen before by player A
			if (stepPos == pos)
				return true;
		}

		for (int stepPos : playerBSteps) {
			// Step is chosen before by player B
			if (stepPos == pos)
				return true;
		}

		// Not chosen
		return false;
	}

	public boolean isGameEnd() {
		checkWinner();
		if (playerASteps.size() + playerBSteps.size() == 9 || winner != -1) {
			return true;
		}
		return false;
	}

	public void checkWinner() {
		ArrayList<Integer> stepsToCheck = new ArrayList<>();
		if (currentPlayer == 0) {
			stepsToCheck.addAll(playerASteps);
		} else {
			stepsToCheck.addAll(playerBSteps);
		}

		for (ArrayList<Integer> result : possibleResults) {
			if (stepsToCheck.containsAll(result)) {
				winner = currentPlayer;
			}
		}
	}

	public void saveStep(int choice) {
		if (currentPlayer == 0) {
			playerASteps.add(choice);
		} else {
			playerBSteps.add(choice);
		}
	}

	public ArrayList<Integer> getPlayerASteps() {
		return playerASteps;
	}

	public void setPlayerASteps(ArrayList<Integer> playerASteps) {
		this.playerASteps = playerASteps;
	}

	public ArrayList<Integer> getPlayerBSteps() {
		return playerBSteps;
	}

	public void setPlayerBSteps(ArrayList<Integer> playerBSteps) {
		this.playerBSteps = playerBSteps;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public void switchPlayer() {
		currentPlayer = currentPlayer == 0 ? 1 : 0;
	}
}
