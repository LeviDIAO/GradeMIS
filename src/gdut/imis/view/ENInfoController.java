package gdut.imis.view;

import gdut.imis.entity.CS;
import gdut.imis.entity.EN;
import gdut.imis.entity.Student;
import gdut.imis.service.GradeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ENInfoController {
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField sex;
    @FXML
    private TextField midScoreField;
    @FXML
    private TextField finalScoreField;
    @FXML
    private TextField speechScoreField;
    @FXML private TextField writeScore;
    @FXML private TextField dept;
    @FXML
    private Stage Editor;
    public void setStage(Stage dialogStage) {
        Editor = dialogStage;
    }
    @FXML
    private void handleCancel(){
        Editor.close();
    }
    public void setInfo(EN s){
        id.setText(s.getId());
        name.setText(s.getName());
        dept.setText(s.getDepartment());
        age.setText(s.getSex());
        sex.setText(s.getSex());
        midScoreField.setText(String.valueOf(s.getMidScore()));
        finalScoreField.setText(String.valueOf(s.getFinalScore()));
        speechScoreField.setText(String.valueOf(s.getSpeechScore()));
        writeScore.setText(String.valueOf(s.getWriteScore()));
    }
}
