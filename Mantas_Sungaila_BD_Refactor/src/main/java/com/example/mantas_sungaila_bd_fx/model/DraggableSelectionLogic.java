package com.example.mantas_sungaila_bd_fx.model;

import com.example.mantas_sungaila_bd_fx.view.MainPage;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;

public class DraggableSelectionLogic {

    private double mouseAnchorX;
    private double mouseAnchorY;

    public void makeDraggable(Node node){

        node.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                mouseAnchorX = mouseEvent.getX();
                mouseAnchorY = mouseEvent.getY();
                MainPage.setSelectedId(Integer.parseInt(node.getId()));
                MainPage.staticSelectedIdLabel.setText(node.getId());
                //new LineDrawer(node);
            } else {
                MainPage.setSecondarySelectedId(Integer.parseInt(node.getId()));
                MainPage.staticSecondarySelectedIdLabel.setText(node.getId());
                //MainPage.staticSelectedIdLabel.setText(node.getId());
            }
        });

        node.setOnMouseDragged(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
                node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
                lineUpdate(node);
            }
        });

    }

    public void lineUpdate(Node node){
        for(Connection connection : MainPage.connectionList){
            if(connection.getConnectedElementIds()[0] == MainPage.selectedId){
                MainPage.lineList.get(connection.getLineId()).setStartX(new Center(node).centerXProperty().doubleValue());
                MainPage.lineList.get(connection.getLineId()).setStartY(new Center(node).centerYProperty().doubleValue());
            } else if (connection.getConnectedElementIds()[1] == MainPage.selectedId){
                MainPage.lineList.get(connection.getLineId()).setEndX(new Center(node).centerXProperty().doubleValue());
                MainPage.lineList.get(connection.getLineId()).setEndY(new Center(node).centerYProperty().doubleValue());
            }

        }
    }
}
