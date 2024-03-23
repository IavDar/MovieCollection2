package movieCollection.views;

import movieCollection.*;
import movieCollection.controllers.MovieController;
import movieCollection.models.Movie;
import movieCollection.models.MovieGenre;
import movieCollection.models.Person;

import java.util.*;

public class CLIView {
    MovieController movieController;
    Scanner scanner;

    public void run(String filepath) {

        movieController = new MovieController(filepath);
        movieController.loadMovies();

        scanner = new Scanner(System.in);
        //коллекция фильмов в виде HashMap (ключ - id, значение - объекты класса Movie)
        HashMap<Long, Movie> movieMap = new HashMap<>();

        // создаём объекты Person и Movie;
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

        movieMap.put(movie1.getId(), movie1);
        movieMap.put(movie2.getId(), movie2);
        movieMap.put(movie3.getId(), movie3);
        movieMap.put(movie4.getId(), movie4);
        movieMap.put(movie5.getId(), movie5);
        movieMap.put(movie6.getId(), movie6);
        movieMap.put(movie7.getId(), movie7);
        movieMap.put(movie8.getId(), movie8);

        // для наглядности выводим HashMap на печать
        System.out.println("Коллекция фильмов:\n " + movieMap);

        movieController.setMovieMap(movieMap);// Дарья

        // сортировка HashMap по ключу
        List<Movie> listValues = new ArrayList<>(movieMap.values());
        Collections.sort(listValues);
        // для наглядности выводим отсортированный список на печать
        System.out.println("Коллекция отсортирована:\n " + listValues + "\n ");

        //начало работы с пользовательским вводом
        Scanner scanner = new Scanner(System.in);
        String usersLine;// строка ввода пользователя

        System.out.println("Вас приветствует MovieCollection!\n");

        do {
            this.startIntro();// выводим приветствие и набор команд. ожидаем ввод пользователя
            usersLine = scanner.nextLine();// считывание ввода пользователя
            String[] lineInParts = null;//вводим переменные для последующей обработки строк с пробелами
            String argIn = null;

            if (usersLine.contains(" ")) { //если строка с командой пользователя содержит пробел,
                lineInParts = usersLine.split(" ");//делим строку на части до и после пробела с помощью метода split.
                // Метод возвращает String[]
                // 1я часть - команда, 2я - аргумент
            }

            if (lineInParts != null && lineInParts.length == 2) {
                usersLine = lineInParts[0];// 1я часть - команда
                argIn = lineInParts[1];// 2я часть - аргумент (например, id)
            }

            switch (usersLine) {
                case "exit":
                    this.startExitCommand();
                    break;

                case "help":
                    this.startHelpCommand();
                    break;

                case "info":
                    this.startInfoCommand();
                    break;

                case "show":
                    this.startShowCommand();
                    break;

                case "insert":
                    this.startInsertCommand();
                    break;

                case "update":
                    movieController.startUpdateCommand(argIn);
                    break;

                case "remove_key":
                    movieController.startRemoveKeyCommand(argIn);
                    break;

                case "clear":
                    movieController.startClearCommand();
                    break;

                case "remove_greater":
                   this.startRemoveGreaterCommand(argIn);
                    break;

                case "remove_lower":
                    this.startRemoveLowerCommand(argIn);
                    break;

                case "count_less_than_genre":
                    this.startCountLessThanGenreView(argIn);
                    break;

                default:
                    System.out.println("Вы ввели неверную команду. Попробуйте ещё раз: ");
            }

        } while (true);
    }

