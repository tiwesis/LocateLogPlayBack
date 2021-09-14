package com.wt.logplaybackkit.LogHandleTest;

import com.wt.logplaybackkit.Loghandle.LocateLog;
import com.wt.logplaybackkit.Loghandle.LocateLogHandle;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocateLogHandleTest {

    LocateLogHandle locateLogHandle = new LocateLogHandle();


    @Test
    public void testGetLocateLogsFromLogFile(){
        Logger logger = Logger.getGlobal();
        locateLogHandle.setFile(new File("/users/wt/locate_log/pos_20210910140209_uuid.log"));
        List<LocateLog> locateLogs = locateLogHandle.turnLogLineToObjects();
        for (LocateLog log : locateLogs){
            if (Objects.equals(log.getType(), "@POS"))
            logger.log(Level.INFO, log.toString());
        }

    }

}
