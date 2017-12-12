package get.brains.quizmundial.data;

import get.brains.quizmundial.data.model.Player;
import get.brains.quizmundial.data.network.ConnectionManager;
import get.brains.quizmundial.data.network.NetworkUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayerREST {

    private static Player parseJSON(String json) {
        try {
            JSONObject jsonObj = new JSONObject(json);

            int ID = jsonObj.getInt("id");
            String nick = jsonObj.getString("nick");
            int age = jsonObj.getInt("age");
            int score = jsonObj.getInt("score");
            int currentLevel = jsonObj.getInt("currentLevel");
            int hits = jsonObj.getInt("hits");
            int answeredQuestions = jsonObj.getInt("answeredQuestions");
            String password = jsonObj.getString("password");

            return new Player(ID, nick, age, score, currentLevel, hits, answeredQuestions, password);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject toJSON(Player player) {
        JSONObject json = new JSONObject();

        try {
            json.put("id", player.getID());
            json.put("nick", player.getNick());
            json.put("age", player.getAge());
            json.put("score", player.getScore());
            json.put("currentLevel", player.getCurrentLevel());
            json.put("hits", player.getHits());
            json.put("answeredQuestions", player.getAnsweredQuestions());
            json.put("password", player.getPassword());
        } catch (JSONException ex) {
            Logger.getLogger(QuestionREST.class.getName()).log(Level.SEVERE, null, ex);
        }

        return json;
    }

    public static Player getPlayer(String nick) {
        String json = ConnectionManager.getJSON(NetworkUtils.URL_WEB_SERVICE + "player?nick=" + nick);
        if (json.isEmpty())
            return null;
        return parseJSON(json);
    }

    public static void savePlayer(Player player) {
        ConnectionManager.postJSON(NetworkUtils.URL_WEB_SERVICE + "player", toJSON(player));
    }

    public static void updatePlayer(Player player) {

    }

    public static Player[] getPlayersList() {
        Player players[] = null;
        String json = ConnectionManager.getJSON(NetworkUtils.URL_WEB_SERVICE + "player/list");
        try {
            JSONArray jsonArray = new JSONArray(json);
            players = new Player[jsonArray.length()];
            for (int i = 0; i < players.length; i++) {
                players[i] = parseJSON(jsonArray.getJSONObject(i).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (json.isEmpty())
            return null;
        return players;
    }
}