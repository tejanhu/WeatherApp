/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samsu
 */
public class tipsText {
    
    private HashMap<Integer, String> quotes = new HashMap<Integer, String>();

    public HashMap<Integer, String> getQuotes() {
        return quotes;
    }

    public tipsText() throws FileNotFoundException {
        int i=1;
        Scanner scan = new Scanner(new FileReader("src/weatherapp/quotes.txt"));
        while (scan.hasNextLine()) {
            String quote=scan.nextLine();
            quotes.put(i, quote);
            i=i+1;
        }
        
//        for (int j = 1; j <= quotes.size(); j++) {
//            System.out.println(quotes.get(j));
//            
//        }
        
        System.out.println(quotes.size());
        
    }
    
    
}
