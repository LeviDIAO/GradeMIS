package gdut.imis.service;

import gdut.imis.dao.StudentDAO;
import gdut.imis.entity.Student;

import java.util.ArrayList;

public class GradeService implements IGrade{
    private static ArrayList<Student> stuList;
    public void init(){
        stuList = StudentDAO.read();
    }
    @Override
    public boolean insert(Student stu) {
        for (Student s : stuList){
            if(s.getId().equals((stu.getId()))) {
                System.out.println("记录已存在，新增失败！");
                return false;
            }
        }
        stuList.add(stu);
        System.out.println("新增成功！");
        return false;
    }

    @Override
    public boolean delete(Student id) {
        return false;
    }

    @Override
    public boolean update(Student stu) {
        return false;
    }

    @Override
    public Student selectById(String id) {
        return null;
    }

    @Override
    public Student[] selectByName(String name) {
        return new Student[0];
    }

    @Override
    public Student[] selectByGrade(String dept, double min, double max) {
        return new Student[0];
    }

    @Override
    public void sortByGrade(String dept) {
        ArrayList<Student> deptStu = new ArrayList<>();
        for (int i = 0;i<stuList.size();i++){
            if(stuList.get(i).getDepartment().equals(dept))deptStu.add(stuList.get(i));
        }
        //筛选指定系的学生

        Student[] deptStuArr = new Student[deptStu.size()];
        deptStu.toArray(deptStuArr);

        for (int i = 0;i<deptStuArr.length-1;i++){
            boolean flag = true;
            for (int k = 0;k<deptStuArr.length-1-i;k++){
                if(deptStuArr[k].countGrade()<deptStuArr[k+1].countGrade()){
                    Student stu = deptStuArr[k];
                    deptStuArr[k] = deptStuArr[k+1];
                    deptStuArr[k+1] = stu;
                    flag = false;
                }
            }
            if (flag)break;
        }
        //基于综合成绩完成该系学生信息的排序（冒泡排序）

        System.out.println("系别\t学号\t姓名\t综合成绩");
        for (Student s : deptStuArr){
            System.out.println(s.getDepartment()+"\t\t"+s.getId()+"\t"+s.getName()+"\t"+s.countGrade());
        }
    }

    public void save(){
        Student[] stuArr = new Student[stuList.size()];
        stuList.toArray(stuArr);
        StudentDAO.write(stuArr);
    }
}
