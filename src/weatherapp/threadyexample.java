/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author Samsu
 */
public class threadyexample extends Application implements Observer {

    StackPane root = new StackPane();
    private int i=0;
    ArrayList<String> styley = new ArrayList<String>();
     ExecutorService multithread;
    @Override
    public void init() throws Exception {
        multithread = Executors.newFixedThreadPool(
                2,
                new someThread("This is multi thready")
        );
    }

    @Override
    public void start(Stage primaryStage) {
        multithread = Executors.newFixedThreadPool(
                2,
                new someThread("This is multi thready")
        );
     
        somelabel = new Label("someguy");
        somelabel2 = new Label("crap");
        somelabel3 = new Label("this is label 3");
        final numby service = new numby(root);
        final domy service2 = new domy();
        
        IntegerProperty somenum =new SimpleIntegerProperty(100);
        IntegerProperty somenum2 =new SimpleIntegerProperty(100);
//        System.out.println(somenum.get());
        service.setExecutor(multithread);
        service2.setExecutor(multithread);
        somenum.bind(service.somint);
        somenum2.bind(service.crap);
        service.start();
        service2.start();

        somelabel.setStyle("-fx-background-color:purple;");
//        somelabel2.textProperty().bind(service.lbltext);
        somelabel2.setStyle("-fx-background-color:red;");
        somelabel.setId("backy");
        somelabel.textProperty().bind(service2.messageProperty());
//        somelabel.styleProperty().bind(service.path);
//        System.out.println(somenum.get());
//        for (int i = 0; i < 566; i++) {
//            System.out.println("This is the value of somenum "+somenum.get()+" and the counter is  "+i);
//            somelabel.setText(String.valueOf(somenum.get()));
//            
//        }
        ll = new HBox(20);
        styley.add("gg.css");
        styley.add("hh.css");
//        ImageView gg = new ImageView(new Image("weatherapp/WL.jpg"));
//        gg.imageProperty().bind(service.vv);
        somenum.bind(service.somint);
        System.out.println(service.getValue());
        
Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame someani = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (somenum.get()==1) {
                   root.getStylesheets().add(threadyexample.class.getResource(styley.get(0)).toExternalForm());
                    System.out.println("We change the stylesheet here");
                    root.setId("backy");
//                                            root.setStyle("-fx-background-color:purple");
                }
                
                else{
                
                    root.getStylesheets().add(threadyexample.class.getResource(styley.get(1)).toExternalForm());
//                                            root.setStyle("-fx-background-color:orange");
                    root.setId("backy");
                }
                somelabel2.setText("This is someint "+somenum.getValue());
                somelabel3.setText("This is crap"+somenum2.getValue());
            }
        });
          timeline.getKeyFrames().add(someani);
        timeline.play();
        
        
//        root.getChildren().add(somelabel);
//        root.getChildren().add(somelabel2);
        root.setId("backy");
        ll.getChildren().add(root);
        ll.getChildren().add(somelabel);
        ll.getChildren().add(somelabel2);
        ll.getChildren().add(somelabel3);
//        ll.getChildren().add(gg);
        
        scene = new Scene(ll, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Label somelabel3;
    private Label somelabel2;
    private Label somelabel;
    private Scene scene;
    private HBox ll;

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void update(String val1, String val2) {
        i=i+1;
        
//        JOptionPane.showInputDialog(null, "We have entered");
        System.out.println("We get to here in the update  "+i);
        somelabel2.setText(val1);
        somelabel3.setText(val2);
    }

}
