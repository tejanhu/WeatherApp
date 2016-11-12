/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.Model;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import weatherapp.Stylesheets;
import weatherapp.view.Menuview;
import weatherapp.view.OrientationObserver;

/**
 *
 * @author Samsu
 */
public class Settings_Model   {
    private     boolean      isLandscape=false;
    private     int          isTooltip=1;
    private     String       currentLanguage=Language.ENGLISH;
    private     Menuview     menuView;
    private     Translator   translate = Translator.getInstance();
    private     Audio audi = Audio.getInstance();
    private     HashMap<Integer,Stylesheets> styles = new HashMap<Integer,Stylesheets>();
     private List<OrientationObserver> observers = new ArrayList<OrientationObserver>();
    public Settings_Model() {
        setLandscape();
    }

    public void setLandscape() {
        isLandscape=true;
        notifyAllObservers(isLandscape);
    }
    public void unsetLandscape() {
        isLandscape=false;
        notifyAllObservers(isLandscape);
    }
    public void setToolTipEnabled() {
        isTooltip=1;
//        notifyAllObservers(isTooltip);
    }
    public void setToolTipUNEnabled() {
        isTooltip=0;
//        notifyAllObservers(isTooltip);
    }
    public void setLanguage(String chosenLanguage) {
        currentLanguage=chosenLanguage;
//        notifyAllObservers(currentLanguage);
    }
    public Menuview getMenuView() {
        return menuView;
    }

    public void setMenuView(Menuview menuView) {
        this.menuView = menuView;
    }
    
     public  void readOutText(String text) throws IOException {
        try {
                text = translate.translate(text, Language.ENGLISH, Language.JAPANESE);
                InputStream so = audi.getAudio(text, Language.JAPANESE);
                audi.play(so);
            } catch (JavaLayerException ex) {
                Logger.getLogger(Dashboard_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
     public void attach(OrientationObserver observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(boolean orientation){
      for (OrientationObserver observer : observers) {
         observer.update(orientation);
      }
}
}