package com.xinyu.controller;

import com.xinyu.operate.delete_worker;
import com.xinyu.operate.searchPeople;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.junit.runners.AllTests;

public class deleteWorkerController {
    @FXML
    private TextField id;
    @FXML
    private Button config;
    @FXML
    private Button ret;

//    确认删除的操作
    @FXML
    public void configDelete(){
        String workerId=id.getText();
        if (searchPeople.isExist(workerId)){
//            弹窗确认删除
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
//            窗口设置为模态。
            alert.initModality(Modality.APPLICATION_MODAL);
            Stage stage=(Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/确认.png"));
            alert.setTitle("确认");
            alert.setHeaderText("确认删除该员工？");
            Button confirmation=(Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            confirmation.setOnAction(event -> delete_worker.delete(workerId));
            Button cancel=(Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
//            取消就关闭弹窗
            cancel.setOnAction(event -> alert.close());

            alert.show();
            id.setText("");
        }
        else{
//            报错，没找到员工ID
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            Stage stage=(Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/错误.png"));
            alert.setTitle("错误");
            alert.setHeaderText("未找到该员工，请重新输入员工ID");
            alert.show();
        }
    }

    //返回经理界面的操作
    @FXML
    public void returnToManager(){
        Stage stage=(Stage) ret.getScene().getWindow();
        stage.close();

    }
}



