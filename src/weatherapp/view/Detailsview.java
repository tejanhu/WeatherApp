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
public class Detailsview implements OrientationObserver {

    MigPane view;

    DetailsLandscapeview landscapeView = new DetailsLandscapeview();
    DetailsPortraitview  portraitView = new   DetailsPortraitview();
    boolean checkLandORPortrait;

    public Detailsview() {
        
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
