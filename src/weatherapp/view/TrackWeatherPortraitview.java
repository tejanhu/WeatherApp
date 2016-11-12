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
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class TrackWeatherPortraitview extends MigPane implements TrackWeatherInteface  {
private     ToggleButton    menu;
private     Label           inputTextLabel;
private     Button          trackButton;
private     ListView        countriesPickedView;
private     ListView        countriesSuggestedView;
private     Label           countriesPickedLabel;
private     Label           countriesSuggestedLabel;
private     TextField       searchBar;
private     ObservableList  somecrap;
private     Button          searchButton;

    public TrackWeatherPortraitview() {

        super("wrap", "[grow]", "[][][]");

        menu = new ToggleButton();
        menu.getStylesheets().add(TrackWeatherPortraitview.class.getResource("Weatherland.css").toExternalForm());
        menu.setId("meny");
        searchButton= new Button("Search");
         
        inputTextLabel = new Label("Enter the countries you want to track");
        
        this.add(menu, "right");
        this.add(inputTextLabel, "center,span");;
        this.add(getMaincontainer(),"span,center,width 319, height 398");
             

    }

    
    public MigPane getMaincontainer() {
        MigPane mainContainer = new MigPane("wrap","[]","[]10[]10[]10[]10[]10[]");
        searchBar = new TextField();
        trackButton = new Button("Track these countries ");
        countriesSuggestedLabel = new Label("Countries suggested :");
        countriesPickedLabel = new Label("Countries picked :");
        countriesSuggestedView = new ListView();
        countriesPickedView = new ListView(); 
        
        mainContainer.add(searchBar,"width 313,height 21");
//        mainContainer.add(searchBar,"width 290,height 21,split2");
//        mainContainer.add(searchButton,"span");
        mainContainer.add(countriesSuggestedLabel);
        mainContainer.add(countriesSuggestedView,"width 311,height 129");
        mainContainer.add(countriesPickedLabel);
        mainContainer.add(countriesPickedView,"width 311,height 129");
        mainContainer.add(trackButton,"width 313,height 21");
              
        
        return mainContainer;
    
    }

    public ToggleButton getMenu() {
        return menu;
    }

 
    public Label getInputTextLabel() {
        return inputTextLabel;
    }

 
    public Button getTrackButton() {
        return trackButton;
    }

    
    public ListView getCountriesPickedView() {
        return countriesPickedView;
    }

    
    public ListView getCountriesSuggestedView() {
        return countriesSuggestedView;
    }

  
    public Label getCountriesPickedLabel() {
        return countriesPickedLabel;
    }

 
    public Label getCountriesSuggestedLabel() {
        return countriesSuggestedLabel;
    }


    public TextField getSearchBar() {
        return searchBar;
    }

   
    public ObservableList getSomecrap() {
        return somecrap;
    }
    
    public Button getSearchButton() {
        return searchButton;
    }

}
