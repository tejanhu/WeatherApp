/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import se.walkercrou.places.Place;
import weatherapp.Model.TrackWeather_Model;
import weatherapp.view.MenuLandscapeview;
import weatherapp.view.Menuview;
import weatherapp.view.OrientationObserver;
import weatherapp.view.TrackWeatherInteface;
import weatherapp.view.TrackWeatherLandscapeview;
import weatherapp.view.TrackWeatherPortraitview;
import weatherapp.view.TrackWeatherview;

/**
 *
 * @author Samsu
 */
public class TrackWeather_controller implements OrientationObserver {
    private     TrackWeather_Model              trackModel;
    private     TrackWeatherview                trackView;
    private     StackPane                       tempstack;
    private     Menuview                        menuView ;

    public TrackWeather_controller(TrackWeather_Model trackModel, TrackWeatherview trackView, StackPane tempstack) {
        this.trackModel = trackModel;
        this.trackView = trackView;
        this.tempstack = tempstack;
        menuView=this.trackModel.getMenuView();
        
        enableActions();
        
    }

    public void enableActions() {
        enableToSearchForLocation(this.trackView);
        enableTrackWeatherToGoMenu();
        
        enableUICOmponentsWithSpeech();
    }

    public void enableUICOmponentsWithSpeech() {
        enableInputTextWithSpeech();
        enableMenuWithSpeech();
        enableCountriesPickedLabelWithSpeech();
        enableCountriesSuggestedLabelWithSpeech();
    }

    public void enableInputTextWithSpeech() {
        if (this.trackView.getView() instanceof TrackWeatherLandscapeview) {
            TrackWeatherLandscapeview trackLand = (TrackWeatherLandscapeview) this.trackView.getView();
            setInputTextLabelWithSpeech(trackLand);
        } else {
            TrackWeatherPortraitview trackPort = (TrackWeatherPortraitview) this.trackView.getView();
            setInputTextLabelWithSpeech(trackPort);
            
        }
    }

    public<T extends TrackWeatherInteface> void setInputTextLabelWithSpeech(T trackView) {
        trackView.getInputTextLabel().setOnMouseEntered(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                try {
                    trackModel.readOutText(trackView.getInputTextLabel().getText());
                } catch (IOException ex) {
                    Logger.getLogger(TrackWeather_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void enableMenuWithSpeech() {
        if (this.trackView.getView() instanceof TrackWeatherLandscapeview) {
            TrackWeatherLandscapeview trackLand = (TrackWeatherLandscapeview) this.trackView.getView();
            setMenuWithSpeech(trackLand);
        } else {
            TrackWeatherPortraitview trackPort = (TrackWeatherPortraitview) this.trackView.getView();
            setMenuWithSpeech(trackPort);
            
        }
    }

    public<T extends TrackWeatherInteface> void setMenuWithSpeech(T trackView) {
        trackView.getMenu().setOnMouseEntered(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                try {
                    trackModel.readOutText("Menu");
                } catch (IOException ex) {
                    Logger.getLogger(TrackWeather_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void enableCountriesPickedViewWithSpeech() {
        if (this.trackView.getView() instanceof TrackWeatherLandscapeview) {
            TrackWeatherLandscapeview trackLand = (TrackWeatherLandscapeview) this.trackView.getView();
            setMenuWithSpeech(trackLand);
        } else {
            TrackWeatherPortraitview trackPort = (TrackWeatherPortraitview) this.trackView.getView();
            setMenuWithSpeech(trackPort);
            
        }
    }

    public<T extends TrackWeatherInteface> void setCountriesPickedViewWithSpeech(T trackView) {
//        trackView.getCountriesSuggestedView().getSelectionModel().
    }
    public void enableCountriesSuggestedLabelWithSpeech() {
        if (this.trackView.getView() instanceof TrackWeatherLandscapeview) {
            TrackWeatherLandscapeview trackLand = (TrackWeatherLandscapeview) this.trackView.getView();
            setCountriesSuggestedWithSpeech(trackLand);
        } else {
            TrackWeatherPortraitview trackPort = (TrackWeatherPortraitview) this.trackView.getView();
            setCountriesSuggestedWithSpeech(trackPort);
            
        }
    }

    public<T extends TrackWeatherInteface> void setCountriesSuggestedWithSpeech(T trackView) {
        trackView.getCountriesSuggestedLabel().setOnMouseEntered(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                try {
                    trackModel.readOutText(trackView.getCountriesSuggestedLabel().getText());
                } catch (IOException ex) {
                    Logger.getLogger(TrackWeather_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void enableCountriesPickedLabelWithSpeech() {
        if (this.trackView.getView() instanceof TrackWeatherLandscapeview) {
            TrackWeatherLandscapeview trackLand = (TrackWeatherLandscapeview) this.trackView.getView();
            setCountriesPickedWithSpeech(trackLand);
        } else {
            TrackWeatherPortraitview trackPort = (TrackWeatherPortraitview) this.trackView.getView();
            setCountriesPickedWithSpeech(trackPort);
            
        }
    }

    public<T extends TrackWeatherInteface> void setCountriesPickedWithSpeech(T trackView) {
        trackView.getCountriesPickedLabel().setOnMouseEntered(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                try {
                    trackModel.readOutText(trackView.getCountriesPickedLabel().getText());
                } catch (IOException ex) {
                    Logger.getLogger(TrackWeather_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void enableTrackWeatherToGoMenu() {
        if (this.trackView.getView() instanceof TrackWeatherLandscapeview) {
            TrackWeatherLandscapeview trackLand = (TrackWeatherLandscapeview) this.trackView.getView();
            makeTrackWeatheGoToMenu(trackLand);
        } else {
            TrackWeatherPortraitview trackPort = (TrackWeatherPortraitview) this.trackView.getView();
            makeTrackWeatheGoToMenu(trackPort);
        }
    }

    public void enableToSearchForLocation(TrackWeatherview trackView1) {
        System.out.println("Searching for location ");
        if (trackView1.getView() instanceof TrackWeatherLandscapeview) {
            TrackWeatherLandscapeview trackLand = (TrackWeatherLandscapeview) this.trackView.getView();
            populateListsWithLocations(trackLand);
        } else {
            TrackWeatherPortraitview trackPort = (TrackWeatherPortraitview) this.trackView.getView();
            populateListsWithLocations(trackPort);
        }
    }

    public <T extends TrackWeatherInteface>void populateListsWithLocations(T trackWeather) {
        TextField tracky=trackWeather.getSearchBar();

        tracky.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
            if (event.getCode().equals(KeyCode.ENTER)) {
                    ObservableList <String> places = trackModel.getLocations(trackWeather.getSearchBar().getText());
                    
                    trackWeather.getCountriesSuggestedView().setItems(places);
                    System.out.println("We get in here to trackweather");
                }
            }
        });
       
      
    }

    public <T extends TrackWeatherInteface>void makeTrackWeatheGoToMenu(T trackView1) {
        
        trackView1.getMenu().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("We clicked the button ");
//                tempstack.getChildren().remove(this);
                tempstack.getChildren().add(trackModel.getMenuView().getView());
                FadeTransition ft = new FadeTransition(Duration.millis(2000), trackModel.getMenuView().getView());
                ft.setNode(menuView.getView());
                ft.setFromValue(0.05);
                ft.setToValue(1);
                ft.setAutoReverse(true);
                
                ft.play();
                
            }
        });
    }

    @Override
    public void update(boolean orientation) {
        enableActions();
    }
    
    
    
    
}
