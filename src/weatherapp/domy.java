/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.Random;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 *
 * @author Samsu
 */
public class domy extends  Service {
Random nomo = new Random();
    @Override
    protected Task<Void> createTask() {
       return new Task<Void>() {

           @Override
           protected Void call() throws Exception {
               boolean mm=true;
               while (true) {
                   updateMessage(String.valueOf(nomo.nextInt(10)));
                   
               }
           }
       };
        

           

           
           

        };
    }
    
    

