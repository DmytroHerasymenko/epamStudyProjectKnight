package ua.study.epam.dbservice.dto;

import ua.study.epam.knight.Knight;
import ua.study.epam.knight.gender.Gender;
import ua.study.epam.knight.rank.Rank;

/**
 * Created by dima on 12.02.17.
 */
public class KnightDTO {
    private String gender;
    private String name;
    private int age;
    private String rank;
    private int money;
    private int defence;
    private int damage;

    public KnightDTO(String gender, String name, int age, String rank, int money, int defence, int damage) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.rank = rank;
        this.money = money;
        this.defence = defence;
        this.damage = damage;
    }

    public Knight loadKnightFromDB(){
        if(this == null) return null;
        else {
            Knight knight = new Knight(Gender.valueOf(this.getGender()), this.getName(), this.getAge());
            knight.setRank(Rank.valueOf(this.getRank()));
            knight.setMoney(this.getMoney());
            knight.setDefence(this.getDefence());
            knight.setDamage(this.getDamage());
            return knight;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
