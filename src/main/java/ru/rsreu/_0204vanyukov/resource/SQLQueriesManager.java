package ru.rsreu._0204vanyukov.resource;

import java.util.ResourceBundle;

public class SQLQueriesManager {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("SQLQueries");

    private SQLQueriesManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
