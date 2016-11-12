/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import java.util.Observable;
import java.util.Observer;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class Dashboardview extends MigPane implements OrientationObserver {

    MigPane view;

    DashboardLandscapeview landscapeView = new DashboardLandscapeview();
    DashboardPortraitview  portraitView = new DashboardPortraitview();
    boolean checkLandORPortrait;

    public Dashboardview() {
//        this= new Dashboardview
        view=landscapeView;
    }

    public DashboardLandscapeview getLandscapeView() {
        return landscapeView;
    }

    public void update(boolean arg) {
       
            checkLandORPortrait =  arg;
        

        if (checkLandORPortrait) {
            view = landscapeView;

        } else {

            view = portraitView;
        }

    }
    public MigPane getView() {
        return view;
    }

}
