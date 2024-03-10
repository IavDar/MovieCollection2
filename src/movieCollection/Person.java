package movieCollection;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private boolean isMan; //Поле не может быть null

    public Person(String name, boolean isMan) {
        this.name = name;
        this.isMan = isMan;
    }
    // @Tatjana геттеры-сеттеры сгенерированы автоматически, по ходу может понадобиться сделать проверки на null и пр.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean IsMan() {
        return isMan;
    }

    public void setMan(boolean isMan) {
        this.isMan = isMan;
    }


}
