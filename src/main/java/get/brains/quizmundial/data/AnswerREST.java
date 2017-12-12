package get.brains.quizmundial.data;

import get.brains.quizmundial.data.model.Answer;
import get.brains.quizmundial.data.network.ConnectionManager;
import get.brains.quizmundial.data.network.NetworkUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnswerREST {

    private static Answer parseJSON(String json) {
        try {
            JSONObject jsonObj = new JSONObject(json);

            int ID = jsonObj.getInt("id");
            String label = jsonObj.getString("label");
            boolean correct = jsonObj.getBoolean("correct");

            return new Answer(ID,label,correct,0);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject toJSON(Answer answer) {
        JSONObject json = new JSONObject();

        try {
            json.put("id", answer.getID());
            json.put("label", answer.getLabel());
            json.put("correct", answer.isCorrect());
            json.put("question", answer.getQuestionID());
        } catch (JSONException ex) {
            Logger.getLogger(QuestionREST.class.getName()).log(Level.SEVERE, null, ex);
        }

        return json;
    }

    public static Answer[] getAnswersByQuestion(int question){
        Answer answers[] = null;
        String json = ConnectionManager.getJSON(NetworkUtils.URL_WEB_SERVICE + "answer?question="+question);
        try {
            JSONArray jsonArray = new JSONArray(json);
            answers = new Answer[jsonArray.length()];
            for (int i = 0; i < answers.length; i++) {
                answers[i] = parseJSON(jsonArray.getJSONObject(i).toString());
                answers[i].setQuestionID(question);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (json.isEmpty())
            return null;
        return answers;
    }
}
