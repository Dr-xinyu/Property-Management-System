package com.xinyu.Initial;

import com.xinyu.controller.managerController;
import com.xinyu.entity.People;
import com.xinyu.operate.getPeople;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.List;

/*
经理界面初始化
 */
public class managerStage extends Application {
Stage stage=new Stage();

@Override
    public void start(Stage primaryStage)throws Exception{
    FXMLLoader loader=new FXMLLoader(getClass().getResource("/manager.fxml"));
    Parent root=loader.load();

    Scene scene=new Scene(root);
    primaryStage.setTitle("经理管理界面");
    primaryStage.getIcons().add(new Image("/系统.png"));
    primaryStage.setScene(scene);

//    加载数据 得到loader 的controller
    managerController managerController=loader.getController();
    initValues(managerController);
    primaryStage.show();
    }

    public void showWindow()throws Exception{
    start(stage);
    }
    private void initValues(managerController managerController){
        List<People> people= getPeople.get_People();
        ObservableList<People> worker= FXCollections.observableArrayList();
        worker.addAll(people);

//         把list 的数据放入tableView
        managerController.workerShow.setItems(worker);

//        System.out.println("-----------------------");
//        System.out.println(managerController);
//
        managerController.workerId.setCellValueFactory(new PropertyValueFactory<>("worker_id"));
        managerController.workerName.setCellValueFactory(new PropertyValueFactory<>("worker_name"));
        managerController.workerSex.setCellValueFactory(new PropertyValueFactory<>("gender"));
        managerController.workerPosition.setCellValueFactory(new PropertyValueFactory<>("post"));
        managerController.departmentId.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<People, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<People, String> peopleStringCellDataFeatures) {
                SimpleStringProperty department=new SimpleStringProperty(peopleStringCellDataFeatures.getValue().getDepartment().getDepartment_id());
                return department;
            }
        });
        managerController.workerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        managerController.phoneNumber.setCellValueFactory(new PropertyValueFactory<>("work_phone"));
    }
}
