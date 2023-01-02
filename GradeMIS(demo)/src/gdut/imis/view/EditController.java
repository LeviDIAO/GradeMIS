package gdut.imis.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EditController {
    @FXML private Label insert;
    @FXML private Label delete;
    @FXML private Label update;
    @FXML private Stage stage;
    @FXML private HBox editstage;

    @FXML private void showChoose(){
            FXMLLoader loader=new FXMLLoader(MainSceneController.class.getResource("Choose.fxml"));
         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         Stage ChooseStage = new Stage();
            ChooseStage.setTitle("计算机系学生信息录入");
            ChooseStage.initModality(Modality.WINDOW_MODAL);
            ChooseStage.setScene(new Scene(root));

            //设置新增页面的控制器
            //CSEditDialogController controller = loader.getController();
            //controller.setDialogStage(ChooseStage);

            stage.close();
            //显示对话框并等待用户操作
            ChooseStage.showAndWait();



        }
    Stage getStage(){
        return stage = (Stage) editstage.getScene().getWindow();
    }
    public void setEditStage(Stage stage) {
         this.stage= stage;
    }
}



