package ua.study.epam.knight.barracks;

import ua.study.epam.knight.Knight;
import ua.study.epam.knight.gender.Gender;

import java.util.Random;

/**
 * Created by dima on 14.02.17.
 */
public class BarracksImpl implements Barracks {
    private Random random = new Random();

    private static Barracks barracksImpl;
    private BarracksImpl(){
    }
    public static Barracks instance(){
        if (barracksImpl == null){
            barracksImpl = new BarracksImpl();
        }
        return barracksImpl;
    }
    @Override
    public Knight createKnight(Gender gender, String name) {

        int age = random.nextInt(20) + 20;

        if(age < 20 || age > 40) throw new IllegalArgumentException();

        return new Knight(gender, name, age);
    }
}
