/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.controller;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.dialog.Dialogs;
import weatherapp.Model.Dashboard_Model;
import weatherapp.clockTask;
import weatherapp.view.DashboardInteface;
import weatherapp.view.DashboardLandscapeview;
import weatherapp.view.DashboardPortraitview;
import weatherapp.view.Dashboardview;
import weatherapp.view.MenuLandscapeview;
import weatherapp.view.Menuview;
import weatherapp.view.OrientationObserver;
import weatherapp.weatherReadingsTask;

/**
 *
 * @author Samsu
 */
public class Dashboard_controller   {

    private     Dashboard_Model             dashModel;
    private     Dashboardview               dashView;
    private     StackPane                   tempStack;
    private     Menuview                    menuView ;
    private     ExecutorService             threadManager;
    private     Stage                       mainStage;
    public Dashboard_controller(Dashboard_Model dashModel, Dashboardview dashview,Menuview themenu,StackPane thestack,Stage mainStage) {
        this.dashModel = dashModel;
        this.mainStage = mainStage;
//        setQuotesOnButton();
        this.dashView = dashview;
        menuView=themenu;
        tempStack=thestack;
        threadManager=Executors.newFixedThreadPool(2, new WeatherThreads("Weather readings and a clock"));
        clock = new clockTask(dashModel.getTime(),dashModel.getDateformat());
        weatherTemps = new weatherReadingsTask(dashModel);
        clock.setExecutor(threadManager);
        weatherTemps.setExecutor(threadManager);
        clock.start();
        weatherTemps.start();
        StringProperty value = new SimpleStringProperty();
        value.bind(weatherTemps.currentTemp);
        runRealTimeWeather();
        enableUIElementsWithSpeech();
        
//        translateNowLabel(dashModel);
        
    runClock();
        
    }

    private void translateNowLabel(Dashboard_Model dashModel1) {
        if (this.dashView.getView() instanceof DashboardLandscapeview) {
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            dashLand.getLbl_now().setText(dashModel1.setTranslatedText(dashLand.getLbl_now().getText()));
        } else {
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            dashPort.getLbl_now().setText(dashModel1.setTranslatedText(dashPort.getLbl_now().getText()));
        }
    }
    private void translateDay2Label(Dashboard_Model dashModel1) {
        if (this.dashView.getView() instanceof DashboardLandscapeview) {
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            dashLand.getLbl_Tom().setText(dashModel1.setTranslatedText(dashLand.getLbl_Tom().getText()));
        } else {
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            dashPort.getLbl_Tom().setText(dashModel1.setTranslatedText(dashPort.getLbl_Tom().getText()));
        }
    }
    private void translateDay3Label(Dashboard_Model dashModel1) {
        if (this.dashView.getView() instanceof DashboardLandscapeview) {
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            dashLand.getLbl_Wed().setText(dashModel1.setTranslatedText(dashLand.getLbl_Wed().getText()));
        } else {
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            dashPort.getLbl_Wed().setText(dashModel1.setTranslatedText(dashPort.getLbl_Wed().getText()));
        }
    }
    private void translateLocationLabel(Dashboard_Model dashModel1) {
        if (this.dashView.getView() instanceof DashboardLandscapeview) {
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            dashLand.getLocationLabel().setText(dashModel1.setTranslatedText(dashLand.getLocationLabel().getText()));
        } else {
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            dashPort.getLocationLabel().setText(dashModel1.setTranslatedText(dashPort.getLocationLabel().getText()));
        }
    }
    private void translateTipsButton(Dashboard_Model dashModel1) {
        if (this.dashView.getView() instanceof DashboardLandscapeview) {
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            dashLand.getTips().setText(dashModel1.setTranslatedText(dashLand.getTips().getText()));
        } else {
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            dashPort.getTips().setText(dashModel1.setTranslatedText(dashPort.getTips().getText()));
        }
    }

    private void enableUIElementsWithSpeech() {
        enableCurrentTempWithSpeech();
        enableMenuWithSpeech();
    }

    private void enableCurrentTempWithSpeech() {
        if (this.dashView.getView() instanceof DashboardLandscapeview) {
            
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            setCurrentTempSpeech(dashLand);
        } else {
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            setCurrentTempSpeech(dashPort);
        }
//                    setRealTimeWeather(automateWeather,dashLand);
    }
    private void enableMenuWithSpeech() {
        if (this.dashView.getView() instanceof DashboardLandscapeview) {
            
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            setMenuSpeech(dashLand);
        } else {
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            setMenuSpeech(dashPort);
        }
//                    setRealTimeWeather(automateWeather,dashLand);
    }

