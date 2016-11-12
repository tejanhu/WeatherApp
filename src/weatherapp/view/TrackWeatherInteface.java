/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author Samsu
 */
public interface TrackWeatherInteface {
     public ToggleButton getMenu() ;

 
    public Label getInputTextLabel() ;

 
    public Button getTrackButton() ;

    
    public ListView getCountriesPickedView() ;
     
    
    public ListView getCountriesSuggestedView();

  
    public Label getCountriesPickedLabel() ;
 
    public Label getCountriesSuggestedLabel() ;

    public TextField getSearchBar() ;

   
    public ObservableList getSomecrap() ;
    
    public Button getSearchButton() ;
}
