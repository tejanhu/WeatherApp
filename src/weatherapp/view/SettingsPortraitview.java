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
 */
public class SettingsPortraitview extends MigPane implements SettingsInterface {

    private     SegmentedButton     tooltipSegmentedButton;
    private     ToggleButton        menu;
    private     ToggleButton        enToolTip;
    private     ToggleButton        disToolTip;
    private     MigPane             left;
    private     MigPane             right;
    private     Label               toolTipsLabel;
    private     Label               orientLabel;
    private     Label               setLocationsLabel;
    private     Label               timeLabel;
    private     Label               tempLabel;
    private     Label               settingsLabel;
    private     ToggleButton        pmButton;
    private     ToggleButton        amButton;
    private     SegmentedButton     tempValue;
    private     ToggleButton        farenheit;
    private     ToggleButton        degrees;
    private     ComboBox            locationValues;
    private     ToggleButton        port;
    private     ToggleButton        land;
    private     SegmentedButton     orientOptions;
    private     SegmentedButton     timeValue;

    public SettingsPortraitview() {
        super("insets 0,gap 0, wrap2", "[grow] []", "[][]");
        this.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        this.setId("mainy");

        left = new MigPane("gap 0,insets 0", "[grow]", "[]");
        left.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        left.setId("left");
        leftBlock();

        MigPane bottom = new MigPane();
        bottom.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        bottom.setId("bottom");
        rightBlock();

        this.add(left, "width 38, height 353,growy 5");
        this.add(right, "width 282, height 400");
        this.add(bottom, "gaptop 4px,width 38, height 123");

    }

    public void leftBlock() {
        menu = new ToggleButton();
        menu.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        menu.setId("meny");
        left.add(menu, "center");
    }

    public void rightBlock() {
        right = new MigPane("wrap2", "[grow] 10 [grow]", "[]14[]14[]14[]14[]14[]");
        right.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        right.setId("right");

        settingsLabel = new Label("Settings");
        settingsLabel.setFont(new Font("Arial", 30));
        settingsLabel.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        settingsLabel.setId("settings_col");

        tempLabel = new Label("Temp Metric");
        tempLabel.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        tempLabel.setId("settings_col");

        tempValue = new SegmentedButton();
        degrees = new ToggleButton("°C");
        farenheit = new ToggleButton("°F");
        tempValue.getButtons().addAll(degrees, farenheit);

        timeValue = new SegmentedButton();
        timeValue.getButtons().addAll(amButton, pmButton);
        amButton = new ToggleButton("am");
        pmButton = new ToggleButton("pm");

        locationValues = new ComboBox();

        orientLabel = new Label("Orientation");
        orientOptions = new SegmentedButton();
        land = new ToggleButton("Landscape");
        port = new ToggleButton("Portrait");
        orientOptions.getButtons().addAll(land, port);

        toolTipsLabel = new Label("Tooltips");
        tooltipSegmentedButton = new SegmentedButton();

        disToolTip = new ToggleButton("Disable");
        enToolTip = new ToggleButton("Enable");

        tooltipSegmentedButton.getButtons().addAll(disToolTip, enToolTip);

        stylesAndFonts(land, port);
        
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
        right.add(tooltipSegmentedButton, "sg a");
    }

    public void stylesAndFonts(ToggleButton land, ToggleButton port) {
        locationValues.setPrefHeight(20);
        Font thefontfortoolorient = new Font("Arial", 8);
        land.setFont(thefontfortoolorient);
        port.setFont(thefontfortoolorient);
        
        setLocationsLabel = new Label("Set locations");
        setLocationsLabel.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        setLocationsLabel.setId("settings_col");
        
        orientLabel.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        orientLabel.setId("settings_col");
        
        toolTipsLabel.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        toolTipsLabel.setId("settings_col");
        
        Font thefontfortooltips = new Font("Arial", 10);
        disToolTip.setFont(thefontfortooltips);
        enToolTip.setFont(thefontfortooltips);
        locationValues.setPrefWidth(100);
        timeLabel = new Label("Set time");
        timeLabel.getStylesheets().add(SettingsPortraitview.class.getResource("sety.css").toExternalForm());
        timeLabel.setId("settings_col");
    }

    public SegmentedButton getToolTipSegmentedButton() {
        return tooltipSegmentedButton;
    }

    public ToggleButton getMenu() {
        return menu;
    }

    public ToggleButton getEnToolTip() {
        return enToolTip;
    }

    public ToggleButton getDisToolTip() {
        return disToolTip;
    }

    public Label getToolTipsLabel() {
        return toolTipsLabel;
    }

    public Label getOrientLabel() {
        return orientLabel;
    }

    public Label getSetLocationsLabel() {
        return setLocationsLabel;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public Label getTempLabel() {
        return tempLabel;
    }

    public Label getSettingsLabel() {
        return settingsLabel;
    }

    public ToggleButton getPmButton() {
        return pmButton;
    }

    public ToggleButton getAmButton() {
        return amButton;
    }

    public SegmentedButton getTempValue() {
        return tempValue;
    }

    public ToggleButton getFarenheit() {
        return farenheit;
    }

    public ToggleButton getDegrees() {
        return degrees;
    }

    public ComboBox getLocationValues() {
        return locationValues;
    }

    public ToggleButton getPort() {
        return port;
    }

    public ToggleButton getLand() {
        return land;
    }

    public SegmentedButton getOrientOptions() {
        return orientOptions;
    }

    public SegmentedButton getTimeValue() {
        return timeValue;
    }

    public static void main(String[] args) {

    }

   

    

 
 


}
