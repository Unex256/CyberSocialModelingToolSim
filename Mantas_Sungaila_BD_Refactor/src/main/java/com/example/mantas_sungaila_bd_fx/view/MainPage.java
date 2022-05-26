package com.example.mantas_sungaila_bd_fx.view;

import com.example.mantas_sungaila_bd_fx.model.Application;
import com.example.mantas_sungaila_bd_fx.model.Connection;
import com.example.mantas_sungaila_bd_fx.model.DraggableSelectionLogic;
import com.example.mantas_sungaila_bd_fx.model.Influence;
import com.example.mantas_sungaila_bd_fx.model.Object;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPage implements Initializable {

    public AnchorPane mainPane;

    public Button newObjectBtn;

    public  Label selectedIdLabel;
    public static Label staticSelectedIdLabel;

    public int idIntType1 = 1;
    public int idIntType2 = 2;
    public static int selectedId = 0;
    public static int secondarySelectedId = 0;
    public static int staticArrayItemId;
    public Slider speedSlider;

    private int simulationSpeed = 1;
    public ToggleButton startStopSimulationBtn;
    public Label stepCountLabel;

    private int stepCount = 0;
    public static Label staticStepCountLabel;

    private int shapeId = 0;


    public static ArrayList<com.example.mantas_sungaila_bd_fx.model.Object> objectList = new ArrayList<com.example.mantas_sungaila_bd_fx.model.Object>();

    public static ArrayList<Influence> influenceList = new ArrayList<Influence>();

    public static ArrayList<Connection> connectionList = new ArrayList<Connection>();

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    public static ArrayList<Line> lineList = new ArrayList<Line>();

    public static int staticLineId = 0;
    public Label secondarySelectedIdLabel;

    public static Label staticSecondarySelectedIdLabel;
    DraggableSelectionLogic draggableMaker = new DraggableSelectionLogic();
    private boolean notAdjusted = true;

    public void onNewObjectBtnPressed(ActionEvent actionEvent) throws IOException {
        createNewObject();
        newObject();
    }

    private void createNewObject() {
        this.objectList.add(new com.example.mantas_sungaila_bd_fx.model.Object(idIntType1, shapeId));
    }

    public void onNewInfluenceBtnPressed(ActionEvent actionEvent) throws IOException {
        createNewInfluence();
        newInfluence();
    }

    private void createNewInfluence() {
        this.influenceList.add(new Influence(idIntType2, shapeId));
    }

    public void newObject() {
        MainPage.shapeList.add(new Rectangle(50, 50));

        MainPage.shapeList.get(shapeId).setStroke(Color.BLACK);
        MainPage.shapeList.get(shapeId).setFill(Color.CYAN);
        MainPage.shapeList.get(shapeId).setId(Integer.toString(idIntType1));
        draggableMaker.makeDraggable(MainPage.shapeList.get(shapeId));
        mainPane.getChildren().add(MainPage.shapeList.get(shapeId));
        this.shapeId++;
        this.idIntType1++;
        this.idIntType1++;
    }
    public void newInfluence() {
        MainPage.shapeList.add(new Rectangle(50, 50));

        MainPage.shapeList.get(shapeId).setStroke(Color.BLACK);
        MainPage.shapeList.get(shapeId).setFill(Color.SANDYBROWN);
        MainPage.shapeList.get(shapeId).setId(Integer.toString(idIntType2));
        draggableMaker.makeDraggable(MainPage.shapeList.get(shapeId));
        mainPane.getChildren().add(MainPage.shapeList.get(shapeId));
        this.shapeId++;
        this.idIntType2++;
        this.idIntType2++;
    }

    public static void setSelectedId(int id) {
        MainPage.selectedId = id;
        //System.out.println(this.selectedIdLabel.getText());
    }

    public static int getSecondarySelectedId() {
        return secondarySelectedId;
    }

    public static void setSecondarySelectedId(int secondarySelectedId) {
        MainPage.secondarySelectedId = secondarySelectedId;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staticSelectedIdLabel = selectedIdLabel;
        staticSecondarySelectedIdLabel = secondarySelectedIdLabel;
        staticStepCountLabel = stepCountLabel;

        speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                simulationSpeed = (int)speedSlider.getValue();
                System.out.println(simulationSpeed);
            }
        });
    }

    public static int getStaticArrayItemId() {
        return staticArrayItemId;
    }

    public void editSelectedNode(ActionEvent event) throws IOException {
        switch (returnSelectedListItem(selectedId)[0]) {
            case 1 -> {
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("object-options.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Object options");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
            }
            case 2 -> {
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("influence-options.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Outside influence");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
            }
        }

    }


    public static int[] returnSelectedListItem(int selectedId){

        if (selectedId % 2 == 1) {
            MainPage.staticArrayItemId = 0;
            for (com.example.mantas_sungaila_bd_fx.model.Object object : objectList) {
                if(object.getId() == selectedId){
                    return new int[]{1, staticArrayItemId};
                }
               MainPage.staticArrayItemId++;
            }
        }else {
            MainPage.staticArrayItemId = 0;
            for (Influence influence : influenceList) {
                if(influence.getId() == selectedId){
                    return new int[]{2, staticArrayItemId};
                }
                MainPage.staticArrayItemId++;
            }
        }
            return new int[] {0,0};
    }
    public void makeConnection(ActionEvent event) {
        if(selectedId != 0 && secondarySelectedId != 0 && secondarySelectedId != selectedId){
            connectionList.add(new Connection(selectedId, secondarySelectedId, staticLineId));
            addConnectionToObject(selectedId, secondarySelectedId);
        }
    }

    private void addConnectionToObject(int selectedId, int secondarySelectedId) {
        if (selectedId % 2 == 1) {
            for (com.example.mantas_sungaila_bd_fx.model.Object object : objectList) {
                if(object.getId() == selectedId){
                    object.addConnection(secondarySelectedId);
                }
            }
        }else {
            for (Influence influence : influenceList) {
                if(influence.getId() == selectedId){
                    influence.addConnection(secondarySelectedId);
                }
            }
        }
    }

    public void startStopSimulation(ActionEvent event) throws InterruptedException {
        if(notAdjusted) {
            for (Influence influence : influenceList) {
                for (Integer integer : influence.getConnections()) {
                    System.out.println(MainPage.objectList.get(integer / 2).getExitChance() + " " + influence.getExitValueChange() + " " + integer / 2);
                    MainPage.objectList.get(integer / 2).adjustExitChance(influence.getExitValueChange());
                    System.out.println(MainPage.objectList.get(integer / 2).getAdjustedExitChance());
                    System.out.println(MainPage.objectList.get(integer / 2).getRiskChance());
                    MainPage.objectList.get(integer / 2).adjustRiskChance(influence.getRiskValueChange());
                    System.out.println(MainPage.objectList.get(integer / 2).getAdjustedRiskChance());
                }
            }
            this.notAdjusted = false;
        } else{
            for (Influence influence : influenceList) {
                for (Integer integer : influence.getConnections()) {
                    System.out.println(MainPage.objectList.get(integer / 2).getExitChance() + " " + influence.getExitValueChange());
                    MainPage.objectList.get(integer / 2).adjustExitChance(-influence.getExitValueChange());
                    System.out.println(MainPage.objectList.get(integer / 2).getAdjustedExitChance());
                    System.out.println(MainPage.objectList.get(integer / 2).getRiskChance() + " " + influence.getRiskValueChange());
                    MainPage.objectList.get(integer / 2).adjustRiskChance(-influence.getRiskValueChange());
                    System.out.println(MainPage.objectList.get(integer / 2).getAdjustedRiskChance());
                }
            }
            this.notAdjusted = true;
        }
        Service<Void> toggleService = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {

                return new Task<Void>(){

                    @Override
                    protected Void call() throws Exception {

                        while(!isCancelled()) {
                            System.out.println(stepCount);
                            Platform.runLater(new Runnable() {
                                @Override public void run() {
                                    updateStepCount();
                                }
                            });
                            for (com.example.mantas_sungaila_bd_fx.model.Object object : objectList) {
                                if(object.isBeginningNode()) {
                                    objectTree(object);
                                }
                            }

                            Thread.sleep(1000/simulationSpeed);
                            stepCount++;
                        }
                        return null;
                    }

                    private void objectTree(Object object) {
                        if(Math.random() < object.getAdjustedRiskChance()){
                            object.increaseRiskCount();
                            System.out.println(Math.random() + " " + object.getRiskCount());
                        }
                        if(Math.random() < object.getAdjustedExitChance()){
                            for(Integer integer : object.getConnections()){
                                objectTree(MainPage.objectList.get(integer / 2));

                            }
                        }
                    }
                };
            }
        };

        startStopSimulationBtn.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if(newVal) {
                toggleService.reset();
                toggleService.start();
            }
            else
                toggleService.cancel();

        });
    }

    private void updateStepCount() {
        MainPage.staticStepCountLabel.setText(Integer.toString(stepCount));
    }

}

