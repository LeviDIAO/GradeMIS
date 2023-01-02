package gdut.imis.view;

import gdut.imis.service.GradeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.IOException;
import javafx.scene.control.*;

public class MainSceneController {
    @FXML private Label edit;
    @FXML
    private MenuItem delete;
    @FXML
    private MenuItem update;
    @FXML
    private MenuItem save;
    private Stage stage;

    @FXML private TextArea text;
    @FXML
    //处理编辑的鼠标点击操作
    public  void handleEdit(){
        showEdit();
    }

    @FXML
    //处理保存的鼠标点击操作
    private void handleSave(){
        new GradeService().save();
    }

    @FXML public void showEdit(){
        FXMLLoader loader=new FXMLLoader(EditController.class.getResource("Edit.fxml"));
        HBox root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage Editstage = new Stage();
        //stage.initModality(Modality.WINDOW_MODAL);
        Editstage.setScene(new Scene(root));

        //设置新增页面的控制器
        EditController controller = loader.getController();
        controller.setEditStage(stage);

        //Editstage.setX(mainX+305);
        //Editstage.setY(mainY+174);
        //取消标题栏
        //Editstage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        Editstage.setAlwaysOnTop(true);
        //修改透明度
        //Editstage.setOpacity(0.5);
        //显示对话框并等待用户操作
        Editstage.showAndWait();
    }
    @FXML
    public void print(){
        text.setText("chenggong");
    }


}
