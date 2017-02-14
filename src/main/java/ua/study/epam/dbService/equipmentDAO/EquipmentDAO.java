package ua.study.epam.dbService.equipmentDAO;

import ua.study.epam.dbService.equipmentDTO.EquipmentDTO;
import ua.study.epam.knight.Knight;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dima on 14.02.17.
 */
public interface EquipmentDAO {
    void createEquipmentTable() throws SQLException;
    void insertIntoTableEquipment(Knight knight) throws SQLException;
    List<EquipmentDTO> getEquipmentByOwner(String owner) throws SQLException;

}
