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
public class TrackWeatherview implements OrientationObserver {

    MigPane view;

    TrackWeatherLandscapeview landscapeView = new TrackWeatherLandscapeview();
    TrackWeatherPortraitview portraitView = new TrackWeatherPortraitview();
    boolean checkLandORPortrait;

    public TrackWeatherview() {
        view=landscapeView;
    }

   public void update(boolean arg) {
       
            checkLandORPortrait = (boolean) arg;
        

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
