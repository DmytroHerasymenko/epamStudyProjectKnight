package ua.study.epam.knight;

import ua.study.epam.knight.gender.Gender;

/**
 * Created by dima on 11.02.17.
 */
public abstract class Human {
    private final Gender gender;
    private String name;
    private int age;

    public Human(Gender gender, String name, int age) {
        this.gender = gender;
        this.name = name;
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
