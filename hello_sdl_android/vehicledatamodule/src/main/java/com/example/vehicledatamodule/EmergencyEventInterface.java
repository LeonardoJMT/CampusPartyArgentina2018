package com.example.vehicledatamodule;

import android.content.Context;



/**
 * Created by cvsmain on 3/21/18.
 */

public class EmergencyEventInterface {
    public EmergencyEventInterface(){};

    private String emergencyEventType;
    private String fuelCutoffStatus;
    private String rolloverEvent;
    private String maximumChangeVelocity;
    private String multipleEvents;

    public String getEmergencyEventType() {
        return emergencyEventType;
    }

    public void setEmergencyEventType(String emergencyEventType) {
        this.emergencyEventType = emergencyEventType;
    }

    public String getFuelCutoffStatus() {
        return fuelCutoffStatus;
    }

    public void setFuelCutoffStatus(String fuelCutoffStatus) {
        this.fuelCutoffStatus = fuelCutoffStatus;
    }

    public String getRolloverEvent() {
        return rolloverEvent;
    }

    public void setRolloverEvent(String rolloverEvent) {
        this.rolloverEvent = rolloverEvent;
    }

    public String getMaximumChangeVelocity() {
        return maximumChangeVelocity;
    }

    public void setMaximumChangeVelocity(String maximumChangeVelocity) {
        this.maximumChangeVelocity = maximumChangeVelocity;
    }

    public String getMultipleEvents() {
        return multipleEvents;
    }

    public void setMultipleEvents(String multipleEvents) {
        this.multipleEvents = multipleEvents;
    }
}
