package gdut.imis;

import gdut.imis.view.EditController;
import gdut.imis.view.MainSceneController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MainApp extends Application {
    double mainX,mainY;
    @Override
    public void start(Stage stage) throws Exception {
        //加载layout
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/MainScene.fxml"));
        BorderPane root = loader.load();
        //设置scene
        Scene scene = new Scene(root);
        stage.setTitle("成绩管理系统");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
        MainSceneController controller = loader.getController();
        mainX=stage.getX();
        mainY=stage.getY();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);            }
        });
        showEdit();
    }
    @FXML
    public void showEdit(){
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
        //EditController controller = loader.getController();
        //controller.setEditStage(stage);

        Editstage.setX(mainX+305);
        Editstage.setY(mainY+174);
        //取消标题栏
        //Editstage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        Editstage.setAlwaysOnTop(true);
        //修改透明度
        Editstage.setOpacity(0.5);
        //显示对话框并等待用户操作
        Editstage.showAndWait();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
