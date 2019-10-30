package com.app.store.retail.discounts.app.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public
class RetailStoreDiscountLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

    static public void setup() throws IOException {

        // get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // suppress the logging output to the console
        Logger rootLogger = Logger.getLogger ("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        File file = new File("logs");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("logs Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date( );

        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("logs/"+dateFormat.format ( resultdate )+".txt");
        fileHTML = new FileHandler("logs/"+dateFormat.format ( resultdate )+".html");

        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        // create an HTML formatter
        formatterHTML = new RetailStoreDiscountLoggerHtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);
    }
}
