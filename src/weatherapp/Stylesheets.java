/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.HashMap;

/**
 *
 * @author Samsu
 */
public class Stylesheets {

  private   String landscape;
  private   String portrait;

    public Stylesheets(String landscape, String portrait) {
        this.landscape = landscape;
        this.portrait = portrait;
    }

    @Override
    public boolean equals(Object obj) {
       Stylesheets gg = (Stylesheets) obj;
        if (this.equals(gg)) {
            return true;
        } else {
        return false;
        }
    }

    @Override
    public int hashCode() {
        return 5;
    }
    public String getLandscape() {
        return landscape;
    }

    public String getPortrait() {
        return portrait;
    }
    
  
}
