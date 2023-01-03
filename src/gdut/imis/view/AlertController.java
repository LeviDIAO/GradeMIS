package gdut.imis.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import gdut.imis.entity.CS;
import gdut.imis.entity.Student;
import gdut.imis.service.GradeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.*;

import javax.swing.*;

public class AlertController {
    @FXML private Label textArea;
    private Stage stage;
    @FXML
    public void print(String str){
        textArea.setText(str);
    }
    @FXML private void handleOK(){
        stage.close();
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
