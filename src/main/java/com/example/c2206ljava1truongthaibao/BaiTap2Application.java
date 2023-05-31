package com.example.c2206ljava1truongthaibao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BaiTap2Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BaiTap2Application.class.getResource("BaiTap2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bài tập 2!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}