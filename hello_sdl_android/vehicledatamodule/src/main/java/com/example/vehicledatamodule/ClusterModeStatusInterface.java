package com.example.vehicledatamodule;

import android.content.Context;

/**
 * Created by cvsmain on 3/21/18.
 */

public class ClusterModeStatusInterface {
    public ClusterModeStatusInterface(){};

    private Boolean powerModeActive;
    private String powerModeQualificationStatus;
    private String carModeStatus;
    private String powerModeStatus;

    public Boolean getPowerModeActive() {
        return powerModeActive;
    }

    public void setPowerModeActive(Boolean powerModeActive) {
        this.powerModeActive = powerModeActive;
    }

    public String getPowerModeQualificationStatus() {
        return powerModeQualificationStatus;
    }

    public void setPowerModeQualificationStatus(String powerModeQualificationStatus) {
        this.powerModeQualificationStatus = powerModeQualificationStatus;
    }

    public String getCarModeStatus() {
        return carModeStatus;
    }

    public void setCarModeStatus(String carModeStatus) {
        this.carModeStatus = carModeStatus;
    }

    public String getPowerModeStatus() {
        return powerModeStatus;
    }

    public void setPowerModeStatus(String powerModeStatus) {
        this.powerModeStatus = powerModeStatus;
    }
}
