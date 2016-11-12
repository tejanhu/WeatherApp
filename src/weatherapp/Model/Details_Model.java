/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.Model;

import com.gtranslate.Language;
import com.gtranslate.Translator;
import java.util.HashMap;
import weatherapp.Stylesheets;

/**
 *
 * @author Samsu
 */
public class Details_Model  {
    private     Translator  translate = Translator.getInstance();
    private     String      defaultLanguage = Language.ENGLISH;
    private     String      translatedLanguage;
    private     String      menuTooltipText = "Click for the menu to appear";
    private     String      chanceOFRainText="Chance of Rain:";
    private     String      humidityText="Humidity:";
    private     String      windText="Wind:";
    private     String      feelsLikeRainText="Feels like:";
    private     String      uvIndexText="Uv Index:";
    private     String      translatedMenuToolTipText;
    private     String      translatedChanceOFRainText;
    private     String      translatedHumidityText;
    private     String      translatedWindText;
    private     String      translatedFeelslikeRainText;
    private     String      translatedUvIndexText;
    private     HashMap<Integer,Stylesheets> styles = new HashMap<Integer,Stylesheets>();
    public String getTranslatedChanceOFRainText() {
        translatedChanceOFRainText=translate.translate(chanceOFRainText, defaultLanguage, translatedLanguage);
        return translatedChanceOFRainText;
    }

    public String getTranslatedHumidityText() {
        translatedHumidityText=translate.translate(humidityText, defaultLanguage, translatedLanguage);
        return translatedHumidityText;
    }

    public String getTranslatedWindText() {
        translatedWindText=translate.translate(windText, defaultLanguage, translatedLanguage);
        return translatedWindText;
    }

    public String getTranslatedFeelslikeRainText() {
        translatedFeelslikeRainText=translate.translate(feelsLikeRainText, defaultLanguage, translatedLanguage);
        return translatedFeelslikeRainText;
    }

    public String getTranslatedUvIndexText() {
        translatedUvIndexText=translate.translate(uvIndexText, defaultLanguage, translatedLanguage);
        return translatedUvIndexText;
    }
    
     public void setTranslatedLanguage(String translatedLanguage) {
        this.translatedLanguage = translatedLanguage;
    }
    
    /**
     * @param defaultLanguage the defaultLanguage to set
     */
    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }
    
        public String getTranslatedmenuToolTipText() {
        translatedMenuToolTipText=translate.translate(menuTooltipText, defaultLanguage, translatedLanguage);
        return translatedMenuToolTipText;
    }
    
    
}
