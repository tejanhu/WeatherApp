/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import net.miginfocom.layout.AC;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class sometest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MigPane container = new MigPane("wrap3", "[][][]", "50[]0[]0[]0[]0[]");
        MigPane somepane=getsecondColDetails();
        MigPane somepane2=getthirdColDetails();
        somepane.setTranslateY(-2);
        somepane2.setTranslateY(-2);
        container.add(getWeatherReading2(), "left");
        container.add(somepane,"top");
        container.add(somepane2,"top");
        
        
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(120, 120);
        Scene scene = new Scene(container, 320, 480);
        scrollPane.setContent(container);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
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
    
    public MigPane getWeatherReading() {
        MigPane somecontainer = new MigPane("insets 0 62", "[][grow]");
        Image thecloud = new Image("weatherapp/view/cloudy d.png");
        ImageView cloud = new ImageView(thecloud);
//        Label someimg = new  Label("It's some image \n somecrap \n morecrap", cloud);
//        Label someimg = new  Label("It's some image", cloud);
//        Label someimg = new  Label("Now \n 15 \n 10", cloud);
        Label someimg = new Label("Uk,London", cloud);
//        someimg.setTextAlignment(TextAlignment.CENTER);
        Font jj = new Font("Arial", 14);
        Font mm = new Font("Arial", 8);
        Font nn = new Font("Arial", 10);
        someimg.setFont(nn);
        
        Label somenextthing = new Label("15");
        Label somenextthing2 = new Label("Hi 12");
        Label somenextthing3 = new Label("low 10");
        someimg.setContentDisplay(ContentDisplay.BOTTOM);
        someimg.setGraphicTextGap(0);
        someimg.setTextAlignment(TextAlignment.LEFT);
//        someimg.setTranslateX(-12);
        somenextthing.setFont(jj);
        somenextthing2.setFont(mm);
        somenextthing3.setFont(mm);
//        somenextthing.setAlignment(Pos.BASELINE_LEFT);
        somecontainer.add(someimg);
        somecontainer.add(somenextthing, "top, split3, flowy,span");
        somecontainer.add(somenextthing2, "top,span");
        somecontainer.add(somenextthing3, "top,span");
        somenextthing.setTranslateY(2);
        somenextthing.setTranslateX(-4);
        somenextthing3.setTranslateY(-2);
        somenextthing2.setTranslateX(-4);
        somenextthing3.setTranslateX(-4);
//        someimg.setStyle("-fx-label-padding:0,0,0,4000;");
        return somecontainer;
    }
    public MigPane getWeatherReading2() {
        MigPane somecontainer = new MigPane("insets 0 62", "[][grow][][]");
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
