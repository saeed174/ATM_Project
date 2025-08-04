package com.sfs.gui;

import com.sfs.entity.Account;

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

public class AccountStatement {
    public static void accountStatement(Stage stage,Image background,ImageView backgroundView,Account bankAccount) {
        StackPane pane = new StackPane();
        pane.getChildren().add(backgroundView);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        pane.getChildren().add(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        Text welcome = new Text("Welcome "+bankAccount.getAccountHolderName()+"!");
        welcome.setStyle(
            "-fx-font-size: 50px;" +
            "-fx-text-fill: #2c3e50;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: #ecf0f1;" +
            "-fx-border-color: #bdc3c7;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 20px 40px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" +
            "-fx-font-smoothing-type: lcd;"
        );
        pane.getChildren().add(welcome);
        pane.setAlignment(welcome, Pos.TOP_LEFT);

        Text accountStatement = new Text("Account Statement");
        accountStatement.setStyle(
            "-fx-font-size: 50px;" +
            "-fx-text-fill: #2c3e50;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: #ecf0f1;" +
            "-fx-border-color: #bdc3c7;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 20px 40px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" +
            "-fx-font-smoothing-type: lcd;"
        );
        gridPane.add(accountStatement, 0, 0);
        GridPane.setColumnSpan(accountStatement, 2);
        GridPane.setHalignment(accountStatement, HPos.CENTER);

        Label balanceIs = new Label("Your balance is:");
        balanceIs.setStyle(
            "-fx-font-size: 35px;" +
            "-fx-text-fill: #2c3e50;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 20px 40px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" +
            "-fx-font-smoothing-type: lcd;"
        );

        Label balance = new Label(Double.toString(bankAccount.getBalance()));
        balance.setStyle(
            "-fx-font-size: 35px;" +
            "-fx-text-fill: #2c3e50;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: linear-gradient(to bottom, #ffffff, #ecf0f1);" +
            "-fx-border-color: #dcdde1;" +
            "-fx-border-width: 1px;" +
            "-fx-border-radius: 12px;" +
            "-fx-background-radius: 12px;" +
            "-fx-padding: 20px 40px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 4, 0.2, 0, 2);" +
            "-fx-font-smoothing-type: lcd;"
        );
        gridPane.add(balanceIs, 0, 1);
        gridPane.add(balance, 1, 1);


        Button logout = new Button("Logout");
        CardPassword.styleNumberButton(logout);
        logout.setOnAction(e -> {
            stage.close();
            LoginScene.loginScene1(stage, background, backgroundView);
        });
        pane.getChildren().add(logout);
        pane.setAlignment(logout, Pos.BOTTOM_LEFT);

        Button Continue = new Button("Continue");
        CardPassword.styleNumberButton(Continue);
        Continue.setOnAction(e -> {
            MoreOrClose.moreOrClose(stage,background,backgroundView,bankAccount);
        });
        pane.getChildren().add(Continue);
        pane.setAlignment(Continue, Pos.BOTTOM_RIGHT);

        Scene scene = new Scene(pane);
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
        stage.setHeight(630);
        stage.getIcons().add(background);
        stage.show();
    }
}
