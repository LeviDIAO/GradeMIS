package gdut.imis;

import gdut.imis.view.MainSceneController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //加载layout
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/MainScene.fxml"));
        VBox root = loader.load();
        //设置scene
        Scene scene = new Scene(root);
        //stage.setTitle("成绩管理系统");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
        MainSceneController controller = loader.getController();
        //主界面关闭时全部窗口关闭
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
