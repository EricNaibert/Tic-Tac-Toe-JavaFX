package com.github.ericnaibert.tictactoe;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HardGameImplementationEvent extends GameTools {
    public static String returnPlayerInput;
    public static int chosenPosition;
    static ArrayList<Integer> playerInputs = new ArrayList<>();
    public static EventHandler<ActionEvent> event = (Event) -> {
        boolean notValidOperation = false;
        int y = 152;
        int x = 245;
        ApplicationInterface.inputHardMode.requestFocus();
        if (!HardGameTools.endGame) {
            try {
                returnPlayerInput = ApplicationInterface.inputHardMode.getText();
                chosenPosition = Integer.parseInt(returnPlayerInput);
            } catch (NumberFormatException var10) {
                System.out.println("Invalid number format");
            }

            if (HardGameTools.playerScore.contains(chosenPosition) || HardGameTools.cpuScore.contains(chosenPosition) || chosenPosition > 9) {
                Label gameStatusLabel = new Label();
                gameStatusLabel.setLayoutX(180.0);
                gameStatusLabel.setLayoutY(50.0);
                gameStatusLabel.setId("gameStatusLabel");
                gameStatusLabel.setText("You chose an invalid position! \n Enter a valid one: ");
                ApplicationInterface.hardGameRoot.getChildren().add(gameStatusLabel);
                notValidOperation = true;
            }

            int pos;
            int randomNumber;

            if (!notValidOperation) {
                Rectangle whiteBox = new Rectangle();
                whiteBox.setLayoutX(180.0);
                whiteBox.setLayoutY(50.0);
                whiteBox.setHeight(50.0);
                whiteBox.setWidth(400.0);
                whiteBox.setFill(Color.WHITE);
                ApplicationInterface.hardGameRoot.getChildren().add(whiteBox);
                HardGameTools.playerScore.add(chosenPosition);
                HardGameTools.playerCheck(GameBoard.board, chosenPosition);
                HardGameTools.winner();

                if (HardGameTools.gameGoesOn) {
                    pos = chosenPosition;
                    playerInputs.add(pos);
                    if (playerInputs.size() == 2) {
                        if ((WinnerFactorLists.cpuSeesPlayerList() == 0 || HardGameTools.playerScore.
                                contains(WinnerFactorLists.cpuSeesPlayerList())) || HardGameTools.cpuScore.
                                contains(WinnerFactorLists.cpuSeesPlayerList())) {
                            randomNumber = HardGameTools.cpuRandomNumber();
                            HardGameTools.cpuScore.add(randomNumber);
                            HardGameTools.cpuCheck(GameBoard.board, randomNumber);
                        } else {
                            HardGameTools.cpuScore.add(WinnerFactorLists.cpuSeesPlayerList());
                            HardGameTools.cpuCheck(GameBoard.board, WinnerFactorLists.cpuSeesPlayerList());
                            HardGameTools.cpuCheck(GameBoard.board, WinnerFactorLists.cpuSeesPlayerList());
                        }
                    } else if (playerInputs.size() == 3) {
                        if ((WinnerFactorLists.returnSecondMissingNumber() == 0 || HardGameTools.playerScore.
                                contains(WinnerFactorLists.cpuSeesPlayerList())) || HardGameTools.cpuScore.
                                contains(WinnerFactorLists.cpuSeesPlayerList())) {
                            randomNumber = HardGameTools.cpuRandomNumber();
                            HardGameTools.cpuScore.add(randomNumber);
                            HardGameTools.cpuCheck(GameBoard.board, randomNumber);
                        } else {
                            HardGameTools.cpuScore.add(WinnerFactorLists.returnSecondMissingNumber());
                            HardGameTools.cpuCheck(GameBoard.board, WinnerFactorLists.returnSecondMissingNumber());
                        }
                    } else {
                        randomNumber = HardGameTools.cpuRandomNumber();
                        HardGameTools.cpuScore.add(randomNumber);
                        HardGameTools.cpuCheck(GameBoard.board, randomNumber);
                    }

                    HardGameTools.winner();
                }
            }

            ApplicationInterface.inputHardMode.clear();
            HardGameTools.winner();

            char[][] var12 = GameBoard.board;
            pos = var12.length;

            for(randomNumber = 0; randomNumber < pos; ++randomNumber) {
                char[] strings = var12[randomNumber];

                for(int column = 0; column < GameBoard.board.length; ++column) {
                    Label label = new Label(" " + strings[column] + " ");
                    label.setLayoutY(y);
                    label.setLayoutX(x);
                    ApplicationInterface.hardGameRoot.getChildren().add(label);
                    x += 65;
                }

                x = 245;
                y += 75;
            }
        }

    };

}



