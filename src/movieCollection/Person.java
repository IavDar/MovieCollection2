package movieCollection;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private boolean isMan; //Поле не может быть null

    public Person(String name, boolean isMan) {
        this.name = name;
        this.isMan = isMan;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isMan=" + isMan +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

}
