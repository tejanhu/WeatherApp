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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import weatherapp.Model.Settings_Model;
import weatherapp.view.OrientationObserver;
import weatherapp.view.SettingsInterface;
import weatherapp.view.SettingsLandscapeview;
import weatherapp.view.SettingsPortraitview;
import weatherapp.view.Settingsview;

/**
 *
 * @author Samsu
 */
public  class Settings_controller implements OrientationObserver {
   private  Settings_Model settingModel;
   private  Settingsview  settingView;
   private  StackPane     stacky;

    public Settings_controller(Settings_Model settingModel, Settingsview settingView, StackPane stacky) {
        this.settingModel = settingModel;
        this.settingView = settingView;
        this.stacky = stacky;
        System.out.println("Valy in the controller is  :"+settingView.getValy());
        enableFunctions(settingView);
       
    }

    public void enableFunctions(Settingsview settingView1) {
        enableSettingsToGoToMenu(settingView1);
        enableTempLabelWithSpeech();
        enablePortrait();
        enableLandscape();
    }

    public void enablePortrait() {
        if (this.settingView.getView() instanceof SettingsLandscapeview) {
            SettingsLandscapeview  settingLand = (SettingsLandscapeview) this.settingView.getView();
            setPortrait(settingLand);
        } else {
            SettingsPortraitview  settingPort = (SettingsPortraitview) this.settingView.getView();
            setPortrait(settingPort);
        
        }
    }

    public <T extends SettingsInterface>void setPortrait(T settingview) {
        settingview.getPort().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               settingModel.unsetLandscape();
            }
        });
    }
    public void enableLandscape() {
        if (this.settingView.getView() instanceof SettingsLandscapeview) {
            SettingsLandscapeview  settingLand = (SettingsLandscapeview) this.settingView.getView();
            setLandscape(settingLand);
        } else {
            SettingsPortraitview  settingPort = (SettingsPortraitview) this.settingView.getView();
            setLandscape(settingPort);
        
        }
    }

    public <T extends SettingsInterface>void setLandscape(T settingview) {
        settingview.getLand().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                settingModel.setLandscape();
            }
        });
    }

    public void enableTempLabelWithSpeech() {
        if (this.settingView.getView() instanceof SettingsLandscapeview) {
            SettingsLandscapeview  settingLand = (SettingsLandscapeview) this.settingView.getView();
            setTempLabelWithSpeech(settingLand);
        } else {
            SettingsPortraitview  settingPort = (SettingsPortraitview) this.settingView.getView();
            setTempLabelWithSpeech(settingPort);
        }
    }

    public<T extends SettingsInterface> void setTempLabelWithSpeech(T settingView) {
        settingView.getTempLabel().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    settingModel.readOutText(settingView.getTempLabel().getText());
                } catch (IOException ex) {
                    Logger.getLogger(Settings_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void enableTimeLabelWithSpeech() {
        if (this.settingView.getView() instanceof SettingsLandscapeview) {
            SettingsLandscapeview  settingLand = (SettingsLandscapeview) this.settingView.getView();
            setTimeLabelWithSpeech(settingLand);
        } else {
            SettingsPortraitview  settingPort = (SettingsPortraitview) this.settingView.getView();
            setTimeLabelWithSpeech(settingPort);
        }
    }

    public<T extends SettingsInterface> void setTimeLabelWithSpeech(T settingView) {
        settingView.getTimeLabel().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    settingModel.readOutText(settingView.getTimeLabel().getText());
                } catch (IOException ex) {
                    Logger.getLogger(Settings_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void enableLocationsLabelWithSpeech() {
        if (this.settingView.getView() instanceof SettingsLandscapeview) {
            SettingsLandscapeview  settingLand = (SettingsLandscapeview) this.settingView.getView();
            setLocationsLabelWithSpeech(settingLand);
        } else {
            SettingsPortraitview  settingPort = (SettingsPortraitview) this.settingView.getView();
            setLocationsLabelWithSpeech(settingPort);
        }
    }

    public<T extends SettingsInterface> void setLocationsLabelWithSpeech(T settingView) {
        settingView.getSetLocationsLabel().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    settingModel.readOutText(settingView.getSetLocationsLabel().getText());
                } catch (IOException ex) {
                    Logger.getLogger(Settings_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void enableOrientLabelWithSpeech() {
        if (this.settingView.getView() instanceof SettingsLandscapeview) {
            SettingsLandscapeview  settingLand = (SettingsLandscapeview) this.settingView.getView();
            setOrientLabelWithSpeech(settingLand);
        } else {
            SettingsPortraitview  settingPort = (SettingsPortraitview) this.settingView.getView();
            setOrientLabelWithSpeech(settingPort);
        }
    }

    public<T extends SettingsInterface> void setOrientLabelWithSpeech(T settingView) {
        settingView.getOrientLabel().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    settingModel.readOutText(settingView.getOrientLabel().getText());
                } catch (IOException ex) {
                    Logger.getLogger(Settings_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void enableToolTipsLabelWithSpeech() {
        if (this.settingView.getView() instanceof SettingsLandscapeview) {
            SettingsLandscapeview  settingLand = (SettingsLandscapeview) this.settingView.getView();
            setToolTipsLabelWithSpeech(settingLand);
        } else {
            SettingsPortraitview  settingPort = (SettingsPortraitview) this.settingView.getView();
            setToolTipsLabelWithSpeech(settingPort);
        }
    }

    public<T extends SettingsInterface> void setToolTipsLabelWithSpeech(T settingView) {
        settingView.getToolTipsLabel().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    settingModel.readOutText(settingView.getToolTipsLabel().getText());
                } catch (IOException ex) {
                    Logger.getLogger(Settings_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void enableSettingsToGoToMenu(Settingsview settingView1) {
        if (settingView1.getView() instanceof SettingsLandscapeview) {
            SettingsLandscapeview  settingLand = (SettingsLandscapeview) settingView1.getView();
            setSettingsToGoToMenu(settingLand);
        } else {
            SettingsPortraitview settingPort= (SettingsPortraitview) settingView1.getView();
            setSettingsToGoToMenu(settingPort);
        }
    }

    public <T extends SettingsInterface>void setSettingsToGoToMenu(T setting) {
        setting.getMenu().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
               stacky.getChildren().add(settingModel.getMenuView().getView());
                FadeTransition ft = new FadeTransition(Duration.millis(2000), settingModel.getMenuView().getView());
                ft.setNode(settingModel.getMenuView().getView());
                ft.setFromValue(0.05);
                ft.setToValue(1);
                ft.setAutoReverse(true);
                
                ft.play();
            }
        });
    }

    @Override
    public void update(boolean orientation) {
        enableFunctions(settingView);
    }

    
    
}
