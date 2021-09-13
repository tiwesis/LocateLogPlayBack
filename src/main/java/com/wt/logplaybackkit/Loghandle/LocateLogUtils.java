package com.wt.logplaybackkit.Loghandle;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LocateLogUtils {

    /*
    some utils to handle LocateLog
     */

    public static String timestampToDate(String timeStamp){
        /*
        refer "DateFormatSymbols" Class
        SS: ms
        ss: s
         */
        String format = "yyyy-MM-dd HH:mm:ss:SS";
        Date date = new Date(Long.parseLong(timeStamp));
        return new SimpleDateFormat(format).format(date);
    }

}
