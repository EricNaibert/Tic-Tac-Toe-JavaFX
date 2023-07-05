package com.github.ericnaibert.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    public Button resetGame;

    public void resetGameButton() {

        int clearCanvasY = 152;
        int clearCanvasX = 270;

        GameTools.playerScore.clear();
        GameTools.cpuScore.clear();
        GameTools.playerWon = false;
        GameTools.cpuWon = false;
        GameTools.endGame = false;
        GameTools.gameGoesOn = true;

        for (char[] strings : GameBoard.board) {
            for (int column = 0; column < GameBoard.board.length; column++) {
                Rectangle clearCanvas = new Rectangle();
                clearCanvas.setWidth(30);
                clearCanvas.setHeight(40);
                clearCanvas.setLayoutX(clearCanvasX);
                clearCanvas.setLayoutY(clearCanvasY);
                clearCanvas.setFill(Color.WHITE);
                ApplicationInterface.gameRoot.getChildren().add(clearCanvas);
                clearCanvasX = clearCanvasX + 65;
            }
            clearCanvasX = 270;
            clearCanvasY = clearCanvasY + 75;
        }

        GameBoard.gameBoard();

    }

}