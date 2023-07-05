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
        List<Integer> winFactorTop = Arrays.asList(1, 2, 3);
        List<Integer> winFactorMiddle = Arrays.asList(4, 5, 6);
        List<Integer> winFactorMiddle2 = Arrays.asList(2, 5, 8);
        List<Integer> winFactorBottom = Arrays.asList(7, 8, 9);
        List<Integer> winFactorLeft = Arrays.asList(1, 4, 7);
        List<Integer> winFactorRight = Arrays.asList(3, 6, 9);
        List<Integer> winFactorCross1 = Arrays.asList(1, 5, 9);
        List<Integer> winFactorCross2 = Arrays.asList(3, 5, 7);

        if(playerScore.containsAll(winFactorTop) || playerScore.containsAll(winFactorMiddle) ||
                playerScore.containsAll(winFactorBottom) || playerScore.containsAll(winFactorLeft) ||
                playerScore.containsAll(winFactorRight) || playerScore.containsAll(winFactorCross1) ||
                playerScore.containsAll(winFactorCross2) || playerScore.containsAll(winFactorMiddle2)) {

            Label gameStatusLabel = new Label();
            gameStatusLabel.setLayoutX(210);
            gameStatusLabel.setLayoutY(50);
            gameStatusLabel.setId("gameStatusLabel");
            gameStatusLabel.setText("Congratulations, You Won!");
            ApplicationInterface.gameRoot.getChildren().add(gameStatusLabel);

            playerWon = true;
            gameGoesOn = false;
            endGame = true;
        } else if(cpuScore.containsAll(winFactorTop) || cpuScore.containsAll(winFactorMiddle) ||
                cpuScore.containsAll(winFactorBottom) || cpuScore.containsAll(winFactorLeft) ||
                cpuScore.containsAll(winFactorRight) || cpuScore.containsAll(winFactorCross1) ||
                cpuScore.containsAll(winFactorCross2) || cpuScore.containsAll(winFactorMiddle2)) {

            Label gameStatusLabel = new Label();
            gameStatusLabel.setLayoutX(280);
            gameStatusLabel.setLayoutY(50);
            gameStatusLabel.setId("gameStatusLabel");
            gameStatusLabel.setText("You Lose!");
            ApplicationInterface.gameRoot.getChildren().add(gameStatusLabel);

            cpuWon = true;
            gameGoesOn = false;
            endGame = true;
        } else if((GameTools.playerScore.size() + GameTools.cpuScore.size()) > 8) {
            Label gameStatusLabel = new Label();
            gameStatusLabel.setLayoutX(280);
            gameStatusLabel.setLayoutY(50);
            gameStatusLabel.setId("gameStatusLabel");
            gameStatusLabel.setText("CAT!");
            ApplicationInterface.gameRoot.getChildren().add(gameStatusLabel);
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
