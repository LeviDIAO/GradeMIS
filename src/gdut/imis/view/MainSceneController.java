package gdut.imis.view;

import gdut.imis.service.GradeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.IOException;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

public class MainSceneController {
    @FXML private TextField idDelete;
    @FXML private void insert(){
        showCSEdit();

    }
    @FXML public void showCSEdit(){
        FXMLLoader loader=new FXMLLoader(CSEditController.class.getResource("CSEdit.fxml"));
        AnchorPane root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage Editstage = new Stage();
        //stage.initModality(Modality.WINDOW_MODAL);
        Editstage.setScene(new Scene(root));
        //设置新增页面的控制器
        CSEditController controller = loader.getController();
        controller.setStage(Editstage);
        //取消标题栏
        Editstage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        Editstage.setAlwaysOnTop(true);
        //显示对话框并等待用户操作
        Editstage.showAndWait();
    }
    @FXML public void showENEdit(){
        FXMLLoader loader=new FXMLLoader(CSEditController.class.getResource("ENEdit.fxml"));
        AnchorPane root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage Editstage = new Stage();
        //stage.initModality(Modality.WINDOW_MODAL);
        Editstage.setScene(new Scene(root));
        //设置新增页面的控制器
        ENEditController controller = loader.getController();
        controller.setStage(Editstage);
        //取消标题栏
        Editstage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        Editstage.setAlwaysOnTop(true);
        //显示对话框并等待用户操作
        Editstage.showAndWait();
    }
    @FXML public void showLTEdit(){
        FXMLLoader loader=new FXMLLoader(CSEditController.class.getResource("LTEdit.fxml"));
        AnchorPane root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage Editstage = new Stage();
        //stage.initModality(Modality.WINDOW_MODAL);
        Editstage.setScene(new Scene(root));
        //设置新增页面的控制器
        LTEditController controller = loader.getController();
        controller.setStage(Editstage);
        //取消标题栏
        Editstage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        Editstage.setAlwaysOnTop(true);
        //显示对话框并等待用户操作
        Editstage.showAndWait();
    }
    @FXML private void handleDelete(){
        String id = idDelete.getText();
        new GradeService().delete(id);
    }
    @FXML private void save(){
        new GradeService();
        GradeService.getGradeService().save();
    }
}
