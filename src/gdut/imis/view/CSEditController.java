package gdut.imis.view;

import gdut.imis.entity.CS;
import gdut.imis.entity.Student;
import gdut.imis.service.GradeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javafx.scene.control.*;

import java.awt.event.MouseEvent;

public class CSEditController {
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
    private TextField operationScoreField;
    @FXML private Button cancle;
    @FXML
    private Stage CSEditor;
    private Student stu;

    @FXML
    private void initialize(){

    }

    public void setStage(Stage dialogStage) {
        CSEditor = dialogStage;
    }
    @FXML
    private void handleOK(ActionEvent event){
        CS cs = new CS();
        cs.setId(id.getText());
        cs.setName(name.getText());
        cs.setDepartment("计算机系");
        cs.setAge(Integer.parseInt(age.getText()));
        cs.setSex(((RadioButton)(sex.getSelectedToggle())).getText());
        cs.setMidScore(Double.parseDouble(midScoreField.getText()));
        cs.setFinalScore(Double.parseDouble(finalScoreField.getText()));
        cs.setOperationScore(Double.parseDouble(operationScoreField.getText()));
        new GradeService();
        GradeService.getGradeService().insert(cs);
        CSEditor.close();
    }
    @FXML
    private void handleCancel(){
        CSEditor.close();
    }
}
