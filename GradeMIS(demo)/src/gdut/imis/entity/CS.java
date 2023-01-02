package gdut.imis.entity;

public class CS extends Student{
    private double operationScore;

    public CS() {
    }

    public CS(String id, String name, int age, String department, String sex, double midScore, double finalScore, double operationScore) {
        super(id, name, age, department, sex, midScore, finalScore);
        if(checkScore(operationScore)){
            this.operationScore = operationScore;
        }
    }

    public double getOperationScore() {
        return operationScore;
    }

    public void setOperationScore(double operationScore) {
        if(checkScore(operationScore)){
            this.operationScore = operationScore;
        }
    }

    @Override
    public double countGrade() {
        return 0.5*operationScore+0.25*getMidScore()+0.25*getFinalScore();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"#"+operationScore;
    }
}
