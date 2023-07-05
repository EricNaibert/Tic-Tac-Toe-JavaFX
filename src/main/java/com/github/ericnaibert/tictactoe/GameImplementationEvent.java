package com.github.ericnaibert.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameImplementationEvent {

    public static String returnPlayerInput;

    public static int chosenPosition;

    //I'll take a look at those nested if's someday...
    public static EventHandler<ActionEvent> event = (Event) -> {
        boolean notValidOperation = false;
        int y = 152;
        int x = 245;

        ApplicationInterface.input.requestFocus();

        if(!GameTools.endGame) {
            try {
                returnPlayerInput = ApplicationInterface.input.getText();
                chosenPosition = Integer.parseInt(returnPlayerInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }

            if (GameTools.playerScore.contains(chosenPosition) || GameTools.cpuScore.contains(chosenPosition) || chosenPosition > 9) {
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

                GameTools.playerScore.add(chosenPosition);
                GameTools.playerCheck(GameBoard.board, chosenPosition);

                GameTools.winner();
                if(GameTools.gameGoesOn) {

                    int cpuChosenPosition = (int) (Math.floor(Math.random() * 9) + 1);
                    while (GameTools.playerScore.contains(cpuChosenPosition) || GameTools.cpuScore.contains(cpuChosenPosition)) {
                        cpuChosenPosition = (int) (Math.floor(Math.random() * 9) + 1);
                    }
                    GameTools.cpuScore.add(cpuChosenPosition);
                    GameTools.cpuCheck(GameBoard.board, cpuChosenPosition);

                    GameTools.winner();
                }
            }
            ApplicationInterface.input.clear();
            GameTools.winner();

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
