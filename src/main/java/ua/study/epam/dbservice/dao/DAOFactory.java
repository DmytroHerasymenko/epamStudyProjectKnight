package ua.study.epam.dbservice.dao;

import java.sql.*;

/**
 * Created by dima on 12.02.17.
 */
public class DAOFactory {
    private final Connection connection;
    private  static DAOFactory instance;
    private KnightDAO knightDAO;
    private EquipmentDAO equipmentDAO;

    private DAOFactory(Connection connection){
        this.connection = connection;
    }

    public static DAOFactory getInstance() throws ClassNotFoundException, SQLException {

        if (instance == null){
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://127.0.0.1/epam_project_knight";
            Connection connection = DriverManager.getConnection(url, "postgres", "1");
            instance = new DAOFactory(connection);
        }
        return instance;
    }

    public KnightDAO getKnightDAO(){
        if(knightDAO == null){
            knightDAO = new KnightDAOImpl(connection);
        }
        return knightDAO;
    }

    public EquipmentDAO getEquipmentDAO(){
        if(equipmentDAO == null) {
            equipmentDAO = new EquipmentDAOImpl(this.connection);
        }
        return equipmentDAO;
    }

    public Connection getConnection() {
        return connection;
    }
}
