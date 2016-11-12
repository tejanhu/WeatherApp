/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import org.controlsfx.control.SegmentedButton;

/**
 *
 * @author Samsu
 */
public interface SettingsInterface {

    ToggleButton getDegrees();

    ToggleButton getDisToolTip();

    ToggleButton getEnToolTip();

    ComboBox getLocationValues();

    ToggleButton getMenu();

    Label getOrientLabel();

    SegmentedButton getOrientOptions();

    ToggleButton getPmButton();

    ToggleButton getPort();

    Label getSettingsLabel();

    Label getTempLabel();

    SegmentedButton getTempValue();

    Label getTimeLabel();

    SegmentedButton getToolTipSegmentedButton();

    Label getToolTipsLabel();

    public ToggleButton getAmButton();

    public Label getSetLocationsLabel();
    
   public ToggleButton getLand();
   
   public SegmentedButton getTimeValue();

}
