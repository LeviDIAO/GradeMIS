package gdut.imis.view;

import gdut.imis.entity.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class InfoController {
    @FXML private TextArea textArea;
    private Stage stage;

    @FXML public void setTextArea(StringBuffer s){
        textArea.setEditable(false);
        textArea.appendText("系别\t\t学号\t姓名\t综合成绩\n"+String.valueOf(s));
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML private void handleOK(){
        stage.close();
    }
}
