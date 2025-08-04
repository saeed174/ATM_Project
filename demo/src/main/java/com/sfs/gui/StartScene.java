package com.sfs.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StartScene {
    public static void startScene(Stage stage,Scene scene)
    {
        StackPane pane = new StackPane();
        Image background = new Image("File:D:\\Summer2025\\ATM_Project\\background.png");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(800);
        backgroundView.setPreserveRatio(true);
        backgroundView.setOpacity(0.2);

        Label welcomeLabel = new Label("Welcome in SFS Bank ATM");
        welcomeLabel.setStyle(
            "-fx-font-size: 50px;" +
            "-fx-text-fill: black;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: lightgray;" +
            "-fx-border-color: black;" +
            "-fx-border-width: 2px;" +
            "-fx-padding: 20px;"
        );
        welcomeLabel.setOpacity(0.5);

        Button loginButton = new Button("Continue");
        loginButton.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-text-fill: black;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: lightgray;" +
            "-fx-border-color: black;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 20px;"+
            "-fx-padding: 20px;"
        );

        loginButton.setOnAction(e -> {
            LoginScene.loginScene1(stage,background,backgroundView);
        });

        StackPane.setAlignment(welcomeLabel, Pos.TOP_CENTER);
        pane.getChildren().add(backgroundView);
        pane.getChildren().add(welcomeLabel);
        pane.getChildren().add(loginButton);
        scene = new Scene(pane);
        stage.setScene(scene);
        backgroundView.setPreserveRatio(false);
        backgroundView.setFitWidth(scene.getWidth());
        backgroundView.setFitHeight(scene.getHeight());

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            backgroundView.setFitWidth(newVal.doubleValue());
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            backgroundView.setFitHeight(newVal.doubleValue());
        });
        backgroundView.setSmooth(true);
        backgroundView.setCache(true);
        stage.setWidth(800);
        stage.setHeight(580);
        stage.getIcons().add(background);
        stage.show();
    }
}
