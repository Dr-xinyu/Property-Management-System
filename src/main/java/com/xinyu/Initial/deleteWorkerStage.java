package com.xinyu.Initial;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class deleteWorkerStage extends Application {
    Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage)throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/deleteWorker.fxml"));
        Parent root= loader.load();
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/系统.png"));
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }
    public void showWindow() throws Exception {
        start(stage);
    }
}
