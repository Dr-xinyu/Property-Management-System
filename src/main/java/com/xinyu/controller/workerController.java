package com.xinyu.controller;

import com.xinyu.Initial.clientStage;
import com.xinyu.entity.Charge;
import com.xinyu.entity.Room;
import com.xinyu.operate.add_charge;
import com.xinyu.operate.searchCharge;
import com.xinyu.operate.searchPeople;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Date;

import static com.xinyu.operate.getRoom.getroom;

public class workerController {
//    员工号
    @FXML
    private TextField workerId;
//    房间号
    @FXML
    private TextField roomId;
//    业主ID
    @FXML
    private TextField ownerId;
//    电梯楼层
    @FXML
    private TextField elevatorFloor;
//    用水数量
    @FXML
    private TextField waterNumber;
//    用电度数
    @FXML
    private TextField powerDegree;
    @FXML
    private Button commit;
    @FXML
    private Button returnToLogin;
    @FXML
//    添加数据到charge表格中的动作
    public void insertCharge(ActionEvent event)throws Exception {
//        得到输入的内容
        String worker_id=workerId.getText();
        String room_id = roomId.getText();
        String owner_id = ownerId.getText();
        String floor = elevatorFloor.getText();
        String water = waterNumber.getText();
        String power = powerDegree.getText();

//        存在这个房子,并且业主正确,并且
        if (isExist(room_id,owner_id)){
            if(noExist()){
                if (numberIsExist()){
                    addSucceed(room_id,owner_id,worker_id,floor,water,power);
                }
                else {
                    numberGetFailed();
                }
            }else {
                alterError("数据已经存在");
                clearField();
            }

        }
        else {
            addFailed("房号或业主号错误");
        }

    }

//    查看输入的房号和业主号是否正确
    private boolean isExist(String roomid,String ownerid){
        return searchPeople.isExist(ownerid,roomid);
    }
//   查看是否输入各个数量的数据
    private boolean numberIsExist(){
        if (trimSpace(elevatorFloor.getText()).equals("")||trimSpace(waterNumber.getText()).equals("")||trimSpace(powerDegree.getText()).equals("")){
            return false;
        }
        else return true;
    }

//输入正确之后的操作
    private void addSucceed(String roomid,String ownerid,String workerid,String floor,String water,String power){
        Room room=getroom(roomid);
        Charge charge=new Charge();
        charge.setOwner_id(ownerid);//存入业主id
        charge.setRoom_id(roomid);//房屋id
        charge.setWorker_id(workerid);//员工id
        charge.setElectricity_number(power);//用电数量
        charge.setElevator_number(floor);//电梯层数
        charge.setWater_number(water);//用水的吨数
        charge.setWuye_number(String.valueOf(room.getRoom_area()));
        Date date = new Date();//获得系统时间
        charge.setCharge_date(date);//存入时间
//        计算费用    电梯费   水费       电费      物业费
        int floor1=Integer.valueOf(floor);
        double water1 =Double.valueOf(water);
        double power1=Double.valueOf(power);
        double money=(floor1*5)+(water1*0.7)+(power1*0.8)+room.getRoom_area();
        charge.setMoney(String.valueOf(money));
        add_charge.add(charge);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("添加完成！");
        Stage  stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/.确认.png"));
        alert.getDialogPane().getButtonTypes().remove(1);
        alert.show();
        clearField();
    }
//    没有获取到输入的数量，报错
    private void numberGetFailed(){
        alterError("请输入正确的数量");
    }
//房号或者业主号错误而报错
    private void addFailed(String s){
        alterError(s);
    }
    @FXML
//    返回登录菜单的动作
    public void returnToLogin(ActionEvent event)throws Exception{
        clientStage clientstage=new clientStage();
        Stage stage=new Stage();
        clientstage.start(stage);
        Stage stage1=(Stage) returnToLogin.getScene().getWindow();
        stage1.close();
    }

//    判断输入的数据是否存在
    private boolean noExist(){
        Date date=new Date();
//        存在返回0,不存在返回1
        return !searchCharge.isExist(roomId.getText(),date);
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

//    去掉输入的空格
    private String trimSpace(String s){
        s=s.replace(" ","");
        return s;
    }

//    清空输入的数据
    private void clearField(){
        workerId.setText("");
        roomId.setText("");
        ownerId.setText("");
        elevatorFloor.setText("");
        waterNumber.setText("");
        powerDegree.setText("");
    }
}
