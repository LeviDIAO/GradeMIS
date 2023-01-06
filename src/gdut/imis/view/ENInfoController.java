package gdut.imis.view;

import gdut.imis.entity.EN;
import gdut.imis.service.GradeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
        age.setText(String.valueOf(s.getAge()));
        sex.setText(s.getSex());
        midScoreField.setText(String.valueOf(s.getMidScore()));
        finalScoreField.setText(String.valueOf(s.getFinalScore()));
        speechScoreField.setText(String.valueOf(s.getSpeechScore()));
        writeScore.setText(String.valueOf(s.getWriteScore()));
    }
    @FXML private void handleOK(ActionEvent event){
        new GradeService().delete(id.getText());
        EN en = new EN();
        en.setId(id.getText());
        en.setName(name.getText());
        en.setDepartment("英语系");
        en.setAge(Integer.parseInt(age.getText()));
        en.setSex((sex.getText()));
        en.setMidScore(Double.parseDouble(midScoreField.getText()));
        en.setFinalScore(Double.parseDouble(finalScoreField.getText()));
        en.setSpeechScore(Double.parseDouble(speechScoreField.getText()));
        en.setWriteScore(Double.parseDouble(writeScore.getText()));
        new GradeService().insert(en);
        new GradeService().save();
        Editor.close();
    }
}
