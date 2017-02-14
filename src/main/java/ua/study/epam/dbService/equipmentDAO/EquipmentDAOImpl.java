package ua.study.epam.dbService.equipmentDAO;

import ua.study.epam.dbService.daoFactory.DAOFactory;
import ua.study.epam.dbService.equipmentDTO.EquipmentDTO;
import ua.study.epam.dbService.executor.Executor;
import ua.study.epam.equipment.Equipment;
import ua.study.epam.equipment.defenceEquipment.DefenceEquipment;
import ua.study.epam.equipment.defenceEquipment.Shield;
import ua.study.epam.equipment.weapon.Weapon;
import ua.study.epam.knight.Knight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 14.02.17.
 */
public class EquipmentDAOImpl implements EquipmentDAO {
    private Executor executor;
    public EquipmentDAOImpl(Connection connection){
        this.executor = new Executor(connection);
    }

    public void createEquipmentTable() throws SQLException {

        String createTableSQL = "CREATE TABLE IF NOT EXISTS equipment("
                + "type VARCHAR (20) NOT NULL, "
                + "material VARCHAR (10) NOT NULL, "
                + "name VARCHAR (20) NOT NULL, "
                + "weight INTEGER NOT NULL, "
                + "price INTEGER NOT NULL, "
                + "damage INTEGER, "
                + "damageRange INTEGER, "
                + "defence INTEGER, "
                + "block INTEGER, "
                + "owner VARCHAR (20) REFERENCES knights(name) NOT NULL,"
                + "PRIMARY KEY (name) " + ")";

        executor.executorUpdate(createTableSQL);
        System.out.println("Table \"equipment\" is created!");
    }

    public void insertIntoTableEquipment(Knight knight) throws SQLException {

        String insertTableSQL = "INSERT INTO equipment (type, material, name, weight, price, damage, damageRange, defence, block, owner)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?)";

        for (Equipment equipment : knight.getEquipment()) {
            try (PreparedStatement preparedStatement = DAOFactory.getInstance().connection.prepareStatement(insertTableSQL)) {
                preparedStatement.setString(1, String.valueOf(equipment.getClass().getSimpleName()));
                preparedStatement.setString(2, String.valueOf(equipment.getMaterial()));
                preparedStatement.setString(3, equipment.getName());
                preparedStatement.setInt(4, equipment.getWeight());
                preparedStatement.setInt(5, equipment.getPrice());
                if (equipment instanceof Weapon) {
                    preparedStatement.setInt(6, ((Weapon) equipment).getDamage());
                    preparedStatement.setInt(7, ((Weapon) equipment).getDamageRange());
                } else {
                    preparedStatement.setInt(6, 0);
                    preparedStatement.setInt(7, 0);
                }
                if (equipment instanceof DefenceEquipment) {
                    preparedStatement.setInt(8, ((DefenceEquipment) equipment).getDefence());
                } else {
                    preparedStatement.setInt(8, 0);
                }
                if (equipment instanceof Shield) {
                    preparedStatement.setInt(9, ((Shield) equipment).getBlock());
                } else {
                    preparedStatement.setInt(9, 0);
                }
                preparedStatement.setString(10, knight.getName());
                preparedStatement.execute();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<EquipmentDTO> getEquipmentByOwner(String owner) throws SQLException{
        return executor.executorQuery("SELECT * FROM equipment WHERE owner='" + owner + "'", result -> {
            ArrayList<EquipmentDTO> equipmentDTOS = new ArrayList<>();
            while(result.next()) {
                equipmentDTOS.add(new EquipmentDTO(result.getString(1), result.getString(2),
                        result.getString(3), result.getInt(4), result.getInt(5),
                        result.getInt(6), result.getInt(7), result.getInt(8), result.getInt(9)));
            }
            return equipmentDTOS;
        });
    }
}
