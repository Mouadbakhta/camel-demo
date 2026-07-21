package com.example.cameldemo;

import com.example.cameldemo.route.FileIntakeRouteFile;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class TestRoute {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        FileIntakeRouteFile file = new FileIntakeRouteFile();
        camelContext.addRoutes(file);
        while (true){
            camelContext.start();
        }
    }
}
