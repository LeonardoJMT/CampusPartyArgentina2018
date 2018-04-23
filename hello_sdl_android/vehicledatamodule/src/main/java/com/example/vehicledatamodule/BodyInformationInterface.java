package com.example.vehicledatamodule;

import android.content.Context;

/**
 * Created by cvsmain on 3/21/18.
 */

public class BodyInformationInterface {
    public BodyInformationInterface(){};

    private Boolean parkBrakeActive;
    private Boolean rearLeftDoorAjar;
    private Boolean rearRightDoorAjar;
    private Boolean driverDoorAjar;
    private Boolean passengerDoorAjar;
    private String ignitionStatusStable;
    private String ignitionStatus;

    public Boolean getParkBrakeActive() {
        return parkBrakeActive;
    }

    public void setParkBrakeActive(Boolean parkBrakeActive) {
        this.parkBrakeActive = parkBrakeActive;
    }

    public Boolean getRearLeftDoorAjar() {
        return rearLeftDoorAjar;
    }

    public void setRearLeftDoorAjar(Boolean rearLeftDoorAjar) {
        this.rearLeftDoorAjar = rearLeftDoorAjar;
    }

    public Boolean getRearRightDoorAjar() {
        return rearRightDoorAjar;
    }

    public void setRearRightDoorAjar(Boolean rearRightDoorAjar) {
        this.rearRightDoorAjar = rearRightDoorAjar;
    }

    public Boolean getDriverDoorAjar() {
        return driverDoorAjar;
    }

    public void setDriverDoorAjar(Boolean driverDoorAjar) {
        this.driverDoorAjar = driverDoorAjar;
    }

    public Boolean getPassangerDoorAjar() {
        return passengerDoorAjar;
    }

    public void setPassangerDoorAjar(Boolean passangerDoorAjar) {
        this.passengerDoorAjar = passangerDoorAjar;
    }

    public String getIgnitionStatusStable() {
        return ignitionStatusStable;
    }

    public void setIgnitionStatusStable(String ignitionStatusStable) {
        this.ignitionStatusStable = ignitionStatusStable;
    }

    public String getIgnitionStatus() {
        return ignitionStatus;
    }

    public void setIgnitionStatus(String ignitionStatus) {
        this.ignitionStatus = ignitionStatus;
    }
}
