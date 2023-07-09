package com.github.ericnaibert.tictactoe;

import javafx.scene.control.Label;

import java.util.*;

public class EasyGameTools extends GameTools {

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

            cpuWon = true;
            gameGoesOn = false;
            endGame = true;
        } else if((EasyGameTools.playerScore.size() + EasyGameTools.cpuScore.size()) > 8) {

            Label gameStatusLabel = new Label();
            gameStatusLabel.setLayoutX(280);
            gameStatusLabel.setLayoutY(50);
            gameStatusLabel.setId("gameStatusLabel");
            gameStatusLabel.setText("CAT!");
            ApplicationInterface.gameRoot.getChildren().add(gameStatusLabel);

            gameGoesOn = false;
            EasyGameTools.endGame = true;
        }

    }

    public static int cpuRandomNumber() {

        int cpuChosenPosition = (int) (Math.floor(Math.random() * 9) + 1);
        while (EasyGameTools.playerScore.contains(cpuChosenPosition) || EasyGameTools.cpuScore.contains(cpuChosenPosition)) {
            cpuChosenPosition = (int) (Math.floor(Math.random() * 9) + 1);
        }
        return cpuChosenPosition;
    }

}
