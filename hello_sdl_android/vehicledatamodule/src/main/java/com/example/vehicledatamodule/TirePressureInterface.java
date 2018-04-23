package com.example.vehicledatamodule;

import android.content.Context;

/**
 * Created by cvsmain on 3/21/18.
 */

public class TirePressureInterface {
    public TirePressureInterface(){};

    private String leftFrontStatus;
    private String leftRearStatus;
    private String rightFrontStatus;
    private String rightRearStatus;
    private Integer leftFrontValue;
    private Integer leftRearValue;
    private Integer rightFrontValue;
    private Integer rightRearValue;


    public String getLeftFrontStatus() {
        return leftFrontStatus;
    }

    public void setLeftFrontStatus(String leftFrontStatus) {
        this.leftFrontStatus = leftFrontStatus;
    }

    public String getLeftRearStatus() {
        return leftRearStatus;
    }

    public void setLeftRearStatus(String leftRearStatus) {
        this.leftRearStatus = leftRearStatus;
    }

    public String getRightFrontStatus() {
        return rightFrontStatus;
    }

    public void setRightFrontStatus(String rightFrontStatus) {
        this.rightFrontStatus = rightFrontStatus;
    }

    public String getRightRearStatus() {
        return rightRearStatus;
    }

    public void setRightRearStatus(String rightRearStatus) {
        this.rightRearStatus = rightRearStatus;
    }

    public Integer getLeftFrontValue() {
        return leftFrontValue;
    }

    public void setLeftFrontValue(Integer leftFrontValue) {
        this.leftFrontValue = leftFrontValue;
    }

    public Integer getLeftRearValue() {
        return leftRearValue;
    }

    public void setLeftRearValue(Integer leftRearValue) {
        this.leftRearValue = leftRearValue;
    }

    public Integer getRightFrontValue() {
        return rightFrontValue;
    }

    public void setRightFrontValue(Integer rightFrontValue) {
        this.rightFrontValue = rightFrontValue;
    }

    public Integer getRightRearValue() {
        return rightRearValue;
    }

    public void setRightRearValue(Integer rightRearValue) {
        this.rightRearValue = rightRearValue;
    }
}
