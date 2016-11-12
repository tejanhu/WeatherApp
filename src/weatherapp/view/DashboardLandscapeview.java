
package weatherapp.view;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.tbee.javafx.scene.layout.MigPane;
import weatherapp.Model.Dashboard_Model;


public class DashboardLandscapeview extends MigPane implements DashboardInteface{
private         Service<Void>   someservice;
private         ToggleButton    menu;
private         MigPane         Weathercont;
private         Label           lbl_NowDegreec;
private         Label           timeLabel;
private         Label           currenttemp;
private         Label           lbl_Tom;
private         Label           Lbl_now;
private         Label           Lbl_Wed;
private         Tooltip         menuToolTip;
private         Tooltip         tipsbuttonToolTip;
private         Button          tips;
private         Label           locationLabel;

    public Label getLocationLabel() {
        return locationLabel;
    }

    public void setLocationLabel(Label locationLabel) {
        this.locationLabel = locationLabel;
    }

    public Label getLbl_Tom() {
        return lbl_Tom;
    }

    public Label getLbl_now() {
        return Lbl_now;
    }

    public Label getLbl_Wed() {
        return Lbl_Wed;
    }

    public Button getTips() {
        return tips;
    }

    public Label getCurrenttemp() {
        return currenttemp;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

  
    public ToggleButton getMenu() {
        return menu;
    }

    public DashboardLandscapeview() {
        super("insets 0,wrap,gap 0", "[]", "[][]");
        this.setMinSize(480, 320);
        this.add(getTopblock(), "height 203, width 480,dock north");

        this.add(getBotblock(), "height 117, width 480,dock south");
        
    }
    
   

    
    public  void setNowTemp(String newTemp) {
        lbl_NowDegreec.setText(newTemp);
//        MigPane Tempnow = new MigPane("debug","","[][][]");
//        MigPane Temptom = new MigPane("debug","[]","[][][]");
//        MigPane Tempwed = new MigPane("debug","[]","[][][]");
        
//        getDegree_Now();
    }

    
    public GridPane getNowtemp() {
        GridPane nowtemp = new GridPane();
        nowtemp.setAlignment(Pos.CENTER);
        Lbl_now = new Label("Now");
            Lbl_now.setFont(new Font("Verdana", 18));
            Lbl_now.setAlignment(Pos.CENTER);
            Lbl_now.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_now.setId("textforreading");
            Lbl_now.setBorder(Border.EMPTY);
            Lbl_now.setTranslateX(15);
            Lbl_now.setTranslateY(4);
            
        lbl_NowDegreec = new Label("15");
            lbl_NowDegreec.setFont(new Font("Verdana", 40));
            lbl_NowDegreec.setAlignment(Pos.TOP_CENTER);
            lbl_NowDegreec.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            lbl_NowDegreec.setId("textforreading");
            lbl_NowDegreec.setTranslateY(-1);
            lbl_NowDegreec.setTranslateX(15);
//                Lbl_degreec.setLineSpacing(600);
          Label Lbl_degreecelsius= new Label("°C"); 
            Lbl_degreecelsius.setFont(new Font("Verdana", 18));
            Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER); 
            Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreecelsius.setId("textforreading");
            Lbl_degreecelsius.setTranslateX(8);
            Lbl_degreecelsius.setTranslateY(-12);
            
         
        thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
        
       
            ImageView cloud = new ImageView (thecloud);
            cloud.setTranslateX(15);
            cloud.setTranslateY(-8);

        
        nowtemp.setHalignment(Lbl_now, HPos.CENTER);
        nowtemp.setHalignment(lbl_NowDegreec, HPos.CENTER);
        nowtemp.setHalignment(cloud, HPos.CENTER);
        nowtemp.setValignment(cloud, VPos.CENTER);
     
        nowtemp.add(Lbl_now, 0, 0);
        nowtemp.add(lbl_NowDegreec, 0, 1);
        nowtemp.add(Lbl_degreecelsius, 1, 1);
        nowtemp.add(cloud, 0, 2);
            
//        nowtemp.setGridLinesVisible(true);
        
    return nowtemp;
    }

    
    public void setImageWeather(String imagepath) {
        thecloud = new Image(imagepath);
    }
    private Image thecloud;
    
