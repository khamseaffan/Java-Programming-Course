package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {

    @FXML
    private Label labelOne;
    @FXML
    private GridPane gridPane;
    @FXML
    private Button openButton;

    public void initialize(){

    }
    @FXML
    public void handelMouseEnter(){
        labelOne.setScaleY(2.0);
        labelOne.setScaleX(2.0);
        labelOne.setRotate(90);
    }
    @FXML
    public void handelMouseExit(){
        labelOne.setScaleX(1.0);
        labelOne.setScaleY(1.0);
    }
    @FXML
    private void handelClick(){
        FileChooser chooser = new FileChooser();


//        chooser.setTitle("SAve Application file");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("PDF","*.pdf")
        );

        File file = chooser.showOpenDialog(gridPane.getScene().getWindow());
        if (file !=null){
            System.out.printf(file.getPath());
        }else {
            System.out.printf("Chooser was Cancled");
        }
    }
}
