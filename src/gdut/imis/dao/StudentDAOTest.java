package gdut.imis.dao;

import gdut.imis.entity.CS;
import gdut.imis.entity.Student;
import gdut.imis.service.GradeService;

import java.util.ArrayList;

public class StudentDAOTest {

    @org.junit.Test
    public void write() {
        GradeService gs = new GradeService();
        gs=GradeService.getGradeService();
        Student stu = new CS("77751","不调用javafx测试", 21,"计算机系","女",90,86,78);
        gs.delete(String.valueOf(2));
    }


}