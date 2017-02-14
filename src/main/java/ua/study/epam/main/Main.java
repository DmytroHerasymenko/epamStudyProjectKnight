package ua.study.epam.main;

import java.sql.SQLException;

/**
 * Created by dima on 11.02.17.
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Logic logic = new Logic();
        logic.execute();
    }
}
