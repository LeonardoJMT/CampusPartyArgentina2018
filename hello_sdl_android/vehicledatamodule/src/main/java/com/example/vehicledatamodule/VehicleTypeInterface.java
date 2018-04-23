package com.example.vehicledatamodule;

import android.content.Context;

/**
 * Created by cvsmain on 3/21/18.
 */

public class VehicleTypeInterface {
    public VehicleTypeInterface(){};

    private String Make;
    private String Model;
    private String ModelYear;
    private String Trim;


    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getModelYear() {
        return ModelYear;
    }

    public void setModelYear(String modelYear) {
        ModelYear = modelYear;
    }

    public String getTrim() {
        return Trim;
    }

    public void setTrim(String trim) {
        Trim = trim;
    }
}
