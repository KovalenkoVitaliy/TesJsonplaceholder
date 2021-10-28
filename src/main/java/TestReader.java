import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class TestReader {



    public static String readJson(HttpURLConnection httpURLConnection) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        String responseLine;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((responseLine = bufferedReader.readLine())!=null) {
                stringBuilder.append(responseLine);
            }
        } catch (IOException e) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
        return stringBuilder.toString();
    }

    public static void printJson(String response) {
        int porog = 0;
        JSONArray array = new JSONArray(response);
        for (int i=0 ; i<array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            int userId = jsonObject.getInt("userId");
            int id =jsonObject.getInt("id");
            String title = jsonObject.getString("title");
            if (porog != userId) {
                System.out.println("-----------------------------");
            }
            porog = userId;
            System.out.println(userId + " " + " " + id + " " + title);
        }
    }

}
