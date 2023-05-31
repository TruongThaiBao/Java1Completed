package com.example.c2206ljava1truongthaibao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class MainController {
    @FXML
    private Button btn1,btn2,btn3,btnExit;
    Stage stage;
    @FXML
    protected void openBT1(ActionEvent event) {
        BaiTap1Application app = new BaiTap1Application();
        try {
            app.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void openBT2(ActionEvent event) {
        BaiTap2Application app = new BaiTap2Application();
        try {
            app.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void openBT3(ActionEvent event) {
        BaiTap3Application app = new BaiTap3Application();
        try {
            app.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void Exit(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Thông báo !");
        alert.setHeaderText("Bạn có muốn thoát không ?");
        alert.setContentText("Lựa chọn của bạn :");

        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(btnYes,btnCancel);

        Optional<ButtonType> result = alert.showAndWait();

        if( result.get()==btnYes){
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        }
    }
}