    public void startShowCommand() {
        System.out.println("Все элементы:");
        Collection<Movie> movies = movieController.handleShowCommand();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void startRemoveGreaterCommand(String argIn) { // Дарья

        if (!Utils.isLong(argIn)) {
            System.out.println("Указанно некорректное значение");
            return;
        }
        Long idIn = Long.valueOf(argIn);
        movieController.startRemoveGreaterCommand(idIn);
        System.out.println("Элементы, id которых больше " + idIn + "удалены из списка" );
    }

    public void startRemoveLowerCommand(String argIn) { // Дарья
        if (!Utils.isLong(argIn)) {
            System.out.println("Указанно некорректное значение");
            return;
        }
        Long idIn = Long.valueOf(argIn);
        movieController.startRemoveLowerCommand(idIn);
        System.out.println("Элементы, id которых меньше " + idIn + "удалены из списка" );
    }


    void startCountLessThanGenreView(String argIn) {
        //1. Ввод и проверка данных
        if (!Utils.isEnum(argIn, MovieGenre.class)) {
            System.out.println("Указанно некорректное значение");
            return;
        }

        MovieGenre targetGenre = MovieGenre.valueOf(argIn);

        //2. Вызов контроллера
        int counter = movieController.startCountLessThanGenreCommand(targetGenre);

        //3. Вывод результата
        System.out.println("Количество элементов: " + counter);
    }

    public void startIntro() { //начальное сообщение с приглашением к выбору команды
        System.out.println(
                "Выберите команду из списка. Для получения справки по доступным командам выберите help.\n\n" +
                        "help\n" +
                        "info\n" +
                        "show\n" +
                        "insert\n" +
                        "update {id}\n" +
                        "remove_key {id}\n" +
                        "clear\n" +
                        "exit\n" +
                        "remove_greater {fieldValue}\n" +
                        "remove_lower {fieldValue}\n" +
                        "count_less_than_genre {genre}\n ");
        System.out.print("Введите выбранную команду: ");
    }

    // Составные части команды Insert
    // 1. подполя для получения названия фильма
    private String addMovieName() {
        String movieName;
        do {
            System.out.println("Задайте название фильма: ");
            movieName = scanner.nextLine();
            if (movieName.isEmpty()) {
                System.out.println("Строка не может быть пустой");
            } else {
                return movieName;
            }
        } while (true);
    }
    // 2. подполя для получения жанра фильма
    private MovieGenre addMovieGenre() {
        String lineIn;
        do {
            System.out.println("Задайте жанр: ");
            System.out.println(Arrays.toString(MovieGenre.values()));
            lineIn = scanner.nextLine().toUpperCase();
            switch (lineIn) {
                case "ACTION":
                    return MovieGenre.ACTION;
                case "ADVENTURE":
                    return MovieGenre.ADVENTURE;
                case "TRAGEDY":
                    return MovieGenre.TRAGEDY;
                case "HORROR":
                    return MovieGenre.HORROR;
                case "FANTASY":
                    return MovieGenre.FANTASY;
                default:
                    System.out.println("Неверно задан жанр");
            }
        } while (true);

    }

    // 3. подполя для получения имени Person
    private String addPersonName() {
        String personName;
        do {
            System.out.println("Задайте имя сценариста: ");
            personName = scanner.nextLine();
            if (personName.isEmpty()) {
                System.out.println("Строка не может быть пустой.");
            } else {
                return personName;
            }
        } while (true);
    }

    // 4. подполя для получения пола Person
    private boolean addPersonGender() {
        String lineIn;
        do {
            System.out.println("Сценарист мужчина? [yes/no]");
            lineIn = scanner.nextLine().toLowerCase();
            if (lineIn.equals("yes")) {
                return true;
            } else if (lineIn.equals("no")) {
                return false;
            } else {
                System.out.println("строка не может быть пустой.");
            }
        } while (true);
    }

    //добавление фильма с построковым заданием полей
    public void startInsertCommand() { // ПРОВЕРИТЬ!
        System.out.println("Добавить фильм");
        movieController.handleInsertCommand(addPersonName(), addPersonGender(), addMovieName(), addMovieGenre());
        System.out.println("Фильм добавлен в коллекцию");
    }

    public void startSaveCommand() {
        System.out.println("Сохраняем элементы...");
        this.movieController.handleSaveCommand();
    }

    public void startInfoCommand() {//Екатерина
        System.out.println("Коллекция содержит: " + movieController.handleInfoCommand() + " элементов\n");
    }

    public void startHelpCommand() {//Екатерина
        System.out.println(
                "info : вывести информацию о коллекции\n" +
                        "show : вывести все элементы коллекции\n" +
                        "insert: добавить новый элемент \n" +
                        "update {id} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove_key {id} : удалить элемент из коллекции по его ключу\n" +
                        "clear : очистить коллекцию\n" +
                        "exit : завершить программу (без сохранения в файл)\n" +
                        "remove_greater {fieldValue} : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                        "remove_lower {fieldValue} : удалить из коллекции все элементы, ключ которых меньше, чем заданный\n" +
                        "count_less_than_genre {genre}: вывести количество элементов, значение поля genre которых меньше заданного\n");
    }

    public void startExitCommand() { // Татьяна
        System.out.println("Программа завершена. До свидания!");
        System.exit(0);
    }


}
