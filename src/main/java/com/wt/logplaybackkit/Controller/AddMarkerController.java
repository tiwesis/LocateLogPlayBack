package com.wt.logplaybackkit.Controller;

import com.wt.logplaybackkit.Loghandle.LocateLog;
import com.wt.logplaybackkit.Loghandle.LocateLogHandle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class AddMarkerController {

    @GetMapping("/")
    public String getMainPage(){
        return "MainPage";
    }

    @GetMapping("/map")
    public String AddPOSMarkersOnMap(Model model){
        Logger logger = Logger.getLogger("AddPOSMarkersOnMapLog");
        LocateLogHandle logHandle = new LocateLogHandle(new File("/users/wt/locate_log/pos_20210910140209_uuid.log"));
        List<LocateLog> locateLogs = logHandle.turnLogLineToObjects();
        List<Float> posLogLatList = new ArrayList<>();
        List<Float> posLogLngList = new ArrayList<>();
        List<LocateLog> posLocateLogs = new ArrayList<>();
        for (LocateLog locateLog : locateLogs){
            if (locateLog.getType().equals("@POS")){
                posLocateLogs.add(locateLog);
                posLogLatList.add(locateLog.getLat());
                posLogLngList.add(locateLog.getLng());
            }
        }
        for (LocateLog log : posLocateLogs){
            logger.log(Level.INFO, log.toString());
        }
        logger.log(Level.INFO, "log end");
        model.addAttribute("posList", posLocateLogs);
        model.addAttribute("posLatList", posLogLatList);
        model.addAttribute("posLngList", posLogLngList);
        return "BaiduMap";
    }

}
