package get.brains.quizmundial.data;

import get.brains.quizmundial.data.model.Question;
import get.brains.quizmundial.data.network.ConnectionManager;
import get.brains.quizmundial.data.network.NetworkUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuestionREST {

    private static Question parseJSON(String json) {
        try {
            JSONObject jsonObj = new JSONObject(json);

            int ID = jsonObj.getInt("id");
            String region = jsonObj.getString("region");
            String continent = jsonObj.getString("continent");
            String statement = jsonObj.getString("statement");
            int difficult = jsonObj.getInt("difficult");

            return new Question(ID,continent,region,difficult,statement);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject toJSON(Question question) {
        JSONObject json = new JSONObject();

        try {
            json.put("id", question.getID());
            json.put("region", question.getRegion());
            json.put("continent", question.getContinent());
            json.put("statement", question.getStatement());
            json.put("difficult", question.getDifficult());
        } catch (JSONException ex) {
            Logger.getLogger(QuestionREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static Question[] getQuestionsByContinent(String continent){
        Question questions[] = null;
        String json = ConnectionManager.getJSON(NetworkUtils.URL_WEB_SERVICE + "question?continent="+continent);
        try {
            JSONArray jsonArray = new JSONArray(json);
            questions = new Question[jsonArray.length()];
            for (int i = 0; i < questions.length; i++) {
                questions[i] = parseJSON(jsonArray.getJSONObject(i).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (json.isEmpty())
            return null;
        return questions;
    }
}
