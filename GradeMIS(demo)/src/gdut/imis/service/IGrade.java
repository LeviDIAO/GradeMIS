package gdut.imis.service;

import gdut.imis.entity.Student;

public interface IGrade {
    boolean insert(Student stu);
    //新增学生信息
    boolean delete(Student id);
    //删除学生信息（根据学号）
    boolean update(Student stu);
    //更新学生信息
    Student selectById(String id);
    //根据学号查询学生信息
    Student[] selectByName(String name);
    //根据姓名查询学生信息
    Student[] selectByGrade(String dept,double min,double max);
    //查询综合成绩在某一分数段的学生信息
    void sortByGrade(String dept);
    //各系学生信息按综合成绩排序
    void save();
    //保存写入的学生信息
}
