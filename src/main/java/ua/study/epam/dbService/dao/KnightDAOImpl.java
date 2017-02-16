package ua.study.epam.dbService.dao;

import ua.study.epam.dbService.knightDTO.KnightDTO;
import ua.study.epam.dbService.executor.Executor;
import ua.study.epam.knight.Knight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by dima on 12.02.17.
 */
public class KnightDAOImpl implements KnightDAO {
    private Executor executor;
    public KnightDAOImpl(Connection connection){
        this.executor = new Executor(connection);
    }

    public void createKnightsTable() throws SQLException {

        String createTableSQL = "CREATE TABLE IF NOT EXISTS knights("
                + "gender VARCHAR (10) NOT NULL, "
                + "name VARCHAR (50) NOT NULL, "
                + "age INTEGER NOT NULL, "
                + "rank VARCHAR (10) NOT NULL, "
                + "money INTEGER NOT NULL, "
                + "defence INTEGER NOT NULL, "
                + "damage INTEGER NOT NULL, "
                + "PRIMARY KEY (name) " + ")";

        executor.executorUpdate(createTableSQL);
    }

    public void insertIntoTableKnights(Knight knight) throws SQLException {

        String insertTableSQL = "INSERT INTO knights (gender, name, age, rank, money, defence, damage)" +
                " VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = DAOFactory.getInstance().connection.prepareStatement(insertTableSQL)) {
            preparedStatement.setString(1, String.valueOf(knight.getGender()));
            preparedStatement.setString(2, knight.getName());
            preparedStatement.setInt(3, knight.getAge());
            preparedStatement.setString(4, String.valueOf(knight.getRank()));
            preparedStatement.setInt(5, knight.getMoney());
            preparedStatement.setInt(6, knight.getDefence());
            preparedStatement.setInt(7, knight.getDamage());
            preparedStatement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("knight " + knight.getName() + " saved!");
    }

    public KnightDTO getKnightByName(String name) throws SQLException{
        return executor.executorQuery("SELECT * FROM knights WHERE name='" + name + "'", result -> {
            if(!(result.next())) return null;
            else{
            return new KnightDTO(result.getString(1), result.getString(2), result.getInt(3),
                    result.getString(4), result.getInt(5),
                    result.getInt(6), result.getInt(7));
            }
        });
    }
}