    public GridPane getTomtemp() {
        GridPane tomTemp = new GridPane();
        tomTemp.setAlignment(Pos.CENTER);
        lbl_Tom = new Label("Tommorow");
            lbl_Tom.setFont(new Font("Verdana", 18));
            lbl_Tom.setAlignment(Pos.CENTER);
            lbl_Tom.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            lbl_Tom.setId("textforreading");
            lbl_Tom.setBorder(Border.EMPTY);
            lbl_Tom.setTranslateX(15);
            lbl_Tom.setTranslateY(4);
            
          Label Lbl_degreec = new Label("15");
            Lbl_degreec.setFont(new Font("Verdana", 40));
            Lbl_degreec.setAlignment(Pos.TOP_CENTER);
            Lbl_degreec.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreec.setId("textforreading");
            Lbl_degreec.setTranslateY(-1);
            Lbl_degreec.setTranslateX(15);
//                Lbl_degreec.setLineSpacing(600);
              Label Lbl_degreecelsius= new Label("°C"); 
                Lbl_degreecelsius.setFont(new Font("Verdana", 18));
                Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER); 
                Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
                Lbl_degreecelsius.setId("textforreading");
                Lbl_degreecelsius.setTranslateX(-3);
                Lbl_degreecelsius.setTranslateY(-12);
            
         
            Image thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
            ImageView cloud = new ImageView (thecloud);
            cloud.setTranslateX(15);
            cloud.setTranslateY(-8);

        
        tomTemp.setHalignment(lbl_Tom, HPos.CENTER);
        tomTemp.setHalignment(Lbl_degreec, HPos.CENTER);
        tomTemp.setHalignment(cloud, HPos.CENTER);
        tomTemp.setValignment(cloud, VPos.CENTER);
     
        tomTemp.add(lbl_Tom, 0, 0);
        tomTemp.add(Lbl_degreec, 0, 1);
        tomTemp.add(Lbl_degreecelsius, 1, 1);
        tomTemp.add(cloud, 0, 2);
            
//        nowtemp.setGridLinesVisible(true);
        
    return tomTemp;
    }
    
    public GridPane getWedtemp() {
        GridPane nowtemp = new GridPane();
        nowtemp.setAlignment(Pos.CENTER);
        Lbl_Wed = new Label("Wednesday");
            Lbl_Wed.setFont(new Font("Verdana", 18));
            Lbl_Wed.setAlignment(Pos.CENTER);
            Lbl_Wed.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_Wed.setId("textforreading");
            Lbl_Wed.setBorder(Border.EMPTY);
//            Lbl_Wed.setTranslateX(0);
            Lbl_Wed.setTranslateY(4);
            
          Label Lbl_degreec = new Label("15");
            Lbl_degreec.setFont(new Font("Verdana", 40));
            Lbl_degreec.setAlignment(Pos.TOP_CENTER);
            Lbl_degreec.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreec.setId("textforreading");
            Lbl_degreec.setTranslateY(-1);
            Lbl_degreec.setTranslateX(15);
//                Lbl_degreec.setLineSpacing(600);
              Label Lbl_degreecelsius= new Label("°C"); 
                Lbl_degreecelsius.setFont(new Font("Verdana", 18));
                Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER); 
                Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
                Lbl_degreecelsius.setId("textforreading");
                Lbl_degreecelsius.setTranslateX(0);
                Lbl_degreecelsius.setTranslateY(-12);
            
         
            Image thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
            ImageView cloud = new ImageView (thecloud);
            cloud.setTranslateX(15);
            cloud.setTranslateY(-8);

        
        nowtemp.setHalignment(Lbl_Wed, HPos.CENTER);
        nowtemp.setHalignment(Lbl_degreec, HPos.CENTER);
        nowtemp.setHalignment(cloud, HPos.CENTER);
        nowtemp.setValignment(cloud, VPos.CENTER);
     
        nowtemp.add(Lbl_Wed, 0, 0);
        nowtemp.add(Lbl_degreec, 0, 1);
        nowtemp.add(Lbl_degreecelsius, 1, 1);
        nowtemp.add(cloud, 0, 2);
            
