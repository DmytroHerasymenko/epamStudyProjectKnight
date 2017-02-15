package ua.study.epam.main;

import ua.study.epam.dbService.daoFactory.DAOFactory;
import ua.study.epam.dbService.equipmentDAO.EquipmentDAO;
import ua.study.epam.dbService.equipmentDTO.EquipmentDTO;
import ua.study.epam.dbService.knightDAO.KnightDAO;
import ua.study.epam.dbService.knightDTO.KnightDTO;
import ua.study.epam.forge.*;
import ua.study.epam.knight.Knight;
import ua.study.epam.knight.barracks.Barracks;
import ua.study.epam.knight.barracks.BarracksImpl;
import ua.study.epam.knight.gender.Gender;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dima on 12.02.17.
 */
public class Logic {
    public void execute() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        DAOFactory factory = DAOFactory.getInstance();
        factory.getKnightDAO().createKnightsTable();
        factory.getEquipmentDAO().createEquipmentTable();

        Forge forge = ForgeImpl.instance();
        Barracks barracks = BarracksImpl.instance();

        Knight knight = barracks.createKnight(Gender.MALE);

        forge.createFullKnightEquipment(knight);

        knight.countEquipmentPrice();
        knight.sortEquipmentByWeight();
        knight.getEquipmentByPrice();

        factory.getKnightDAO().insertIntoTableKnights(knight);
        factory.getEquipmentDAO().insertIntoTableEquipment(knight);

        /*KnightDAO knightDAO = factory.getKnightDAO();
        //loading your kninothingght from date base
        KnightDTO knightDTO = knightDAO.getKnightByName("Dmytro");
        Knight knight1 = knightDTO.loadKnightFromDB();

        EquipmentDAO equipmentDAO = factory.getEquipmentDAO();
        List<EquipmentDTO> equipmentDTOList = equipmentDAO.getEquipmentByOwner(knight1.getName());
        for(EquipmentDTO equipmentDTO : equipmentDTOList){
            knight1.getEquipment().add(equipmentDTO.loadEquipmentFromDB());
        }*/
    }

    /*//create number of knights:
    Knight arthur;
        for(int i = 0; i < n; i++){
        arthur = new Knight(Gender.MALE, "Arthur" + i+1, 26);
        forge.createFullKnightEquipment(arthur);
        knight.sortEquipmentByWeight();
        factory.getKnightDAO().insertIntoTableKnights(arthur);
        factory.getEquipmentDAO().insertIntoTableEquipment(arthur);
    }*/

}
