package com.sfs.gui;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScene {
    public static void loginScene1(Stage stage , Image background, ImageView backgroundView)
    {
        StackPane pane = new StackPane();
        pane.getChildren().add(backgroundView);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        pane.getChildren().add(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        Text Login = new Text("Login AS");
        Login.setStyle(
            "-fx-font-size: 50px;" +
            "-fx-text-fill: #2c3e50;" +                  // Dark grayish blue
            "-fx-font-weight: bold;" +
            "-fx-background-color: #ecf0f1;" +           // Light gray (modern)
            "-fx-border-color: #bdc3c7;" +               // Light gray border
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 20px 40px;" +                  // Vertical + horizontal padding
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" + // Optional shadow
            "-fx-font-smoothing-type: lcd;"
        );



        gridPane.add(Login, 0, 0);
        GridPane.setColumnSpan(Login, 3);
        GridPane.setHalignment(Login,HPos.CENTER);

        Label cardLogin = new Label("Bank Login");
        cardLogin.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-text-fill: #2c3e50;" +                  // Dark grayish blue
            "-fx-font-weight: bold;" +
            "-fx-background-color: #ecf0f1;" +           // Light gray (modern)
            "-fx-border-color: #2f546cff;" +               // Light gray border
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 20px 40px;" +                  // Vertical + horizontal padding
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" + // Optional shadow
            "-fx-font-smoothing-type: lcd;"
        );
        gridPane.add(cardLogin, 0, 1);

        cardLogin.setOnMouseClicked(event -> {
            CardLoginScene.cardLoginScene(stage,background,backgroundView);
        });

        Label walletLogin = new Label("Wallet Login");
        walletLogin.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-text-fill: #2c3e50;" +                  // Dark grayish blue
            "-fx-font-weight: bold;" +
            "-fx-background-color: #ecf0f1;" +           // Light gray (modern)
            "-fx-border-color: #2f546cff;" +               // Light gray border
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 20px 40px;" +                  // Vertical + horizontal padding
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" + // Optional shadow
            "-fx-font-smoothing-type: lcd;"
        );
        gridPane.add(walletLogin, 2, 1);

        walletLogin.setOnMouseClicked(event -> {
            WalletLoginScene.walletLoginScene(stage,background,backgroundView);
        });

        Button backButton = new Button("←");
        backButton.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: #ecf0f1;" +
            "-fx-text-fill: #2c3e50;" +
            "-fx-border-color: #2f546cff;" +
            "-fx-border-radius: 5px;" +
            "-fx-background-radius: 5px;" +
            "-fx-padding: 8px 16px;" +
            "-fx-cursor: hand;"
        );

        pane.getChildren().add(backButton);
        pane.setAlignment(backButton, Pos.TOP_LEFT);

        Scene scene = new Scene(pane);
        backButton.setOnAction(event -> {
            StartScene.startScene(stage,scene);
        });

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
        stage.setHeight(600);
        stage.getIcons().add(background);
        stage.show();
    }
}
