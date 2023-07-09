package com.github.ericnaibert.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ApplicationInterface extends Application {

    public static TextField inputEasyMode;
    public static TextField inputHardMode;
    public static Group menuRoot;
    public static Group gameRoot;
    public static Group hardGameRoot;
    private static Scene menuScene;
    private static Scene gameScene;
    private static Scene hardGameScene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlMenuLoader = new FXMLLoader(ApplicationInterface.class.getResource("menu.fxml"));
        FXMLLoader fxmlGameLoader = new FXMLLoader(ApplicationInterface.class.getResource("game-view.fxml"));
        FXMLLoader fxmlHardGameLoader = new FXMLLoader(ApplicationInterface.class.getResource("hardGame-view.fxml"));

        String css = (Objects.requireNonNull(ApplicationInterface.class.getResource("application.css")).toExternalForm());

        menuRoot = new Group();
        gameRoot = new Group();
        hardGameRoot = new Group();

        menuRoot.getChildren().add(fxmlMenuLoader.load());
        gameRoot.getChildren().add(fxmlGameLoader.load());
        hardGameRoot.getChildren().add(fxmlHardGameLoader.load());

        menuScene = new Scene(menuRoot, 700, 500);
        gameScene = new Scene(gameRoot, 700, 500);
        hardGameScene = new Scene(hardGameRoot, 700, 500);

        inputEasyMode = new TextField("Enter (1-9) to Mark");
        inputEasyMode.setLayoutX(270);
        inputEasyMode.setLayoutY(380);
        gameRoot.getChildren().add(inputEasyMode);

        inputHardMode = new TextField("Enter (1-9) to Mark");
        inputHardMode.setLayoutX(270);
        inputHardMode.setLayoutY(380);
        hardGameRoot.getChildren().add(inputHardMode);

        Button returnMenuButton = new Button();
        returnMenuButton.setLayoutX(20);
        returnMenuButton.setLayoutY(200);
        returnMenuButton.setText("Back to Menu");
        returnMenuButton.setOnAction(event -> {

            stage.setScene(menuScene);

            stage.setResizable(false);
            stage.setTitle("Tic Tac Toe FX - Menu");
            stage.show();
        });

        Button returnMenuFromHard = new Button();
        returnMenuFromHard.setLayoutX(20);
        returnMenuFromHard.setLayoutY(200);
        returnMenuFromHard.setText("Back to Menu");
        returnMenuFromHard.setOnAction(event -> {

            stage.setScene(menuScene);

            stage.setResizable(false);
            stage.setTitle("Tic Tac Toe FX - Menu");
            stage.show();
        });
        gameRoot.getChildren().add(returnMenuButton);
        hardGameRoot.getChildren().add(returnMenuFromHard);

        //The 'reset game button' could've been here. But it is on the FXML Controller, so the code looks cleaner.

        Button easyGameStartButton = new Button();
        easyGameStartButton.setLayoutX(273);
        easyGameStartButton.setLayoutY(250);
        easyGameStartButton.setPrefWidth(153);
        easyGameStartButton.setPrefHeight(36);
        easyGameStartButton.setText("Start Easy");
        easyGameStartButton.setOnAction(event -> {

            gameScene.getStylesheets().add(css);
            stage.setScene(gameScene);

            stage.setResizable(false);
            stage.setTitle("Tic Tac Toe FX - Easy");
            stage.show();
        });

        Button hardGameStartButton = new Button();
        hardGameStartButton.setLayoutX(273);
        hardGameStartButton.setLayoutY(324);
        hardGameStartButton.setPrefWidth(153);
        hardGameStartButton.setPrefHeight(36);
        hardGameStartButton.setText("Start Hard");
        hardGameStartButton.setOnAction(event -> {

            hardGameScene.getStylesheets().add(css);
            stage.setScene(hardGameScene);

            stage.setResizable(false);
            stage.setTitle("Tic Tac Toe FX - Hard");
            stage.show();
        });

        Button enterEasyButton = new Button();
        enterEasyButton.setLayoutX(270);
        enterEasyButton.setLayoutY(410);
        enterEasyButton.setPrefWidth(153);
        enterEasyButton.setText("Enter");
        enterEasyButton.setOnAction(EasyGameImplementationEvent.event);
        gameRoot.getChildren().add(enterEasyButton);

        Button enterHardButton = new Button();
        enterHardButton.setLayoutX(270);
        enterHardButton.setLayoutY(410);
        enterHardButton.setPrefWidth(153);
        enterHardButton.setText("Enter");
        enterHardButton.setOnAction(HardGameImplementationEvent.event);
        hardGameRoot.getChildren().add(enterHardButton);


        menuRoot.getChildren().add(easyGameStartButton);
        menuRoot.getChildren().add(hardGameStartButton);
        menuScene.getStylesheets().add(css);

        String applicationIconPath = "/com/github/ericnaibert/tictactoe/images/TicTacToeLogo.png";

        stage.setScene(menuScene);
        stage.getIcons().add(new Image(Objects.requireNonNull(ApplicationInterface.class.getResourceAsStream(applicationIconPath))));
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe FX - Menu");
        stage.show();
    }

    @SuppressWarnings("unused")
    public static void launch(String[] args) {
        launch();
    }
}