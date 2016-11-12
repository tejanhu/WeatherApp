package weatherapp.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Font;
import org.controlsfx.control.textfield.TextFields;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class TrackWeatherLandscapeview extends MigPane implements TrackWeatherInteface  {
    private      Label               inputTextLabel;
    private      ToggleButton        menu;
    private      MigPane             Maincontainer;
    private      ObservableList      somecrap;
    private      ListView            countriesPickedView;
    private      ListView            countriesSuggestedView;
    private      Label               countriesPickedLabel;
    private      Label               countriesSuggestedLabel;
    private      Button              trackButton;
    private      TextField           searchBar;
    private      Button               searchButton;


    public TrackWeatherLandscapeview() {

        super("wrap", "[grow]", "[][][]");

        menu = new ToggleButton();
        menu.getStylesheets().add(TrackWeatherLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        menu.setId("meny");
        inputTextLabel = new Label("Enter the countries you want to track");
        searchButton = new Button("Search");
//        this.add(menu,"span, gapleft 430px ");
        this.add(menu, "right");
        this.add(inputTextLabel, " center,span");

        this.add(getMaincontainer(), "span,width 319, height 239,center");

    }

 
    public MigPane getMaincontainer() {
        Maincontainer = new MigPane(",wrap2", "[][]", "[][][]20[grow]");
        searchBar = new TextField();
        trackButton = new Button("Track these countries ");

        Maincontainer.setStyle("-fx-background-color:#3a3965;");
        countriesSuggestedLabel = new Label("Countries suggested :");
        countriesPickedLabel = new Label("Countries picked :");
        countriesSuggestedView = new ListView();
        countriesPickedView = new ListView();

        Maincontainer.add(searchBar, "width 313,height 21,span");
//        Maincontainer.add(searchBar, "width 150,height 21,split2");
//        Maincontainer.add(searchButton,"span");
        Maincontainer.add(countriesSuggestedLabel);
        Maincontainer.add(countriesPickedLabel);
        Maincontainer.add(countriesSuggestedView, "gapright 5px");
        Maincontainer.add(countriesPickedView);
        Maincontainer.add(trackButton, "span,growx");
        somecrap = FXCollections.observableArrayList();
        somecrap.add("someguy");
        somecrap.add("somenextguy");
        somecrap.add("hobo");
        
//        countriesSuggestedView.setItems(somecrap);
        countriesPickedView.setItems(somecrap);
        
        TextFields.bindAutoCompletion(searchBar, "somecrap", "morecrap");
        
        return Maincontainer;
    }
    
    public ToggleButton getMenu() {
        return menu;
    }

   
    public Label getInputTextLabel() {
        return inputTextLabel;
    }

    
    public ObservableList getSomecrap() {
        return somecrap;
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
    
    public Button getSearchButton() {
        return searchButton;
    }

}
