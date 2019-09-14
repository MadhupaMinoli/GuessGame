package GuessGame.WordRepository;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HTTPDatasource implements Datasource{

    private String[] AllWord;


    public HTTPDatasource(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));



        JSONArray array = new JSONArray(in.readLine());

        String[] allWords = new String[array.length()];
       for(int i= 0; i< array.length();i++){
           allWords[i]= (String) array.get(i);
       }

        in.close();
        AllWord=allWords;

    }

    @Override
    public String[] getWordList() {

        return AllWord;
    }



    @Override
    public String randomWord(String[] possibleWords) {

        Random random = new Random();
        int randomIndex = random.nextInt(possibleWords.length);

        return possibleWords[randomIndex];
    }
}
