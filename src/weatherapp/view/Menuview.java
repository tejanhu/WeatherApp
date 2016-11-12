/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import java.util.Observable;

import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class Menuview implements OrientationObserver {

    MenuLandscapeview landscapeView = new MenuLandscapeview();
    MenuPortraitview  portraitView = new MenuPortraitview();
    MigPane view;
    boolean checkLandORPortrait;

    public Menuview() {
        view=landscapeView;
    }

    @Override
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
