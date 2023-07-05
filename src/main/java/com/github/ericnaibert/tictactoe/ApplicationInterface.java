package com.github.ericnaibert.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ApplicationInterface extends Application {

    public static TextField input;
    public static Group menuRoot;
    public static Group gameRoot;

    private static Scene menuScene;

    private static Scene gameScene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlMenuLoader = new FXMLLoader(ApplicationInterface.class.getResource("menu.fxml"));
        FXMLLoader fxmlGameLoader = new FXMLLoader(ApplicationInterface.class.getResource("game-view.fxml"));

        String css = (Objects.requireNonNull(ApplicationInterface.class.getResource("application.css")).toExternalForm());

        menuRoot = new Group();
        gameRoot = new Group();

        menuRoot.getChildren().add(fxmlMenuLoader.load());
        gameRoot.getChildren().add(fxmlGameLoader.load());

        menuScene = new Scene(menuRoot, 700, 500);
        gameScene = new Scene(gameRoot, 700, 500);

        input = new TextField("Enter (1-9) to Mark");
        input.setLayoutX(270);
        input.setLayoutY(380);
        gameRoot.getChildren().add(input);

        Button returnMenuButton = new Button();
        returnMenuButton.setLayoutX(20);
        returnMenuButton.setLayoutY(200);
        returnMenuButton.setText("Back to Menu");
        returnMenuButton.setOnAction(event -> {

            stage.setScene(menuScene);

            stage.setResizable(false);
            stage.setTitle("Tic Tac Toe Menu");
            stage.show();
        });
        gameRoot.getChildren().add(returnMenuButton);

        //The 'reset game button' could've been here. But it is on the FXML Controller, so the code looks cleaner.

        Button enterButton = new Button();
        enterButton.setLayoutX(270);
        enterButton.setLayoutY(410);
        enterButton.setPrefWidth(153);
        enterButton.setText("Enter");
        enterButton.setOnAction(GameImplementationEvent.event);
        gameRoot.getChildren().add(enterButton);

        Button easyGameButton = new Button();
        easyGameButton.setLayoutX(273);
        easyGameButton.setLayoutY(250);
        easyGameButton.setPrefWidth(153);
        easyGameButton.setPrefHeight(36);
        easyGameButton.setText("Start Easy");
        easyGameButton.setOnAction(event -> {

            gameScene.getStylesheets().add(css);
            stage.setScene(gameScene);

            stage.setResizable(false);
            stage.setTitle("Tic Tac Toe Game");
            stage.show();
        });

        menuRoot.getChildren().add(easyGameButton);

        menuScene.getStylesheets().add(css);
        stage.setScene(menuScene);

        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe Menu");
        stage.show();
    }

    @SuppressWarnings("unused")
    public static void launch(String[] args) {
        launch();
    }
}