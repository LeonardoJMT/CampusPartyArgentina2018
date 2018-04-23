package com.example.vehicledatamodule;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

public class VehicleDataInterface implements Parcelable{
    public VehicleDataInterface(){}
    private int mData;

    /**
     * ArrayList of each object type.
     */
    public String name;

    private ArrayList<Double> SpeedDataArray = new ArrayList<Double>();
    private ArrayList<Integer> RpmDataArray = new ArrayList<Integer>();
    private ArrayList<String> PRNDLArray = new ArrayList<String>();
    private ArrayList<String> EngineTorqueDataArray = new ArrayList<String>();
    private ArrayList<String> TirePressureDataArray = new ArrayList<String>();
    private ArrayList<Integer> OdometerDataArray = new ArrayList<Integer>();
    private ArrayList<String> FuelLevelDataArray = new ArrayList<String>();
    private ArrayList<Double> FuelLevelDataArrayDouble = new ArrayList<Double>();
    private ArrayList<String> InstantFuelConsumptionDataArray = new ArrayList<String>();
    private ArrayList<Double> ExternalTemperatureArray = new ArrayList<Double>();
    private ArrayList<BodyInformationInterface> BodyInformationArray = new ArrayList<BodyInformationInterface>();
    private ArrayList<GPSDataInterface> GpsDataArray = new ArrayList<GPSDataInterface>();
    private ArrayList<TirePressureInterface> TirePressureArray = new ArrayList<TirePressureInterface>();
    private ArrayList<BeltStatusInterface> BeltStatusArray = new ArrayList<BeltStatusInterface>();
    private ArrayList<HeadLampStatusInterface> HeadLampStatusArray = new ArrayList<HeadLampStatusInterface>();
    private ArrayList<Double> AccPedalPositionArray = new ArrayList<Double>();
    private ArrayList<Double> SteeringWheelAngleArray = new ArrayList<Double>();
    private ArrayList<String> WiperStatusArray = new ArrayList<String>();
    private ArrayList<AirbagStatusInterface> AirbagStatusArray = new ArrayList<AirbagStatusInterface>();
    private ArrayList<EmergencyEventInterface> EmergencyEventArray = new ArrayList<EmergencyEventInterface>();
    private ArrayList<ClusterModeStatusInterface> ClusterModeStatusArray = new ArrayList<ClusterModeStatusInterface>();
    private ArrayList<MyKeyInterface> MyKeyArray = new ArrayList<MyKeyInterface>();

    /**
     * Individual declaration
     */

    
    private String ignitionStatusStable, ignitionStatus, driverBeltDeployed, passengerBeltDeployed, 
            passengerBuckleBelted, driverBuckleBelted, leftRow2BuckleBelted, passengerChildDetected, 
            rightRow2BuckleBelted, middleRow2BuckleBelted, middleRow3BuckleBelted, leftRow3BuckleBelted, 
            rightRow3BuckleBelted, leftRearInflatableBelted, rightRearInflatableBelted, middleRow1BeltDeployed,
            middleRow1BuckleBelted, driverAirbagDeployed, driverSideAirbagDeployed, driverCurtainAirbagDeployed, 
            passengerAirbagDeployed, passengerCurtainAirbagDeployed, driverKneeAirbagDeployed, passengerSideAirbagDeployed, 
            passengerKneeAirbagDeployed, direction, emergencyEventType, fuelCutoffStatus, rolloverEvent,
            maximumChangeVelocity, multipleEvents, powerModeQualificationStatus, carModeStatus, powerModeStatus,
            E911Override, AmbientLightStatus, Make, Model, ModelYear, Trim, leftFrontStatus, leftRearStatus,
            rightFrontStatus, rightRearStatus, PRNDL, Speed, Rpm, Vin, Odometer, FuelLevel, FuelLevel_State,
            DriverBreaking, leftFrontValue, leftRearValue, rightFrontValue, rightRearValue, EngineTorque,
            powerModeActive, parkBrakeActive, rearLeftDoorAjar, rearRightDoorAjar, driverDoorAjar,
            passengerDoorAjar, HighBeamsOn, LowBeamsOn, altitude, heading, longitudeDegrees, latitudeDegrees, 
            SpeedDouble, FuelLevelDouble, ExternalTemperature, utcSeconds, utcMinutes, utcHour, utcDay, 
            utcMonth, utcYear, satellites, OdometerInteger;


