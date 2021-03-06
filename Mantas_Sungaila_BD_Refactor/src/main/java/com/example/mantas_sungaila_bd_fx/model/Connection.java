package com.example.mantas_sungaila_bd_fx.model;

import com.example.mantas_sungaila_bd_fx.view.LineDrawer;
import com.example.mantas_sungaila_bd_fx.view.MainPage;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Connection implements Initializable {
    private int[] connectedElementIds;
    private LineDrawer lineDrawer = new LineDrawer();

    private int lineId;
    private Center center1;
    private Center center2;

    public Connection(int a, int b, int lineId){
        this.connectedElementIds = new int[]{a , b};
        this.lineId = lineId;
        System.out.println("check1 "+ connectedElementIds[0] + " " + connectedElementIds[1]);
        switch (MainPage.returnSelectedListItem(connectedElementIds[0])[0]) {
            case 1 -> {System.out.println("check 1.1 " + MainPage.objectList.get(
                    MainPage.returnSelectedListItem(connectedElementIds[0])[1]).getShapeId());
                center1 = new Center(MainPage.shapeList.get(MainPage.objectList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[0])[1]).getShapeId()));
            }
            case 2 -> {
                center1 = new Center(MainPage.shapeList.get(MainPage.influenceList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[0])[1]).getShapeId()));
            }
        }
        switch (MainPage.returnSelectedListItem(connectedElementIds[1])[0]) {
            case 1 -> {
                System.out.println("check 1.2 " + MainPage.objectList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[1])[1]).getShapeId());
                center2 = new Center(MainPage.shapeList.get(MainPage.objectList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[1])[1]).getShapeId()));
                lineDrawer.drawLine(center1, center2, 0);
            }
            case 2 -> {
                center2 = new Center(MainPage.shapeList.get(MainPage.influenceList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[1])[1]).getShapeId()));
                lineDrawer.drawLine(center1, center2, 0);

            }

        }
    }

    public int[] getConnectedElementIds() {
        return connectedElementIds;
    }

    public int getLineId() {
        return lineId;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("check 77");
        switch (MainPage.returnSelectedListItem(connectedElementIds[0])[0]) {
            case 1 -> {
                center1 = new Center(MainPage.shapeList.get(MainPage.objectList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[0])[1]).getShapeId()));
            }
            case 2 -> {
                center1 = new Center(MainPage.shapeList.get(MainPage.influenceList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[0])[1]).getShapeId()));
                ;
            }
        }
        switch (MainPage.returnSelectedListItem(connectedElementIds[1])[0]) {
            case 1 -> {
                center2 = new Center(MainPage.shapeList.get(MainPage.objectList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[1])[1]).getShapeId()));
                lineDrawer.drawLine(center1, center2, 0);
            }
            case 2 -> {
                center2 = new Center(MainPage.shapeList.get(MainPage.influenceList.get(
                        MainPage.returnSelectedListItem(connectedElementIds[1])[1]).getShapeId()));
                lineDrawer.drawLine(center1, center2, 0);

            }

        }
    }
}
