package com.example.c2206ljava1truongthaibao;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaiTap3Controller implements Initializable {
    @FXML
    private Polygon item1, item2, item3;
    @FXML
    private BorderPane borderPane;
    private Stage stage;
    public void getStage(Stage stage) {
        this.stage = stage;
    }
    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
    @FXML
    protected void delShape(ActionEvent event) {
        borderPane.setLeft(null);
        borderPane.setCenter(null);
        borderPane.setRight(null);
    }
    @FXML
    protected void Exit(ActionEvent event) {stage.close();}
    @FXML
    protected void openOption(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BaiTap3Option.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setTitle("Option");
        newStage.setScene(new Scene(root));
        newStage.setResizable(false);
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initOwner(this.stage);
        BaiTap3OptionController optionController = loader.getController();
        optionController.setStage(stage); // Gán biến stage chính cho OptionController
        optionController.setBorderPane(borderPane); //Gán giá trị cho AnchorPane
        newStage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(1), item1);
        transition1.setByY(80f);
        transition1.setCycleCount(Animation.INDEFINITE);
        transition1.setAutoReverse(true);
        transition1.play();

        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), item2);
        transition2.setByY(-80f);
        transition2.setCycleCount(Animation.INDEFINITE);
        transition2.setAutoReverse(true);
        transition2.play();

        TranslateTransition transition3 = new TranslateTransition(Duration.seconds(1), item3);
        transition3.setByY(80f);
        transition3.setCycleCount(Animation.INDEFINITE);
        transition3.setAutoReverse(true);
        transition3.play();
    }
    public void getRoot(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
}
