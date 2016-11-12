/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.Model;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import java.util.List;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Place;

/**
 *
 * @author Samsu
 */
public class weatherapitestg {
    public static void main(String[] args) {
        GooglePlaces gg = new GooglePlaces("AIzaSyBnPbWJX-lwyqPSeSP_8elrlYpKllcOPzI");
        
        List<Place> mm =gg.getPlacesByQuery("Stratford town hall ", GooglePlaces.MAXIMUM_RESULTS);
        Place theplace = mm.get(0);
        
        ForecastIO weather = new ForecastIO("1c8562e22739fe85aeb8686b8edeba63");
        
        weather.setUnits(ForecastIO.UNITS_UK);
        weather.setLang(ForecastIO.LANG_ENGLISH);
        weather.getForecast(String.valueOf(theplace.getLatitude()),String.valueOf(theplace.getLongitude()));
//            FIODaily daily = new FIODaily(weather);
//            
//    //In case there is no daily data available
//    if(daily.days()<0)
//        System.out.println("No daily data.");
//    else
//        System.out.println("\nDaily:\n");
//    //Print daily data
//    for(int i = 0; i<daily.days(); i++){
//        String [] h = daily.getDay(i).getFieldsArray();
//        System.out.println("Day #"+(i+1));
//        for(int j=0; j<h.length; j++)
//            System.out.println(h[j]+": "+daily.getDay(i).getByKey(h[j]));
//        System.out.println("\n");
//    }
    
     FIOCurrently currently = new FIOCurrently(weather);
     FIODaily cc = new FIODaily(weather);
    //Print currently data
    System.out.println("\nCurrently\n");
        System.out.println("The temperature is :"+currently.get().temperature());
       
//    String [] f  = currently.get().getFieldsArray();
//    for(int i = 0; i<f.length;i++)
//        System.out.println(f[i]+": "+currently.get().getByKey(f[i]));
//    

     for(int i = 0; i<cc.days(); i++){
        String [] h = cc.getDay(i).getFieldsArray();
        System.out.println("Day #"+(i+1));
        for(int j=0; j<h.length; j++)
            System.out.println(h[j]+": "+cc.getDay(i).getByKey(h[j]));
        System.out.println("\n");
    }
    FIODataPoint fiod = cc.getDay(2);
        System.out.println();
        System.out.println("The weather on this day is ");
        System.out.println(fiod.temperature());
    
    
    
    
        
    }
}
