/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Samsu
 */
public class someThread implements ThreadFactory {
public String name;

    public someThread(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread somethread = new Thread(r, name);
        somethread.setDaemon(true);
        return somethread;
    }
    
}
