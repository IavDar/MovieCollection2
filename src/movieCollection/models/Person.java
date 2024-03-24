package movieCollection.models;

import java.util.Objects;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private boolean isMan;
    public Person(String name, boolean isMan) { // конструктор
        this.setName(name);
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

     public boolean getGender() {
        return isMan;
    }

    public void setName(String name) {
        if(!Person.validatePersonName(name)){
            throw new RuntimeException("Некорректное значение");
        }
        this.name = name;
    }

    public void setGender(boolean man) {
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

    // валидация personName (проверка на пограничные значения из задания)
    // Поле не может быть null, Строка не может быть пустой
    // Татьяна
    public static boolean validatePersonName(String name){
        if (name == null){ // Поле не может быть null
            return false;
        }
        if (name.isEmpty()){ // Строка не может быть пустой
            return false;
        }
        return true;
    }


}
