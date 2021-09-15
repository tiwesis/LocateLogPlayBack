package com.wt.logplaybackkit.Loghandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LocateLogHandle {

    /*
    Class LocateLogHandle could turn file to log list
     */

    private File file;

    public LocateLogHandle(){
        Logger logger = Logger.getLogger("noParam constructor");
    }

    public LocateLogHandle(File file){
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<String[]> getLogsFromFile(){
        List<String[]> logLineList = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null){
                String[] logLine = tmp.split(" ");
                logLineList.add(logLine);
            }
        }catch (IOException ioException){
            Logger logger = Logger.getLogger("file not exist");
        }
        return logLineList;
    }

    public List<LocateLog> turnLogLineToObjects(){
        List<LocateLog> locateLogList = new ArrayList<>();
        List<String[]> logsFromFile = getLogsFromFile();
        for (String[] logLine : logsFromFile){
            LocateLog locateLog = new LocateLog();
            locateLog.setType(logLine[0]);
            locateLog.setTime(LocateLogUtils.timestampToDate(logLine[1]));
            //different type, add different other params
            switch (logLine[0]){
                case "@POS":
                    locateLog.setLng((float)Long.parseLong(logLine[4])/10000000);
                    locateLog.setLat((float)Long.parseLong(logLine[5])/10000000);
                    locateLog.setSpeed(Float.parseFloat(logLine[8]));
            }
            locateLogList.add(locateLog);
        }
        Logger logger = Logger.getLogger("turnToObjectLog");
        logger.log(Level.INFO, "turn to LogLine Success");
        return locateLogList;
    }

}
