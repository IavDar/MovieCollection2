package movieCollection;

import java.util.Objects;

public class Movie implements Comparable<Movie> {
    private long id; //Значение поля должно быть больше 0,
    // Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String movieName; //Поле не может быть null, Строка не может быть пустой
    //@Tatjana поменяла имя поля, чтобы не было повтора с name из класса Person
    private MovieGenre genre; //Поле может быть null
    private Person screenwriter;

    private static int counter = 0;

    public Movie(String movieName, MovieGenre genre, Person screenwriter) {
        this.movieName = movieName;
        this.genre = genre;
        this.screenwriter = screenwriter;
        Movie.counter++;
        this.id = 918291822 + Movie.counter; //автоматическая генерация id
    }
// @Tatjana геттеры-сеттеры сгенерированы автоматически, по ходу может понадобиться сделать проверки на null и пр.
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) { // проверка movieName:

        if (movieName.equals(null)) {
            System.out.println("Поле не может быть NULL");
        } else if (movieName.equals("")) {
            System.out.println("Строка не может быть пустой");
        } else {
            this.movieName = movieName;
        }
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public Person getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(Person screenwriter) {
        this.screenwriter = screenwriter;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", genre=" + genre +
                ", screenwriter=" + screenwriter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getId() == movie.getId() && Objects.equals(getMovieName(), movie.getMovieName())
                && getGenre() == movie.getGenre() && Objects.equals(getScreenwriter(), movie.getScreenwriter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMovieName(), getGenre(), getScreenwriter());
    }

//    @Override
//    public int compareTo(Movie o) {
//        if (this.getId() < o.getId()) {
//            return -1;
//        } else if (this.getId() > o.getId()){
//            return 1;
//        } else
//        return 0;
//    }

    @Override
    public int compareTo(Movie o) {// переопределяем метод, приводим результат к int
        return (int)(this.getId() - o.getId());
    }

}

