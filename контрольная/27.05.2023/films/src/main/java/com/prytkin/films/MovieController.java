package com.prytkin.films;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MovieController implements Initializable {
    @FXML
    private ListView<Movie> movieListView;

    private MovieService movieService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movieService = new MovieService();

        try {
            List<Movie> movies = movieService.getMovies();
            movieListView.getItems().addAll(movies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
