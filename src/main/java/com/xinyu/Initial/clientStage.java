package com.xinyu.Initial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.xinyu.controller.*;

import java.net.URL;

/*
客户端的登录初始化
 */
public class clientStage extends Application {
    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/client.fxml"));

//        注意这里必须是load(),而不能是laod(url). 不然，会使得loader 得不到controller
        AnchorPane root1=loader.load();

        loginController controller=loader.getController();
        initValues(controller);
        Scene scene=new Scene(root1);
        stage.getIcons().add(new Image("/系统.png"));
        stage.setScene(scene);
        stage.show();
    }
    private void initValues(loginController controller) {
        ToggleGroup toggleGroup = new ToggleGroup();
        controller.worker.setToggleGroup(toggleGroup);
        controller.manager.setToggleGroup(toggleGroup);
        controller.worker.setSelected(true);
    }
}
