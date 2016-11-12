/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class MenuPortraitview extends MigPane implements MenuInterface{
    private     MigPane            leftBlock;
    private     MigPane            rightBlock;
    private     MigPane            insiderightBlock;
    private     MigPane            buttonPane;
    private     Button             menuChoice1;
    private     Button             menuChoice2;
    private     Button             menuChoice3;
    private     Button             menuChoice4;
    private     ToggleButton       menuButton;

  

// ******************** Constructors **************************************
    public MenuPortraitview() {
        super("wrap2,insets 0, gap 0","[grow][]", "[]");
        System.out.println("we get in here");
        leftBlock = initlleftBlock();
        rightBlock = initrightBlock();
        this.add(leftBlock,"width 184, height 480");
        this.add(rightBlock,"width 136, height 480");

    }

    public MigPane initrightBlock() {
        rightBlock = new MigPane("","[grow]");
        menuButton= new ToggleButton("");
        rightBlock.setStyle("-fx-background-color:blue;");
        rightBlock.getStylesheets().add(MenuLandscapeview.class.getResource("menu.css").toExternalForm());
//        rightBlock.setId("rightcont");
        insiderightBlock = new MigPane();
        insiderightBlock.setStyle("-fx-background-color:purple;");
        rightBlock.add(insiderightBlock,"width 112, height 379,center,span,gaptop 20px");
        return rightBlock;
    }

    public MigPane initlleftBlock() {
        buttonPane = new MigPane("wrap","[grow]");
        leftBlock = new MigPane("debug,wrap","[grow]","[][]");
        leftBlock.setStyle("-fx-background-color:red;");
        leftBlock.add(new Label("somecrap"));
        initbuttonPane();
        leftBlock.add(buttonPane,"grow");
        return leftBlock;
    }

    private void initbuttonPane() {
        
        menuChoice1 = new Button("blah");
        menuChoice2 = new Button("blah");
        menuChoice3 = new Button("blah");
        menuChoice4 = new Button("blah");
       
        buttonPane.add(menuChoice1,"sg a,growx,span");
        buttonPane.add(menuChoice2,"sg a,span,growx,");
        buttonPane.add(menuChoice3,"sg a,span,growx");
        buttonPane.add(menuChoice4,"sg a,span,growx");
    }
    public MigPane getButtonPane() {
        return buttonPane;
    }

    public Button getMenuChoice1() {
        return menuChoice1;
    }

    public Button getMenuChoice2() {
        return menuChoice2;
    }

    public Button getMenuChoice3() {
        return menuChoice3;
    }

    public Button getMenuChoice4() {
        return menuChoice4;
    }

    public ToggleButton getMenuButton() {
        return menuButton;
    }
    
    
}
