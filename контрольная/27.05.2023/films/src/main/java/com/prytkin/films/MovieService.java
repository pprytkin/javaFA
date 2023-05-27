package com.prytkin.films;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class MovieService {
    private static final String API_URL = "http://localhost:8080/films";

    public List<Movie> getMovies() throws IOException {
        List<Movie> movies = new ArrayList<>();

        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            JSONArray moviesJsonArray = new JSONArray(response.toString());
            for (int i = 0; i < moviesJsonArray.length(); i++) {
                JSONObject movieJson = moviesJsonArray.getJSONObject(i);
                Movie movie = new Movie();
                movie.setId(movieJson.getInt("id"));
                movie.setTitle(movieJson.getString("title"));
                movie.setDescription(movieJson.getString("description"));
                movies.add(movie);
            }
        }

        return movies;
    }
}
