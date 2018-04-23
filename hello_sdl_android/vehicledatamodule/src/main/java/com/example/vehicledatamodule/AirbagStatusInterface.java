package com.example.vehicledatamodule;

import android.content.Context;

/**
 * Created by cvsmain on 3/21/18.
 */

public class AirbagStatusInterface {
    public AirbagStatusInterface(){};

    private String driverAirbagDeployed;
    private String driverSideAirbagDeployed;
    private String driverCurtainAirbagDeployed;
    private String passengerAirbagDeployed;
    private String passengerCurtainAirbagDeployed;
    private String driverKneeAirbagDeployed;
    private String passengerSideAirbagDeployed;
    private String passengerKneeAirbagDeployed;

    public String getDriverAirbagDeployed() {
        return driverAirbagDeployed;
    }

    public void setDriverAirbagDeployed(String driverAirbagDeployed) {
        this.driverAirbagDeployed = driverAirbagDeployed;
    }

    public String getDriverSideAirbagDeployed() {
        return driverSideAirbagDeployed;
    }

    public void setDriverSideAirbagDeployed(String driverSideAirbagDeployed) {
        this.driverSideAirbagDeployed = driverSideAirbagDeployed;
    }

    public String getDriverCurtainAirbagDeployed() {
        return driverCurtainAirbagDeployed;
    }

    public void setDriverCurtainAirbagDeployed(String driverCurtainAirbagDeployed) {
        this.driverCurtainAirbagDeployed = driverCurtainAirbagDeployed;
    }

    public String getPassengerAirbagDeployed() {
        return passengerAirbagDeployed;
    }

    public void setPassengerAirbagDeployed(String passengerAirbagDeployed) {
        this.passengerAirbagDeployed = passengerAirbagDeployed;
    }

    public String getPassengerCurtainAirbagDeployed() {
        return passengerCurtainAirbagDeployed;
    }

    public void setPassengerCurtainAirbagDeployed(String passengerCurtainAirbagDeployed) {
        this.passengerCurtainAirbagDeployed = passengerCurtainAirbagDeployed;
    }

    public String getDriverKneeAirbagDeployed() {
        return driverKneeAirbagDeployed;
    }

    public void setDriverKneeAirbagDeployed(String driverKneeAirbagDeployed) {
        this.driverKneeAirbagDeployed = driverKneeAirbagDeployed;
    }

    public String getPassengerSideAirbagDeployed() {
        return passengerSideAirbagDeployed;
    }

    public void setPassengerSideAirbagDeployed(String passengerSideAirbagDeployed) {
        this.passengerSideAirbagDeployed = passengerSideAirbagDeployed;
    }

    public String getPassengerKneeAirbagDeployed() {
        return passengerKneeAirbagDeployed;
    }

    public void setPassengerKneeAirbagDeployed(String passengerKneeAirbagDeployed) {
        this.passengerKneeAirbagDeployed = passengerKneeAirbagDeployed;
    }
}
