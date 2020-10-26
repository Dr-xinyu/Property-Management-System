package com.xinyu.controller;

import com.xinyu.Initial.addWorkerStage;
import com.xinyu.Initial.clientStage;
import com.xinyu.Initial.deleteWorkerStage;
import com.xinyu.Initial.modifyWorkerStage;
import com.xinyu.entity.*;
import com.xinyu.operate.getCharge;
import com.xinyu.operate.getOwner;
import com.xinyu.operate.getPeople;
import com.xinyu.operate.searchCharge;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/*
经理界面的控制器
用于处理经理界面每个按钮需要实现的动作
 */
public class managerController {
    @FXML
    private Button addButton;

    @FXML
    private Button modifyButton;

    @FXML
    public TableView<People> workerShow;

    @FXML
    private Button returnToLogin;//返回登录界面的按钮

//    搜索按钮
    @FXML
    private Button search;
    @FXML
    private TextField searchField;

//    员工ID
    @FXML
    public TableColumn<People,String> workerId;
//    员工姓名
    @FXML
    public TableColumn<People,String> workerName;

//    员工部门ID
    @FXML
    public TableColumn<People,String>departmentId;

//     地址
    @FXML
    public TableColumn<People,String>workerAddress;
//    电话号码
    @FXML
    public TableColumn<People,String>phoneNumber;
//    性别
    @FXML
    public TableColumn<People,String>workerSex;
    @FXML
    public TableColumn<People,String>workerPosition;

//    第二个tableview 用于查询流水订单的
    @FXML
    private TextField roomIdField;
    @FXML
    private TextField chargeDateField;

    @FXML
    private Button chargeSearchButton;

    @FXML
    private Label wuyeNumber;
    @FXML
    private Label diantiNumber;
    @FXML
    private Label waterNumber;
    @FXML
    private Label dianNumber;
    @FXML
    private Label wuyeMoney;
    @FXML
    private Label diantiMoney;
    @FXML
    private Label waterMoney;
    @FXML
    private Label dianMoney;



//    5个label
    @FXML
    private Label roomLabel;
    @FXML
//    缴纳月份
    private Label chargeDateLabel;
    @FXML
    private Label ownerLabel;
    @FXML
//    收费时间
    private Label dateLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label chineseNumberLabel;
    @FXML
    private Label totalLabel;



//刷新显示的数据
    @FXML
    public void reFresh(){
//        从数据库里重新读取数据。并且加载。
        List<People> people= getPeople.get_People();
        ObservableList<People> worker= FXCollections.observableArrayList();
        worker.addAll(people);
        workerShow.setItems(worker);
        workerId.setCellValueFactory(new PropertyValueFactory<>("worker_id"));
        workerName.setCellValueFactory(new PropertyValueFactory<>("worker_name"));
        workerSex.setCellValueFactory(new PropertyValueFactory<>("gender"));
        departmentId.setCellValueFactory(peopleStringCellDataFeatures -> {
            SimpleStringProperty department=new SimpleStringProperty(peopleStringCellDataFeatures.getValue().getDepartment().getDepartment_id());
            return department;
        });

        workerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("work_phone"));
        workerShow.refresh();

    }


//    删除员工
    @FXML
    public void deleteWorker() throws Exception {
//        调用deleteWorkerStage 页面
        deleteWorkerStage deleteWorker=new deleteWorkerStage();
        deleteWorker.showWindow();
    }

//    根据员工ID查找员工，并且显示到 tableColumn上
    @FXML
    public void searchWorker(){
//        从搜索栏拿到数据
        String workerId=searchField.getText();
        ObservableList<People> people= workerShow.getItems();
        boolean flag=false;
        for (People p:people){
            if (p.getWorker_id().equals(workerId)){
                int index=people.indexOf(p);
//                找到后滚动
                workerShow.scrollTo(index);
                flag=true;
                break;
            }
        }
        if (!flag){
//                未找到，弹窗
            searchField.setText("");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("未查询到该员工，请重新输入员工ID");
            alert.show();
        }
    }
//    返回登录界面
    @FXML
    public void reToLogin(ActionEvent event)throws Exception{
        clientStage clientstage=new clientStage();
        Stage stage=new Stage();
        clientstage.start(stage);
        Stage stage1=(Stage) returnToLogin.getScene().getWindow();
        stage1.close();
    }

