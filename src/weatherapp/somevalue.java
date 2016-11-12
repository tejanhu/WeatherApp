/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.value.ChangeListener;

/**
 *
 * @author Samsu
 */
public class somevalue extends ReadOnlyStringProperty{
private String valy;

    public void setValy(String valy) {
        this.valy = valy;
    }
    @Override
    public String get() {
        return valy;
    }

    @Override
    public void addListener(ChangeListener<? super String> listener) {
        System.out.println("Blah");
    }

    @Override
    public void removeListener(ChangeListener<? super String> listener) {
        System.out.println("some more crap");
    }

    @Override
    public void addListener(InvalidationListener listener) {
        System.out.println("This doesn't work ");
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        System.out.println("This doesn't work to");
        
    }

    @Override
    public Object getBean() {
        return this;
    }

    @Override
    public String getName() {
        return "This doesn't have a name";
    }
    
}
