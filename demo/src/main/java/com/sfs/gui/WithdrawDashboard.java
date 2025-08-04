package com.sfs.gui;

import com.sfs.Services.AccountService;
import com.sfs.entity.Account;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WithdrawDashboard {
    public static void withdrawDashboard(Stage stage,Image background,ImageView backgroundView,Account bankAccount) {
        StackPane pane = new StackPane();
        pane.getChildren().add(backgroundView);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        pane.getChildren().add(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        Text Transaction = new Text("Select the Amount");
        Transaction.setStyle(
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
        gridPane.add(Transaction, 0,0);
        gridPane.setColumnSpan(Transaction, 2);

        Label message = new Label();
        message.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-text-fill: #e60404ff;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 20px 40px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" +
            "-fx-font-smoothing-type: lcd;"
        );
        gridPane.add(message, 0, 4);
        gridPane.setColumnSpan(message, 3);
        GridPane.setHalignment(message, HPos.CENTER);
        GridPane.setValignment(message, VPos.CENTER);

        Button cash1 = new Button("100");
        Dashboard.styleNumberButton(cash1);
        gridPane.add(cash1, 0, 1);
        cashAction(cash1,bankAccount,message,stage,background,backgroundView);
        
        Button cash2 = new Button("300");
        Dashboard.styleNumberButton(cash2);
        gridPane.add(cash2, 2, 1);
        cashAction(cash2,bankAccount,message,stage,background,backgroundView);

        Button cash3 = new Button("1000");
        Dashboard.styleNumberButton(cash3);
        gridPane.add(cash3, 0, 2);
        cashAction(cash3,bankAccount,message,stage,background,backgroundView);

        Button cash4 = new Button("3000");
        Dashboard.styleNumberButton(cash4);
        gridPane.add(cash4, 2, 2);
        cashAction(cash4,bankAccount,message,stage,background,backgroundView);

        Button cash5 = new Button("5000");
        Dashboard.styleNumberButton(cash5);
        gridPane.add(cash5, 0, 3);
        cashAction(cash5,bankAccount,message,stage,background,backgroundView);

        Button cash6 = new Button("Another amount");
        Dashboard.styleNumberButton(cash6);
        gridPane.add(cash6, 2, 3);
        cash6.setOnAction(e -> {
            WithdrawAmount.withdrawAmount(stage,background,backgroundView,bankAccount);
        });

        Button logout = new Button("Logout");
        Dashboard.styleNumberButton(logout);
        logout.setOnAction(e -> {
            stage.close();
            LoginScene.loginScene1(stage, background, backgroundView);
        });
        pane.getChildren().add(logout);
        pane.setAlignment(logout, Pos.BOTTOM_LEFT);

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
        stage.setHeight(650);
        stage.getIcons().add(background);
        stage.show();
    }

    public static void cashAction(Button bt, Account bankAccount, Label message, Stage stage,Image background,ImageView backgroundView) {
        bt.setOnAction(e -> {
            int amount = Integer.parseInt(bt.getText());
            try {
                bankAccount.withdrawBalance(amount);
                message.setText("");
                AccountService sc = new AccountService();
                sc.update(bankAccount);
                sc.close();
                MoreOrClose.moreOrClose(stage,background,backgroundView,bankAccount);

            } catch (IllegalArgumentException ex) {
                message.setText(ex.getMessage());
            }
        });
    }
}
