/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Samsu
 */
public class ScreensController extends StackPane{

    HashMap<String, Node> screens = new HashMap<String, Node>();
    public ScreensController() {
    super();
        
    }

    public Node getScreen(String name) {
        return screens.get(name);
    }
    
    
    
    
    
}
