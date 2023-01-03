package gdut.imis.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
