package com.xinyu.Initial;

import com.xinyu.controller.modifyWorkerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
修改员工信息的窗口
 */
public class modifyWorkerStage extends Application {
    Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage)throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/modifyWorker.fxml"));
        Parent root=loader.load();

        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("修改员工信息");
        primaryStage.getIcons().add(new Image("/系统.png"));
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        modifyWorkerController modifyWorkerController=loader.getController();
        initial(modifyWorkerController);
        primaryStage.show();

    }
    private void initial(modifyWorkerController modifyWorkerController){
        modifyWorkerController.choicebox.getItems().addAll("地址","电话","密码","部门");
        modifyWorkerController.choicebox.getSelectionModel().select("地址");

    }
    public void showWindow()throws  Exception{
        start(stage);
    }
}
