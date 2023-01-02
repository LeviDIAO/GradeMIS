package gdut.imis.entity;

public class LT extends Student{
    private double speechScore;
    private double workScore;

    public LT() {
    }

    public LT(String id, String name, int age, String department, String sex, double midScore, double finalScore, double speechScore, double workScore) {
        super(id, name, age, department, sex, midScore, finalScore);
        if(checkScore(speechScore,workScore)){
            this.speechScore = speechScore;
            this.workScore = workScore;
        }
    }

    public double getSpeechScore() {
        return speechScore;
    }

    public void setSpeechScore(double speechScore) {
        if(checkScore(speechScore))this.speechScore = speechScore;
    }

    public double getWorkScore() {
        return workScore;
    }

    public void setWorkScore(double workScore) {
        if(checkScore(workScore))this.workScore = workScore;
    }

    @Override
    public double countGrade() {
        return 0.35*speechScore+0.35*workScore+0.15*getMidScore()+0.15*getFinalScore();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"#"+speechScore+"#"+workScore;
    }
}
