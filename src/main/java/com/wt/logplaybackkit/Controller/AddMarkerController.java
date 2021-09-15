package com.wt.logplaybackkit.Controller;

import com.wt.logplaybackkit.Loghandle.LocateLog;
import com.wt.logplaybackkit.Loghandle.LocateLogHandle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class AddMarkerController {

    @GetMapping(value = "/")
    public String getMainPage(){
        return "MainPage";
    }

    @PostMapping(value = "/")
    public String postMainPage(@RequestParam("file") File file){
        Logger uploadFileLog = Logger.getLogger("uploadFileLog");
        uploadFileLog.log(Level.INFO, "upload done");
        return "MainPage";
    }

    @GetMapping(value = "/map")
    public String AddPOSMarkersOnMap(Model model){
        Logger logger = Logger.getLogger("AddPOSMarkersOnMapLog");
        LocateLogHandle logHandle = new LocateLogHandle(new File("/users/wt/locate_log/pos_20210908153839_uuid.log"));
        List<LocateLog> locateLogs = logHandle.turnLogLineToObjects();
        List<Float> posLogLatList = new ArrayList<>();
        List<Float> posLogLngList = new ArrayList<>();
        List<Float> posLogSpeedList = new ArrayList<>();
        List<LocateLog> posLocateLogs = new ArrayList<>();
        for (LocateLog locateLog : locateLogs){
            if (locateLog.getType().equals("@POS")){
                posLocateLogs.add(locateLog);
                posLogLatList.add(locateLog.getLat());
                posLogLngList.add(locateLog.getLng());
                posLogSpeedList.add(locateLog.getSpeed());
            }
        }
        for (LocateLog log : posLocateLogs){
            logger.log(Level.INFO, log.toString());
        }
        logger.log(Level.INFO, "log end");
        model.addAttribute("posList", posLocateLogs);
        model.addAttribute("posLatList", posLogLatList);
        model.addAttribute("posLngList", posLogLngList);
        model.addAttribute("posSpeedList", posLogSpeedList);
        return "BaiduMap";
    }

}
