package com.github.ericnaibert.tictactoe;

import javafx.scene.control.Label;

import java.util.*;

public class GameTools {

    public static ArrayList<Integer> playerScore = new ArrayList<>();
    public static ArrayList<Integer> cpuScore = new ArrayList<>();

    public static boolean playerWon = false;
    public static boolean cpuWon = false;
    public static boolean endGame = false;

    public static boolean gameGoesOn = true;


    public static void winner() {

        if(playerScore.containsAll(WinnerFactorLists.winFactorTop) || playerScore.containsAll(WinnerFactorLists.winFactorMiddle) ||
                playerScore.containsAll(WinnerFactorLists.winFactorBottom) || playerScore.containsAll(WinnerFactorLists.winFactorLeft) ||
                playerScore.containsAll(WinnerFactorLists.winFactorRight) || playerScore.containsAll(WinnerFactorLists.winFactorCross1) ||
                playerScore.containsAll(WinnerFactorLists.winFactorCross2) || playerScore.containsAll(WinnerFactorLists.winFactorMiddle2)) {

            Label gameStatusLabel = new Label();
            gameStatusLabel.setLayoutX(210);
            gameStatusLabel.setLayoutY(50);
            gameStatusLabel.setId("gameStatusLabel");
            gameStatusLabel.setText("Congratulations, You Won!");
            ApplicationInterface.gameRoot.getChildren().add(gameStatusLabel);

            Label hardGameStatusLabel = new Label();
            hardGameStatusLabel.setLayoutX(210);
            hardGameStatusLabel.setLayoutY(50);
            hardGameStatusLabel.setId("gameStatusLabel");
            hardGameStatusLabel.setText("Congratulations, You Won!");
            ApplicationInterface.hardGameRoot.getChildren().add(hardGameStatusLabel);

            playerWon = true;
            gameGoesOn = false;
            endGame = true;
        } else if(cpuScore.containsAll(WinnerFactorLists.winFactorTop) || cpuScore.containsAll(WinnerFactorLists.winFactorMiddle) ||
                cpuScore.containsAll(WinnerFactorLists.winFactorBottom) || cpuScore.containsAll(WinnerFactorLists.winFactorLeft) ||
                cpuScore.containsAll(WinnerFactorLists.winFactorRight) || cpuScore.containsAll(WinnerFactorLists.winFactorCross1) ||
                cpuScore.containsAll(WinnerFactorLists.winFactorCross2) || cpuScore.containsAll(WinnerFactorLists.winFactorMiddle2)) {

            Label gameStatusLabel = new Label();
            gameStatusLabel.setLayoutX(280);
            gameStatusLabel.setLayoutY(50);
            gameStatusLabel.setId("gameStatusLabel");
            gameStatusLabel.setText("You Lose!");
            ApplicationInterface.gameRoot.getChildren().add(gameStatusLabel);

            Label hardGameStatusLabel = new Label();
            hardGameStatusLabel.setLayoutX(280);
            hardGameStatusLabel.setLayoutY(50);
            hardGameStatusLabel.setId("gameStatusLabel");
            hardGameStatusLabel.setText("You Lose!");
            ApplicationInterface.hardGameRoot.getChildren().add(hardGameStatusLabel);

            cpuWon = true;
            gameGoesOn = false;
            endGame = true;
        } else if((GameTools.playerScore.size() + GameTools.cpuScore.size()) > 8) {
            Label gameStatusLabel = new Label();
            gameStatusLabel.setLayoutX(280);
            gameStatusLabel.setLayoutY(50);
            gameStatusLabel.setId("gameStatusLabel");
            gameStatusLabel.setText("CAT!");

            Label hardGameStatusLabel = new Label();
            hardGameStatusLabel.setLayoutX(280);
            hardGameStatusLabel.setLayoutY(50);
            hardGameStatusLabel.setId("gameStatusLabel");
            hardGameStatusLabel.setText("CAT!");

            ApplicationInterface.gameRoot.getChildren().add(gameStatusLabel);
            ApplicationInterface.hardGameRoot.getChildren().add(hardGameStatusLabel);
            gameGoesOn = false;
            GameTools.endGame = true;
        }

    }

    public static void playerCheck(char[][] board, int pos) {
        switch (pos) {
            case 1 -> board[0][0] = 'X';
            case 2 -> board[0][1] = 'X';
            case 3 -> board[0][2] = 'X';
            case 4 -> board[1][0] = 'X';
            case 5 -> board[1][1] = 'X';
            case 6 -> board[1][2] = 'X';
            case 7 -> board[2][0] = 'X';
            case 8 -> board[2][1] = 'X';
            case 9 -> board[2][2] = 'X';
            default -> System.out.println("Enter a valid spot!");
        }
    }

    public static void cpuCheck(char[][] board, int cpuPos) {

        switch (cpuPos) {
            case 1 -> board[0][0] = 'O';
            case 2 -> board[0][1] = 'O';
            case 3 -> board[0][2] = 'O';
            case 4 -> board[1][0] = 'O';
            case 5 -> board[1][1] = 'O';
            case 6 -> board[1][2] = 'O';
            case 7 -> board[2][0] = 'O';
            case 8 -> board[2][1] = 'O';
            case 9 -> board[2][2] = 'O';
            default -> System.out.println("Enter a valid spot!");
        }
    }

    public static int cpuRandomNumber() {

        int cpuChosenPosition = (int) (Math.floor(Math.random() * 9) + 1);
        while (GameTools.playerScore.contains(cpuChosenPosition) || GameTools.cpuScore.contains(cpuChosenPosition)) {
            cpuChosenPosition = (int) (Math.floor(Math.random() * 9) + 1);
        }
        return cpuChosenPosition;
    }

    @SuppressWarnings("unused")
    // It may be useful for debugging with the console:
    public static void playableBoard(char[][] board) {

        for (char[] strings : board) {
            for (int column = 0; column < board.length; column++) {
                System.out.print(strings[column]);
            }
            System.out.print("\n");
        }
    }


}
