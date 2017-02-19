package ua.study.epam.main;

import java.sql.SQLException;

/**
 * Created by dima on 11.02.17.
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        View view = new View();
        view.execute();
    }
}

