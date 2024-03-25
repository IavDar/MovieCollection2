package tests;

import movieCollection.models.Movie;
import movieCollection.models.MovieGenre;
import movieCollection.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class MainTest {

    @Test
    public void MovieConstructorTest() {
        String name = "Titanic";
        MovieGenre genre = MovieGenre.TRAGEDY;
        Person person = new Person("Игорь Иванович", true);

        Movie movie = new Movie(name, genre, person);

        Assertions.assertEquals(movie.getMovieName(), name);

    }

    @Test
    public void PersonConstructorTest() {
        String name = "Евгений Велтистов";
        boolean isMan = true ;
        Person Person = new Person(name, isMan);

        Assertions.assertEquals(Person.getName(), name);

    }

}
