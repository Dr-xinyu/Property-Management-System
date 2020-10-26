package com.xinyu.controller;

import com.xinyu.Initial.managerStage;
import com.xinyu.Initial.workerStage;
import com.xinyu.entity.People;
import com.xinyu.operate.getPeople;
import com.xinyu.operate.searchPeople;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginController {
    @FXML
    private Button login;
    @FXML
    private TextField ID;
    @FXML
    private PasswordField password;
    @FXML
    public RadioButton worker;
    @FXML
    public RadioButton manager;

    public loginController() {
    }

    @FXML
    public void Login(ActionEvent event)throws Exception {
        int type=worker.isSelected() ? 0 : 1;
        String user=ID.getText();
        String pass=password.getText();


        if (isExist(user,pass,type)){
            loginSucceed(type);
        }
        else{
            loginFailed();
        }
    }
//    查看员工是否存在
    public boolean isExist(String user,String password,int type){
        if(searchPeople.isExist(user)==false){
            return false;
        }
        else {
            People people= getPeople.get_People(user);
            if (!people.getPassword().equals(password)){
                return false;
            }
            else if (!people.getAccess().equals(type)){
                return false;
            }
            else
                return true;
        }
    }
//    登录成功的动作
    private void loginSucceed(int type) throws Exception {
//        打开员工的界面
        if (type==0){
            workerStage wokerstage=new workerStage();
            wokerstage.showWindow();
        }
        else{
//            打开经理的界面
            managerStage managerStage=new managerStage();
            managerStage.showWindow();
        }
        Stage stage = (Stage)login.getScene().getWindow();
        stage.close();

    }

//    登录失败的动作
    private void loginFailed(){
        ID.setText("");
        password.setText("");
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.initModality(Modality.APPLICATION_MODAL);
        Stage stage=(Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/错误.png"));
        alert.setHeaderText("账号或密码输入错误，请重新输入");
        alert.show();
    }

}
