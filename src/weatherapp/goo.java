/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.io.IOException;
import java.util.List;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Place;


/**
 *
 * @author Samsu
 */
public class goo {
    public static void main(String[] args) throws IOException {
       
        GooglePlaces gg = new GooglePlaces("AIzaSyBnPbWJX-lwyqPSeSP_8elrlYpKllcOPzI");
        
        List<Place> mm =gg.getPlacesByQuery("Stratford town hall ", GooglePlaces.MAXIMUM_RESULTS);
        
        
        for (Place mm1 : mm) {
            
        System.out.println("This is stratford :"+ mm1.getName());
        System.out.println("This is stratford :"+ mm1.getAddress());
        
        }
        
        
       
        
        
        
    }
}
