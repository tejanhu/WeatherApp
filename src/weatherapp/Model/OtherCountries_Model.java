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

/**
 *
 * @author Samsu
 */
public class OtherCountries_Model {

    private     Translator  translate = Translator.getInstance();
    private     String      defaultLanguage = Language.ENGLISH;
    private     String      translatedLanguage;
    private     String      titleText = "Weather that you are tracking";
    private     String      translatedTitleText;
    private     String      menuTooltipText = "Click for the menu to appear";
    private     String      translatedmenuToolTipText;
    private     HashMap<Integer,Stylesheets> styles = new HashMap<Integer,Stylesheets>();
    private     Audio audi = Audio.getInstance();
   
   
    public String getTranslatedmenuToolTipText() {
        translatedmenuToolTipText=translate.translate(menuTooltipText, defaultLanguage, translatedLanguage);
        return translatedmenuToolTipText;
    }
    

    public void setTranslatedLanguage(String translatedLanguage) {
        this.translatedLanguage = translatedLanguage;
    }

    public String getTranslatedTitleText() {
        translatedTitleText=translate.translate(titleText, defaultLanguage, translatedLanguage);
        return translatedTitleText;
    }

    /**
     * @param defaultLanguage the defaultLanguage to set
     */
    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
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
    
    
    
}
