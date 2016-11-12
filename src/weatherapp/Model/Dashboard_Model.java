/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weatherapp.Model;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Place;
import weatherapp.Stylesheets;
import weatherapp.tipsText;
public class Dashboard_Model {
        
        ForecastIO weather = new ForecastIO("f1b3722aa7f178fe3b686fdafa080de4");
        private     HashMap<Integer,Stylesheets> styles = new HashMap<Integer,Stylesheets>();
        private     SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        private     FIODaily     dailyForecast ;
        private     String          location; 
        private     GooglePlaces placeFinder = new GooglePlaces("AIzaSyBnPbWJX-lwyqPSeSP_8elrlYpKllcOPzI");
        private     Place currentPlace ; 
        private     FIOCurrently currently;
        private     tipsText quotes;
        private     Translator translate = Translator.getInstance();
        private     Audio audi = Audio.getInstance();
        private     Date             time = new Date();
        private     String           longitude;
        private     String           latitude;
        private     String           resultoftime ="";
        private     String           currentTemp="";
        private     String           day2lowTemp="";
        private     String           day2highTemp="";
        private     String           day3lowTemp="";
        private     String           day3highTemp="";
        private     String           day1Text="Now";
        private     String           day2="";
        private     String           day3="";


        
    public String getDay2() {
       
       double temporaryTemp=  dailyForecast.getDay(2).temperature();
        int val =(int)temporaryTemp;
        day2=String.valueOf(val);
        return day2;
    }

    public  void readOutText(String text) throws IOException {
            try {
                //        weather.getForecast("38.7252993", "-9.1500364");
                  text = translate.translate(text, Language.ENGLISH, Language.JAPANESE);
                InputStream so = audi.getAudio(text, Language.JAPANESE);
                audi.play(so);
            } catch (JavaLayerException ex) {
                Logger.getLogger(Dashboard_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public  String setTranslatedText(String text)  {
          
                //        weather.getForecast("38.7252993", "-9.1500364");
                  return text = translate.translate(text, Language.ENGLISH, Language.JAPANESE);
                
    }
    public Dashboard_Model() {
        initiliaseQuotes();
        weather.getForecast("38.7252993", "-9.1500364");
      
        currently = new FIOCurrently(weather);
        dailyForecast = new FIODaily(weather);
        weather.setUnits(ForecastIO.UNITS_UK);
        weather.setLang(ForecastIO.LANG_ENGLISH);
//        setLocationtemp();
        
        
        
   }

    private void initiliaseQuotes()  {
            try {
                quotes = new tipsText();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dashboard_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void setLocationtemp() {
        currentPlace= placeFinder.getPlacesByQuery(location, GooglePlaces.MAXIMUM_RESULTS).get(0);
        latitude = String.valueOf(currentPlace.getLatitude());
        longitude = String.valueOf(currentPlace.getLongitude());
        weather.getForecast(latitude, longitude);
    }

    /**
     * @return the resultoftime
     */
    public String getResultoftime() {
        
        return resultoftime;
    }

    /**
     * @return the currentTemp
     */
    public String getCurrentTemp() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
//        System.out.println("The temp is "+currently.get().temperature());
//        currentTemp=String.valueOf(currently.get().temperature());
//        int val = (int)currently.get().temperature();
        double temporaryTemp= currently.get().temperature();
        int val =(int)temporaryTemp;
//        currentTemp=(nf.format(currently.get().temperature()));
        currentTemp=(String.valueOf(val));
        return currentTemp;
    }

    /**
     * @return the day2lowTemp
     */
    public String getDay2lowTemp() {
          double temporaryTemp=  dailyForecast.getDay(2).temperatureMin();
        int val =(int)temporaryTemp;
        day2lowTemp=String.valueOf(val);
        
        return day2lowTemp;
    }

    /**
     * @return the day2highTemp
     */
    public String getDay2highTemp() {
         double temporaryTemp=  dailyForecast.getDay(2).temperatureMax();
        int val =(int)temporaryTemp;
        day2highTemp=String.valueOf(val);
        
        return day2highTemp;
    }

    /**
     * @return the day3lowTemp
     */
    public String getDay3lowTemp() {
          double temporaryTemp=  dailyForecast.getDay(3).temperatureMin();
        int val =(int)temporaryTemp;
        day2lowTemp=String.valueOf(val);
        
       
        return day3lowTemp;
    }

    /**
     * @return the day3highTemp
     */
    public String getDay3highTemp() {
          double temporaryTemp=  dailyForecast.getDay(3).temperatureMax();
        int val =(int)temporaryTemp;
        day2lowTemp=String.valueOf(val);
       
        return day3highTemp;
    }

    public void setLocation(String location) {
        this.location = location;
    }
  
    public SimpleDateFormat getDateformat() {
        return dateFormat;
    }
    
    public Date getTime() {
//        getRandomQuote();
        return time;
    }

//    public String getRandomQuote() {
//        Random giveRandom = new Random();
//        int chosenquote=giveRandom.nextInt(quotes.getQuotes().size()-1)+1;
//      return quotes.getQuotes().get(chosenquote);
//    }
//   
    
    
    public static void main(String[] args) {
        try {
        System.out.println(new Dashboard_Model().getDay2highTemp());
            
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        
    }
    
}
