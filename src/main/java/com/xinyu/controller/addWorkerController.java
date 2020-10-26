package com.xinyu.controller;

import com.xinyu.Initial.managerStage;
import com.xinyu.entity.People;
import com.xinyu.operate.add_worker;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
添加员工的界面
 */
public class addWorkerController {
    @FXML
    private Button ret;
    @FXML
    private TextField idField;

    @FXML
    private TextField dateField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField sexField;
    @FXML
    private TextField departmentField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField postField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;


    @FXML
    public void config(){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=dateField.getText();
        Date date1=new Date();
        try {
             date1=df.parse(date);
        }
        catch (Exception e){
            alterError("日期格式错误");
        }
        People people=new People();
//        设置日期
        people.setBirth_day(date1);

//        得到添加的员工id
        String workerId=idField.getText();
        if (!trimSpace(workerId).equals("")){
            people.setWorker_id(workerId);
        }else {
            alterError("请输入正确格式的员工id");
        }

//        设置名字
        String name=nameField.getText();
        if (!trimSpace(name).equals("")){
            people.setWorker_name(name);
        }
        else {
            alterError("请勿只输入空格");
        }

//      设置性别
        String gender= sexField.getText();
        if (!trimSpace(gender).equals("")){
            people.setGender(gender);
        }
        else {
            alterError("请勿只输入空格");
        }

//        设置密码
        String password=passwordField.getText();
        if (!trimSpace(password).equals("")){
            people.setPassword(password);
        }
        else {
            alterError("请勿只输入空格");
        }

//      设置职位
        String position=postField.getText();
        if (!trimSpace(position).equals("")){
            people.setPost(position);
        }
        else {
            alterError("请勿只输入空格");
        }

//      设置住址
        String address=addressField.getText();
        if (!trimSpace(address).equals("")){
            people.setAddress(address);
        }
        else {
            alterError("请勿只输入空格");
        }

//        设置手机号
        String phone=phoneField.getText();
        if (!trimSpace(phone).equals("")){
            people.setWork_phone(phone);
        }
        else {
            alterError("请勿只输入空格");
        }

//        设置权限
        if (people.getPost().equals("经理")){
            people.setAccess(1);
        }
        else {
            people.setAccess(0);
        }

//        数据库添加员工
        String departId=departmentField.getText();
        if (trimSpace(phone).equals("")){
            alterError("请勿只输入空格");
        }else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("确认");
            alert.setHeaderText("确认添加该员工?");
            alert.initModality(Modality.APPLICATION_MODAL);
            Stage stage=(Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/系统.png"));

//            确认就添加数据
            Button button1=(Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            button1.setOnAction(event -> add_worker.add(people,departId));
            Button button2=(Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);

//            关闭窗口
            button2.setOnAction(event -> alert.close());
            alert.show();
            clearTextField();

        }
    }
    public void ret(){
        Stage stage=(Stage) ret.getScene().getWindow();
        stage.close();
    }
//    去掉全部的空格
    private String trimSpace(String s){
        s=s.replace(" ","");
        return s;
    }

//    弹窗报错
    private void alterError(String s){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("错误");
        alert.setHeaderText(s);
        alert.initModality(Modality.APPLICATION_MODAL);
        Stage stage=(Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/错误.png"));
        alert.show();
    }
    private void clearTextField(){
        idField.setText("");
        dateField.setText("");
        nameField.setText("");
        sexField.setText("");
        departmentField.setText("");
        passwordField.setText("");
        postField.setText("");
        addressField.setText("");
        phoneField.setText("");
    }
}
