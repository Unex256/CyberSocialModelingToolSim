package com.example.mantas_sungaila_bd_fx.view;
import com.example.mantas_sungaila_bd_fx.model.Center;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class LineDrawer {
    //final Line line = new Line();

        public LineDrawer(){
        }

        public void drawLine (Center center1, Center center2, int nodeId){
            MainPage.lineList.add(new Line());
            MainPage.lineList.get(MainPage.staticLineId).setStartX(center1.centerXProperty().doubleValue());
            MainPage.lineList.get(MainPage.staticLineId).setStartY(center1.centerYProperty().doubleValue());
            MainPage.lineList.get(MainPage.staticLineId).setEndX(center2.centerXProperty().doubleValue());
            MainPage.lineList.get(MainPage.staticLineId).setEndY(center2.centerYProperty().doubleValue());
            ((AnchorPane) MainPage.shapeList.get(1).getParent()).getChildren().add(MainPage.lineList.get(MainPage.staticLineId));
            MainPage.staticLineId++;
        }

}
