package movieCollection.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MovieRepository {

    private HashMap<Long, Movie> movieMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
    }

    public Collection<Movie> getValues() {
        return movieMap.values();
    }

    public void add(Movie movie){
        movieMap.put(movie.getId(), movie);
    }

    public Movie getById(Long id) {
        return movieMap.get(id);
    }

    public int size() {
      return this.movieMap.size();
    }
    public boolean containsKey(long idValue){
        // для метода startRemoveKeyCommand
        return this.movieMap.containsKey(idValue);
    }
    public void remove(long idValue){
        // для метода startRemoveKeyCommand
        this.movieMap.remove(idValue);
    }
    public void clear(){
        // для метода startClearCommand
        this.movieMap.clear();
    }
    public Set<Long> getIdSet(){
        // для метода startRemoveGreaterCommand
        return this.movieMap.keySet();
    }
}
