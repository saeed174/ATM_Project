package com.sfs.gui;

import com.sfs.entity.Account;

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

public class MoreOrClose {
    public static void moreOrClose(Stage stage,Image background,ImageView backgroundView,Account bankAccount) {
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane);
        pane.getChildren().add(backgroundView);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        pane.getChildren().add(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        Text Transaction = new Text("Thanks to use our services\nDo you want other services?");
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

        Button Yes = new Button("Yes");
        Dashboard.styleNumberButton(Yes);
        gridPane.add(Yes, 0, 1);

        Yes.setOnAction(e -> {
            Dashboard.dashboard(stage,background,backgroundView,bankAccount);
        });

        Button NO = new Button("NO");
        Dashboard.styleNumberButton(NO);
        gridPane.add(NO, 0, 2);

        NO.setOnAction(e -> {
            stage.close();
            StartScene.startScene(stage,scene);
        });


        GridPane.setHalignment(Yes, HPos.CENTER);
        GridPane.setHalignment(NO, HPos.CENTER);
        GridPane.setValignment(Yes, VPos.CENTER);
        GridPane.setValignment(NO, VPos.CENTER);

        Button logout = new Button("Logout");
        Dashboard.styleNumberButton(logout);
        logout.setOnAction(e -> {
            stage.close();
            LoginScene.loginScene1(stage, background, backgroundView);
        });
        pane.getChildren().add(logout);
        pane.setAlignment(logout, Pos.BOTTOM_LEFT);

        
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

}
