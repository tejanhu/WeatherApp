/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import static java.awt.SystemColor.menu;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class OtherCountriesPortraitview extends MigPane{
MigPane topBar = new MigPane("","[grow][]","[grow]");
    MigPane botBar = new MigPane();
    Label  title= new Label("Weather that you are Tracking");
    Font titleFont = new Font("Arial", 24);
    ToggleButton menu = new ToggleButton();
    public OtherCountriesPortraitview() {
       super("wrap,insets 0,gap 0", "[]", "[][]");
       MigPane somepane=getsecondColDetails();
        MigPane somepane2=getthirdColDetails();
       topBar.getStylesheets().add(OtherCountriesPortraitview.class.getResource("OCL.css").toExternalForm());
        botBar.getStylesheets().add(OtherCountriesPortraitview.class.getResource("OCL.css").toExternalForm());
        this.add(topBar, "width 320,height 50");
        this.add(botBar, "width 320,height 430");
        topBar.setId("tb");
        botBar.setId("bb");
             menu.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        title.setTextAlignment(TextAlignment.CENTER);
        menu.setId("meny");
        somepane.setTranslateY(-2);
        somepane2.setTranslateY(-1);
        topBar.add(title,"center");
//        topBar.add(menu,"gapleft 120px");
        topBar.add(menu,"span,right");
        botBar.add(getWeatherReading2());
        botBar.add(somepane,"top");
        botBar.add(somepane2,"top");
        
        
    
    }
    
    public MigPane getWeatherReading2() {
        MigPane somecontainer = new MigPane("insets 0", "15[][grow][][]");
        Image thecloud = new Image("weatherapp/view/cloudy d.png");
        ImageView cloud = new ImageView(thecloud);
//        Label someimg = new  Label("It's some image \n somecrap \n morecrap", cloud);
//        Label someimg = new  Label("It's some image", cloud);
//        Label someimg = new  Label("Now \n 15 \n 10", cloud);
        Label someimg = new Label("Uk,London");
//        someimg.setTextAlignment(TextAlignment.CENTER);
        Font jj = new Font("Arial", 14);
        Font mm = new Font("Arial", 8);
        Font nn = new Font("Arial", 10);
        someimg.setFont(nn);
        
        Label somenextthing = new Label("15°C");
        Label somenextthing2 = new Label("Hi 12°C");
        Label somenextthing3 = new Label("low 10°C");
        Label feelslike = new Label("Feels Like 10");
      
//        someimg.setTranslateX(-12);
        somenextthing.setFont(jj);
        somenextthing2.setFont(mm);
        somenextthing3.setFont(mm);
        feelslike.setFont(mm);
//        somenextthing.setAlignment(Pos.BASELINE_LEFT);
        somecontainer.add(someimg,"");
        
        somecontainer.add(somenextthing, "top, split3, flowy,span");
        somecontainer.add(somenextthing2, "top,span");
        somecontainer.add(somenextthing3, "top,span");
        somecontainer.add(cloud,"");
        
        someimg.setTranslateX(-8);
        someimg.setTranslateY(-15);
        cloud.setTranslateY(-30);
//        somenextthing.setTranslateY(2);
        somenextthing.setTranslateX(-9);
//        somenextthing3.setTranslateY(-2);
        somenextthing2.setTranslateX(-6);
        somenextthing3.setTranslateX(-6);
        somenextthing3.setTranslateY(-1);
//        someimg.setStyle("-fx-label-padding:0,0,0,4000;");
        return somecontainer;
    }

 public MigPane getsecondColDetails() {
        //        container.add(getWeatherReading2(), "span,grow, left");
//        container.add(getWeatherReading2(), "span,grow, left");
//        container.add(getWeatherReading2(), "span,grow, left");
//        container.add(getWeatherReading2(), "span,grow, left");
//        container.add(getWeatherReading2(), "span,grow, left");
        MigPane secondColDetails = new MigPane("wrap");
        Label feelsLike = new Label("Feels Like 10");
        Label dewPoint = new Label("Dew point 10");
        Label windDirection = new Label("Wind-direction:45");
        Font mm = new Font("Arial", 8);
        
        
        feelsLike.setFont(mm);
        dewPoint.setFont(mm);
        windDirection.setFont(mm);
        
        secondColDetails.add(feelsLike);
        secondColDetails.add(dewPoint);
        secondColDetails.add(windDirection);
        return secondColDetails;
    }
 
        public MigPane getthirdColDetails() {
        //        container.add(getWeatherReading2(), "span,grow, left");
//        container.add(getWeatherReading2(), "span,grow, left");
//        container.add(getWeatherReading2(), "span,grow, left");
//        container.add(getWeatherReading2(), "span,grow, left");
//        container.add(getWeatherReading2(), "span,grow, left");
        MigPane thirdColDetails = new MigPane("wrap");
        Label preciptationLabel = new Label("Precipitation 7");
        Label humidityLabel = new Label("Humidity 10");
        Label uvindexLabel = new Label("UV index");
        Font mm = new Font("Arial", 8);
        
        
        preciptationLabel.setFont(mm);
        humidityLabel.setFont(mm);
        uvindexLabel.setFont(mm);
        
        thirdColDetails.add(preciptationLabel);
        thirdColDetails.add(humidityLabel);
        thirdColDetails.add(uvindexLabel);
        return thirdColDetails;
    }
}
