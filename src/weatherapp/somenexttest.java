/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author Samsu
 */
public class somenexttest {
    public static void main(String[] args) throws IOException {
        
        
        try {
            Translator translate = Translator.getInstance();
            String text = translate.translate("1", Language.ENGLISH, Language.SPANISH);
            Audio audi = Audio.getInstance();
            InputStream so = audi.getAudio(text, Language.SPANISH);
            audi.play(so);
            
            System.out.println(text); //Eu sou programador
        } catch (JavaLayerException ex) {
            Logger.getLogger(somenexttest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
