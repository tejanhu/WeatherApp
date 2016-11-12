/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public interface NewInterface {

    ListView getCountriesPickedView();

    ListView getCountriesSuggestedView();

    Label getInputTextLabel();

    Label getLbl_countries_picked();

    Label getLbl_countries_suggested();

    MigPane getMaincontainer();

    ToggleButton getMenu();

    ObservableList getSomecrap();
    
}
