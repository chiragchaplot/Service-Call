package com.tseapp.paperbind.servicecall.GPS;

/**
 * Created by chiragchaplot on 4/7/15.
 */
import java.util.Date;

public class LogMessage {
    public final Date date;
    public final String message;

    public LogMessage(Date date, String message) {
        this.date = date;
        this.message = message;
    }
}