//        nowtemp.setGridLinesVisible(true);
        
    return nowtemp;
    }

    
    public MigPane getDegree_Now() {
        MigPane degree_now = new MigPane("", "[][]", "[]");
        
        Label Lbl_degreec = new Label("15");
            Lbl_degreec.setFont(new Font("Verdana", 40));
            Lbl_degreec.setAlignment(Pos.TOP_CENTER);
            Lbl_degreec.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreec.setId("textforreading");

            
        Label Lbl_degreecelsius= new Label("°C"); 
            Lbl_degreecelsius.setFont(new Font("Verdana", 18));
            Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER);
            Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreecelsius.setId("textforreading");

        
        degree_now.add(Lbl_degreec);
        degree_now.add(Lbl_degreecelsius,"wrap");
        
        return degree_now;
    }
    
    public MigPane getDegree_Now2() {
        MigPane degree_now = new MigPane("wrap", "[grow,center]", "[grow,center][grow,center][grow,center]");
        
       Label Lbl_now = new Label("Now");
            Lbl_now.setFont(new Font("Verdana", 18));
            Lbl_now.setAlignment(Pos.CENTER);
            Lbl_now.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_now.setId("textforreading");
            Lbl_now.setBorder(Border.EMPTY);
        
        
        Label Lbl_degreec = new Label("15");
            Lbl_degreec.setFont(new Font("Verdana", 40));
            Lbl_degreec.setAlignment(Pos.TOP_CENTER);
            Lbl_degreec.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreec.setId("textforreading");
//            Lbl_degreec.setPrefHeight(40);
            Lbl_degreec.setBorder(Border.EMPTY);
//            Lbl_degreec.setTranslateY(8);
        Label Lbl_degreecelsius= new Label("°C"); 
            Lbl_degreecelsius.setFont(new Font("Verdana", 18));
            Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER);
            Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreecelsius.setId("textforreading");
            Lbl_degreecelsius.setBorder(Border.EMPTY);
//            Lbl_degreecelsius.setPrefHeight(42);
            Image thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
            ImageView cloud = new ImageView (thecloud);
//        cloud.setFitHeight(38);
//        cloud.setFitWidth(78);
//        degree_now.add(Lbl_now,"center,width 48px,height 18px");
//        degree_now.add(Lbl_now,"center,width 41px,height 31px");
        degree_now.add(Lbl_now,"center,width 41px,height 31px,gaptop 10px");
        
//        degree_now.add(Lbl_degreec,"split2,center");
        degree_now.add(Lbl_degreec,"split2,center,height 15px");
//        degree_now.add(Lbl_degreec,"split2,height 34px,width 50px ");
        degree_now.add(Lbl_degreecelsius,"center,height 15px");
//        degree_now.add(Lbl_degreecelsius,"center,push");

        degree_now.add(cloud,"wrap,gapbottom 0px,gaptop -20px");
   
        
        return degree_now;
    }
    
    public MigPane getDegree_Tom() {
        MigPane degree_now = new MigPane("wrap", "[grow,center]", "[grow][grow][grow]");
        
       Label lbl_tom = new Label("Tommorow");
            lbl_tom.setFont(new Font("Verdana", 18));
            lbl_tom.setAlignment(Pos.CENTER);
            lbl_tom.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            lbl_tom.setId("textforreading");
            lbl_tom.setBorder(Border.EMPTY);
        
        Label Lbl_degreec = new Label("15");
            Lbl_degreec.setFont(new Font("Verdana", 40));
            Lbl_degreec.setAlignment(Pos.TOP_CENTER);
            Lbl_degreec.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreec.setId("textforreading");
            Lbl_degreec.setBorder(Border.EMPTY);
//            Lbl_degreec.setPrefHeight(40);
            
        Label Lbl_degreecelsius= new Label("°C"); 
            Lbl_degreecelsius.setFont(new Font("Verdana", 18));
            Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER);
            Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreecelsius.setId("textforreading");
            Lbl_degreecelsius.setBorder(Border.EMPTY);
//            Lbl_degreecelsius.setPrefHeight(42);
//            Image thecloud = new Image("weatherapp/view/Weathermisty.jpeg");
            Image thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
            ImageView cloud = new ImageView (thecloud);
        
//        degree_now.add(Lbl_now,"center,width 48px,height 18px");
//        degree_now.add(lbl_tom,"center,width 41px,height 31px,span");
        degree_now.add(lbl_tom,"center,span,gaptop 10px");
        degree_now.add(Lbl_degreec,"split2");
