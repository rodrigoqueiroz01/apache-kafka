package br.com.udemy.strconsumer.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstantsUtil {

    public static void log4j(Class<?> clazz, Level level, String message) {
        Logger logger = LogManager.getLogger(clazz);
        logger.log(level, message);
    }

}
