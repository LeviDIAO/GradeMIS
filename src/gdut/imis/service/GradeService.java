package gdut.imis.service;

import gdut.imis.dao.StudentDAO;
import gdut.imis.entity.CS;
import gdut.imis.entity.EN;
import gdut.imis.entity.LT;
import gdut.imis.entity.Student;
import gdut.imis.view.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;

public class GradeService implements IGrade {
    private static ArrayList<Student> stuList;
    private String alert;
    private static GradeService gradeService = new GradeService();
    public static GradeService getGradeService() {
        return gradeService;
    }
    private void init() {
        stuList = StudentDAO.read();
    }
    @Override
    public boolean insert(Student stu) {
        init();
        for (Student s : stuList) {
            if (s.getId().equals((stu.getId()))) {
                alert = ("存在相同学号记录，新增失败！");
                showAlert();
                return false;
            }
        }
        stuList.add(stu);
        alert = ("新增成功！");
        showAlert();
        return false;
    }

    @FXML
    public void showAlert() {
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
        //AlertStage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        AlertStage.setAlwaysOnTop(true);
        controller.print(alert);
        AlertStage.showAndWait();
    }

    @Override
    public boolean delete(String id) {
        init();
        for (Student s : stuList) {
            if (s.getId().equals(id)) {
                stuList.remove(s);
                alert = ("删除成功！");
                break;
            } else alert = ("不存在该记录，删除失败！");
        }
        //append传入false表示写入内容时将会覆盖文件中之前存在的内容
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("student.info",false))){
            for (Student s : stuList){
                bw.write(s.getInfo()+"\n");//执行删除操作，写入空内容覆盖之前的内容
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        showAlert();
        return false;
        }



    @Override
    public boolean update(Student stu) {
        return false;
    }

    @Override
    public Student selectById(String id) {
        init();
        boolean key = true;
        alert = ("不存在该记录，查询失败！");
        for (Student s : stuList) {
            if (s.getId().equals(id)) {
                if (s.getDepartment().equals("计算机系")) showCSInfo((CS)s);
                if (s.getDepartment().equals("英语系")) showENInfo((EN)s);
                if (s.getDepartment().equals("文学系")) showLTInfo((LT)s);
                key=false;
            }
        }
        if(key)showAlert();
        return null;
    }
    @Override
    public Student[] selectByName(String name) {
        init();
        alert = ("不存在该记录，查询失败！");
        for (Student s : stuList) {
            if (s.getName().equals(name)) {
                alert=(s.getInfo());
            }
        }
        showAlert();
        return null;
    }

    @Override
    public Student[] selectByGrade( double min, double max) {
        init();
        StringBuffer str = new StringBuffer();
        for (Student s : stuList) {
            if (s.countGrade() < max && s.countGrade() > min) {
                str.append(s.getDepartment()).append("\t").append(s.getId()).append("\t").append(s.getName()).append("\t").append(s.countGrade()).append("\n");
            }
        }
        showInfo(str);
        return null;
    }
    public void showInfo(StringBuffer stringBuffer) {
        FXMLLoader loader = new FXMLLoader(CSEditController.class.getResource("Info.fxml"));
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
        InfoController controller = loader.getController();
        controller.setStage(AlertStage);
        controller.setTextArea(stringBuffer);
        //取消标题栏
        //AlertStage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        AlertStage.setAlwaysOnTop(true);
        AlertStage.showAndWait();
    }
    @Override
    public void sortByGrade(String dept) {
        ArrayList<Student> deptStu = new ArrayList<>();
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getDepartment().equals(dept)) deptStu.add(stuList.get(i));
        }
        //筛选指定系的学生

        Student[] deptStuArr = new Student[deptStu.size()];
        deptStu.toArray(deptStuArr);

        for (int i = 0; i < deptStuArr.length - 1; i++) {
            boolean flag = true;
            for (int k = 0; k < deptStuArr.length - 1 - i; k++) {
                if (deptStuArr[k].countGrade() < deptStuArr[k + 1].countGrade()) {
                    Student stu = deptStuArr[k];
                    deptStuArr[k] = deptStuArr[k + 1];
                    deptStuArr[k + 1] = stu;
                    flag = false;
                }
            }
            if (flag) break;
        }
        //基于综合成绩完成该系学生信息的排序（冒泡排序）

        for (Student s : deptStuArr) {

        }
    }
    public void save() {
        Student[] stuArr = new Student[stuList.size()];
        stuList.toArray(stuArr);
        new StudentDAO();
        StudentDAO.write(stuArr);
    }
    private void showCSInfo(CS s){
        FXMLLoader loader = new FXMLLoader(CSEditController.class.getResource("CSInfo.fxml"));
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
        CSInfoController controller = loader.getController();
        controller.setStage(AlertStage);
        controller.setInfo(s);
        //取消标题栏
        //AlertStage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        AlertStage.setAlwaysOnTop(true);
        AlertStage.showAndWait();
    }
    private void showENInfo(EN s){
        FXMLLoader loader = new FXMLLoader(CSEditController.class.getResource("ENInfo.fxml"));
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
        ENInfoController controller = loader.getController();
        controller.setStage(AlertStage);
        controller.setInfo(s);
        //取消标题栏
        //AlertStage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        AlertStage.setAlwaysOnTop(true);
        AlertStage.showAndWait();
    }
    private void showLTInfo(LT s){
        FXMLLoader loader = new FXMLLoader(CSEditController.class.getResource("LTInfo.fxml"));
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
        LTInfoController controller = loader.getController();
        controller.setStage(AlertStage);
        controller.setInfo(s);
        //取消标题栏
        //AlertStage.initStyle(StageStyle.UNDECORATED);
        //置于最上层
        AlertStage.setAlwaysOnTop(true);
        AlertStage.showAndWait();
    }








}

