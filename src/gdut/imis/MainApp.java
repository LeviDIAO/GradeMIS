package gdut.imis;

import gdut.imis.dao.StudentDAO;
import gdut.imis.entity.Person;
import gdut.imis.entity.Student;
import gdut.imis.view.MainSceneController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class MainApp extends Application {

    //创建透明列表
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    //初始化列表
    public MainApp() {
        ArrayList<Student> arrayList ;
        new StudentDAO();
        arrayList=StudentDAO.read();
        for (Student s : arrayList){
            personData.add(new Person(s.getId(),s.getName()));
        }
    }

    //返回列表数据
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage stage) throws Exception {
        //加载layout
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/MainScene.fxml"));
        VBox root = loader.load();
        //设置scene
        Scene scene = new Scene(root);
        stage.setTitle("成绩管理系统");
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UTILITY);
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();
        MainSceneController controller = loader.getController();
        controller.setMainApp(this);
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
