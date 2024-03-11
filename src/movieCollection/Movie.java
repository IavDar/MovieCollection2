package movieCollection;

public class Movie {
    private long id; //Значение поля должно быть больше 0,
    // Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String movieName; //Поле не может быть null, Строка не может быть пустой
    //@Tatjana поменяла имя поля, чтобы не было повтора с name из класса Person
    private MovieGenre genre; //Поле может быть null
    private Person screenwriter;

    private static int counter = 0;

    public Movie(long id, String movieName, MovieGenre genre, Person screenwriter) {
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

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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
}

