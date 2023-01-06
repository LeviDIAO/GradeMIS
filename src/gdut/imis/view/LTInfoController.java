package gdut.imis.view;

import gdut.imis.entity.LT;
import gdut.imis.service.GradeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LTInfoController {
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
    @FXML
    private TextField workScoreField;
    @FXML private TextField dept;
    @FXML
    private Stage Editor;
    public void setStage(Stage dialogStage) {
        Editor = dialogStage;
    }
    @FXML private void handleCancle(){
        Editor.close();
    }
    public void setInfo(LT s){
        id.setText(s.getId());
        name.setText(s.getName());
        dept.setText(s.getDepartment());
        age.setText(String.valueOf(s.getAge()));
        sex.setText(s.getSex());
        midScoreField.setText(String.valueOf(s.getMidScore()));
        finalScoreField.setText(String.valueOf(s.getFinalScore()));
        speechScoreField.setText(String.valueOf(s.getSpeechScore()));
        workScoreField.setText(String.valueOf(s.getWorkScore()));
    }
    @FXML private void handleOK(ActionEvent event){
        LT lt = new LT();
        lt.setId(id.getText());
        lt.setName(name.getText());
        lt.setDepartment("文学系");
        lt.setAge(Integer.parseInt(age.getText()));
        lt.setSex((sex.getText()));
        lt.setMidScore(Double.parseDouble(midScoreField.getText()));
        lt.setFinalScore(Double.parseDouble(finalScoreField.getText()));
        lt.setSpeechScore(Double.parseDouble(speechScoreField.getText()));
        lt.setWorkScore(Double.parseDouble(workScoreField.getText()));
        new GradeService().insert(lt);
        new GradeService().save();
        Editor.close();
    }
}
