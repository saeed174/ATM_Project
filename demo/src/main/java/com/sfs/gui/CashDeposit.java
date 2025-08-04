package com.sfs.gui;

import com.sfs.Services.AccountService;
import com.sfs.entity.Account;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CashDeposit {
    public static void cashDeposit(Stage stage,Image background,ImageView backgroundView,Account bankAccount)
    {
        StackPane pane = new StackPane();
        pane.getChildren().add(backgroundView);
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        pane.getChildren().add(gridPane);
        gridPane.setAlignment(Pos.CENTER);
        
        Text Amount = new Text("Enter Amount");
        Amount.setStyle(
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
        
        gridPane.add(Amount, 0, 0);
        GridPane.setColumnSpan(Amount, 5);
        GridPane.setHalignment(Amount,HPos.CENTER);

        Label cashAmount = new Label("Amount");
        cashAmount.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-text-fill: #2c3e50;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 20px 40px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" +
            "-fx-font-smoothing-type: lcd;"
        );
        gridPane.add(cashAmount, 0, 1);
        GridPane.setColumnSpan(cashAmount, 2);

        Label message = new Label();
        message.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-text-fill: #e60404ff;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 20px 40px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.1, 0, 2);" +
            "-fx-font-smoothing-type: lcd;"
        );
        gridPane.add(message, 0, 3);

        TextField amountField = new TextField();
        amountField.setPromptText("Enter your amount");

        gridPane.add(amountField, 2, 1);
        GridPane.setColumnSpan(amountField, 3);

        Button one = new Button("1");
        styleNumberButton(one);
        gridPane.add(one, 2, 2);
        actionNumberButton(one,amountField,message);

        Button two = new Button("2");
        styleNumberButton(two);
        gridPane.add(two, 3, 2);
        actionNumberButton(two,amountField,message);

        Button three = new Button("3");
        styleNumberButton(three);
        gridPane.add(three, 4, 2);
        actionNumberButton(three,amountField,message);

        Button four = new Button("4");
        styleNumberButton(four);
        gridPane.add(four, 2, 3);
        actionNumberButton(four,amountField,message);
        
        Button five = new Button("5");
        styleNumberButton(five);
        gridPane.add(five, 3, 3);
        actionNumberButton(five,amountField,message);
        
        Button six = new Button("6");
        styleNumberButton(six);
        gridPane.add(six, 4, 3);
        actionNumberButton(six,amountField,message);
        
        Button seven = new Button("7");
        styleNumberButton(seven);
        gridPane.add(seven, 2, 4);
        actionNumberButton(seven,amountField,message);
        
        Button eight = new Button("8");
        styleNumberButton(eight);
        gridPane.add(eight, 3, 4);
        actionNumberButton(eight,amountField,message);
        
        Button nine = new Button("9");
        styleNumberButton(nine);
        gridPane.add(nine, 4, 4);
        actionNumberButton(nine,amountField,message);
        
        Button zero = new Button("0");
        styleNumberButton(zero);
        gridPane.add(zero, 3, 5);
        actionNumberButton(zero,amountField,message);
        
        Button delete = new Button("Delete");
        styleNumberButton(delete);
        pane.getChildren().add(delete);
        pane.setAlignment(delete, Pos.BOTTOM_CENTER);

        delete.setOnAction(event -> {
            String text = amountField.getText();
            if (text.length() > 0) {
                amountField.setText(text.substring(0, text.length() - 1));
            }
        });

        Button Logout = new Button("Logout");
        styleNumberButton(Logout);
        pane.getChildren().add(Logout);
        pane.setAlignment(Logout, Pos.BOTTOM_LEFT);

        Logout.setOnAction(event -> {
            stage.close();
            LoginScene.loginScene1(stage, background, backgroundView);
        });
        
        
        Button enter = new Button("Enter");
        styleNumberButton(enter);
        pane.getChildren().add(enter);
        pane.setAlignment(enter, Pos.BOTTOM_RIGHT);

        enter.setOnAction(event -> {
            int amount = Integer.parseInt(amountField.getText());
            if(amount >= 0)
            {
                message.setText("");
                bankAccount.addBalance(amount);
                AccountService sc = new AccountService();
                sc.update(bankAccount);
                sc.close();
                MoreOrClose.moreOrClose(stage,background,backgroundView,bankAccount);
            }
            else
            {
                message.setText("This amount doesn`t accepted");
            }
        });

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

    public static void styleNumberButton(Button button) {
    button.setStyle(
        "-fx-font-size: 20px;" +
        "-fx-font-weight: bold;" +
        "-fx-background-color: #dfe6e9;" +
        "-fx-text-fill: #2d3436;" +
        "-fx-border-color: #b2bec3;" +
        "-fx-border-width: 1px;" +
        "-fx-background-radius: 10px;" +
        "-fx-border-radius: 10px;" +
        "-fx-padding: 15px 25px;" +
        "-fx-cursor: hand;"
    );
    
    }

    public static void actionNumberButton(Button button , TextField textField , Label message)
    {
        button.setOnAction(event -> {
            String text = textField.getText();
            if(text.length() == 16)
            {
                message.setText("Card Number is full");
            }
            else
                textField.setText(text + button.getText());
        });
    }
}
