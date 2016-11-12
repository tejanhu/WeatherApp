/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import weatherapp.Model.Dashboard_Model;

/**
 *
 * @author Samsu
 */
public class weatherReadingsTask extends Service {
private boolean weatherReadingsEnabled;
public  StringProperty  currentTemp;
public  StringProperty  day2lowTemp;
public  StringProperty  day3lowTemp;
public  StringProperty  day2highTemp;
public  StringProperty  day3highTemp;

    public StringProperty getCurrentTemp() {
        return currentTemp;
    }
    Dashboard_Model model;

    public weatherReadingsTask(Dashboard_Model model) {
        this.model = model;
        currentTemp= new SimpleStringProperty("ss");
        weatherReadingsEnabled=true;
    }
    
    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                System.out.println("We get in here");
                while (weatherReadingsEnabled) {
                    System.out.println("The temperature is "+model.getCurrentTemp());
                    currentTemp.setValue(model.getCurrentTemp());
                }
                
                
                return null;
          
            }
            
        };
     
    }
    
}
