package org.example.util;

import java.util.ResourceBundle;

public class Config {

    public static String getProperties(String key) {
        ResourceBundle rb = ResourceBundle.getBundle("config");
        return rb.getString(key);
    }
}
