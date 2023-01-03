package gdut.imis.view;

import gdut.imis.entity.CS;
import gdut.imis.service.GradeService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CSInfoController {
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
    private TextField operationScoreField;
    @FXML private TextField dept;
    @FXML
    private Stage CSEditor;
    public void setStage(Stage dialogStage) {
        CSEditor = dialogStage;
    }
    @FXML
    private void handleCancel(){
        CSEditor.close();
    }
    public void setInfo(CS s){
        id.setText(s.getId());
        name.setText(s.getName());
        dept.setText(s.getDepartment());
        age.setText(s.getSex());
        sex.setText(s.getSex());
        midScoreField.setText(String.valueOf(s.getMidScore()));
        finalScoreField.setText(String.valueOf(s.getFinalScore()));
        operationScoreField.setText(String.valueOf(s.getOperationScore()));
    }
    @FXML private void handleOK(){
        CS cs = new CS();
        cs.setId(id.getText());
        cs.setName(name.getText());
        cs.setDepartment("计算机系");
        cs.setAge(Integer.parseInt(age.getText()));
        cs.setSex((sex.getText()));
        cs.setMidScore(Double.parseDouble(midScoreField.getText()));
        cs.setFinalScore(Double.parseDouble(finalScoreField.getText()));
        cs.setOperationScore(Double.parseDouble(operationScoreField.getText()));
        new GradeService();
        GradeService.getGradeService().insert(cs);
        GradeService.getGradeService().save();
        CSEditor.close();
    }
}