    /**
     * Interfaces that can be used
     */
    private BeltStatusInterface beltStatusInterface = new BeltStatusInterface();
    private BodyInformationInterface bodyInformationInterface = new BodyInformationInterface();
    private GPSDataInterface gpsDataInterface = new GPSDataInterface();
    private HeadLampStatusInterface headLampStatusInterface = new HeadLampStatusInterface();
    private TirePressureInterface tirePressureInterface = new TirePressureInterface();
    private VehicleTypeInterface vehicleTypeInterface = new VehicleTypeInterface();
    private AirbagStatusInterface airbagStatusInterface = new AirbagStatusInterface();
    private EmergencyEventInterface emergencyEventInterface = new EmergencyEventInterface();
    private ClusterModeStatusInterface clusterModeStatusInterface = new ClusterModeStatusInterface();
    private MyKeyInterface myKeyInterface = new MyKeyInterface();

    /** Getters and Setters **/

    public ArrayList<Double> getSpeedDataArray() {
        return SpeedDataArray;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSpeedDataArray(ArrayList<Double> speedDataArray) { SpeedDataArray = speedDataArray; }

    public ArrayList<Integer> getRpmDataArray() {
        return RpmDataArray;
    }

    public void setRpmDataArray(ArrayList<Integer> rpmDataArray) {
        RpmDataArray = rpmDataArray;
    }

    public ArrayList<String> getEngineTorqueDataArray() {
        return EngineTorqueDataArray;
    }

    public void setEngineTorqueDataArray(ArrayList<String> engineTorqueDataArray) { EngineTorqueDataArray = engineTorqueDataArray; }

    public ArrayList<String> getTirePressureDataArray() {
        return TirePressureDataArray;
    }

    public void setTirePressureDataArray(ArrayList<String> tirePressureDataArray) { this.TirePressureDataArray = tirePressureDataArray; }

    public ArrayList<Integer> getOdometerDataArray() {
        return OdometerDataArray;
    }

    public void setOdometerDataArray(ArrayList<Integer> odometerDataArray) { OdometerDataArray = odometerDataArray; }

    public ArrayList<String> getFuelLevelDataArray() {
        return FuelLevelDataArray;
    }

    public void setFuelLevelDataArray(ArrayList<String> fuelLevelDataArray) { this.FuelLevelDataArray = fuelLevelDataArray; }

    public ArrayList<String> getInstantFuelConsumptionDataArray() { return InstantFuelConsumptionDataArray; }

    public void setConsumptionDataArray(ArrayList<String> consumptionDataArray) { InstantFuelConsumptionDataArray = consumptionDataArray; }

    public ArrayList<GPSDataInterface> getGpsDataArray() {
        return GpsDataArray;
    }

    public void setGpsDataArray(ArrayList<GPSDataInterface> gpsDataArray) { this.GpsDataArray = gpsDataArray; }

    public ArrayList<Double> getExternalTemperatureArray() {
        return ExternalTemperatureArray;
    }

    public void setExternalTemperatureArray(ArrayList<Double> externalTemperatureArray) { ExternalTemperatureArray = externalTemperatureArray; }

    public ArrayList<TirePressureInterface> getTirePressureArray() {
        return TirePressureArray;
    }

    public void setTirePressureArray(ArrayList<TirePressureInterface> tirePressureArray) { TirePressureArray = tirePressureArray; }

    public ArrayList<String> getPRNDLArray() {
        return PRNDLArray;
    }

    public void setPRNDLArray(ArrayList<String> PRNDLArray) {
        this.PRNDLArray = PRNDLArray;
    }

    public ArrayList<BodyInformationInterface> getBodyInformationArray() { return BodyInformationArray; }

    public void setBodyInformationArray(ArrayList<BodyInformationInterface> bodyInformationArray) { BodyInformationArray = bodyInformationArray; }

    public ArrayList<BeltStatusInterface> getBeltStatusArray() {
        return BeltStatusArray;
    }

    public void setBeltStatusArray(ArrayList<BeltStatusInterface> beltStatusArray) { BeltStatusArray = beltStatusArray; }

    public ArrayList<HeadLampStatusInterface> getHeadLampStatusArray() { return HeadLampStatusArray; }

    public void setHeadLampStatusArray(ArrayList<HeadLampStatusInterface> headLampStatusArray) { HeadLampStatusArray = headLampStatusArray; }

    public ArrayList<Double> getAccPedalPositionArray() {
        return AccPedalPositionArray;
    }

    public void setAccPedalPositionArray(ArrayList<Double> accPedalPositionArray) { AccPedalPositionArray = accPedalPositionArray; }

    public ArrayList<Double> getSteeringWheelAngleArray() {
        return SteeringWheelAngleArray;
    }

    public void setSteeringWheelAngleArray(ArrayList<Double> steeringWheelAngleArray) { SteeringWheelAngleArray = steeringWheelAngleArray; }

    public VehicleTypeInterface getVehicleTypeInterface() {
        return vehicleTypeInterface;
    }

    public void setVehicleTypeInterface(VehicleTypeInterface vehicleTypeInterface) { this.vehicleTypeInterface = vehicleTypeInterface; }

    public GPSDataInterface getGpsDataInterface() {
        return gpsDataInterface;
    }

    public void setGpsDataInterface(GPSDataInterface gpsDataInterface) { this.gpsDataInterface = gpsDataInterface; }

    public BeltStatusInterface getBeltStatusInterface() {
        return beltStatusInterface;
    }

    public void setBeltStatusInterface(BeltStatusInterface beltStatusInterface) { this.beltStatusInterface = beltStatusInterface; }

    public BodyInformationInterface getBodyInformationInterface() { return bodyInformationInterface; }

    public void setBodyInformationInterface(BodyInformationInterface bodyInformationInterface) { this.bodyInformationInterface = bodyInformationInterface; }

    public HeadLampStatusInterface getHeadLampStatusInterface() {
        return headLampStatusInterface;
    }

    public void setHeadLampStatusInterface(HeadLampStatusInterface headLampStatusInterface) { this.headLampStatusInterface = headLampStatusInterface; }

    public TirePressureInterface getTirePressureInterface() {
        return tirePressureInterface;
    }

    public void setTirePressureInterface(TirePressureInterface tirePressureInterface) { this.tirePressureInterface = tirePressureInterface; }

    public ArrayList<String> getWiperStatusArray() {
        return WiperStatusArray;
    }

    public void setWiperStatusArray(ArrayList<String> wiperStatusArray) { WiperStatusArray = wiperStatusArray; }

    public ArrayList<AirbagStatusInterface> getAirbagStatusArray() {
        return AirbagStatusArray;
    }

    public void setAirbagStatusArray(ArrayList<AirbagStatusInterface> airbagStatusArray) { AirbagStatusArray = airbagStatusArray; }

    public AirbagStatusInterface getAirbagStatusInterface() {
        return airbagStatusInterface;
    }

    public void setAirbagStatusInterface(AirbagStatusInterface airbagStatusInterface) { this.airbagStatusInterface = airbagStatusInterface; }

    public EmergencyEventInterface getEmergencyEventInterface() {
        return emergencyEventInterface;
    }

    public void setEmergencyEventInterface(EmergencyEventInterface emergencyEventInterface) { this.emergencyEventInterface = emergencyEventInterface; }

    public ArrayList<EmergencyEventInterface> getEmergencyEventArray() { return EmergencyEventArray; }

    public void setEmergencyEventArray(ArrayList<EmergencyEventInterface> emergencyEventArray) { EmergencyEventArray = emergencyEventArray; }

    public ArrayList<ClusterModeStatusInterface> getClusterModeStatusArray() { return ClusterModeStatusArray; }

    public void setClusterModeStatusArray(ArrayList<ClusterModeStatusInterface> clusterModeStatusArray) { ClusterModeStatusArray = clusterModeStatusArray; }

    public ClusterModeStatusInterface getClusterModeStatusInterface() { return clusterModeStatusInterface; }

    public void setClusterModeStatusInterface(ClusterModeStatusInterface clusterModeStatusInterface) { this.clusterModeStatusInterface = clusterModeStatusInterface; }

    public ArrayList<MyKeyInterface> getMyKeyArray() {
        return MyKeyArray;
    }

    public void setMyKeyArray(ArrayList<MyKeyInterface> myKeyArray) {
        MyKeyArray = myKeyArray;
    }

    public MyKeyInterface getMyKeyInterface() {
        return myKeyInterface;
    }

    public void setMyKeyInterface(MyKeyInterface myKeyInterface) { this.myKeyInterface = myKeyInterface; }

    public ArrayList<Double> getFuelLevelDataArrayDouble() {
        return FuelLevelDataArrayDouble;
    }

    public void setFuelLevelDataArrayDouble(ArrayList<Double> fuelLevelDataArrayDouble) { FuelLevelDataArrayDouble = fuelLevelDataArrayDouble; }

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

    public String getLeftFrontStatus() {
        return leftFrontStatus;
    }

    public void setLeftFrontStatus(String leftFrontStatus) { this.leftFrontStatus = leftFrontStatus; }

    public String getLeftRearStatus() {
        return leftRearStatus;
    }

    public void setLeftRearStatus(String leftRearStatus) {
        this.leftRearStatus = leftRearStatus;
    }

    public String getRightFrontStatus() {
        return rightFrontStatus;
    }

    public void setRightFrontStatus(String rightFrontStatus) { this.rightFrontStatus = rightFrontStatus; }

    public String getRightRearStatus() {
        return rightRearStatus;
    }

    public void setRightRearStatus(String rightRearStatus) { this.rightRearStatus = rightRearStatus; }

    public String getLeftFrontValue() {
        return leftFrontValue;
    }

    public void setLeftFrontValue(String leftFrontValue) {
        this.leftFrontValue = leftFrontValue;
    }

    public String getLeftRearValue() {
        return leftRearValue;
    }

    public void setLeftRearValue(String leftRearValue) {
        this.leftRearValue = leftRearValue;
    }

    public String getRightFrontValue() {
        return rightFrontValue;
    }

    public void setRightFrontValue(String rightFrontValue) { this.rightFrontValue = rightFrontValue; }

    public String getRightRearValue() {
        return rightRearValue;
    }

    public void setRightRearValue(String rightRearValue) { this.rightRearValue = rightRearValue; }

    public String getE911Override() {
        return E911Override;
    }

    public void setE911Override(String e911Override) {
        E911Override = e911Override;
    }

    public String getAmbientLightStatus() {
        return AmbientLightStatus;
    }

    public void setAmbientLightStatus(String ambientLightStatus) { AmbientLightStatus = ambientLightStatus; }
    
    public String getHighBeamsOn() {
        return HighBeamsOn;
    }

    public void setHighBeamsOn(String highBeamsOn) {
        HighBeamsOn = highBeamsOn;
    }

    public String getLowBeamsOn() {
        return LowBeamsOn;
    }

    public void setLowBeamsOn(String lowBeamsOn) {
        LowBeamsOn = lowBeamsOn;
    }

    public String getUtcSeconds() {
        return utcSeconds;
    }

    public void setUtcSeconds(String utcSeconds) {
        this.utcSeconds = utcSeconds;
    }

    public String getUtcMinutes() {
        return utcMinutes;
    }

    public void setUtcMinutes(String utcMinutes) {
        this.utcMinutes = utcMinutes;
    }

    public String getUtcHour() {
        return utcHour;
    }

    public void setUtcHour(String utcHour) {
        this.utcHour = utcHour;
    }

    public String getIgnitionStatusStable() {
        return ignitionStatusStable;
    }

    public void setIgnitionStatusStable(String ignitionStatusStable) { this.ignitionStatusStable = ignitionStatusStable; }

    public String getIgnitionStatus() {
        return ignitionStatus;
    }

    public void setIgnitionStatus(String ignitionStatus) {
        this.ignitionStatus = ignitionStatus;
    }

    public String getDriverBeltDeployed() {
        return driverBeltDeployed;
    }

    public void setDriverBeltDeployed(String driverBeltDeployed) { this.driverBeltDeployed = driverBeltDeployed; }

    public String getPassengerBeltDeployed() {
        return passengerBeltDeployed;
    }

    public void setPassengerBeltDeployed(String passengerBeltDeployed) { this.passengerBeltDeployed = passengerBeltDeployed; }

    public String getPassengerBuckleBelted() {
        return passengerBuckleBelted;
    }

    public void setPassengerBuckleBelted(String passengerBuckleBelted) { this.passengerBuckleBelted = passengerBuckleBelted; }

    public String getDriverBuckleBelted() {
        return driverBuckleBelted;
    }

    public void setDriverBuckleBelted(String driverBuckleBelted) { this.driverBuckleBelted = driverBuckleBelted; }

    public String getLeftRow2BuckleBelted() {
        return leftRow2BuckleBelted;
    }

    public void setLeftRow2BuckleBelted(String leftRow2BuckleBelted) { this.leftRow2BuckleBelted = leftRow2BuckleBelted; }

    public String getPassengerChildDetected() {
        return passengerChildDetected;
    }

    public void setPassengerChildDetected(String passengerChildDetected) { this.passengerChildDetected = passengerChildDetected; }

    public String getRightRow2BuckleBelted() {
        return rightRow2BuckleBelted;
    }

    public void setRightRow2BuckleBelted(String rightRow2BuckleBelted) { this.rightRow2BuckleBelted = rightRow2BuckleBelted; }

    public String getMiddleRow2BuckleBelted() {
        return middleRow2BuckleBelted;
    }

    public void setMiddleRow2BuckleBelted(String middleRow2BuckleBelted) { this.middleRow2BuckleBelted = middleRow2BuckleBelted; }

    public String getMiddleRow3BuckleBelted() {
        return middleRow3BuckleBelted;
    }

    public void setMiddleRow3BuckleBelted(String middleRow3BuckleBelted) { this.middleRow3BuckleBelted = middleRow3BuckleBelted; }

    public String getLeftRow3BuckleBelted() {
        return leftRow3BuckleBelted;
    }

    public void setLeftRow3BuckleBelted(String leftRow3BuckleBelted) { this.leftRow3BuckleBelted = leftRow3BuckleBelted; }

    public String getRightRow3BuckleBelted() {
        return rightRow3BuckleBelted;
    }

    public void setRightRow3BuckleBelted(String rightRow3BuckleBelted) { this.rightRow3BuckleBelted = rightRow3BuckleBelted; }

    public String getLeftRearInflatableBelted() {
        return leftRearInflatableBelted;
    }

    public void setLeftRearInflatableBelted(String leftRearInflatableBelted) { this.leftRearInflatableBelted = leftRearInflatableBelted; }

    public String getRightRearInflatableBelted() {
        return rightRearInflatableBelted;
    }

    public void setRightRearInflatableBelted(String rightRearInflatableBelted) { this.rightRearInflatableBelted = rightRearInflatableBelted; }

    public String getMiddleRow1BeltDeployed() {
        return middleRow1BeltDeployed;
    }

    public void setMiddleRow1BeltDeployed(String middleRow1BeltDeployed) { this.middleRow1BeltDeployed = middleRow1BeltDeployed; }

    public String getMiddleRow1BuckleBelted() {
        return middleRow1BuckleBelted;
    }

    public void setMiddleRow1BuckleBelted(String middleRow1BuckleBelted) { this.middleRow1BuckleBelted = middleRow1BuckleBelted; }

    public String getDriverAirbagDeployed() {
        return driverAirbagDeployed;
    }

    public void setDriverAirbagDeployed(String driverAirbagDeployed) { this.driverAirbagDeployed = driverAirbagDeployed; }

    public String getDriverSideAirbagDeployed() {
        return driverSideAirbagDeployed;
    }

    public void setDriverSideAirbagDeployed(String driverSideAirbagDeployed) { this.driverSideAirbagDeployed = driverSideAirbagDeployed; }

    public String getDriverCurtainAirbagDeployed() {
        return driverCurtainAirbagDeployed;
    }

    public void setDriverCurtainAirbagDeployed(String driverCurtainAirbagDeployed) { this.driverCurtainAirbagDeployed = driverCurtainAirbagDeployed; }

    public String getPassengerAirbagDeployed() {
        return passengerAirbagDeployed;
    }

    public void setPassengerAirbagDeployed(String passengerAirbagDeployed) { this.passengerAirbagDeployed = passengerAirbagDeployed; }

    public String getPassengerCurtainAirbagDeployed() {
        return passengerCurtainAirbagDeployed;
    }

    public void setPassengerCurtainAirbagDeployed(String passengerCurtainAirbagDeployed) { this.passengerCurtainAirbagDeployed = passengerCurtainAirbagDeployed; }

    public String getDriverKneeAirbagDeployed() {
        return driverKneeAirbagDeployed;
    }

    public void setDriverKneeAirbagDeployed(String driverKneeAirbagDeployed) { this.driverKneeAirbagDeployed = driverKneeAirbagDeployed; }

    public String getPassengerSideAirbagDeployed() {
        return passengerSideAirbagDeployed;
    }

    public void setPassengerSideAirbagDeployed(String passengerSideAirbagDeployed) { this.passengerSideAirbagDeployed = passengerSideAirbagDeployed; }

    public String getPassengerKneeAirbagDeployed() {
        return passengerKneeAirbagDeployed;
    }

    public void setPassengerKneeAirbagDeployed(String passengerKneeAirbagDeployed) { this.passengerKneeAirbagDeployed = passengerKneeAirbagDeployed; }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEmergencyEventType() {
        return emergencyEventType;
    }

    public void setEmergencyEventType(String emergencyEventType) { this.emergencyEventType = emergencyEventType; }

    public String getFuelCutoffStatus() {
        return fuelCutoffStatus;
    }

    public void setFuelCutoffStatus(String fuelCutoffStatus) { this.fuelCutoffStatus = fuelCutoffStatus; }

    public String getRolloverEvent() {
        return rolloverEvent;
    }

    public void setRolloverEvent(String rolloverEvent) {
        this.rolloverEvent = rolloverEvent;
    }

    public String getMaximumChangeVelocity() {
        return maximumChangeVelocity;
    }

    public void setMaximumChangeVelocity(String maximumChangeVelocity) { this.maximumChangeVelocity = maximumChangeVelocity; }

    public String getMultipleEvents() {
        return multipleEvents;
    }

    public void setMultipleEvents(String multipleEvents) {
        this.multipleEvents = multipleEvents;
    }

    public String getPowerModeQualificationStatus() {
        return powerModeQualificationStatus;
    }

    public void setPowerModeQualificationStatus(String powerModeQualificationStatus) { this.powerModeQualificationStatus = powerModeQualificationStatus; }

    public String getCarModeStatus() {
        return carModeStatus;
    }

    public void setCarModeStatus(String carModeStatus) {
        this.carModeStatus = carModeStatus;
    }

    public String getPowerModeStatus() {
        return powerModeStatus;
    }

    public void setPowerModeStatus(String powerModeStatus) { this.powerModeStatus = powerModeStatus; }

    public String getUtcDay() {
        return utcDay;
    }

    public void setUtcDay(String utcDay) {
        this.utcDay = utcDay;
    }

    public String getUtcMonth() {
        return utcMonth;
    }

    public void setUtcMonth(String utcMonth) {
        this.utcMonth = utcMonth;
    }

    public String getUtcYear() {
        return utcYear;
    }

    public void setUtcYear(String utcYear) {
        this.utcYear = utcYear;
    }

    public String getSatellites() {
        return satellites;
    }

    public void setSatellites(String satellites) {
        this.satellites = satellites;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getLongitudeDegrees() {
        return longitudeDegrees;
    }

    public void setLongitudeDegrees(String longitudeDegrees) { this.longitudeDegrees = longitudeDegrees; }

    public String getLatitudeDegrees() {
        return latitudeDegrees;
    }

    public void setLatitudeDegrees(String latitudeDegrees) { this.latitudeDegrees = latitudeDegrees; }

    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String Speed) {
        this.Speed = Speed;
    }

    public String getPowerModeActive() {
        return powerModeActive;
    }

    public void setPowerModeActive(String powerModeActive) { this.powerModeActive = powerModeActive; }

    public String getParkBrakeActive() {
        return parkBrakeActive;
    }

    public void setParkBrakeActive(String parkBrakeActive) { this.parkBrakeActive = parkBrakeActive; }

    public String getRearLeftDoorAjar() {
        return rearLeftDoorAjar;
    }

    public void setRearLeftDoorAjar(String rearLeftDoorAjar) { this.rearLeftDoorAjar = rearLeftDoorAjar; }

    public String getRearRightDoorAjar() {
        return rearRightDoorAjar;
    }

    public void setRearRightDoorAjar(String rearRightDoorAjar) { this.rearRightDoorAjar = rearRightDoorAjar; }

    public String getDriverDoorAjar() {
        return driverDoorAjar;
    }

    public void setDriverDoorAjar(String driverDoorAjar) {
        this.driverDoorAjar = driverDoorAjar;
    }

    public String getPassengerDoorAjar() {
        return passengerDoorAjar;
    }

    public void setPassengerDoorAjar(String passengerDoorAjar) { this.passengerDoorAjar = passengerDoorAjar; }

    public String getPRNDL() {
        return PRNDL;
    }

    public void setPRNDL(String PRNDL) {
        this.PRNDL = PRNDL;
    }

    public String getRpm() {
        return Rpm;
    }

    public void setRpm(String rpm) {
        Rpm = rpm;
    }

    public String getSpeedDouble() {
        return SpeedDouble;
    }

    public void setSpeedDouble(String speedDouble) {
        SpeedDouble = speedDouble;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getOdometer() {
        return Odometer;
    }

    public void setOdometer(String odometer) {
        Odometer = odometer;
    }

    public String getOdometerInteger() {
        return OdometerInteger;
    }

    public void setOdometerInteger(String odometerInteger) {
        OdometerInteger = odometerInteger;
    }

    public String getFuelLevelDouble() {
        return FuelLevelDouble;
    }

    public void setFuelLevelDouble(String fuelLevelDouble) {
        FuelLevelDouble = fuelLevelDouble;
    }

    public String getFuelLevel() {
        return FuelLevel;
    }

    public void setFuelLevel(String fuelLevel) {
        FuelLevel = fuelLevel;
    }

    public String getFuelLevel_State() {
        return FuelLevel_State;
    }

    public void setFuelLevel_State(String fuelLevel_State) {
        FuelLevel_State = fuelLevel_State;
    }

    public String getExternalTemperature() {
        return ExternalTemperature;
    }

    public void setExternalTemperature(String externalTemperature) { ExternalTemperature = externalTemperature; }

    public String getDriverBreaking() {
        return DriverBreaking;
    }

    public void setDriverBreaking(String driverBreaking) {
        DriverBreaking = driverBreaking;
    }

    public String getEngineTorque() {
        return EngineTorque;
    }

    public void setEngineTorque(String engineTorque) {
        EngineTorque = engineTorque;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<VehicleDataInterface> CREATOR = new Parcelable.Creator<VehicleDataInterface>() {
        public VehicleDataInterface createFromParcel(Parcel in) {
            return new VehicleDataInterface(in);
        }

        public VehicleDataInterface[] newArray(int size) {
            return new VehicleDataInterface[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private VehicleDataInterface(Parcel in) {
        mData = in.readInt();
    }
}
