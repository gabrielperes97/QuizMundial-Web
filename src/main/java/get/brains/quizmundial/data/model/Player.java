package get.brains.quizmundial.data.model;

public class Player {
    private Integer ID;
    private String nick;
    private String password;
    private Integer age;
    private Integer score;
    private Integer currentLevel;
    private Integer hits;
    private Integer answeredQuestions;

    public Player(Integer ID, String nick, Integer age, Integer score, Integer currentLevel, Integer hits, Integer answeredQuestions, String password) {
        this.ID = ID;
        this.nick = nick;
        this.password = password;
        this.age = age;
        this.score = score;
        this.currentLevel = currentLevel;
        this.hits = hits;
        this.answeredQuestions = answeredQuestions;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(Integer answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }
}
