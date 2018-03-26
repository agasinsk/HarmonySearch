package com.blag.harmonysearch.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        URL resource = getClass().getResource("/fxml/main.fxml");
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("Harmony Search");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();
    }

}
