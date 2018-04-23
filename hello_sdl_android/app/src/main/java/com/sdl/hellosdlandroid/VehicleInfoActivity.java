package com.sdl.hellosdlandroid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TextView;
import com.example.vehicledatamodule.VehicleDataInterface;

/**
 * Created by leonardo on 22/04/18.
 */

public class VehicleInfoActivity extends Activity{
    private TextView txtDt, txtVin, txtPrndl, txtSpeed, txtRpm, txtFuelLevel, txtFuelLevel_State,
            txtOdometer, txtExternalTemperature, txtDriverBreaking, txtEngineTorque,
            txtLatitude, txtLongitude, txtAltitude, txtHeading, txtCompassDirection,
            txtLowBeamsOn, txtHighBeamsOn, txtAmbientLightSensorStatus,
            txtRightRear, txtLeftRear, txtRightFront, txtLeftFront, txtInnerRightRear, txtInnerLeftRear,
            txtPressureTelltale, txtDriverDoorAjar, txtPassengerDoorAjar, txtRearRightDoorAjar, txtRearLeftDoorAjar,
            txtIgnitionStatus, txtIgnitionStableStatus, txtParkBreakeActive, txtModel, txtModelYear;
    private Boolean defined = false;

    VehicleDataInterface VDReceiver = new VehicleDataInterface();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);

        initComponents();

        LocalBroadcastManager.getInstance(this).registerReceiver(
                VehicleDataReceiver, new IntentFilter("VehicleDataSent"));
    }

    private void defineLabels(VehicleDataInterface VehicleData){
        txtModel.setText(String.format("Model: %s", VehicleData.getModel()));
        txtModel.setText(String.format("Model Year: %s", VehicleData.getModelYear()));
        txtVin.setText(String.format("Vin: %s", VehicleData.getVin()));
        txtPrndl.setText(String.format("PRNDL: %s", VehicleData.getPRNDL()));
        txtSpeed.setText(String.format("Speed: %s", VehicleData.getSpeed()));
        txtRpm.setText(String.format("RPM: %s", VehicleData.getRpm()));
        txtFuelLevel.setText(String.format("Fuel Level: %s", VehicleData.getFuelLevel()));
        txtFuelLevel_State.setText(String.format("Fuel Level State: %s", VehicleData.getFuelLevel_State()));
        txtOdometer.setText(String.format("Odometer: %s", VehicleData.getOdometer()));
        txtExternalTemperature.setText(String.format("Ext. Temperature: %s", VehicleData.getExternalTemperature()));
        txtDriverBreaking.setText(String.format("Driver Breaking: %s", VehicleData.getDriverBreaking()));
        txtEngineTorque.setText(String.format("Eng. Torque: %s", VehicleData.getEngineTorque()));

        /* GPS */
        txtLatitude.setText(String.format("Latitude: %s", VehicleData.getLatitudeDegrees()));
        txtLongitude.setText(String.format("Longitude: %s", VehicleData.getLongitudeDegrees()));
        txtAltitude.setText(String.format("Altitude: %s", VehicleData.getAltitude()));
        txtHeading.setText(String.format("Heading: %s", VehicleData.getHeading()));
        txtCompassDirection.setText(String.format("Compass Direction: %s", VehicleData.getDirection()));

        /* Head Lamps */
        txtLowBeamsOn.setText(String.format("Low Beams On: %s", VehicleData.getLowBeamsOn()));
        txtHighBeamsOn.setText(String.format("High Beams On: %s", VehicleData.getHighBeamsOn()));
        txtAmbientLightSensorStatus.setText(String.format("Ambient Light Sensor: %s", VehicleData.getAmbientLightStatus()));

        /* Body Information */
        txtDriverDoorAjar.setText(String.format("Driver Door: %s", VehicleData.getDriverDoorAjar()));
        txtPassengerDoorAjar.setText(String.format("Passenger Door: %s", VehicleData.getPassengerDoorAjar()));
        txtRearRightDoorAjar.setText(String.format("Rear Right Door: %s", VehicleData.getRearRightDoorAjar()));
        txtRearLeftDoorAjar.setText(String.format("Rear Left Door: %s", VehicleData.getRearLeftDoorAjar()));
        txtIgnitionStatus.setText(String.format("Ignition Status: %s", VehicleData.getIgnitionStatus()));
        txtIgnitionStableStatus.setText(String.format("Ignition Status Stable: %s", VehicleData.getIgnitionStatusStable()));
        txtParkBreakeActive.setText(String.format("Park Breake Active: %s", VehicleData.getParkBrakeActive()));

        /* Tire Pressures */
        txtRightRear.setText(String.format("Right Rear: %s", VehicleData.getRightRearStatus()));
        txtLeftRear.setText(String.format("Left Rear: %s", VehicleData.getLeftRearStatus()));
        txtRightFront.setText(String.format("Right Front: %s", VehicleData.getRightFrontStatus()));
        txtLeftFront.setText(String.format("Left Front: %s", VehicleData.getLeftFrontStatus()));
        txtInnerRightRear.setText(String.format("Inner Right Rear: %s", VehicleData.getRightRearValue()));
        txtInnerLeftRear.setText(String.format("Inner Left Rear: %s", VehicleData.getLeftRearValue()));
    }

    private void initComponents(){
        txtModel = (TextView) findViewById(R.id.txtModel);
        txtModelYear = (TextView) findViewById(R.id.txtModelYear);
        txtDt =  (TextView) findViewById(R.id.txtDt);
        txtVin = (TextView) findViewById(R.id.txtVin);
        txtPrndl = (TextView) findViewById(R.id.txtPrndl);
        txtSpeed = (TextView) findViewById(R.id.txtSpeed);
        txtRpm = (TextView) findViewById(R.id.txtRpm);
        txtFuelLevel = (TextView) findViewById(R.id.txtFuelLevel);
        txtFuelLevel_State = (TextView) findViewById(R.id.txtFuelLevel_State);
        txtOdometer = (TextView) findViewById(R.id.txtOdometer);
        txtExternalTemperature = (TextView) findViewById(R.id.txtExternalTemperature);
        txtDriverBreaking = (TextView) findViewById(R.id.txtDriverBreaking);
        txtEngineTorque = (TextView) findViewById(R.id.txtEngineTorque);

        /* GPS */
        txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);
        txtAltitude = (TextView) findViewById(R.id.txtAltitude);
        txtHeading = (TextView) findViewById(R.id.txtHeading);
        txtCompassDirection = (TextView) findViewById(R.id.txtCompassDirection);

        /* Head Lamps */
        txtLowBeamsOn = (TextView) findViewById(R.id.txtLowBeamsOn);
        txtHighBeamsOn = (TextView) findViewById(R.id.txtHighBeamsOn);
        txtAmbientLightSensorStatus = (TextView) findViewById(R.id.txtAmbientLightSensorStatus);

        /* Body Information */
        txtDriverDoorAjar = (TextView) findViewById(R.id.txtDriverDoorAjar);
        txtPassengerDoorAjar = (TextView) findViewById(R.id.txtPassengerDoorAjar);
        txtRearRightDoorAjar = (TextView) findViewById(R.id.txtRearRightDoorAjar);
        txtRearLeftDoorAjar = (TextView) findViewById(R.id.txtRearLeftDoorAjar);
        txtIgnitionStatus = (TextView) findViewById(R.id.txtIgnitionStatus);
        txtIgnitionStableStatus = (TextView) findViewById(R.id.txtIgnitionStableStatus);
        txtParkBreakeActive = (TextView) findViewById(R.id.txtParkBreakeActive);

        /* Tire Pressures */
        txtRightRear = (TextView) findViewById(R.id.txtRightRear);
        txtLeftRear = (TextView) findViewById(R.id.txtLeftRear);
        txtRightFront = (TextView) findViewById(R.id.txtRightFront);
        txtLeftFront = (TextView) findViewById(R.id.txtLeftFront);
        txtInnerRightRear = (TextView) findViewById(R.id.txtInnerRightRear);
        txtInnerLeftRear = (TextView) findViewById(R.id.txtInnerLeftRear);
        txtPressureTelltale = (TextView) findViewById(R.id.txtPressureTelltale);
    }

    private BroadcastReceiver VehicleDataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            VDReceiver = intent.getParcelableExtra("VehicleData");
            defineLabels(VDReceiver);
        }
    };
}
