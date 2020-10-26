package com.xinyu.controller;

import com.xinyu.entity.People;
import com.xinyu.operate.add_worker;
import com.xinyu.operate.getPeople;
import com.xinyu.operate.searchDepartment;
import com.xinyu.operate.update_worker;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
修改员工信息的控制器
 */
public class modifyWorkerController {
    @FXML
    public ChoiceBox<String> choicebox;
    @FXML
    private TextField newField;
    @FXML
    private TextField idField;
    @FXML
    private Button configButton;
    @FXML
    private Button returnButton;

    public void config(){
        String id=idField.getText();
        People people= getPeople.get_People(id);
        if (people==null){
            alterError("未找到该员工!");
            idField.setText("");
        }
        else {
            String s=choicebox.getSelectionModel().getSelectedItem();
            String s1=newField.getText();
            if (s.equals("地址")&&!trimSpace(s1).equals("")){
                people.setAddress(s1);
                update_worker.update(people);
            }
            else if (s.equals("电话")&&!trimSpace(s1).equals("")){
                people.setWork_phone(s1);
                update_worker.update(people);
            }
            else if (s.equals("密码")&&!trimSpace(s1).equals("")){
                people.setPassword(s1);
                update_worker.update(people);
            }
            else if (s.equals("部门")&&!trimSpace(s1).equals("")){
                if (searchDepartment.isExist(s1)){
                    add_worker.add(people,s1);
                }
                else{
                    alterError("请输入正确的部门号!");
                }
            }
            else {
                alterError("请选择或输入正确");
            }
            newField.setText("");
            idField.setText("");
            choicebox.getSelectionModel().select("地址");

        }

    }
    public void cancel(){
            Stage stage=(Stage)returnButton.getScene().getWindow();
            stage.close();
    }

//    去除输入 的内容的空格
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

}
