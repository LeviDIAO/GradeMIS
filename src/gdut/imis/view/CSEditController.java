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
    @FXML
    private Stage dialogStage;
    private Student stu;

    @FXML
    private void initialize(){

    }

    //public void setDialogStage(Stage dialogStage) {
        //this.dialogStage = dialogStage;
    //}

    //确认的鼠标点击操作
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
        new GradeService().insert(cs);
        dialogStage.close();
    }
    @FXML
            //取消的鼠标点击操作
    private void handleCancel(ActionEvent event){
        dialogStage.close();
    }

}
