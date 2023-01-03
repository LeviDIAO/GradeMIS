package gdut.imis.view;

import gdut.imis.entity.LT;
import gdut.imis.entity.Student;
import gdut.imis.service.GradeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LTEditController {
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
    @FXML
    private TextField workScoreField;
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
        LT lt = new LT();
        lt.setId(id.getText());
        lt.setName(name.getText());
        lt.setDepartment("文学系");
        lt.setAge(Integer.parseInt(age.getText()));
        lt.setSex(((RadioButton)(sex.getSelectedToggle())).getText());
        lt.setMidScore(Double.parseDouble(midScoreField.getText()));
        lt.setFinalScore(Double.parseDouble(finalScoreField.getText()));
        lt.setSpeechScore(Double.parseDouble(speechScoreField.getText()));
        lt.setWorkScore(Double.parseDouble(workScoreField.getText()));
        new GradeService().insert(lt);
        Editor.close();
    }
    @FXML
    private void handleCancel(){
        Editor.close();
    }
}
