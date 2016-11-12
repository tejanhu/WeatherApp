/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class DetailsPortraitview extends MigPane{
    private     Separator               topSeparator;
    private     Separator               midSeparator;
    private     Separator               botSeparator;
    private     MigPane                 topBlock;
    private     MigPane                 botBlock;
    private     Label                   dayOFWeather;
    private     Label                   statusOFWeather;
    private     Label                   tempOFWeather;
    private     Label                   degreesOFWeather;
    private     Label                   chanceOFRainWeather;
    private     Label                   humidityWeather;
    private     Label                   windWeather;
    private     Label                   feelsLikeWeather;
    private     Label                   uvIndexWeather;    
    private     Label                   valuechanceOFRainWeather;
    private     Label                   valuehumidityWeather;
    private     Label                   valuewindFWeather;
    private     Label                   valuefeesLikeWeather;
    private     Label                   valueuvIndexWeather;
    private     Label                   valuedegreesOFWeather;
    private     Font                    dayOFWeatherFont;
    private     Font                    state_valFont;
    private     Font                    tempOFWeatherFont;
    private     Font                    degreesOFWeatherFont;
    public      ImageView               statusOFWeatherImage;
    

// ******************** Constructors **************************************
    public DetailsPortraitview() {
            super("wrap,debug", "[grow]", "[][]");
            topBlock = getTopBlock();
            botBlock = getBotBlock();

            this.add(topBlock, "top,span,growx");
            this.add(botBlock, "width 210,height 196,span, center");

            this.setStyle("-fx-background-color:red");

        
    }
    
// ******************** Initialization(topBlock) **************************************
    private MigPane getTopBlock() {
        
            MigPane topBlock = new MigPane("debug,,wrap4", "[grow][grow][grow][grow]", "[][][]");
            SimpleDateFormat fmt = new SimpleDateFormat("hh:mm a");
            Label time = new Label(fmt.format(new Date()));
            System.out.println(fmt.format(new Date()));

            Label loc = new Label("Location");

            loc.setFont(new Font("Verdana", 18));
            loc.getStylesheets().add(DetailsLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            loc.setId("locy");
            Button ltab = new Button("UK");
            Button ltab2 = new Button("UK");
            ltab.setPrefSize(38, 23);
            ltab2.setPrefSize(38, 23);

            ltab.getStylesheets().add(DetailsLandscapeview.class.getResource("Weatherland.css").toExternalForm());

            ltab2.getStylesheets().add(DetailsLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            ltab.setId("latab");
            ltab2.setId("latab");
            ltab.setFont(new Font("Verdana", 8));
            ltab2.setFont(new Font("Verdana", 8));

            ToggleButton menu = new ToggleButton();
            menu.getStylesheets().add(DetailsLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            menu.setId("meny");
            time.getStylesheets().add(DetailsLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            time.setId("timy");
            time.setFont(new Font("Verdana", 18));
            ltab.setFont(new Font("Arial", 14));
            ltab2.setFont(new Font("Arial", 14));
            ltab.setAlignment(Pos.CENTER);
            ltab2.setAlignment(Pos.CENTER);

            time.setId("timy");

            topBlock.add(time, "");

         
            topBlock.add(menu, "span,right");

//            topBlock.add(loc, "gaptop 3px,gapleft 5px,span");
            topBlock.add(loc, "");

        return topBlock;

    }
    
// ******************** Initialization(botBlock) ************************************
    private MigPane getBotBlock() {
            MigPane botBlock = new MigPane("wrap2,insets 0,gap 0", "[grow][grow]", "[][][][][][][][][][]");

            topSeparator = new Separator(Orientation.HORIZONTAL);
            midSeparator = new Separator(Orientation.HORIZONTAL);
            botSeparator = new Separator(Orientation.HORIZONTAL);

            /* top area with basic weather information*/
            statusOFWeather = new Label("Cloudy");
            dayOFWeather = new Label("Now");
            tempOFWeather = new Label("15");
            degreesOFWeather = new Label("ºC");

            /* left hand side values*/
            chanceOFRainWeather = new Label("Chance of Rain:");
            humidityWeather = new Label("Humidity:");
            windWeather = new Label("Wind:");
            feelsLikeWeather = new Label("Feels like:");
            uvIndexWeather = new Label("UV Index:");


            /* Right hand side values*/        
            valuechanceOFRainWeather = new Label("30%");
            valuehumidityWeather = new Label("60%");
            valuewindFWeather = new Label("NW 3mph");
            valuefeesLikeWeather = new Label("11ºC");
            valueuvIndexWeather = new Label("0");


            /* Fonts for the labels*/
            dayOFWeatherFont = new Font("Arial",24);
            state_valFont = new Font("Arial",14);
            tempOFWeatherFont = new Font("Arial",36);
            degreesOFWeatherFont = new Font("Arial",18);
            
            statusOFWeatherImage = new ImageView("weatherapp/view/cloud_d.png");
            
            dayOFWeather.setFont(dayOFWeatherFont);
            statusOFWeather.setFont(state_valFont);
            tempOFWeather.setFont(tempOFWeatherFont);
            degreesOFWeather.setFont(degreesOFWeatherFont);
            
            chanceOFRainWeather.setFont(state_valFont);
            humidityWeather.setFont(state_valFont);
            windWeather.setFont(state_valFont);
            feelsLikeWeather.setFont(state_valFont);
            uvIndexWeather.setFont(state_valFont);
            
            valuechanceOFRainWeather.setFont(state_valFont);
            valuehumidityWeather.setFont(state_valFont);
            valuewindFWeather.setFont(state_valFont);
            valuefeesLikeWeather.setFont(state_valFont);
            valueuvIndexWeather.setFont(state_valFont);
            
//            statusOFWeather.setGraphic(statusOFWeatherImage);
//            statusOFWeather.setContentDisplay(ContentDisplay.BOTTOM);

            botBlock.add(topSeparator, "span,gaptop 10px,grow");
            
            botBlock.add(statusOFWeather, "");
            botBlock.add(dayOFWeather, "");
            botBlock.add(statusOFWeatherImage, "");
            botBlock.add(tempOFWeather,"split2");
            botBlock.add(degreesOFWeather,"");
            
            botBlock.add(midSeparator, "span,grow");
            
            botBlock.add(chanceOFRainWeather,"center");
            botBlock.add(valuechanceOFRainWeather);
            botBlock.add(humidityWeather);
            botBlock.add(valuehumidityWeather);
            botBlock.add(windWeather);
            botBlock.add(valuewindFWeather);
            botBlock.add(feelsLikeWeather);
            botBlock.add(valuefeesLikeWeather);
            botBlock.add(uvIndexWeather);
            botBlock.add(valueuvIndexWeather);
            
            botBlock.add(botSeparator, "span,grow");
            
        

        return botBlock;
    }

    
    
    
}
