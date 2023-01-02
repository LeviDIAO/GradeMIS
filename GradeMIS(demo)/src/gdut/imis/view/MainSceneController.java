package gdut.imis.view;

import gdut.imis.service.GradeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.IOException;
import javafx.scene.control.*;

public class MainSceneController {
    @FXML private Label edit;
    @FXML
    private MenuItem delete;
    @FXML
    private MenuItem update;
    @FXML
    private MenuItem save;
    private Stage stage;

    @FXML private TextArea text;
    @FXML
    //处理编辑的鼠标点击操作
    public  void handleEdit(){
        EditController controller = new EditController();
        stage=controller.getStage();
        stage.setOpacity(1);
    }

    @FXML
    //处理保存的鼠标点击操作
    private void handleSave(){
        new GradeService().save();
    }


    @FXML
    public void print(){
        text.setText("chenggong");
    }


}
