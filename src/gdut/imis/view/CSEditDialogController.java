package gdut.imis.view;

import gdut.imis.entity.CS;
import gdut.imis.entity.Student;
import gdut.imis.service.GradeService;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.awt.*;

public class CSEditDialogController {
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private ToggleGroup sex;
    @FXML
    private TextField midScoreField;
    @FXML
    private TextField finalScoreField;
    @FXML
    private TextField operationScoreField;
    @FXML
    private Stage dialogStage;
    private Student stu;

    @FXML
    private void initialize(){

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleOK(){
        CS cs = new CS();
        cs.setId(idField.getText());
        cs.setName(nameField.getText());
        cs.setDepartment("计算机系");
        cs.setAge(Integer.parseInt(ageField.getText()));
        cs.setSex(((RadioButton)(sex.getSelectedToggle())).getText());
        cs.setMidScore(Double.parseDouble(midScoreField.getText()));
        cs.setFinalScore(Double.parseDouble(finalScoreField.getText()));
        cs.setOperationScore(Double.parseDouble(operationScoreField.getText()));
        new GradeService().insert(cs);
        dialogStage.close();
    }
    //确认的鼠标点击操作
    @FXML
    private void handleCancel(){
        dialogStage.close();
    }
    //取消的鼠标点击操作
}
