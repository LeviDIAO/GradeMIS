package gdut.imis.view;

import gdut.imis.MainApp;
import gdut.imis.entity.Person;
import gdut.imis.service.GradeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainSceneController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> idColum;
    @FXML
    private TableColumn<Person, String> nameColum;
    private MainApp mainApp;
    @FXML private void initialize(){
        idColum.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameColum.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
    @FXML private TextField idDelete;
    @FXML private TextField idSelect;
    @FXML private TextField minText;
    @FXML private TextField maxText;
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
        reflashTable();
        new MainApp();
        setMainApp(mainApp);
    }
    @FXML public void reflashTable(){
	personTable.getItems().setAll(new MainApp().getPersonData());
    }
    @FXML private void selectById(){
        String id = idSelect.getText();
        new GradeService().selectById(id);
    }
    @FXML private void selectByName(){
        String id = idSelect.getText();
        new GradeService().selectByName(id);
    }
    @FXML private void selectByGrade(){
        Double min = Double.parseDouble(minText.getText());
        Double max = Double.parseDouble(maxText.getText());
        new GradeService().selectByGrade(min,max);
    }
    @FXML private void CSsortByGrade(){
        new GradeService().sortByGrade("计算机系");
    }
    @FXML private void ENsortByGrade(){
        new GradeService().sortByGrade("英语系");
    }
    @FXML private void LTsortByGrade(){
        new GradeService().sortByGrade("文学系");
    }
}
