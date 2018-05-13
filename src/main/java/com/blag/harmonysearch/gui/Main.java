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
        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("Harmony Search");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
