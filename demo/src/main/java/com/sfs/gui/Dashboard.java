package com.sfs.gui;

import com.sfs.entity.Account;
import com.sfs.entity.BankAccount;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dashboard {
    public static void dashboard(Stage stage,Image background,ImageView backgroundView,Account bankAccount) {
        StackPane pane = new StackPane();
        pane.getChildren().add(backgroundView);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        pane.getChildren().add(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        Text Transaction = new Text("Select the Transaction");
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

        Button withdraw = new Button("Cash Withdrawal");
        styleNumberButton(withdraw);
        gridPane.add(withdraw, 0, 1);

        withdraw.setOnAction(e -> {
            WithdrawDashboard.withdrawDashboard(stage,background,backgroundView,bankAccount);
        });

        Button deposit = new Button("Cash Deposit");
        styleNumberButton(deposit);
        gridPane.add(deposit, 0, 2);

        deposit.setOnAction(e -> {
            CashDeposit.cashDeposit(stage,background,backgroundView,bankAccount);
        });

        Button transfer = new Button("Account Statement");
        styleNumberButton(transfer);
        gridPane.add(transfer, 0, 3);

        transfer.setOnAction(e -> {
            AccountStatement.accountStatement(stage,background,backgroundView,bankAccount);
        });

        GridPane.setHalignment(withdraw, HPos.CENTER);
        GridPane.setHalignment(deposit, HPos.CENTER);
        GridPane.setHalignment(transfer, HPos.CENTER);
        GridPane.setHalignment(Transaction, HPos.CENTER);
        GridPane.setValignment(withdraw, VPos.CENTER);
        GridPane.setValignment(deposit, VPos.CENTER);
        GridPane.setValignment(transfer, VPos.CENTER);
        GridPane.setValignment(Transaction, VPos.CENTER);

        Button logout = new Button("Logout");
        styleNumberButton(logout);
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

    public static void styleNumberButton(Button button) {
        button.setStyle(
            "-fx-font-size: 25px;" +
            "-fx-font-weight: 600;" +
            "-fx-background-color: linear-gradient(to bottom, #ffffff, #dcdde1);" +
            "-fx-text-fill: #2f3640;" +
            "-fx-border-color: #ced6e0;" +
            "-fx-border-width: 1px;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 12px 24px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 3, 0.2, 0, 1);" +
            "-fx-cursor: hand;" +
            "-fx-transition: all 0.3s ease;"
        );

        button.setOnMouseEntered(e -> button.setStyle(
            "-fx-font-size: 25px;" +
            "-fx-font-weight: 600;" +
            "-fx-background-color: linear-gradient(to bottom, #f5f6fa, #383d53ff);" +
            "-fx-text-fill: #2f3640;" +
            "-fx-border-color: #a4b0be;" +
            "-fx-border-width: 1px;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 12px 24px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 4, 0.2, 0, 2);" +
            "-fx-cursor: hand;"
        ));

        button.setOnMouseExited(e -> button.setStyle(
            "-fx-font-size: 25px;" +
            "-fx-font-weight: 600;" +
            "-fx-background-color: linear-gradient(to bottom, #ffffff, #dcdde1);" +
            "-fx-text-fill: #2f3640;" +
            "-fx-border-color: #ced6e0;" +
            "-fx-border-width: 1px;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 12px 24px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 3, 0.2, 0, 1);" +
            "-fx-cursor: hand;"
        ));
    }

}
