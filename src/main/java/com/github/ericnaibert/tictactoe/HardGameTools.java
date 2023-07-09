package com.github.ericnaibert.tictactoe;

import javafx.scene.control.Label;

import java.util.*;

public class HardGameTools extends GameTools{

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

            Label hardGameStatusLabel = new Label();
            hardGameStatusLabel.setLayoutX(280);
            hardGameStatusLabel.setLayoutY(50);
            hardGameStatusLabel.setId("gameStatusLabel");
            hardGameStatusLabel.setText("You Lose!");
            ApplicationInterface.hardGameRoot.getChildren().add(hardGameStatusLabel);

            cpuWon = true;
            gameGoesOn = false;
            endGame = true;
        } else if((HardGameTools.playerScore.size() + HardGameTools.cpuScore.size()) > 8) {

            Label hardGameStatusLabel = new Label();
            hardGameStatusLabel.setLayoutX(280);
            hardGameStatusLabel.setLayoutY(50);
            hardGameStatusLabel.setId("gameStatusLabel");
            hardGameStatusLabel.setText("CAT!");
            ApplicationInterface.hardGameRoot.getChildren().add(hardGameStatusLabel);

            gameGoesOn = false;
            HardGameTools.endGame = true;
        }

    }

    public static int cpuRandomNumber() {

        int cpuChosenPosition = (int) (Math.floor(Math.random() * 9) + 1);
        while (HardGameTools.playerScore.contains(cpuChosenPosition) || HardGameTools.cpuScore.contains(cpuChosenPosition)) {
            cpuChosenPosition = (int) (Math.floor(Math.random() * 9) + 1);
        }
        return cpuChosenPosition;
    }

}




