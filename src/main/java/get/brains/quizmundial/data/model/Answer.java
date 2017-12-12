package get.brains.quizmundial.data.model;

public class Answer {
    private Integer ID;
    private String label;
    private boolean correct;
    private Integer questionID;

    public Answer(Integer ID, String label, boolean correct, Integer questionID) {
        this.ID = ID;
        this.label = label;
        this.correct = correct;
        this.questionID = questionID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }
}
