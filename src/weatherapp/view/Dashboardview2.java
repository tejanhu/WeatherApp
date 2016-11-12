/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.tbee.javafx.scene.layout.MigPane;
import weatherapp.Model.Dashboard_Model;

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

/**
 *
 * author Samsu
 */
public class Dashboardview2 extends experimentView implements Observer {

    public void update(Observable o, Object arg) {
        if (arg instanceof Boolean) {
//            checkLandORPortrait = (boolean) arg;
        }

//        if (checkLandORPortrait) {
////            view = landscapeView;
//
//        } else {
//
////            view = portraitView;
//        }
//
    }

    public class DashboardLandscapeview extends MigPane {

        private Service<Void> someservice;
        private ToggleButton menu;
        private MigPane Weathercont;
        private Label lbl_NowDegreec;
        private Label timeLabel;

        public Label getTimeLabel() {
            return timeLabel;
        }

        public ToggleButton getMenu() {
            return menu;
        }

        public DashboardLandscapeview() {
            setLandscape();

        }

        private void setLandscape() {
//            this =  Dashboardview2("insets 0,wrap,gap 0", "[]", "[][]");
//            this.setMinSize(480, 320);
//            this.add(getTopblock(), "height 203, width 480,dock north");
//
//            this.add(getBotblock(), "height 117, width 480,dock south");
        }

        public void setNowTemp(String newTemp) {
            lbl_NowDegreec.setText(newTemp);
//        MigPane Tempnow = new MigPane("debug","","[][][]");
//        MigPane Temptom = new MigPane("debug","[]","[][][]");
//        MigPane Tempwed = new MigPane("debug","[]","[][][]");

//        getDegree_Now();
        }

        public GridPane getNowtemp() {
            GridPane nowtemp = new GridPane();
            nowtemp.setAlignment(Pos.CENTER);
            Label Lbl_now = new Label("Now");
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
            Label Lbl_degreecelsius = new Label("°C");
            Lbl_degreecelsius.setFont(new Font("Verdana", 18));
            Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER);
            Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreecelsius.setId("textforreading");
            Lbl_degreecelsius.setTranslateX(8);
            Lbl_degreecelsius.setTranslateY(-12);

            thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");

            ImageView cloud = new ImageView(thecloud);
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
            GridPane nowtemp = new GridPane();
            nowtemp.setAlignment(Pos.CENTER);
            Label Lbl_Tom = new Label("Tommorow");
            Lbl_Tom.setFont(new Font("Verdana", 18));
            Lbl_Tom.setAlignment(Pos.CENTER);
            Lbl_Tom.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_Tom.setId("textforreading");
            Lbl_Tom.setBorder(Border.EMPTY);
            Lbl_Tom.setTranslateX(15);
            Lbl_Tom.setTranslateY(4);

            Label Lbl_degreec = new Label("15");
            Lbl_degreec.setFont(new Font("Verdana", 40));
            Lbl_degreec.setAlignment(Pos.TOP_CENTER);
            Lbl_degreec.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreec.setId("textforreading");
            Lbl_degreec.setTranslateY(-1);
            Lbl_degreec.setTranslateX(15);
//                Lbl_degreec.setLineSpacing(600);
            Label Lbl_degreecelsius = new Label("°C");
            Lbl_degreecelsius.setFont(new Font("Verdana", 18));
            Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER);
            Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreecelsius.setId("textforreading");
            Lbl_degreecelsius.setTranslateX(-3);
            Lbl_degreecelsius.setTranslateY(-12);

            Image thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
            ImageView cloud = new ImageView(thecloud);
            cloud.setTranslateX(15);
            cloud.setTranslateY(-8);

            nowtemp.setHalignment(Lbl_Tom, HPos.CENTER);
            nowtemp.setHalignment(Lbl_degreec, HPos.CENTER);
            nowtemp.setHalignment(cloud, HPos.CENTER);
            nowtemp.setValignment(cloud, VPos.CENTER);

