package com.example.mantas_sungaila_bd_fx.model;

import java.util.ArrayList;

public class Influence {

    public int id;
    private int shapeId;
    public int type = 2;

    public String objName = "Obj name";

    public String description = "Obj description";

    public float riskValueChange = 0;

    public ArrayList<Integer> connections = new ArrayList<Integer>();

    public float exitValueChange = 0;
    public Influence(int id, int shapeId) {
        this.id = id;
        this.shapeId= shapeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRiskValueChange() {
        return riskValueChange;
    }

    public void setRiskValueChange(float riskValueChange) {
        this.riskValueChange = riskValueChange;
    }

    public float getExitValueChange() {
        return exitValueChange;
    }

    public void setExitValueChange(float exitValueChange) {
        this.exitValueChange = exitValueChange;
    }

    public int getShapeId() {
        return shapeId;
    }

    public void addConnection(int secondarySelectedId) {
        this.connections.add(secondarySelectedId);
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }
}
