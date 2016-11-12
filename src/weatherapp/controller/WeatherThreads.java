/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.controller;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Samsu
 */
public class WeatherThreads implements ThreadFactory {
    public String name;

    public WeatherThreads(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
     Thread weatherThread = new Thread(r, name);
        weatherThread.setDaemon(true);
        return weatherThread;
    }
    
}
