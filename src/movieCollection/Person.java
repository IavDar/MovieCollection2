package movieCollection;

import java.util.Objects;

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

    // @Tatjana геттеры-сеттеры сгенерированы автоматически, по ходу может понадобиться сделать проверки на null и пр.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name.equals(null)) {
            System.out.println("Поле не может быть пустым");
        } else {
            this.name = name;
        }
    }

    public boolean IsMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return isMan == person.isMan && Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isMan);
    }
}
