## MovieCollection

Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса Movie, описание которого приведено ниже.

### Разработанная программа должна удовлетворять следующим требованиям:

* Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
* Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
* Для хранения необходимо использовать коллекцию типа java.util.HashMap
* Все классы в программе должны быть задокументированы в формате javadoc (если успеваете).
* Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, и т.п.).
* При запуске приложения коллекция должна автоматически заполняться старыми объектами из файла.
* Название файла должно браться из аргументов командной строки
*  Данные должны храниться в файле в формате csv
*  Чтение данных из файла необходимо реализовать с помощью класса java.io.FileReader + BufferedReader
*  Запись данных в файл необходимо реализовать с помощью класса java.io.FileWriter
*  Должно быть хотя бы минимальное тестовое покрытие
*  Программа должна соответствовать MVC

### В интерактивном режиме программа должна поддерживать выполнение следующих команд:
help : вывести справку по доступным командам

save : сохранить коллекцию в файл

info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)

show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении

insert: добавить новый элемент

update {id} : обновить значение элемента коллекции, id которого равен заданному

remove_key {id} : удалить элемент из коллекции по его ключу

clear : очистить коллекцию

exit : завершить программу (без сохранения в файл)

remove_greater {fieldValue} : удалить из коллекции все элементы, ключ которых превышает заданный  (сравнивать методом compareTo, по какому полю/полям сравнивать - решать вам)

remove_lower {fieldValue} : удалить из коллекции все элементы, ключ которых меньше, чем заданный  (сравнивать методом compareTo, по какому полю/полям сравнивать - решать вам)

count_less_than_genre {genre}: вывести количество элементов, значение поля genre которых меньше заданного

### Формат ввода команд:
* Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.
* Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
* При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
* Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
* При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.
* Для ввода значений null использовать пустую строку.
* Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.

## Описание хранимых в коллекции классов:
public class Movie {

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным,
    // Значение этого поля должно генерироваться автоматически
    
    private String name; //Поле не может быть null, Строка не может быть пустой
    
    private MovieGenre genre; //Поле может быть null
    
    private Person screenwriter;
    
}

public class Person {

    private String name; //Поле не может быть null, Строка не может быть пустой
    
    private boolean isMan; //Поле не может быть null
    
}

public enum MovieGenre {

    ACTION,
    ADVENTURE,
    TRAGEDY,
    HORROR,
    FANTASY;
    
   }




