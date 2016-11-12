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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import weatherapp.Stylesheets;
import weatherapp.view.OtherCountriesview;
import weatherapp.view.Settingsview;
import weatherapp.view.TrackWeatherview;

/**
 *
 * @author Samsu
 */
public class Menu_Model {
    private     HashMap<Integer,Stylesheets> styles = new HashMap<Integer,Stylesheets>();


    private     OtherCountriesview   otherLocationsView;
    private     TrackWeatherview     trackWeatherView ;
    private     Settingsview         settingsView;
    private     Translator           translate = Translator.getInstance();
    private     Audio                audi = Audio.getInstance();
    
    public  void readOutText(String text) throws IOException {
    try {

        text = translate.translate(text, Language.ENGLISH, Language.JAPANESE);
        InputStream so = audi.getAudio(text, Language.JAPANESE);
        audi.play(so);
    } 
        catch (JavaLayerException ex) {
        Logger.getLogger(Dashboard_Model.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     
    public  String setTranslatedText(String text){
        return text = translate.translate(text, Language.ENGLISH, Language.JAPANESE);   
    } 
     
    public void setOtherLocationsView(OtherCountriesview otherLocationsView) {
        this.otherLocationsView = otherLocationsView;
    }

    public void setTrackWeatherView(TrackWeatherview trackWeatherView) {
        this.trackWeatherView = trackWeatherView;
    }

    public void setSettingsView(Settingsview settingsView) {
        this.settingsView = settingsView;
    }
    public OtherCountriesview getOtherLocationsView() {
        return otherLocationsView;
    }

    public TrackWeatherview getTrackWeatherView() {
        return trackWeatherView;
    }

    public Settingsview getSettingsView() {
        return settingsView;
    }
    
    
}
