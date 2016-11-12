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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javazoom.jl.decoder.JavaLayerException;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Place;
import weatherapp.Stylesheets;
import weatherapp.view.Menuview;
import weatherapp.view.TrackWeatherLandscapeview;

/**
 *
 * @author Samsu
 */
public class TrackWeather_Model {
private     HashMap<Integer,Stylesheets> styles = new HashMap<Integer,Stylesheets>();
private     Translator                   translate = Translator.getInstance();
private     String                       typeText  ="Enter the Countries that you want to track";
private     String                       countriesSuggestedText  ="Countries suggested:";
private     String                       countriesPickedText  ="Countries Picked:";
private     String                       defaultLanguage=Language.ENGLISH;
private     String                       translatedLanguage;
private     String                       translatedTypeText;
private     String                       translatedCountriesSuggestedText;
private     String                       translatedCountriesPickedText;
private     String                       trackCountriesButtonText="Track these countries";
private     String                       translatedButtonTrack;
private     Audio                        audi = Audio.getInstance();
private     GooglePlaces                 placeFinder = new GooglePlaces("AIzaSyBnPbWJX-lwyqPSeSP_8elrlYpKllcOPzI");
private     Place                        currentPlace ; 
private     Menuview                     menuView;

    public Menuview getMenuView() {
        return menuView;
    }

    public void setMenuView(Menuview menuView) {
        this.menuView = menuView;
    }
    public String getTranslatedButtonTrack() {
        translatedButtonTrack=translate.translate(trackCountriesButtonText, defaultLanguage, translatedLanguage);
        return translatedButtonTrack;
    }

    public String getTranslatedcountriesSuggestedText() {
        translatedCountriesPickedText=translate.translate(countriesSuggestedText, defaultLanguage, translatedLanguage);
        return translatedCountriesSuggestedText;
    }

    public String getTranslatedcountriesPickedText() {
        translatedCountriesPickedText=translate.translate(countriesPickedText, defaultLanguage, translatedLanguage);
        return translatedCountriesPickedText;
    }

    public void setTranslatedLanguage(String translatedLanguage) {
        this.translatedLanguage = translatedLanguage;
    }
    
    public String getTranslatedTypeText() {
        translatedTypeText=translate.translate(typeText, defaultLanguage, translatedLanguage);
        return translatedTypeText;
    }

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

    public  ObservableList<String> getLocations( String text) {
       
   List<Place> places =placeFinder.getPlacesByQuery(text, GooglePlaces.MAXIMUM_RESULTS);
     
   ObservableList someplaces = FXCollections.observableArrayList();
        for (Place someplace : places) {
            someplaces.add(someplace.getAddress());
            System.out.println(someplace.getAddress());
        }
   
    return someplaces;     
    }

    
    
}
