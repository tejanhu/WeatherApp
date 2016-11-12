/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import java.text.SimpleDateFormat;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public interface DashboardInteface {

    MigPane getBotblock();

    MigPane getDegree_Now();

    MigPane getDegree_Now2();

    MigPane getDegree_Tom();

    MigPane getDegree_Wed();

    MigPane getLastBlock();

    ToggleButton getMenu();

    GridPane getNowtemp();

    GridPane getTomtemp();

    MigPane getTopblock();

    GridPane getWedtemp();

    void setImageWeather(String imagepath);

    void setNowTemp(String newTemp);

    void thetime(SimpleDateFormat fmt, Label time);

    public Label getTimeLabel();

    public Label getCurrenttemp();

    public Button getTips();

    public Label getLbl_Tom();

    public Label getLbl_now();

    public Label getLbl_Wed();
    
    public Label getLocationLabel();
}
