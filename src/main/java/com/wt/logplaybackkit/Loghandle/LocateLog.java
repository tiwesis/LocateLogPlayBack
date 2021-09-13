package com.wt.logplaybackkit.Loghandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    public LocateLog(){

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


}
