package com.exam.myapp;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private Map<String, Controller> mappings;

    public HandlerMapping() {
        mappings = new HashMap<>();
        mappings.put("/test.do", new HomeController());
    }

    public Controller getController(String path) {
        return mappings.get(path);
    }
}
