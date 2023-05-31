package com.example.c2206ljava1truongthaibao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class BaiTap2Controller implements Initializable {
    @FXML
    TextField canNang, chieuCao;
    @FXML
    ChoiceBox<String> chuan;
    @FXML
    Label rsLabel;

    @FXML
    protected void onHelloButtonClick() {
        if (canNang.getText().isEmpty() || chieuCao.getText().isEmpty() || chuan.getValue() == null) {
            rsLabel.setText("Vui lòng nhập đầy đủ thông tin");
            return;
        }

        float nang = Float.parseFloat(canNang.getText());
        float cao = Float.parseFloat(chieuCao.getText()) / 100;
        float bmi = nang / (cao * cao);

        if (chuan.getValue().equals("BMI")) {
            if (bmi >= 40) {
                rsLabel.setText("Béo phì độ III");
            } else if (bmi >= 35) {
                rsLabel.setText("Béo phì độ II");
            } else if (bmi >= 30) {
                rsLabel.setText("Béo phì độ I");
            } else if (bmi > 25) {
                rsLabel.setText("Tiền béo phì");
            } else if (bmi == 25) {
                rsLabel.setText("Thừa cân");
            } else if (bmi >= 18.5) {
                rsLabel.setText("Bình thường");
            } else {
                rsLabel.setText("Cân nặng thấp (gầy)");
            }
        } else {
            if (bmi >= 40) {
                rsLabel.setText("Béo phì độ III");
            } else if (bmi >= 30) {
                rsLabel.setText("Béo phì độ II");
            } else if (bmi >= 25) {
                rsLabel.setText("Béo phì độ I");
            } else if (bmi > 23) {
                rsLabel.setText("Tiền béo phì");
            } else if (bmi == 23) {
                rsLabel.setText("Thừa cân");
            } else if (bmi >= 18.5) {
                rsLabel.setText("Bình thường");
            } else {
                rsLabel.setText("Cân nặng thấp (gầy)");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chuan.getItems().addAll("BMI", "IDI & WPRO");
        UnaryOperator<TextFormatter.Change> positiveIntegerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") && newText.length() > 0) {
                try {
                    Integer.parseInt(newText);
                    return change;
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            return null;
        };
        TextFormatter<Integer> canNangFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, positiveIntegerFilter);
        canNang.setTextFormatter(canNangFormatter);
        TextFormatter<Integer> chieuCaoFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, positiveIntegerFilter);
        chieuCao.setTextFormatter(chieuCaoFormatter);

    }

}
