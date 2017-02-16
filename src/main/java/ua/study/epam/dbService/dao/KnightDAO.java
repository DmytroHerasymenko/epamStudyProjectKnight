package ua.study.epam.dbService.dao;

import ua.study.epam.dbService.knightDTO.KnightDTO;
import ua.study.epam.knight.Knight;

import java.sql.SQLException;

/**
 * Created by dima on 13.02.17.
 */
public interface KnightDAO {
    void createKnightsTable() throws SQLException;
    void insertIntoTableKnights(Knight knight) throws SQLException;
    KnightDTO getKnightByName(String name) throws SQLException;
}
