package com.wt.logplaybackkit.Loghandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlEnumValue;

@Component("locateLog")
public class LocateLog extends Log {

    /*
    form a single string log line to a class LocateLog
    LocateLog types:
    @ACC
    @GYR
    @MAG
    @ELA
    @RTM
    @GRV
    @THM
    @BRO
    @GSV
    @NME
    @POS
    @PATH
    @M_PATH
    @ROAD
    @M_ROAD
    @M_GPS
    @RLR
    @RPR
    @NGM
     */


    @Value("none")
    private String type;
    //yyyy-MM-dd HH:mm:ss:SS
    @Value("2000:02:04:08:00:00")
    private String time;
    @Value("0.0")
    private float lng;
    @Value("0.0")
    private float lat;
    @Value("0.0")
    private float speed;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }



    public LocateLog(){

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocateLog(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LocateLog{" +
                "type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", speed=" + speed +
                '}';
    }
}
