package com.wt.logplaybackkit.Loghandle;

import org.springframework.stereotype.Component;

@Component
public class Log {

    private String type;

    public Log() {
    }

    public Log(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
