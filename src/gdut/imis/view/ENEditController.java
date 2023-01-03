package gdut.imis.view;

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

public class ENEditController {
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private ToggleGroup sex;
    @FXML
    private TextField midScoreField;
    @FXML
    private TextField finalScoreField;
    @FXML
    private TextField speechScoreField;
    @FXML private TextField writeScore;
    @FXML private Button cancle;
    @FXML
    private Stage Editor;
    private Student stu;

    @FXML
    private void initialize(){

    }

    public void setStage(Stage dialogStage) {
        Editor = dialogStage;
    }
    @FXML
    private void handleOK(ActionEvent event){
        EN en = new EN();
        en.setId(id.getText());
        en.setName(name.getText());
        en.setDepartment("英语系");
        en.setAge(Integer.parseInt(age.getText()));
        en.setSex(((RadioButton)(sex.getSelectedToggle())).getText());
        en.setMidScore(Double.parseDouble(midScoreField.getText()));
        en.setFinalScore(Double.parseDouble(finalScoreField.getText()));
        en.setSpeechScore(Double.parseDouble(speechScoreField.getText()));
        en.setWriteScore(Double.parseDouble(writeScore.getText()));
        new GradeService().insert(en);
        Editor.close();
    }
    @FXML
    private void handleCancel(){
        Editor.close();
    }
}
