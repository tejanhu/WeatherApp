/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import weatherapp.Model.OtherCountries_Model;
import weatherapp.view.MenuLandscapeview;
import weatherapp.view.OtherCountriesLandscapeview;



/**
 *
 * @author Samsu
 */
public class OtherCountries_controller {
    private     OtherCountries_Model           OtherCountriesModel;
    private     OtherCountriesLandscapeview    OtherCountriesView;
    private     MenuLandscapeview              somemeny ;
    private     StackPane                      tempstack;

    public OtherCountries_controller(OtherCountries_Model OtherCountriesModel, OtherCountriesLandscapeview OtherCountriesView, MenuLandscapeview somemeny, StackPane tempstack) {
        this.OtherCountriesModel = OtherCountriesModel;
        this.OtherCountriesView = OtherCountriesView;
        this.somemeny = somemeny;
        this.tempstack = tempstack;
        
       
    }

    public void makeOtherCountriesGotoMenu(OtherCountriesLandscapeview OtherCountriesView1) {
        OtherCountriesView1.getMenu().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                tempstack.getChildren().remove(this);
                
                tempstack.getChildren().add(somemeny);
            }
        });
    }
    
    
    
    
}
