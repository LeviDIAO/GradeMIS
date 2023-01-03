package gdut.imis.dao;

import gdut.imis.entity.CS;
import gdut.imis.entity.EN;
import gdut.imis.entity.LT;
import gdut.imis.entity.Student;
import gdut.imis.view.AlertController;
import gdut.imis.view.CSEditController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;

public class StudentDAO {
    public boolean isSaved;
    public static void write(Student[] stuList) {
        //学生信息写入文件student.info
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("student.info"))) {
            for (Student stu : stuList) {
                bw.write(stu.getInfo() + "\n");
            }
            bw.flush();
            alert = "保存成功啦！";
            showAlert();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Student> read() {
        ArrayList<Student> stuList = new ArrayList<>();
        String stuInfo;
        try (BufferedReader br = new BufferedReader(new FileReader("student.info"))) {
            while ((stuInfo = br.readLine()) != null) {

                //根据#分离提取学生信息
                String[] stuStrArr = stuInfo.split("#");

                //封装学生信息
                if ("计算机系".equals(stuStrArr[0])) {
                    CS cs = new CS();
                    cs.setDepartment(stuStrArr[0]);
                    cs.setId(stuStrArr[1]);
                    cs.setName(stuStrArr[2]);
                    cs.setAge(Integer.parseInt(stuStrArr[3]));
                    cs.setSex(stuStrArr[4]);
                    cs.setMidScore(Double.parseDouble(stuStrArr[5]));
                    cs.setFinalScore(Double.parseDouble(stuStrArr[6]));
                    cs.setOperationScore(Double.parseDouble(stuStrArr[7]));
                    stuList.add(cs);
                }

                if ("英语系".equals(stuStrArr[0])) {
                    EN en = new EN();
                    en.setDepartment(stuStrArr[0]);
                    en.setId(stuStrArr[1]);
                    en.setName(stuStrArr[2]);
                    en.setAge(Integer.parseInt(stuStrArr[3]));
                    en.setSex(stuStrArr[4]);
                    en.setMidScore(Double.parseDouble(stuStrArr[5]));
                    en.setFinalScore(Double.parseDouble(stuStrArr[6]));
                    en.setSpeechScore(Double.parseDouble(stuStrArr[7]));
                    en.setWriteScore(Double.parseDouble(stuStrArr[8]));
                    stuList.add(en);
                }

                if ("文学系".equals(stuStrArr[0])) {
                    LT lt = new LT();
                    lt.setDepartment(stuStrArr[0]);
                    lt.setId(stuStrArr[1]);
                    lt.setName(stuStrArr[2]);
                    lt.setAge(Integer.parseInt(stuStrArr[3]));
                    lt.setSex(stuStrArr[4]);
                    lt.setMidScore(Double.parseDouble(stuStrArr[5]));
                    lt.setFinalScore(Double.parseDouble(stuStrArr[6]));
                    lt.setSpeechScore(Double.parseDouble(stuStrArr[7]));
                    lt.setWorkScore(Double.parseDouble(stuStrArr[8]));
                    stuList.add(lt);
                }
            }
        } catch (FileNotFoundException e) {
            alert=("文件找不到啊！");
            showAlert();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stuList;
    }
    private static String alert;
    public static void showAlert() {
        FXMLLoader loader = new FXMLLoader(CSEditController.class.getResource("Alert.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage AlertStage = new Stage();
        AlertStage.initModality(Modality.WINDOW_MODAL);
        AlertStage.setScene(new Scene(root));
        //设置新增页面的控制器
        AlertController controller = loader.getController();
        controller.setStage(AlertStage);
        //取消标题栏
        AlertStage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        AlertStage.setAlwaysOnTop(true);
        controller.print(alert);
        AlertStage.showAndWait();
    }
}