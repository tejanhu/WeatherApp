/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class Settingsview implements OrientationObserver {

    private MigPane view;
    boolean checkLandORPortrait;
    private int valy;

    private SettingsLandscapeview   landscapeView = new SettingsLandscapeview();
    private SettingsPortraitview    portraitView = new SettingsPortraitview();

    public Settingsview() {
        view=landscapeView;
    }

     public void update(boolean arg) {
       
            checkLandORPortrait =  arg;
//         JOptionPane.showMessageDialog(null, "We get in here");

        if (checkLandORPortrait) {
            view = landscapeView;

        } else {

            view = portraitView;
        }

    }

    private void setView() {
        if (checkLandORPortrait) {
//            view = landscapeView;

        } else {

            view = portraitView;
        }
    }

    public MigPane getView() {
        return view;
    }
    public int getValy() {
        return valy;
    }

    public void setValy(int valy) {
        this.valy = valy;
    }

}