//        degree_now.add(Lbl_degreec,"split2,height 34px,width 50px ");
        degree_now.add(Lbl_degreecelsius,"center,push");

        degree_now.add(cloud,"wrap");
        
        return degree_now;
    }

    
    public MigPane getBotblock() {
//        MigPane Botblock = new MigPane("wrap7,inset 0,gap 0", "[left,132]1[][]1[][]1[][]", "[]");
        MigPane Botblock = new MigPane("wrap7,inset -16,gap 0", "[][][][][][][]", "[]");

        Botblock.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        Botblock.setId("bot");
        
    //-------Temperature lables
        Label Lbl_now = new Label("Now");
        Lbl_now.setFont(new Font("Verdana", 18));
        Lbl_now.setAlignment(Pos.CENTER);
        Lbl_now.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        Lbl_now.setId("textforreading");
        
        Label Lbl_Tommorow = new Label("Tommorow");
        Lbl_Tommorow.setFont(new Font("Verdana", 18));
        Lbl_Tommorow.setAlignment(Pos.CENTER);
        Lbl_Tommorow.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        Lbl_Tommorow.setId("textforreading");
        
        Label Lbl_Wednesday = new Label("Wednesday");
        Lbl_Wednesday.setFont(new Font("Verdana", 18));
        Lbl_Wednesday.setAlignment(Pos.CENTER);
        Lbl_Wednesday.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        Lbl_Wednesday.setId("textforreading");
    
    //--------Separators   
        Separator one = new Separator(Orientation.VERTICAL);
        Separator two = new Separator(Orientation.VERTICAL);
        Separator three = new Separator(Orientation.VERTICAL);
        
        
       one.setPrefHeight(139);
       two.setPrefHeight(139);
       three.setPrefHeight(139);
        
    //-------Button
       Button thetips = new Button("Tips");
       thetips.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
       thetips.setId("bt");
       thetips.setPrefSize(66, 20);
    
         
        Botblock.add(getNowtemp(),"width 132");
        
        Botblock.add(one);
        Botblock.add(getTomtemp(),"width 129");
        Botblock.add(two);
        Botblock.add(getWedtemp(),"width 124");
        Botblock.add(three);
        
        Botblock.add(getLastBlock(),"width 90");
        
           
        
        

         
        return Botblock;
    }

    
    public MigPane getLastBlock() {
        MigPane lastblock = new MigPane("","[grow]");
        tips = new Button("Tips");
        tips.setTooltip(tipsbuttonToolTip = new Tooltip("Click this button to know about weather facts"));
        tips.setPrefWidth(66);
        tips.setPrefHeight(20);
        tips.setTextAlignment(TextAlignment.CENTER);

        tips.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        tips.setId("tipy");
        //        lastblock.add(tips," tag ok,bottom");
        lastblock.add(tips,"push, gapy 75px,right");
       
        return lastblock;
    }

    
    public MigPane getDegree_Wed() {
        MigPane Degree_Wed = new MigPane("wrap", "[grow,center]", "[grow][grow][grow]");
        
        
        Label Lbl_wed = new Label("Wednesday");
        Lbl_wed.setFont(new Font("Verdana", 18));
        Lbl_wed.setAlignment(Pos.CENTER);
        Lbl_wed.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        Lbl_wed.setId("textforreading");
        Lbl_wed.setBorder(Border.EMPTY);
        
        Label Lbl_degreec = new Label("15");
        Lbl_degreec.setFont(new Font("Verdana", 40));
        Lbl_degreec.setAlignment(Pos.TOP_CENTER);
        Lbl_degreec.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        Lbl_degreec.setId("textforreading");
        Lbl_degreec.setBorder(Border.EMPTY);
//            Lbl_degreec.setPrefHeight(40);
        
        Label Lbl_degreecelsius= new Label("°C");
        Lbl_degreecelsius.setFont(new Font("Verdana", 18));
        Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER);
        Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        Lbl_degreecelsius.setId("textforreading");
        Lbl_degreecelsius.setBorder(Border.EMPTY);
