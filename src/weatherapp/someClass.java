/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import weatherapp.view.DashboardPortraitview;
import weatherapp.view.SettingsLandscapeview;
import weatherapp.view.SettingsPortraitview;
import weatherapp.view.TrackWeatherLandscapeview;
import weatherapp.view.TrackWeatherPortraitview;

/**
 *
 * @author Samsu
 */
public class someClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        
    
  
        
        Scene scene = new Scene(new DashboardPortraitview(), 320,480);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
