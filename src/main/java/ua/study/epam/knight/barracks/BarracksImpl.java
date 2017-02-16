package ua.study.epam.knight.barracks;

import ua.study.epam.dbService.dao.DAOFactory;
import ua.study.epam.knight.Knight;
import ua.study.epam.knight.gender.Gender;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by dima on 14.02.17.
 */
public class BarracksImpl implements Barracks {
    private Scanner scanner = new Scanner(System.in);
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

    public Knight createKnight(Gender gender) throws SQLException, ClassNotFoundException {
        System.out.println("Please enter unique knight name: ");
        while(!scanner.hasNext()){
            System.out.println("Please enter unique knight name: ");
            scanner.nextLine();
        }
        String name = scanner.nextLine();
        if(!(DAOFactory.getInstance().getKnightDAO().getKnightByName(name) == null)){
            System.out.println("knight " + name + " already exists. Try one more time: ");
            name = scanner.nextLine();
        }
        if(name == null) name = "anonymous";

        int age = random.nextInt(20) + 20;
        Knight knight = new Knight(gender, name, age);
        System.out.println("knight " + knight.getName() + " created!");
        return knight;
    }
}
