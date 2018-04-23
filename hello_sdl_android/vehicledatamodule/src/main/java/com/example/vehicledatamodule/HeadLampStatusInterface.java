package com.example.vehicledatamodule;

import android.content.Context;

/**
 * Created by cvsmain on 3/21/18.
 */

public class HeadLampStatusInterface {
    public HeadLampStatusInterface(){};

    private String AmbientLightStatus;
    private Boolean HighBeamsOn;
    private Boolean LowBeamsOn;

    public String getAmbientLightStatus() {
        return AmbientLightStatus;
    }

    public void setAmbientLightStatus(String ambientLightStatus) {
        AmbientLightStatus = ambientLightStatus;
    }

    public Boolean getHighBeamsOn() {
        return HighBeamsOn;
    }

    public void setHighBeamsOn(Boolean highBeamsOn) {
        HighBeamsOn = highBeamsOn;
    }

    public Boolean getLowBeamsOn() {
        return LowBeamsOn;
    }

    public void setLowBeamsOn(Boolean lowBeamsOn) {
        LowBeamsOn = lowBeamsOn;
    }
}
