package com.example.a1408876.films;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * Created by 1408876 on 12/04/2017.
 */

public class MovieSearch {

    public static int responseCode = 0;
    public static String responseString = "";

    public static Thread login = new Thread(new Runnable() {
        private OkHttpClient client = new OkHttpClient();
        private String url = "https://api.themoviedb.org/3/search/movie?api_key=c3b71235edcd1d31c7043892fc4dcf4d&language=en-US&query=\"+query+\"&page=1&include_adult=false";


        public void run() {
            try {

                // Reset the response code
                responseCode = 0;

                // Make the request
                responses = client.newCall(request).execute();

                if ((responseCode = responses.code()) == 200) {
                    // Get response
                    String jsonData = responses.body().string();

                    // Transform reponse to JSon Object
                    JSONObject json = new JSONObject(jsonData);

                    // Use the JSon Object
                    user._token = json.getString("token");
                }

            } catch (IOException e) {
                responseString = e.toString();
            } catch (JSONException e) {
                responseString = e.toString();
            }
        }
    });

}
