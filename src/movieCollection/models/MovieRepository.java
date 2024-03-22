package movieCollection.models;

import java.util.Collection;
import java.util.HashMap;

public class MovieRepository {

    private HashMap<Long, Movie> movieMap;

    public MovieRepository() {
        movieMap = new HashMap<>();
    }

    public HashMap<Long, Movie> getMovieMap() {
        return movieMap;
    }

    public void setMovieMap(HashMap<Long, Movie> movieMap) {
        this.movieMap = movieMap;
    }

    public Collection<Movie> getValues() {
        return movieMap.values();
    }
}
