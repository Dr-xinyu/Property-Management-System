package com.xinyu.Initial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class workerStage extends Application {
    Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/worker.fxml"));

//        注意这里必须是load(),而不能是laod(url). 不然，会使得loader 得不到controller
        AnchorPane root=loader.load();

        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("员工收费窗口");
        primaryStage.getIcons().add(new Image("/系统.png"));
        primaryStage.show();
    }
    public void showWindow() throws Exception {
        start(stage);
    }
}
