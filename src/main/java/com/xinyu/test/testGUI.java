package com.xinyu.test;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class testGUI extends Application {
    @Override
    public void start(Stage stage)throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/manager.fxml"));
        Parent root=loader.load();





        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
