package get.brains.quizmundial.data.network;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionManager {

    public static String getJSON(String url){
        String json = null;
        try {
            URL address = new URL(url);

            HttpURLConnection urlConnection = (HttpURLConnection) address.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(15000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();

            InputStream inputStream;
            int responseCod = urlConnection.getResponseCode();
            if(responseCod < HttpURLConnection.HTTP_BAD_REQUEST)
                inputStream = urlConnection.getInputStream();
            else
                inputStream = urlConnection.getErrorStream();

            json = inputStreamToString(inputStream);
            inputStream.close();
            urlConnection.disconnect();
        } catch (IOException e){
            e.printStackTrace();
        }

        return json;
    }

    public static void postJSON(String url, JSONObject json) {
        try {
            URL address = new URL(url);

            HttpURLConnection urlConnection = (HttpURLConnection) address.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            InputStream inputStream;
            OutputStream outputStream = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            writer.write(json.toString());
            writer.flush();
            writer.close();

            outputStream.close();
            urlConnection.connect();

            int responseCode = urlConnection.getResponseCode();
            if (responseCode < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = urlConnection.getInputStream();
            } else {
                inputStream = urlConnection.getErrorStream();
            }

            inputStream.close();
            urlConnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String inputStreamToString(InputStream is){
        StringBuilder buffer = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while((line = reader.readLine())!=null){
                buffer.append(line);
            }

            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }
}