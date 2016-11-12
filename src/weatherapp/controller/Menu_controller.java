/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import weatherapp.Model.Menu_Model;
import weatherapp.view.DashboardLandscapeview;
import weatherapp.view.DashboardPortraitview;
import weatherapp.view.Dashboardview;
import weatherapp.view.MenuInterface;
import weatherapp.view.MenuLandscapeview;
import weatherapp.view.MenuPortraitview;
import weatherapp.view.Menuview;
import weatherapp.view.OrientationObserver;

/**
 *
 * @author Samsu
 */
public class Menu_controller implements OrientationObserver {

    private Menu_Model menuModel;
    private Menuview menuView;
// private    Dashboardview dashview;
    private StackPane stacky;
    
    public Menu_controller(Menu_Model menuModel, Menuview menuView, StackPane stacky) {
        this.menuModel = menuModel;
        this.menuView = menuView;
//        this.dashview = dashview;
        this.stacky = stacky;
        
        enableMenuFunctions(stacky, menuView);
    }

    public void enableMenuFunctions(StackPane stacky1, Menuview menuView1) {
        makeMenuToggle(stacky1, menuView1);
        enablemenuWithSpeech();
        enablebuttonsWithSpeech();
        enableButtonToGoToTrackWeather(menuView1);
        enableButtonToGoToSettings();
    }

    public void enableButtonToGoToSettings() {
        if (this.menuView.getView() instanceof MenuLandscapeview) {
            MenuLandscapeview menuLand = (MenuLandscapeview) this.menuView.getView();
            setButtonToGoToSettings(menuLand);
        } else {
            MenuPortraitview menuPort = (MenuPortraitview) this.menuView.getView();
            setButtonToGoToSettings(menuPort);
        }
    }

    public <T extends MenuInterface> void setButtonToGoToSettings(T menu) {
        menu.getMenuChoice4().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                stacky.getChildren().remove(0);
                stacky.getChildren().remove(menuView.getView());
                stacky.getChildren().add(menuModel.getSettingsView().getView());
                FadeTransition ft = new FadeTransition(Duration.millis(2000), menuModel.getSettingsView().getView());
                ft.setNode(stacky.getChildren().get(0));
                ft.setFromValue(0.05);
                ft.setToValue(1);
                ft.setAutoReverse(true);
            }
        });
    }

    public void enableButtonToGoToTrackWeather(Menuview menuView1) {
        if (menuView1.getView() instanceof MenuLandscapeview) {
            MenuLandscapeview menuLand = (MenuLandscapeview) menuView1.getView();
            setButtonToGoToTrackWeather(menuLand);
        } else {
            MenuPortraitview menuPort = (MenuPortraitview) menuView1.getView();
            setButtonToGoToTrackWeather(menuPort);
        }
    }

    public <T extends MenuInterface>void setButtonToGoToTrackWeather(T menu) {
        menu.getMenuChoice1().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                stacky.getChildren().remove(0);
                stacky.getChildren().remove(menuView.getView());
                stacky.getChildren().add(menuModel.getTrackWeatherView().getView());
                FadeTransition ft = new FadeTransition(Duration.millis(2000), menuModel.getTrackWeatherView().getView());
                ft.setNode(stacky.getChildren().get(0));
                ft.setFromValue(0.05);
                ft.setToValue(1);
                ft.setAutoReverse(true);
                
                ft.play();
            }
        });
    }
    
    public void makeMenuToggle(StackPane stacky1, Menuview menuView) {
        
        if (menuView.getView() instanceof MenuLandscapeview) {
            MenuLandscapeview menuLand = (MenuLandscapeview) menuView.getView();
            goBackPreviousScreen(menuLand);
        } else {
            MenuPortraitview menuPort = (MenuPortraitview) menuView.getView();
            goBackPreviousScreen(menuPort);
        }
        
    }
    
    public <T extends MenuInterface> void goBackPreviousScreen(T menu) {
        menu.getMenuButton().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                stacky.getChildren().remove(menuView.getView());
                FadeTransition ft = new FadeTransition(Duration.millis(2000), stacky.getChildren().get(0));
                ft.setNode(stacky.getChildren().get(0));
                ft.setFromValue(0.05);
                ft.setToValue(1);
                ft.setAutoReverse(true);
                
                ft.play();
                
            }
        });
    }
    
    private void enablemenuWithSpeech() {
        if (this.menuView.getView() instanceof MenuLandscapeview) {
            
            MenuLandscapeview menuLand = (MenuLandscapeview) this.menuView.getView();
            setMenuWithSpeech(menuLand);
        } else {
            MenuPortraitview menuPort = (MenuPortraitview) this.menuView.getView();
            setMenuWithSpeech(menuPort);
        }
//                    setRealTimeWeather(automateWeather,dashLand);
    }
    private void enablebuttonsWithSpeech() {
        if (this.menuView.getView() instanceof MenuLandscapeview) {
            
            MenuLandscapeview menuLand = (MenuLandscapeview) this.menuView.getView();
            setButtonsWithSpeech(menuLand);
        } else {
            MenuPortraitview menuPort = (MenuPortraitview) this.menuView.getView();
            setButtonsWithSpeech(menuPort);
        }
//                    setRealTimeWeather(automateWeather,dashLand);
    }

    private <T extends MenuInterface>void setMenuWithSpeech(T menu) {
        menu.getMenuButton().setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    menuModel.readOutText("Menu");
                } catch (IOException ex) {
                    Logger.getLogger(Menu_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }

    private <T extends MenuInterface>void setButtonsWithSpeech(T menu) {
        makeButtonWithSpeech(menu.getMenuChoice1());
        makeButtonWithSpeech(menu.getMenuChoice2());
        makeButtonWithSpeech(menu.getMenuChoice3());
        makeButtonWithSpeech(menu.getMenuChoice4());
    }

    public <T extends Button> void makeButtonWithSpeech(T menu) {
        menu.setOnMouseEntered((MouseEvent event) -> {
            
            try {
                menuModel.readOutText(menu.getText());
            } catch (IOException ex) {
                Logger.getLogger(Menu_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void update(boolean orientation) {
        enableMenuFunctions(stacky, menuView);
    }
    
    
    
    
    
    
    
    
    
}
