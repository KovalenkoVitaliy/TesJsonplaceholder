import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;

public class TestJson {
    private static final String urlText = "http://jsonplaceholder.typicode.com/albums";
    private static HttpURLConnection httpURLConnection;
    private static String Response;

    public static void main(String[] args) {
        try {
            URL url = new URL(urlText);
            httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            int status = httpURLConnection.getResponseCode();
            System.out.println(status);
            if (status == 200) {
                 Response = TestReader.readJson(httpURLConnection);
                 System.out.println(Response);
                 System.out.println("********************************************************************************************************");
            }
            TestReader.printJson(Response);
         } catch (MalformedURLException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpURLConnection.disconnect();
        }
    }
}
