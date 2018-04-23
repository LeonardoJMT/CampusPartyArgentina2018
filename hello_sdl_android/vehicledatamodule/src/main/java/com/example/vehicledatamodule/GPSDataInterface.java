package com.example.vehicledatamodule;

import android.content.Context;


/**
 * Created by cvsmain on 3/20/18.
 */

public class GPSDataInterface {
    public GPSDataInterface(){}

    private Integer utcSeconds;
    private Integer utcMinutes;
    private Integer utcHour;
    private Integer utcDay;
    private Integer utcMonth;
    private Integer utcYear;
    private Double altitude;
    private Double heading;
    private Double longitudeDegrees;
    private Double latitudeDegrees;
    private Double speed;
    private Integer satellites;
    private String direction;

    public Integer getUtcDay() {
        return utcDay;
    }

    public void setUtcDay(Integer utcDay) {
        this.utcDay = utcDay;
    }

    public Integer getUtcMonth() {
        return utcMonth;
    }

    public void setUtcMonth(Integer utcMonth) {
        this.utcMonth = utcMonth;
    }


    public Double getLatitudeDegrees() {
        return latitudeDegrees;
    }

    public void setLatitudeDegrees(Double latitudeDegrees) {
        this.latitudeDegrees = latitudeDegrees;
    }

    public Integer getUtcYear() {
        return utcYear;
    }

    public void setUtcYear(Integer utcYear) {
        this.utcYear = utcYear;
    }

    public Integer getUtcHour() {
        return utcHour;
    }

    public void setUtcHour(Integer utcHour) {
        this.utcHour = utcHour;
    }

    public Integer getUtcMinute() {
        return utcMinutes;
    }

    public void setUtcMinute(Integer utcMinute) {
        this.utcMinutes = utcMinute;
    }

    public Integer getUtcSecond() {
        return utcSeconds;
    }

    public void setUtcSecond(Integer utcSecond) {
        this.utcSeconds = utcSecond;
    }

    public Integer getSatellites() {
        return satellites;
    }

    public void setSatellites(Integer satellites) {
        this.satellites = satellites;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getLongitudeDegrees() {
        return longitudeDegrees;
    }

    public void setLongitudeDegrees(Double longitudeDegrees) {
        this.longitudeDegrees = longitudeDegrees;
    }

    public Double getHeading() {
        return heading;
    }

    public void setHeading(Double heading) {
        this.heading = heading;
    }
}
