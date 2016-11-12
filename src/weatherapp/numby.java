/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.Random;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Samsu
 */
public class numby extends Service <Integer> {
    IntegerProperty somint = new SimpleIntegerProperty(30);
    IntegerProperty crap = new SimpleIntegerProperty(30);
      ArrayList<String> styley = new ArrayList<String>();
     StringProperty path = new SimpleStringProperty();
     Label gg;
     
     ObjectProperty<Image> vv;
    StackPane stacky;

   private List<Observer> observers = new ArrayList<Observer>();
    public numby(StackPane stacky) {
        this.stacky = stacky;
        
    }

    
    
   Random nomo = new Random();
   Random nomo2 = new Random();
    @Override
    protected Task createTask() {
         styley.add("cc.css");
         styley.add("gg.css");
        return new Task() {

            

            @Override
            protected Integer call() throws Exception {
                boolean kk=true;
                while (kk) {
                somint.setValue(nomo.nextInt(200));
                crap.setValue(nomo2.nextInt(400));
//                    notifyAllObservers("This is for label 1  "+nomo.nextInt(5000),"This is for label 2  "+nomo.nextInt(300));
                    System.out.println("Something is happening");
 
                    System.out.println("This is someint  "+somint.getValue());
                    if (somint.get()==1) {
                        path = new SimpleStringProperty();
                        System.out.println("We set the stylesheet to change"+styley.get(0));
                        path.setValue(styley.get(0));

                    }
                    else{
                        System.out.println("The stylesheet should be here aswell "+styley.get(1));
                        path = new SimpleStringProperty();
                        path.setValue(styley.get(1));
                        
//                        vv.setValue(new Image("weatherapp/WL.jpg"));
                        
//                        stacky.getStylesheets().add(numby.class.getResource("gg.css").toExternalForm());
//                        stacky.setStyle("-fx-background-color:orange");
//                        Thread.sleep(20);
                    }
                
//                    Thread.sleep(1000);
                    
                }
                System.out.println("We get in here");
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                    }
//                });
                
//                System.out.println(nomo.nextInt(10));
                System.out.println("We finish");
                return null;
            }
        };
     
        
       

     
        
    }
    public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(String label1,String label2){
      for (Observer observer : observers) {
         observer.update(label1,label2);
      }
}
}