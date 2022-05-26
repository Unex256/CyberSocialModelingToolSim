package com.example.mantas_sungaila_bd_fx.view;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InfluenceOptions implements Initializable {
    public TextArea objDescriptionTextArea;
    public TextField exitValueChange;
    public TextField riskValueChange;
    public TextField objNameTextArea;
    public Label idLabel;
    public Button confirmBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.idLabel.setText(Integer.toString(MainPage.selectedId));
        this.objDescriptionTextArea.setText(MainPage.influenceList.get(MainPage.staticArrayItemId).getDescription());
        this.exitValueChange.setText(Float.toString(MainPage.influenceList.get(MainPage.staticArrayItemId).getExitValueChange()));
        this.riskValueChange.setText(Float.toString(MainPage.influenceList.get(MainPage.staticArrayItemId).getRiskValueChange()));
        this.objNameTextArea.setText(MainPage.influenceList.get(MainPage.staticArrayItemId).getObjName());
    }

    public void onConfirmBtnPress(ActionEvent event) {
        MainPage.influenceList.get(MainPage.staticArrayItemId).setDescription(objDescriptionTextArea.getText());
        MainPage.influenceList.get(MainPage.staticArrayItemId).setExitValueChange(Float.parseFloat(exitValueChange.getText()));
        MainPage.influenceList.get(MainPage.staticArrayItemId).setObjName(objNameTextArea.getText());
        MainPage.influenceList.get(MainPage.staticArrayItemId).setRiskValueChange(Float.parseFloat(riskValueChange.getText()));
    }
}
