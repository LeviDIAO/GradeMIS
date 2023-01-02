package gdut.imis.entity;

public class EN extends Student{
    private double speechScore;
    private double writeScore;

    public EN() {
    }

    public EN(String id, String name, int age, String department, String sex, double midScore, double finalScore, double speechScore, double writeScore) {
        super(id, name, age, department, sex, midScore, finalScore);
        if(checkScore(speechScore,writeScore)){
            this.speechScore = speechScore;
            this.writeScore = writeScore;
        }
    }

    public double getSpeechScore() {
        return speechScore;
    }

    public void setSpeechScore(double speechScore) {
        if(checkScore(speechScore,writeScore)){
            this.speechScore = speechScore;
        }
    }

    public double getWriteScore() {
        return writeScore;
    }

    public void setWriteScore(double writeScore) {
        if(checkScore(speechScore,writeScore)){
            this.writeScore = writeScore;
        }
    }

    @Override
    public double countGrade() {
        return 0.4*speechScore+0.2*writeScore+0.2*getMidScore()+0.2*getFinalScore();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"#"+speechScore+"#"+writeScore;
    }
}