            nowtemp.add(Lbl_Tom, 0, 0);
            nowtemp.add(Lbl_degreec, 0, 1);
            nowtemp.add(Lbl_degreecelsius, 1, 1);
            nowtemp.add(cloud, 0, 2);

//        nowtemp.setGridLinesVisible(true);
            return nowtemp;
        }

        public GridPane getWedtemp() {
            GridPane nowtemp = new GridPane();
            nowtemp.setAlignment(Pos.CENTER);
            Label Lbl_Wed = new Label("Wednesday");
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
            Label Lbl_degreecelsius = new Label("°C");
            Lbl_degreecelsius.setFont(new Font("Verdana", 18));
            Lbl_degreecelsius.setAlignment(Pos.TOP_CENTER);
            Lbl_degreecelsius.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            Lbl_degreecelsius.setId("textforreading");
            Lbl_degreecelsius.setTranslateX(0);
            Lbl_degreecelsius.setTranslateY(-12);

            Image thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
            ImageView cloud = new ImageView(thecloud);
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

            Botblock.add(getNowtemp(), "width 132");

            Botblock.add(one);
            Botblock.add(getTomtemp(), "width 129");
            Botblock.add(two);
            Botblock.add(getWedtemp(), "width 124");
            Botblock.add(three);

            Botblock.add(getLastBlock(), "width 90");

            return Botblock;
        }

        public MigPane getLastBlock() {
            MigPane lastblock = new MigPane("", "[grow]");
            Button tips = new Button("Tips");
            tips.setPrefWidth(66);
            tips.setPrefHeight(20);
            tips.setTextAlignment(TextAlignment.CENTER);

            tips.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            tips.setId("tipy");
            //        lastblock.add(tips," tag ok,bottom");
            lastblock.add(tips, "push, gapy 75px,right");
            tips.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    System.out.println("Button was clicked");
                }
            });
            return lastblock;
        }

        public MigPane getTopblock() {
            Dashboard_Model sometime = new Dashboard_Model();

            SimpleDateFormat fmt = new SimpleDateFormat("hh:mm a");
            Date tt = new Date();

            System.out.println(fmt.format(tt));

            timeLabel = new Label(fmt.format(tt));

//        thetime(fmt, timeLabel);
            Label loc = new Label("Location");

            loc.setFont(new Font("Verdana", 18));
            loc.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            loc.setId("locy");
            Button ltab = new Button("UK");
            Button ltab2 = new Button("UK");
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
            timl.getChildren().add(loc);
            ft.getChildren().add(timeLabel);
            ft2.getChildren().add(ltab);
            ft2.getChildren().add(ltab2);

            ft3.getChildren().add(loc);

            MigPane Topblock = new MigPane("insets 0 ,wrap2", "[][]", "[][][]");
            Topblock.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());

            Topblock.setId("back");

            Topblock.add(timeLabel, "top,gapright 205px,gapleft 10px,split2,flowy");
            Topblock.add(loc, "gaptop 3px,gapleft 10px");

            Topblock.add(ltab, "top,split3");

            Topblock.add(ltab2, "gapleft0px,gapright 50px,top");

            Topblock.add(menu, "top");

            Topblock.add(getCtemp(), "gapleft 34px,gaptop 40px");

            return Topblock;
        }

        public MigPane getCtemp() {
            Label currenttemp = new Label("15");
            Label currenttempdegrees = new Label("°C");
            currenttemp.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.BLACK, 5, 0, 0, 5));
            currenttempdegrees.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.BLACK, 5, 0, 0, 5));
            currenttempdegrees.setFont(new Font("Verdana", 24));
            currenttemp.setFont(new Font("Arial", 72));
            currenttemp.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            currenttempdegrees.getStylesheets().add(DashboardLandscapeview.class.getResource("Weatherland.css").toExternalForm());
            currenttemp.setId("ct");
            currenttempdegrees.setId("ct");
            MigPane ctempblock = new MigPane(",wrap2", "[][]", "[]");
            currenttemp.setBorder(Border.EMPTY);
            //        Topblock.add(currenttemp,"");
//        Topblock.add(currenttempdegrees,"pos 100px 110px");
            ctempblock.add(currenttemp, "");
            ctempblock.add(currenttempdegrees, "gapbottom 40px");
            return ctempblock;
        }

    }

    public static void main(String[] args) {

    }

}
