package com.example.mantas_sungaila_bd_fx.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {

    public Button newProjectBtn;
    @FXML
    protected void onNewProjectButtonClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("main-page.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-page.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("CyberSocial");
        stage.setScene(scene);
        stage.show();
    }

    public void onExistingProjectButtonClick(ActionEvent actionEvent) {

    }
}