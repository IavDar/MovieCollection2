package movieCollection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean doLoop = true;

        Map <Long, Movie> movieMapTest = new HashMap<>();// коллекция фильмов.
        // @Tatjana пока выбрала для ключа - id, для значения - объекты класса Movie, как в задании

        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
// @Tatjana видимо, обработка пользовательского ввода для реализации команды insert???

        // дальше опрашиваете об остальных полях и по
        // итогу создаете объект на основе полученных данных


        Person person = new Person("Kameron", true);

        movieMapTest.put(54346L, new Movie (54346, "Titanic", MovieGenre.ACTION, person));
        movieMapTest.put(54345L, new Movie (54345, "Titanic2", MovieGenre.ADVENTURE, person));
        movieMapTest.put(54347L, new Movie (54347, "Titanic3", MovieGenre.FANTASY, person));

        manager.setMovieMap(movieMapTest);


        do {
            System.out.println("Введите команду:");

            //count_less_than_genre FANTASY
            //insert Titanic ACTION Kameron true

            String command = "";

            String[] lineInParts = null;

            String lineIn = scanner.nextLine();

            lineInParts = lineIn.split(" ");

            command = lineInParts[0];

            switch (command) {
                case "exit":
                    System.out.println("до свидания");
                    doLoop = false;
                    break;
                case "count_less_than_genre":
                    manager.startLessThanGenreCommand(lineInParts);
                    break;



                }

            } while (doLoop);


    }
}
