package movieCollection.controllers;

import movieCollection.*;
import movieCollection.models.*;

import java.util.*;

public class MovieController {

    private final MovieRepository movieRepo;
    private final CSVFileRepository fileRepo;
    Scanner scanner;

    public MovieController(String filepath) { // конструктор
        this.scanner = new Scanner(System.in);
        this.movieRepo = new MovieRepository();
        this.fileRepo = new CSVFileRepository(filepath);
        this.loadFile();
    }

    public void addMovie(Movie movie){
        this.movieRepo.add(movie);
    }

    public void handleSaveCommand() { // сохранить фильмы в файл
        Collection<Movie> movies = this.movieRepo.getValues();
        this.fileRepo.save(movies);

    }

    private void loadFile() { // загрузить фильмы из файла
        Collection<Movie> movies = this.fileRepo.load();
        for (Movie movie : movies) {
            this.movieRepo.add(movie);
        }
    }

    public int handleInfoCommand() {//Екатерина
        return this.movieRepo.size();
    }

    public Collection<Movie> handleShowCommand() {
        return movieRepo.getValues();
    }

    public void handleInsertCommand(
            String personName, boolean gender, String movieName, MovieGenre genre) {
        Person person = new Person(personName, gender);
        Movie movie1 = new Movie(movieName, genre, person);
        this.movieRepo.add(movie1);
    }



    public boolean handleRemoveKeyCommand(long idValue) { // Татьяна
        if (this.movieRepo.containsKey(idValue)) {
            this.movieRepo.remove(idValue);
            return true;
        }
        return false;
    }

    public void handleClearCommand() {
        // Татьяна
        movieRepo.clear();
    }

    public void handleRemoveGreaterCommand(Long idIn) { //Дарья
        Set<Long> set = new HashSet<>();
        for (Long idMap : movieRepo.getIdSet()) {
            if (idMap > idIn) {
                set.add(idMap);
            }
        }
        for (Long id : set) {
            movieRepo.remove(id);
        }
    }

    public void handleRemoveLowerCommand(Long idIn) { // Дарья
        Set<Long> set = new HashSet<>();
        for (Long idMap : movieRepo.getIdSet()) {
            if (idMap < idIn) {
                set.add(idMap);
            }
        }
        for (Long id : set) {
            movieRepo.remove(id);
        }
    }

    public int handleCountLessThanGenreCommand(MovieGenre targetGenre) { // Дарья

        int counter = 0;
        for (Movie movie : movieRepo.getValues()) {

            if (movie.getGenre().ordinal() < targetGenre.ordinal()) {
                counter = counter + 1;
            }
        }

        return counter;
    }

    public void handleUpdateCommand(long idValue, MutableField answerValue, String newValue) {
        Movie movie = movieRepo.getById(idValue);
        if (movie==null) {
            System.out.println("Некорректный аргумент");
           return;
        }
        // проверить что movie нашелся
        switch (answerValue) {
            case MOVIENAME:
                movie.setMovieName(newValue);
                break;
            case GENRE:
                movie.setGenre();
                break;
            case SCREENWRITERNAME:
                movie.setScreenwriter();
                break;
        }
    }
}
