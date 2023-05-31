package com.example.c2206ljava1truongthaibao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaiTap1Controller implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    CategoryAxis x;
    @FXML
    NumberAxis y;
    @FXML
    BarChart<String,Number> DoanhThu;
    Stage mystage;
    @FXML
    protected void onHelloButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(mystage);

        if (file != null) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line = bufferedReader.readLine();
                String[] values = line.split("\\s+");

                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName("2023");
                int xValue = 1;
                for (String value : values) {
                    int yValue = Integer.parseInt(value);
                    series.getData().add(new XYChart.Data<>(String.valueOf(xValue), yValue));
                    xValue++;
                }

                bufferedReader.close();
                reader.close();

                // Truyền dữ liệu vào biểu đồ
                DoanhThu.getData().add(series);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        XYChart.Series set1 = new XYChart.Series<>();
//
//        set1.setName("Nam 2023");
//        set1.getData().add(new XYChart.Data("1",100));
//        set1.getData().add(new XYChart.Data("2",120));
//        set1.getData().add(new XYChart.Data("3",115));
//        set1.getData().add(new XYChart.Data("4",122));
//        set1.getData().add(new XYChart.Data("5",114));
//        set1.getData().add(new XYChart.Data("6",105));
//        set1.getData().add(new XYChart.Data("7",98));
//
//        DoanhThu.getData().addAll(set1);

    }
}