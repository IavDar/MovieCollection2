package movieCollection;



import java.util.*;


public class Manager {
    Scanner scanner;
    private Map<Long, Movie> movieMap;



    public void setMovieMap(Map<Long, Movie> movieMap) { //нам точно нужен сеттер?
        this.movieMap = movieMap;
    }

    public Manager() {
        scanner = new Scanner(System.in);
        movieMap = new HashMap<>();
    }

    public void addMovie(Movie movie){ // метод для добавления фильмов в HashMap
        movieMap.put(movie.getId(), movie);
    }

    Person person1 = new Person("Инна Веткина", false);
    Person person2 = new Person("Евгений Велтистов", true);
    Movie movie1 = new Movie("Приключения Буратино", MovieGenre.ACTION , person1);
    Movie movie2 = new Movie("Приключения Электроника", MovieGenre.ADVENTURE , person2);


    public void startIntro() { //начальное сообщение с приглашением к выбору команды
        // (вроде работает, текст можно править) @Tatjana
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

    public void startHelpCommand() {// Help //Екатерина
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
        System.out.print("Введите выбранную команду: ");
    }

    public void startInfoCommand() {
        //Екатерина (про дату инициализации Карлен сказал, можно не делать, объяснение про метод в видео с 32 минуты)
         System.out.println("Информация о Коллекци: " + this.movieMap.size());
    }

    public void startShowCommand() {
        //Екатерина
      System.out.println("Все элементы:");
        for (Movie movie: this.movieMap.values()){
            System.out.println(movie);
        }

    public void startInsertCommand() {
        //Екатерина

        System.out.println("insert");
    }

    public void startUpdateCommand(String argIn) {
        //Татьяна
        System.out.println("update");
    }

    public void startRemoveKeyCommand(String argIn) {//Татьяна

        System.out.println("remove");
    }

    public void startClearCommand() {//Татьяна

        do {
            System.out.print("Вы действительно хотите удалить все элементы из списка? [yes/no] : ");
            scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                Map<Long, Movie> movieMap1 = movieMap;// пока сделала на всякий случай с копией
                movieMap1.clear();
                System.out.println("Список очищен");
                break;

            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Команда отменена");
                break;

            } else {
                System.out.println("Вы ввели неверное значение. Попробуйте ещё раз. ");
                continue;
            }

        } while (true);// ??? условие цикла

    }

    public void startExitCommand() {
        //Татьяна
        System.out.println("Программа завершена. До свидания!");
    }

    public void startRemoveGreaterCommand(String argIn) {
        //Дарья

        if (!Utils.isLong(argIn)) {
            System.out.println("Указанно некорректное значение");
            return;
        }

        Long idIn = Long.valueOf(argIn);
        Set<Long> set = new HashSet<>();

        for (Long idMap : movieMap.keySet()) {
            if (idMap > idIn){
                set.add(idMap);
            }
        }

        for (Long id : set) {

            System.out.println("Удалили " + " " + movieMap.get(id));

            movieMap.remove(id);
        }
    }

    public void startRemoveLowerCommand(String argIn) {
        //Дарья

        if (!Utils.isLong(argIn)) {
            System.out.println("Указанно некорректное значение");
            return;
        }

        Long idIn = Long.valueOf(argIn);
        Set<Long> set = new HashSet<>();

        for (Long idMap : movieMap.keySet()) {
            if (idMap < idIn){
                set.add(idMap);
            }
        }

        for (Long id : set) {

            System.out.println("Удалили " + " " + movieMap.get(id));

            movieMap.remove(id);
        }

    }

    public void startCountLessThanGenreCommand(String argIn) {
        //Дарья

        if (!Utils.isEnum(argIn, MovieGenre.class)) {
            System.out.println("Указанно некорректное значение");
            return;
        }

        MovieGenre targetGenre = MovieGenre.valueOf(argIn);

        int counter = 0;
        for (Movie movie : movieMap.values()) {


            if (movie.getGenre().ordinal() < targetGenre.ordinal()) {
                counter = counter +1;
            }
        }


        System.out.println("Количество элементов: " + counter);
    }

}



