package gdut.imis.entity;

import gdut.imis.common.IllegalScoreException;

public abstract class Student {
    private String id;
    private String name;
    private int age;
    private String department;
    private String sex;
    private double midScore;
    private double finalScore;
//构造方法
    public Student() {
    }
//构造方法
    public Student(String id, String name, int age, String department, String sex, double midScore, double finalScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.sex = sex;
        if(checkScore(midScore,finalScore)){
            this.midScore = midScore;
            this.finalScore = finalScore;
        }
    }
//getter setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
       this.sex=sex;
    }

    public double getMidScore() {
        return midScore;
    }

    public void setMidScore(double midScore) {
        if(checkScore(midScore,finalScore)){
            this.midScore = midScore;
        }
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        if(checkScore(midScore,finalScore)) {
            this.finalScore = finalScore;
        }
    }
    //获取学生信息
    public String getInfo(){
        return department+"#"+id+"#"+name+"#"+age+"#"+sex+"#"+midScore+"#"+finalScore;
    }
    //成绩评测标准
    public abstract double countGrade();
    //成绩输入约束
    public boolean checkScore(double...score){
        for(double s:score){
            try{
                if(s<0||s>100){
                    throw new IllegalScoreException();
                }
            }catch (IllegalScoreException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
}
