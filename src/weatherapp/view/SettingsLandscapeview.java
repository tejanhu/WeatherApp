package weatherapp.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.SegmentedButton;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author ht304
 */
/*
 ____________________________________________________________
 |                                              
 |
 |
 |
 |
 |
 |
 |
 |
 |
 ___________ |
 |
 |
 |
 |
 |
 |
 ___________________________________________________________

 */
public class SettingsLandscapeview extends MigPane implements SettingsInterface  {

    private         ComboBox            locationValues;
    private         Label               settingsLabel;
    private         ToggleButton        amButton;
    private         ToggleButton        pmButton;
    private         SegmentedButton     tempValue;
    private         ToggleButton        degrees;
    private         Label               toolTipsLabel;
    private         Label               orientLabel;
    private         Label               setLocationsLabel;
    private         Label               timeLabel;
    private         Label               tempLabel;
    private         MigPane             bottom;
    private         MigPane             right;
    private         MigPane             left;
    private         ToggleButton        disToolTip;
    private         SegmentedButton     orientOptions;
    private         ToggleButton        port;
    private         ToggleButton        land;
    private         SegmentedButton     toolTipSegmentedButton;
    private         SegmentedButton     timeValue;
    private         ToggleButton        menu;
    private         ToggleButton        enToolTip;



    public SettingsLandscapeview() {

        super("insets 0,gap 0, wrap2", "[grow] []", "[][]");
        this.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        this.setId("mainy");

        left = new MigPane("gap 0,insets 0", "[grow]", "[]");
        left.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        left.setId("left");

        right = new MigPane("wrap2", "[grow] 10 [grow]", "[]14[]14[]14[]14[]14[]");
        right.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        right.setId("right");

        bottom = new MigPane();
        bottom.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        bottom.setId("bottom");

        this.add(left, "width 38, height 234,growy 5");
        this.add(right, "width 443, height 320");
        this.add(bottom, "gaptop 4px,width 38, height 6");

        leftBlock();

        rightBlock();

    }

    private void leftBlock() {
        menu = new ToggleButton();
        menu.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        menu.setId("meny");
        left.add(menu, "center");
    }

    private void rightBlock() {

        settingsLabel = new Label("Settings");
        settingsLabel.setFont(new Font("Arial", 30));
        settingsLabel.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        settingsLabel.setId("settings_col");
        tempLabel = new Label("Temp Metric");
        tempLabel.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        tempLabel.setId("settings_col");

        timeLabel = new Label("Set time");
        timeLabel.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        timeLabel.setId("settings_col");

        setLocationsLabel = new Label("Set locations");
        setLocationsLabel.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        setLocationsLabel.setId("settings_col");

        orientLabel = new Label("Orientation");
        orientLabel.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        orientLabel.setId("settings_col");

        toolTipsLabel = new Label("Tooltips");
        toolTipsLabel.getStylesheets().add(SettingsLandscapeview.class.getResource("sety.css").toExternalForm());
        toolTipsLabel.setId("settings_col");

        degrees = new ToggleButton("°C");
        ToggleButton farenheit = new ToggleButton("°F");

        tempValue = new SegmentedButton();
        tempValue.getButtons().addAll(degrees, farenheit);

        amButton = new ToggleButton("am");
        pmButton = new ToggleButton("pm");

        timeValue = new SegmentedButton();
        timeValue.getButtons().addAll(amButton, pmButton);

        locationValues = new ComboBox();
        locationValues.setPrefHeight(20);
        Font thefontfortoolorient = new Font("Arial", 8);
        land = new ToggleButton("Landscape");
        port = new ToggleButton("Portrait");
        land.setFont(thefontfortoolorient);
        port.setFont(thefontfortoolorient);
        orientOptions = new SegmentedButton();
        orientOptions.getButtons().addAll(land, port);

        disToolTip = new ToggleButton("Disable");
        Font thefontfortooltips = new Font("Arial", 10);
        disToolTip.setFont(thefontfortooltips);
        enToolTip = new ToggleButton("Enable");
        enToolTip.setFont(thefontfortooltips);
        locationValues.setPrefWidth(100);
        toolTipSegmentedButton = new SegmentedButton();

        toolTipSegmentedButton.getButtons().addAll(disToolTip, enToolTip);
        //Settings
        right.add(settingsLabel, "span, center, grow");
        //temp metric
        right.add(tempLabel);
        //cels_faren
        right.add(tempValue, "sg a");
        //set time
        right.add(timeLabel);
        //time
        right.add(timeValue, "sg a");
        //set locations
        right.add(setLocationsLabel);
        //combo box
        right.add(locationValues, "sg a");
        //set orientation
        right.add(orientLabel);
        right.add(orientOptions, "sg a");
        right.add(toolTipsLabel);
        right.add(toolTipSegmentedButton, "sg a");
    }

  
    @Override
    public ComboBox getLocationValues() {
        return locationValues;
    }

  
   


  
    @Override
    public ToggleButton getPmButton() {
        return pmButton;
    }

  
    @Override
    public SegmentedButton getTempValue() {
        return tempValue;
    }

  
    @Override
    public ToggleButton getDegrees() {
        return degrees;
    }

  
    @Override
    public Label getToolTipsLabel() {
        return toolTipsLabel;
    }

   
    @Override
    public Label getOrientLabel() {
        return orientLabel;
    }

    @Override
    public Label getTimeLabel() {
        return timeLabel;
    }

    
    @Override
    public Label getTempLabel() {
        return tempLabel;
    }

    public MigPane getLeft() {
        return left;
    }

    @Override
    public ToggleButton getDisToolTip() {
        return disToolTip;
    }

   
    @Override
    public SegmentedButton getOrientOptions() {
        return orientOptions;
    }

   
    @Override
    public ToggleButton getPort() {
        return port;
    }

    
    @Override
    public SegmentedButton getToolTipSegmentedButton() {
        return toolTipSegmentedButton;
    }

   
    @Override
    public ToggleButton getMenu() {
        return menu;
    }
  
  
    @Override
    public ToggleButton getEnToolTip() {
        return enToolTip;
    }

    @Override
    public Label getSettingsLabel() {
        return settingsLabel;
    }
    public ToggleButton getLand() {
        return land;
    }

    public SegmentedButton getTimeValue() {
        return timeValue;
    }

    public ToggleButton getAmButton() {
        return amButton;
    }

    public Label getSetLocationsLabel() {
        return setLocationsLabel;
    }
}
