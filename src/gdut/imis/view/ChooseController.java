package gdut.imis.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseController {
    @FXML private Label EN;
    @FXML private Label CS;
    @FXML private Label LT;
    @FXML private HBox ChooseStage;
    private void handleEN(){

    }
    @FXML private void handleCS() throws IOException {
        showEditCS();
    }
    @FXML private void showEditCS() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(ChooseController.class.getResource("CSEdit.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(pane));
        //关闭上一个窗口
        //Stage choosestage = (Stage) ChooseStage.getScene().getWindow();
        //choosestage.close();
        //显示对话框并等待用户操作
        stage.showAndWait();
    }
}
