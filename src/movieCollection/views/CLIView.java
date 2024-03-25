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


        scanner = new Scanner(System.in);
//        //коллекция фильмов в виде HashMap (ключ - id, значение - объекты класса Movie)
//        HashMap<Long, Movie> movieMap = new HashMap<>();
//
//
//        // создаём объекты Person и Movie;
//        Movie[] initMovies = {
//        new Movie("Приключения Буратино", MovieGenre.ACTION, new Person("Инна Веткина", false)),
//        new Movie("Приключения Электроника", MovieGenre.ADVENTURE, new Person("Евгений Велтистов", true) ),
//        new Movie("Люси", MovieGenre.ACTION, new Person("Люк Бессон", true)),
//        new Movie("Gone Girl", MovieGenre.TRAGEDY, new Person("David Fincher", true)),
//        new Movie("Dahmer-Monster", MovieGenre.HORROR, new Person("Ryan Murphy", true)),
//        new Movie("Gegen die Wand", MovieGenre.TRAGEDY, new Person("Fatih Akin", true)),
//        new Movie("Die Insel der besonderen Kinder", MovieGenre.FANTASY, new Person("Tim Burton", true)),
//        new Movie("По щучъему велению.", MovieGenre.FANTASY, new Person("Александр Войтинский", true))
//        };
//        for(Movie movie : initMovies){
//            movieController.addMovie(movie);
//        }
//
//        // для наглядности выводим HashMap на печать
//        System.out.println("Коллекция фильмов:\n " + movieMap);
//
//        // сортировка HashMap по ключу
//        List<Movie> listValues = new ArrayList<>(movieMap.values());
//        Collections.sort(listValues);
//        // для наглядности выводим отсортированный список на печать
//        System.out.println("Коллекция отсортирована:\n " + listValues + "\n ");
//
//        this.loadTestData(); // временный метод для тестирования (замена movieController.setMovieMap())
//
        //начало работы с пользовательским вводом
        Scanner scanner = new Scanner(System.in);
        String usersLine;// строка ввода пользователя

        System.out.println("Вас приветствует MovieCollection!");

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

                case "save":
                    this.startSaveCommand();
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
                    this.startUpdateCommand(argIn);
                    break;

                case "remove_key":
                    this.startRemoveKeyCommand(argIn);
                    break;

                case "clear":
                    this.startClearCommand();
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
        List<Movie> movies = movieController.handleShowCommand();
        if (movies.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Все элементы:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }

    }

    public void startRemoveGreaterCommand(String argIn) { // Дарья

        if (!Utils.isLong(argIn)) {
            System.out.println("Указано некорректное значение");
            return;
        }
        Long idIn = Long.valueOf(argIn);
        movieController.handleRemoveGreaterCommand(idIn);
        System.out.println("Элементы, id которых больше " + idIn + " удалены из списка" );
    }

    public void startRemoveLowerCommand(String argIn) { // Дарья
        if (!Utils.isLong(argIn)) {
            System.out.println("Указано некорректное значение");
            return;
        }
        Long idIn = Long.valueOf(argIn);
        movieController.handleRemoveLowerCommand(idIn);
        System.out.println("Элементы, id которых меньше " + idIn + " удалены из списка" );
    }


    void startCountLessThanGenreView(String argIn) {
        //1. Ввод и проверка данных
        if (!Utils.isEnum(argIn, MovieGenre.class)) {
            System.out.println("Указано некорректное значение");
            return;
        }

        MovieGenre targetGenre = MovieGenre.valueOf(argIn);

        //2. Вызов контроллера
        int counter = movieController.handleCountLessThanGenreCommand(targetGenre);

        //3. Вывод результата
        System.out.println("Количество элементов: " + counter);
    }

    public void startIntro() { //начальное сообщение с приглашением к выбору команды
        System.out.println(
                "======================================================================================\n" +
                "Выберите команду из списка. Для получения справки по доступным командам выберите help.\n" +
                        "help\n" +
                        "save\n" +
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
            // применяем метод валидации из Movie
            if (!Movie.validateMovieName(movieName)) {
                System.out.println("Строка не может быть пустой");
                continue;
            }
            return movieName;
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
            // валидация с помощью метода из Person
            if (!Person.validatePersonName(personName)) {
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
    public void startInsertCommand() {
        System.out.println("Добавить фильм");
        String personName = addPersonName();
        boolean gender = addPersonGender();
        String movieName = addMovieName();
        MovieGenre genre = addMovieGenre();
        movieController.handleInsertCommand(personName, gender, movieName, genre);
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
                        "save : сохранить коллекцию в файл\n" +
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

    public void startRemoveKeyCommand(String argIn) { // Татьяна

        if (!Utils.isLong(argIn) || argIn == null) {
            System.out.println("Некорректный аргумент");
            return;
        }
        long idValue = Long.parseLong(argIn); // преобразование String в long
        if (movieController.handleRemoveKeyCommand(idValue)) {
            System.out.println("Элемент с id " + idValue + " успешно удалён");
        } else
            System.out.println("Такого элемента нет в списке");
    }

    public void startUpdateCommand(String argIn) { // Акмур
        if (!Utils.isInt(argIn) || argIn == null) {
            System.out.println("Неверное значение id");
            return;
        }
        long idValue = Long.parseLong(argIn);


        UPPER:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Доступные поля для изменения:");
            for (MutableField field : MutableField.values()) {
                System.out.println(field);
            }

            System.out.print("Введите ответ: ");
            String answer = scanner.nextLine();

            if (!Utils.isEnum(answer, MutableField.class)) {
                System.out.println("Указано некорректное поле для изменения");
                continue;
            }
            MutableField answerValue = MutableField.valueOf(answer);
            if (answer.equalsIgnoreCase("GENRE")) {
                System.out.println("Возможные значения для поля GENRE: " + Arrays.toString(MovieGenre.values()));
            }
            System.out.print("Введите новое значение: ");
            String newValue = scanner.nextLine();
            System.out.println(newValue);




            switch (answerValue) {
                case MOVIENAME:
                    if (!Movie.validateMovieName(newValue)) {
                        System.out.println("Указанно некорректное новое значение");
                        continue;
                    }
                    movieController.handleUpdateCommand(idValue, answerValue, newValue);
                    break;

                case GENRE:
                    if (!Utils.isEnum(newValue, MovieGenre.class)) {
                        System.out.println("Указанно некорректное новое значение");
                        continue;
                    }
                    movieController.handleUpdateCommand(idValue, answerValue, newValue);
                    break;
                case SCREENWRITERNAME:
                    if (newValue.isEmpty()) {
                        System.out.println("Указанно некорректное новое значение");
                        continue;
                    }
                    movieController.handleUpdateCommand(idValue, answerValue, newValue);
                    break;
                default:
                    System.out.println("Неподдерживаемое поле");
            }

            System.out.println("Вы обновили фильм :"+"Movie " +idValue+" "+answerValue+" "+newValue) ;
        break; }
    }

    public void startClearCommand () {
        // Татьяна
        do {
            System.out.print("Вы действительно хотите удалить все элементы из списка? [yes/no] : ");
            scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                movieController.handleClearCommand();
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

}
