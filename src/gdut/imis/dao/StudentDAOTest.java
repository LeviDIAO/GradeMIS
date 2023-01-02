package gdut.imis.dao;

import gdut.imis.entity.CS;
import gdut.imis.entity.Student;
import gdut.imis.service.GradeService;

import java.util.ArrayList;

public class StudentDAOTest {

    @org.junit.Test
    public void write() {
        GradeService gs = new GradeService();
        Student stu = new CS("2002","hong", 20,"计算机系","女",90,86,78);
        gs.insert(stu);
        gs.save();
    }
}