//            Lbl_degreecelsius.setPrefHeight(42);
//        Image thecloud = new Image("weatherapp/view/Weathermisty.jpeg");
        Image thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
        ImageView cloud = new ImageView (thecloud);
        
        
        Degree_Wed.add(Lbl_wed,"gaptop 10px");
        Degree_Wed.add(Lbl_degreec,"split 2");
        Degree_Wed.add(Lbl_degreecelsius);
        Degree_Wed.add(cloud);
        
        
        return Degree_Wed;
    }

    
    public MigPane getTopblock() {
        Dashboard_Model sometime = new Dashboard_Model();

         SimpleDateFormat fmt = new SimpleDateFormat("hh:mm a");
        Date tt = new Date();
       
        System.out.println(fmt.format(tt));
        
        timeLabel = new Label(fmt.format(tt));
       
//        thetime(fmt, timeLabel);
        locationLabel = new Label("Location");
       
        
        locationLabel.setFont(new Font("Verdana", 18));
        locationLabel.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        locationLabel.setId("locy");
        ltab = new Button("UK");
        ltab2 = new Button("UK");
        ltab.setPrefSize(38, 23);
        ltab2.setPrefSize(38, 23);
        
        
        
        ltab.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        
        ltab2.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        ltab.setId("latab");
        ltab2.setId("latab");
        ltab.setFont(new Font("Verdana", 8));
        ltab2.setFont(new Font("Verdana", 8));
        
        
        menu = new ToggleButton();
//        menu.setPrefWidth(24);
//        menu.setPrefHeight(22);
        menu.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        menu.setId("meny");
        menu.setTooltip(menuToolTip=new Tooltip("Click here for the menu"));
        timeLabel.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        timeLabel.setId("timy");
        timeLabel.setFont(new Font("Verdana", 18));
        ltab.setFont(new Font("Arial", 14));
        ltab2.setFont(new Font("Arial", 14));
        ltab.setAlignment(Pos.CENTER);
        ltab2.setAlignment(Pos.CENTER);
        
        timeLabel.setId("timy");
        HBox ft = new HBox();
        HBox ft2 = new HBox();
        HBox ft3 = new HBox();
        VBox timl = new VBox(10);
       timl.getChildren().add(timeLabel);
       timl.getChildren().add(locationLabel);
        ft.getChildren().add(timeLabel);
        ft2.getChildren().add(ltab);
        ft2.getChildren().add(ltab2);

        ft3.getChildren().add(locationLabel);
        

        MigPane Topblock = new MigPane("insets 0 ,wrap2", "[][]", "[][][]");
        Topblock.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());

        Topblock.setId("back");

        Topblock.add(timeLabel,"top,gapright 205px,gapleft 10px,split2,flowy");
        Topblock.add(locationLabel,"gaptop 3px,gapleft 10px");

        Topblock.add(ltab,"top,split3");

        Topblock.add(ltab2,"gapleft0px,gapright 50px,top");

        Topblock.add(menu,"top");

        
        Topblock.add(getCtemp(),"gapleft 34px,gaptop 40px");
        
        return Topblock;
    }
    private Button ltab2;
    private Button ltab;

    
    public void thetime(SimpleDateFormat fmt, Label time) {
        someservice=new Service<Void>() {
            
            
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    
                    
                    protected Void call() throws Exception {
                        boolean gg=true;
                        while (gg) {
                            Date mm = new Date();
                            updateMessage(fmt.format(mm));
                            System.out.println(fmt.format(mm));
                            System.out.println("somecrap should be printed");
                            if (isCancelled()) {
                                gg=false;
                            }
                            
                            
                        }
                        
                        return null;
                    }
                };
                
            }
        };
        time.textProperty().bind(someservice.messageProperty());
        someservice.restart();
    }


    public MigPane getCtemp() {
        currenttemp = new Label("15");
        currenttempdegrees = new Label("°C");
        currenttemp.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.BLACK, 5, 0, 0, 5));
        currenttempdegrees.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.BLACK, 5, 0, 0, 5));
        currenttempdegrees.setFont(new Font("Verdana", 24));
        currenttemp.setFont(new Font("Arial",72));
        currenttemp.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        currenttempdegrees.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
        currenttemp.setId("ct");
        currenttempdegrees.setId("ct");
        MigPane ctempblock = new MigPane(",wrap2", "[][]", "[]");
        currenttemp.setBorder(Border.EMPTY);
        //        Topblock.add(currenttemp,"");
//        Topblock.add(currenttempdegrees,"pos 100px 110px");
        ctempblock.add(currenttemp,"");
        ctempblock.add(currenttempdegrees,"gapbottom 40px");
        return ctempblock;
    }
    private Label currenttempdegrees;

    public static void main(String[] args) {
        
    }

}