//    添加员工的操作
    @FXML
    public void add()throws Exception{
        addWorkerStage stage=new addWorkerStage();
        stage.showWindow();
    }

//    修改员工信息的操作
    @FXML
    public void modify()throws Exception{
        modifyWorkerStage modifyWorkerStage=new modifyWorkerStage();
        modifyWorkerStage.showWindow();
    }

    @FXML
    public void chargeSearch() throws  Exception{
//        查询月份
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//        系统记录的收费日期
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        String roomId=roomIdField.getText();
        String datestring=chargeDateField.getText();
        Date date=sdf.parse(datestring);
        Calendar calendar=getCalendar(date);
//        订单存在
        if (searchCharge.isExist(roomId,date)){
//            从数据库里得到数据
            Charge charge= getCharge.get_charge(roomId,date);
            roomLabel.setText(charge.getRoom_id());
            dateLabel.setText(sdf1.format(charge.getCharge_date()));
            Owner owner= getOwner.get_owner(charge.getOwner_id());
            ownerLabel.setText(owner.getOwner_name());
            int mouth=calendar.get(Calendar.MONTH);
            String mouth1=String.valueOf(mouth);
            int mouth2=mouth+1;
            String mouth3=String.valueOf(mouth2);
            chargeDateLabel.setText(mouth1+"月-"+mouth3+"月");
            idLabel.setText(charge.getWorker_id());
            totalLabel.setText(charge.getMoney());



            List<chargeNumber> list2=chargeNumber.getList();
            List<chargeMoney> list3=chargeMoney.getList();

            list2.get(0).setNumber(charge.getWuye_number());
            list2.get(1).setNumber(charge.getElevator_number());
            list2.get(2).setNumber(charge.getWater_number());
            list2.get(3).setNumber(charge.getElectricity_number());

            Integer elevatormoney=string2int(charge.getElevator_number())*5;
            String em=String.valueOf(elevatormoney);
            list3.get(1).setChargeMoney(em);


            double wuyemoey=string2double(charge.getWuye_number());
            String we=String.valueOf(wuyemoey);
            list3.get(0).setChargeMoney(we);

            double watermoney=string2double(charge.getWater_number())*0.7;
            String wm=String.valueOf(watermoney);
            list3.get(2).setChargeMoney(wm);

            double dmoney=string2double(charge.getElectricity_number())*0.8;
            String dm=String.valueOf(dmoney);
            list3.get(3).setChargeMoney(dm);
//             显示数据
            wuyeNumber.setText(list2.get(0).getNumber());
            diantiNumber.setText(list2.get(1).getNumber());
            waterNumber.setText(list2.get(2).getNumber());
            dianNumber.setText(list2.get(3).getNumber());

            wuyeMoney.setText(list3.get(0).getChargeMoney());
            diantiMoney.setText(list3.get(1).getChargeMoney());
            waterMoney.setText(list3.get(2).getChargeMoney());
            dianMoney.setText(list3.get(3).getChargeMoney());

        }
//        订单不存在
        else
        {
            alterError("订单不存在");
            wuyeNumber.setText("");
            diantiNumber.setText("");
            waterNumber.setText("");
            dianNumber.setText("");
            wuyeMoney.setText("");
            diantiMoney.setText("");
            waterMoney.setText("");
            dianMoney.setText("");
            roomLabel.setText("");
            chargeDateLabel.setText("");
            ownerLabel.setText("");
            dateLabel.setText("");
            idLabel.setText("");
           totalLabel.setText("");


        }
    }
//    弹窗错误
    private void alterError(String s){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("错误");
        alert.setHeaderText(s);
        alert.initModality(Modality.APPLICATION_MODAL);
        Stage stage=(Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/错误.png"));
        alert.show();
    }
//    得到日期
    private Calendar getCalendar(Date date){
        Calendar calendar=new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }
//    string转为double
    private double string2double(String s){
        double d=Double.valueOf(s);
        return d;
    }
//    string转为int
    private Integer string2int(String s){
        Integer i=Integer.valueOf(s);
        return i;
    }

}


