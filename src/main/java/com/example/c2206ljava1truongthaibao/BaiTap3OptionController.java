package com.example.c2206ljava1truongthaibao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BaiTap3OptionController implements Initializable{
    @FXML
    private ToggleGroup shape;
    @FXML
    Label lb;
    @FXML
    ComboBox cbb;
    @FXML
    private BorderPane borderPane;
    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
    private void AddColorToComboBox(){
        ObservableList<String> color = FXCollections.observableArrayList();
        color.addAll("Blue","Red","Green","White","Black","Violet","Yellow");
        cbb.setItems(color);
    }
    public int getValueShape(){
        RadioButton selectedRadioButton = (RadioButton) shape.getSelectedToggle();
        String RadioValue = selectedRadioButton.getText();
        if (RadioValue.equals("Rectangle")){
            lb.setText("");
            return 1;
        }else if (RadioValue.equals("Ellipse")) {
            lb.setText("");
            return 2;
        } else if(RadioValue.equals("Triangle")){
            lb.setText("");
            return 3;
        }else {
            return 1;
        }
    }
    public Rectangle drawRec(String color){
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(100);
        rectangle.setWidth(150);
        rectangle.setFill(Color.web(color));
        return rectangle;
    }
    public Ellipse drawEllipse(String color) {
        Ellipse ellipse = new Ellipse();
        ellipse.setRadiusX(60);
        ellipse.setRadiusY(40);
        ellipse.setFill(Color.web(color));
        return ellipse;
    }
    public Polygon drawTriangle(String color) {
        double triangleSize = 100;
        double triangleHeight = triangleSize * Math.sqrt(3) / 2;
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                triangleSize / 2, 0.0,                 // Điểm trên
                0.0, triangleHeight,                   // Điểm trái dưới
                triangleSize, triangleHeight           // Điểm phải dưới
        );
        triangle.setFill(Color.web(color));
        return triangle;
    }


    @FXML
    protected void onOKButtonClick(ActionEvent event) {
        getValueShape();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        boolean isValid = validateComboBox();

        if (isValid) {
            currentStage.close();
            borderPane.setLeft(null);
            borderPane.setCenter(null);
            borderPane.setRight(null);
            if (stage != null) {
                stage.show();
            }
            String selectedColor = (String) cbb.getValue();
            if (selectedColor != null) {
                if (getValueShape() == 1) {
                    Rectangle rectangle = drawRec(selectedColor);
                    borderPane.setCenter(rectangle);
                } else if (getValueShape() == 2) {
                    Ellipse ellipse = drawEllipse(selectedColor);
                    borderPane.setCenter(ellipse);
                } else if (getValueShape() == 3) {
                    Polygon triangle = drawTriangle(selectedColor);
                    borderPane.setCenter(triangle);
                }
            }
        }else {
            lb.setText("Chưa chọn màu!");
        }

    }
    private boolean validateComboBox() {
        String selectedColor = (String) cbb.getValue();
        return selectedColor != null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AddColorToComboBox();
        cbb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String selectedColor = (String) cbb.getValue();
        });
    }
}
