/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import weatherapp.Model.Details_Model;
import weatherapp.view.DetailsLandscapeview;
import weatherapp.view.MenuLandscapeview;

/**
 *
 * @author Samsu
 */
public class Details_controller {
    private     Details_Model            detailsModel;
    private     DetailsLandscapeview     detailsview;
    private     MenuLandscapeview        somemeny ;
    private     StackPane                tempstack;

    public Details_controller(Details_Model detailsModel, DetailsLandscapeview detailsview, MenuLandscapeview somemeny, StackPane tempstack) {
        this.detailsModel = detailsModel;
        this.detailsview = detailsview;
        this.somemeny = somemeny;
        this.tempstack = tempstack;
        
    }

    public void makeDetailsGoToMenu(DetailsLandscapeview detailsview1) {
        detailsview1.getMenu().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               tempstack.getChildren().remove(this);
                
               tempstack.getChildren().add(somemeny);
            }
        });
    }
   


}
