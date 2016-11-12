
package weatherapp.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import org.tbee.javafx.scene.layout.MigPane;

/**
 *
 * @author Samsu
 */
public class MenuLandscapeview extends MigPane implements MenuInterface {
    private     MigPane            leftBlock;
    private     MigPane            rightBlock;
    private     MigPane            insiderightBlock;
    private     MigPane            buttonPane;
    private     Button             menuChoice1;
    private     Button             menuChoice2;
    private     Button             menuChoice3;
    private     Button             menuChoice4;
    private     ToggleButton       menuButton;
    private     Tooltip            menuToolTip; 



// ******************** Constructors **************************************
    public MenuLandscapeview() {
        super("wrap2,insets 0, gap 0","[grow][]", "[]");
        System.out.println("we get in here");
        leftBlock = initlleftBlock();
        rightBlock = initrightBlock();
        this.add(leftBlock,"width 135, height 320");
        this.add(rightBlock,"width 350, height 320");
//        this.add(rightBlock,"width 350, height 320");

    }

    public MigPane initrightBlock() {
        rightBlock = new MigPane("","[grow]");
        menuButton= new ToggleButton("");
        menuButton.setTooltip(menuToolTip=new Tooltip("Click here for the menu"));
        rightBlock.getStylesheets().add(MenuLandscapeview.class.getResource("menu.css").toExternalForm());
        rightBlock.setId("rightcont");
        insiderightBlock = new MigPane();
        insiderightBlock.setStyle("-fx-background-color:purple;");
        rightBlock.add(menuButton,"span,right,wrap");
        rightBlock.add(insiderightBlock,"width 315, height 252,center,span,gaptop 10px");
        return rightBlock;
    }

    public MigPane initlleftBlock() {
        buttonPane = new MigPane("wrap","[grow]");
        leftBlock = new MigPane(",wrap","[grow]","[][]");
//        leftBlock.setStyle("-fx-background-color:red;");
        leftBlock.getStylesheets().add(MenuLandscapeview.class.getResource("menu.css").toExternalForm());
        leftBlock.setId("leftcont");
        leftBlock.add(new Label("somecrap"));
        initbuttonPane();
        leftBlock.add(buttonPane,"grow");
        return leftBlock;
    }

    private void initbuttonPane() {
        
        menuChoice1 = new Button("Track places");
        menuChoice2 = new Button("Places i'm tracking");
        menuChoice3 = new Button("blah");
        menuChoice4 = new Button("Settings");
       
        buttonPane.add(menuChoice1,"sg a,growx,span");
        buttonPane.add(menuChoice2,"sg a,span,growx,");
        buttonPane.add(menuChoice3,"sg a,span,growx");
        buttonPane.add(menuChoice4,"sg a,span,growx");
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
    public Tooltip getMenuToolTip() {
        return menuToolTip;
    }
}