    private <T extends DashboardInteface>void setCurrentTempSpeech(T dashBoard) {
        dashBoard.getCurrenttemp().setOnMouseEntered(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                try {
                    dashModel.readOutText(dashBoard.getCurrenttemp().getText()+"°C");
                } catch (IOException ex) {
                    Logger.getLogger(Dashboard_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private <T extends DashboardInteface>void setMenuSpeech(T dashBoard) {
        dashBoard.getMenu().setOnMouseEntered(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                try {
                    dashModel.readOutText("Menu");
                } catch (IOException ex) {
                    Logger.getLogger(Dashboard_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

//    private void setQuotesOnButton() {
//        if (this.dashView.getView() instanceof DashboardLandscapeview) {
//            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
//            dashLand.getTips().setOnAction(new EventHandler<ActionEvent>() {
//
//                @Override
//                public void handle(ActionEvent event) {
//                    Dialogs.create()
//        .owner(mainStage)
//        .title("Interesting Weather facts")
//        .masthead("Did you know ?")
//        .message(dashModel.getRandomQuote())
//        .showInformation();
//                }
//            });
//            
//        } else {
//            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
//        }
//    }

    private void runRealTimeWeather() {
        Timeline automateWeather = new Timeline();
        automateWeather.setCycleCount(Timeline.INDEFINITE);
        if (this.dashView.getView() instanceof DashboardLandscapeview) {
        DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            setRealTimeWeather(automateWeather, dashLand);
        }
        else{
        DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            setRealTimeWeather(automateWeather, dashPort);
        }
        
    }
    private weatherReadingsTask weatherTemps;
    private Service clock;

    private <T extends DashboardInteface>void setRealTimeWeather(Timeline automateWeather,T dashBoard) {
                KeyFrame realTimeDuration = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
         
            @Override
            public void handle(ActionEvent event) {
//                System.out.println("dodo "+value.getValue());
//                System.out.println("This is the current temp"+weatherTemps.currentTemp);
//                dashLand.getCurrenttemp().setText(String.valueOf(weatherTemps.getCurrentTemp()));
                dashBoard.getCurrenttemp().setText(weatherTemps.getCurrentTemp().get());
            }
        });
            
            
                   
               automateWeather.getKeyFrames().add(realTimeDuration);
            
                   
     
         
       automateWeather.play();
       
    }

   

    private void runClock() {
        
        this.dashView.getView();
        if (this.dashView.getView() instanceof DashboardLandscapeview ){
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
            dashLand.getTimeLabel().textProperty().bind(clock.messageProperty());
        }
        else{
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
        
        }
      
    }

    private void changeDashboardNowTemp() {
        if (true) {
            DashboardLandscapeview dashLand = (DashboardLandscapeview) this.dashView.getView();
        dashLand.setNowTemp(null);
        } else {
            DashboardPortraitview dashPort = (DashboardPortraitview) this.dashView.getView();
            dashPort.setNowTemp(null);
        }
        
    }

    public void makeDashboardGoToMenu() {
        if (this.dashView.getView() instanceof DashboardLandscapeview ) {
            DashboardLandscapeview dashBoard = (DashboardLandscapeview) this.dashView.getView();
            allowtheDashBoardToGoMenu(dashBoard);
            
        }
        else{
        DashboardPortraitview dashBoard = (DashboardPortraitview) this.dashView.getView();
            allowtheDashBoardToGoMenu(dashBoard);
            
        
        }
    }

    private <T extends DashboardInteface >void  allowtheDashBoardToGoMenu(T dashBoard) {
        dashBoard.getMenu().setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                double width = tempStack.getWidth();
                tempStack.getChildren().add(menuView.getView());
//                tempStack.getChildren().remove(dashView);
//                   KeyFrame start = new KeyFrame(Duration.ZERO,
//                    new KeyValue(somemeny.translateXProperty(), width),
//                    new KeyValue(dashview.translateXProperty(), 0));
//            KeyFrame end = new KeyFrame(Duration.seconds(2),
//                    new KeyValue(somemeny.translateXProperty(), 0),
//                    new KeyValue(dashview.translateXProperty(), -width));
//            Timeline slide = new Timeline(start, end);
//               slide.play();
                FadeTransition ft = new FadeTransition(Duration.millis(2000), menuView.getView());
                ft.setNode(menuView.getView());
                ft.setFromValue(0.05);
                ft.setToValue(1);
                ft.setAutoReverse(true);
                
                ft.play();
                
            }
        });
    }

  
 

}
