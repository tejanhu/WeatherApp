package weatherapp.view;

import java.text.SimpleDateFormat;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import org.tbee.javafx.scene.layout.MigPane;

public class DashboardPortraitview extends MigPane implements DashboardInteface   {
private ToggleButton menu;
private  MigPane topblock;
private  Label degree3;
private  Label degree2;
private  Label degree;
private  Label lblWed;
private  Label lblTow;
private  Label lblnow;
private  Label timeLabel;    
private  Button ltab;
private  Button ltab2;
private         Label           locationLabel;
private Label currenttempdegrees;
    private Label currenttemp;
    public ToggleButton getMenu() {
        return menu;
    }
    public DashboardPortraitview() {
        super("insets 0,debug, wrap,gap 0,hidemode 2", "[]", "[][]");
        this.add(getTopblock(), "width 320, height 310,dock north");
        this.add(getBotBlock(), "width 320, height 170,dock south");

    }

    public MigPane getBotBlock() {
        MigPane Botblock = new MigPane("debug,nogrid,flowy");
        Font somefFont = new Font("Verdana", 24);
        lblnow = new Label("Now");
        lblTow = new Label("Tom");
        lblWed = new Label("Wed");
        degree = new Label("15");
        degree2 = new Label("15");
        degree3 = new Label("15");
        Separator someseparator = new Separator(Orientation.VERTICAL);
        Separator someseparator2 = new Separator(Orientation.VERTICAL);
        Separator someseparator3 = new Separator(Orientation.VERTICAL);

        someseparator.setPrefHeight(170);
        someseparator2.setPrefHeight(170);
        someseparator3.setPrefHeight(170);

        lblnow.setFont(somefFont);
        lblTow.setFont(somefFont);
        lblWed.setFont(somefFont);
        Image thecloud = new Image("weatherapp/view/misty cloud or windy for land.png");
        ImageView cloud = new ImageView(thecloud);
        Image thecloud2 = new Image("weatherapp/view/misty cloud or windy for land.png");
        ImageView cloud2 = new ImageView(thecloud);
        Image thecloud3 = new Image("weatherapp/view/misty cloud or windy for land.png");
        ImageView cloud3 = new ImageView(thecloud);
        Botblock.add(lblnow, "center");
        Botblock.add(degree, "gaptop -5px,center");
        Botblock.add(cloud, "center,wrap");
        Botblock.add(someseparator);
        Botblock.add(lblTow, "center");
        Botblock.add(degree2, "gaptop -5px,center");
        Botblock.add(cloud2, "center,wrap");
        Botblock.add(someseparator2);

        Botblock.add(lblWed, "center");
        Botblock.add(degree3, "gaptop -5px,center");
        Botblock.add(cloud3, "center,wrap");
//       Botblock.add(someseparator3);

        Botblock.getStylesheets().add(DashboardPortraitview.class.getResource("Weatherport.css").toExternalForm());
        Botblock.setId("boty");
        return Botblock;
    }

    public MigPane getTopblock() {
        timeLabel= new Label();
        ltab=new Button();
        ltab2=new Button();
        menu= new ToggleButton();
        currenttemp = new Label("15");
        locationLabel =new Label("Location");
        currenttempdegrees = new Label("ºC");
        topblock = new MigPane("debug,wrap4","[grow][grow][grow][grow]","[][][]");
        topblock.getStylesheets().add(DashboardPortraitview.class.getResource("Weatherport.css").toExternalForm());
        topblock.setId("topy");
        topblock.add(timeLabel);
        topblock.add(ltab);
        topblock.add(ltab2);
        topblock.add(menu);
        topblock.add(locationLabel,"span,left,grow");
        topblock.add(currenttemp,"split2,grow,span");
        topblock.add(currenttempdegrees,"");
        
        Font currentTempFont = new Font(100);
        currenttemp.setFont(currentTempFont);

        return topblock;
    }

    public static void main(String[] args) {

    }

    
    public MigPane getBotblock() {
        return new MigPane();
    }

    
    public MigPane getDegree_Now() {
        return new MigPane();
    }

    
    public MigPane getDegree_Now2() {
        
        return new MigPane();
    }

    
    public MigPane getDegree_Tom() {
        
        return new MigPane();
    }

    
    public MigPane getDegree_Wed() {
        
        return new MigPane();
    }

    
    public MigPane getLastBlock() {
        
        return new MigPane();
    }

   

    
    public GridPane getNowtemp() {
        return new GridPane();
        
    }

    
    public GridPane getTomtemp() {
        return new GridPane();
    }

    
    public GridPane getWedtemp() {
        return new GridPane();
    }

    
    public void setImageWeather(String imagepath) {
        System.out.println("Some crap");
    }

    
    public void setNowTemp(String newTemp) {
        System.out.println("nothing");
    }

    
    public void thetime(SimpleDateFormat fmt, Label time) {
        System.out.println("nothing");
        
    }

    
    public Label getTimeLabel() {
        return  timeLabel;
    }

    @Override
    public Label getCurrenttemp() {
       return new Label();
    }

    @Override
    public Button getTips() {
        return new Button("sfsd");
    }

    @Override
    public Label getLbl_Tom() {
        return new Label();
    }

    @Override
    public Label getLbl_now() {
        return new Label();
    }

    @Override
    public Label getLbl_Wed() {
        return  new Label ();
    }

    @Override
    public Label getLocationLabel() {
     return new Label();
    }

}
        
