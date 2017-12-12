package get.brains.quizmundial.data.model;

public class Question {

    private Integer ID;
    private String continent;
    private String region;
    private Integer difficult;
    private String statement;

    public Question(Integer ID, String continent, String region, Integer difficult, String statement) {
        this.ID = ID;
        this.continent = continent;
        this.region = region;
        this.difficult = difficult;
        this.statement = statement;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
