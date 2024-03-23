package movieCollection.controllers;

import movieCollection.*;
import movieCollection.models.*;

import java.util.*;

public class MovieController {

    private final MovieRepository movieRepo;
    private final CSVFileRepository fileRepo;
    Scanner scanner;

    public void setMovieMap(HashMap<Long, Movie> movieMap) { //Дарья
        movieRepo.setMovieMap(movieMap);
    }

    public MovieController(String filepath) {// конструктор
        this.scanner = new Scanner(System.in);
        this.movieRepo = new MovieRepository();
        this.fileRepo = new CSVFileRepository(filepath);
    }

    public void handleSaveCommand() {  // сохранить фильмы в файл
        Collection<Movie> movies = this.movieRepo.getValues();
        this.fileRepo.save(movies);

    }

    public void loadMovies() {  // загрузить фильмы из файла


    }

    public void addMovie(Movie movie) { // метод для добавления фильмов в HashMap. Не работает ((
        this.movieRepo.add(movie);
    }

    Person person1 = new Person("Инна Веткина", false);
    Person person2 = new Person("Евгений Велтистов", true);
    Person person3 = new Person("Люк Бессон", true);
    Person person4 = new Person("David Fincher", true);
    Person person5 = new Person("Ryan Murphy", true);
    Person person6 = new Person("Fatih Akin", true);
    Person person7 = new Person("Tim Burton", true);
    Person person8 = new Person("Александр Войтинский", true);
    Movie movie1 = new Movie("Приключения Буратино", MovieGenre.ACTION, person1);
    Movie movie2 = new Movie("Приключения Электроника", MovieGenre.ADVENTURE, person2);
    Movie movie3 = new Movie("Люси", MovieGenre.ACTION, person3);
    Movie movie4 = new Movie("Gone Girl", MovieGenre.TRAGEDY, person4);
    Movie movie5 = new Movie("Dahmer-Monster", MovieGenre.HORROR, person5);
    Movie movie6 = new Movie("Gegen die Wand", MovieGenre.TRAGEDY, person6);
    Movie movie7 = new Movie("Die Insel der besonderen Kinder", MovieGenre.FANTASY, person7);
    Movie movie8 = new Movie("По щучъему велению.", MovieGenre.FANTASY, person8);

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

    public void startUpdateCommand(String argIn) { // Акмур

    }

    public void startRemoveKeyCommand(String argIn) { // Татьяна

        if (!Utils.isInt(argIn) || argIn == null) {
            System.out.println("Некорректный аргумент");
            return;
        }
        long idValue = Long.parseLong(argIn); // преобразование String в long "1982912981" -> 1982912981
        if (movieRepo.getMovieMap().containsKey(idValue)) {
            movieRepo.getMovieMap().remove(idValue);
            System.out.println("Элемент с id " + idValue + " успешно удалён");
        } else

            System.out.println("Такого элемента нет в списке");
    }


    public void startClearCommand() {
        // Татьяна

        do {
            System.out.print("Вы действительно хотите удалить все элементы из списка? [yes/no] : ");
            scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                Map<Long, Movie> movieMap1 = movieRepo.getMovieMap();// пока сделала на всякий случай с копией
                movieMap1.clear();
                System.out.println("Список очищен");
                break;

            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Команда отменена");
                break;

            } else {
                System.out.println("Вы ввели неверное значение. Попробуйте ещё раз. ");
            }

        } while (true);

    }

    public void startRemoveGreaterCommand(String argIn) {
        //Дарья

        if (!Utils.isLong(argIn)) {
            System.out.println("Указанно некорректное значение");
            return;
        }

        Long idIn = Long.valueOf(argIn);
        Set<Long> set = new HashSet<>();

        for (Long idMap : movieRepo.getMovieMap().keySet()) {
            if (idMap > idIn) {
                set.add(idMap);
            }
        }

        for (Long id : set) {

            System.out.println("Удалили " + " " + movieRepo.getMovieMap().get(id));

            movieRepo.getMovieMap().remove(id);
        }
    }

    public void startRemoveLowerCommand(String argIn) { // Дарья

        if (!Utils.isLong(argIn)) {
            System.out.println("Указанно некорректное значение");
            return;
        }

        Long idIn = Long.valueOf(argIn);
        Set<Long> set = new HashSet<>();

        for (Long idMap : movieRepo.getMovieMap().keySet()) {
            if (idMap < idIn) {
                set.add(idMap);
            }
        }

        for (Long id : set) {

            System.out.println("Удалили " + " " + movieRepo.getMovieMap().get(id));

            movieRepo.getMovieMap().remove(id);
        }

    }

    public int startCountLessThanGenreCommand(MovieGenre targetGenre) { // Дарья

        int counter = 0;
        for (Movie movie : movieRepo.getMovieMap().values()) {

            if (movie.getGenre().ordinal() < targetGenre.ordinal()) {
                counter = counter + 1;
            }
        }

        return counter;
    }
}
