package com.example.mantas_sungaila_bd_fx.view;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ObjectOptions implements Initializable{

    public TextArea objDescriptionTextArea;
    public TextField exitChance;
    public TextField riskChance;
    public Label exitCountLabel;
    public Label riskCountLabel;
    public TextField objNameTextArea;
    public Label idLabel;
    public Button confirmBtn;

    public CheckBox beginningNodeCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(MainPage.getStaticArrayItemId());
        this.idLabel.setText(Integer.toString(MainPage.selectedId));
        this.objDescriptionTextArea.setText(MainPage.objectList.get(MainPage.staticArrayItemId).getDescription());
        this.exitChance.setText(Float.toString(MainPage.objectList.get(MainPage.staticArrayItemId).getExitChance()));
        this.riskChance.setText(Float.toString(MainPage.objectList.get(MainPage.staticArrayItemId).getRiskChance()));
        this.exitCountLabel.setText(Integer.toString(MainPage.objectList.get(MainPage.staticArrayItemId).getExitCount()));
        this.riskCountLabel.setText(Integer.toString(MainPage.objectList.get(MainPage.staticArrayItemId).getRiskCount()));
        this.objNameTextArea.setText(MainPage.objectList.get(MainPage.staticArrayItemId).getObjName());
        this.beginningNodeCheckBox.setSelected(MainPage.objectList.get(MainPage.staticArrayItemId).isBeginningNode());
    }

    public void onConfirmBtnPress(ActionEvent event) {
        MainPage.objectList.get(MainPage.staticArrayItemId).setDescription(objDescriptionTextArea.getText());
        MainPage.objectList.get(MainPage.staticArrayItemId).setExitChance(Float.parseFloat(exitChance.getText()));
        MainPage.objectList.get(MainPage.staticArrayItemId).setObjName(objNameTextArea.getText());
        MainPage.objectList.get(MainPage.staticArrayItemId).setRiskChance(Float.parseFloat(riskChance.getText()));
        MainPage.objectList.get(MainPage.staticArrayItemId).resetChances();

    }

    public void checkBoxCheck(ActionEvent event){
        if(beginningNodeCheckBox.isSelected()){
            MainPage.objectList.get(MainPage.staticArrayItemId).setBeginningNode(true);
        } else {
            MainPage.objectList.get(MainPage.staticArrayItemId).setBeginningNode(false);
        }
    }
}
