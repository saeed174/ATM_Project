package com.sfs;

import java.io.IOException;

import com.sfs.gui.StartScene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        StartScene.startScene(stage, scene);
    }

    public static void main(String[] args) {
        launch();
    }
}