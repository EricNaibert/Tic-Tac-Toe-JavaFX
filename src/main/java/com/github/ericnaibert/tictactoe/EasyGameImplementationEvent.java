package com.github.ericnaibert.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GameImplementationEvent {

    public static String returnPlayerInput;

    public static int chosenPosition;

    static ArrayList<Integer> playerInputs = new ArrayList<>();

    //I'll take a look at those nested if's someday...
    public static EventHandler<ActionEvent> event = (Event) -> {
        boolean notValidOperation = false;
        int y = 152;
        int x = 245;

        ApplicationInterface.inputEasyMode.requestFocus();
        System.out.println("Easy Mode");

        if(!EasyGameTools.endGame) {
            try {
                returnPlayerInput = ApplicationInterface.inputEasyMode.getText();
                chosenPosition = Integer.parseInt(returnPlayerInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }

            if (EasyGameTools.playerScore.contains(chosenPosition) || EasyGameTools.cpuScore.contains(chosenPosition) || chosenPosition > 9) {
                Label gameStatusLabel = new Label();
                gameStatusLabel.setLayoutX(180);
                gameStatusLabel.setLayoutY(50);
                gameStatusLabel.setId("gameStatusLabel");
                gameStatusLabel.setText("You chose an invalid position! \n Enter a valid one: ");
                ApplicationInterface.gameRoot.getChildren().add(gameStatusLabel);
                notValidOperation = true;
            }

            if (!notValidOperation) {

                Rectangle whiteBox = new Rectangle();
                whiteBox.setLayoutX(180);
                whiteBox.setLayoutY(50);
                whiteBox.setHeight(50);
                whiteBox.setWidth(400);
                whiteBox.setFill(Color.WHITE);
                ApplicationInterface.gameRoot.getChildren().add(whiteBox);

                EasyGameTools.playerScore.add(chosenPosition);
                EasyGameTools.playerCheck(GameBoard.board, chosenPosition);

                EasyGameTools.winner();
                if(EasyGameTools.gameGoesOn) {

                    int randomNumber = EasyGameTools.cpuRandomNumber();
                    EasyGameTools.cpuScore.add(randomNumber);
                    EasyGameTools.cpuCheck(GameBoard.board, randomNumber);

                    EasyGameTools.winner();

                }
            }
            ApplicationInterface.inputEasyMode.clear();
            EasyGameTools.winner();

            for (char[] strings : GameBoard.board) {
                for (int column = 0; column < GameBoard.board.length; column++) {
                    Label label = new Label(" " + strings[column] + " ");
                    label.setLayoutY(y);
                    label.setLayoutX(x);
                    ApplicationInterface.gameRoot.getChildren().add(label);
                    x = x + 65;
                }
                x = 245;
                y = y + 75;
            }

        }

    };
}
