/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import weatherapp.Model.Dashboard_Model;

/**
 *
 * @author Samsu
 */
public class clockTask extends Service {

    private boolean clockEnabled;
    private Date time;
    SimpleDateFormat format;

    public clockTask(Date time, SimpleDateFormat fmt) {
        this.time = time;
        this.format = fmt;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                clockEnabled = true;
                while (clockEnabled) {
                    time = new Date();
                    updateMessage(format.format(time));
                    System.out.println(format.format(time));
                    System.out.println("somecrap should be printed");
                    if (isCancelled()) {
                        clockEnabled = false;
                    }

//                            sometime.
                }
                return null;
            }
        };
    }

}
