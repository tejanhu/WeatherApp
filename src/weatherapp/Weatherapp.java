/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weatherapp;

import java.util.Observable;
import java.util.Observer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.action.Action;
import org.tbee.javafx.scene.layout.MigPane;
import weatherapp.Model.Dashboard_Model;
import weatherapp.Model.Menu_Model;
import weatherapp.Model.Settings_Model;
import weatherapp.Model.TrackWeather_Model;
import weatherapp.controller.Dashboard_controller;
import weatherapp.controller.Menu_controller;
import weatherapp.controller.Settings_controller;
import weatherapp.controller.TrackWeather_controller;
import weatherapp.view.DashboardLandscapeview;
import weatherapp.view.Dashboardview;
import weatherapp.view.DetailsLandscapeview;
import weatherapp.view.MenuLandscapeview;
import weatherapp.view.Menuview;
import weatherapp.view.OrientationObserver;
import weatherapp.view.Settingsview;
import weatherapp.view.TrackWeatherLandscapeview;
import weatherapp.view.TrackWeatherview;
import weatherapp.view.experimentView;

/**
 *
 * @author sm312
 */
public class Weatherapp extends Application implements OrientationObserver{
Dashboard_Model dashModel =  new Dashboard_Model();
Dashboardview dashView = new Dashboardview();
    TrackWeatherview trackView = new TrackWeatherview();
    TrackWeather_Model trackWeather_Model= new TrackWeather_Model();
Menuview menuView = new Menuview();
Menu_Model menuModel = new Menu_Model();
    StackPane root = new StackPane();
    Menu_controller menuController= new Menu_controller(menuModel, menuView, root);
    Scene scene = new Scene(root, 480, 320);
Stage mainStage ;    
    Settings_Model settingModel = new Settings_Model();
    Settingsview   settingView = new Settingsview();
Dashboard_controller dashController = new Dashboard_controller(dashModel, dashView,menuView,root,mainStage);

    @Override
    public void start(Stage primaryStage) {
//       
       mainStage=primaryStage;
        Button clicky = new Button("Click to go to new scene");
                        menuModel.setTrackWeatherView(trackView);
                        menuModel.setSettingsView(settingView);
            trackWeather_Model.setMenuView(menuView);
            settingView.setValy(100);
    Settings_controller settingController = new Settings_controller(settingModel, settingView, root);
    
    settingModel.attach(this);
    settingModel.attach(settingView);
    settingModel.attach(dashView);
    settingModel.attach(menuView);
    settingModel.attach(trackView);
    settingModel.attach(settingController);
    settingModel.attach(menuController);
    
    
            System.out.println("Valy in start is  :"+settingView.getValy());
            TrackWeather_controller trackWeather_controller = new TrackWeather_controller(trackWeather_Model,trackView,root);
                settingModel.attach(trackWeather_controller);
            settingModel.setMenuView(menuView);
        dashController.makeDashboardGoToMenu();
        trackWeather_controller.enableToSearchForLocation(trackView);
//        menuModel.se
//        setThebutton(clicky);
        root.getChildren().add((dashView.getView()));
        
        
        primaryStage.setScene(scene);
        primaryStage.resizableProperty().set(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void setThebutton(Button clicky) {
        clicky.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
//                trackWeatherLandcapeview = new TrackWeatherLandscapeview();
                root.getChildren().add(dashView);
            double width = root.getWidth();
            KeyFrame start = new KeyFrame(Duration.ZERO,
                    new KeyValue(dashView.translateXProperty(), width),
                    new KeyValue(clicky.translateXProperty(), 0));
            KeyFrame end = new KeyFrame(Duration.seconds(0.9),
                    new KeyValue(dashView.translateXProperty(), 0),
                    new KeyValue(clicky.translateXProperty(), -width));
            Timeline slide = new Timeline(start, end);
    
            slide.setOnFinished(e -> root.getChildren().remove(clicky));
            slide.play();
            }
            public TrackWeatherLandscapeview trackWeatherLandcapeview;
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

   
    public void update(boolean arg) {
        
        
        
        
        
        
        
        
        
        if (arg) {
//            scene = new Scene(root, 480, 320);
//             mainStage.setScene(scene);
             mainStage.setHeight(320);
             mainStage.setWidth(480);
        }
        else{
        
        mainStage.setScene(scene);
             mainStage.setHeight(480);
             mainStage.setWidth(320);
        }
    }
    
}
