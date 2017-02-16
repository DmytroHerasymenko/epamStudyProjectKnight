package ua.study.epam.main;

import ua.study.epam.dbService.dao.DAOFactory;
import ua.study.epam.forge.*;
import ua.study.epam.knight.Knight;
import ua.study.epam.knight.barracks.Barracks;
import ua.study.epam.knight.barracks.BarracksImpl;
import ua.study.epam.knight.gender.Gender;

import java.sql.SQLException;

/**
 * Created by dima on 12.02.17.
 */
public class Logic {
    public void execute() throws SQLException, ClassNotFoundException {

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
        //loading your knight from date base
        KnightDTO knightDTO = knightDAO.getKnightByName("Dmytro");
        if(knightDTO == null){
        System.out.println("knight Dmytro was not found in the database.");
        } else{
        Knight knight1 = knightDTO.loadKnightFromDB();
        }

        EquipmentDAO equipmentDAO = factory.getEquipmentDAO();
        List<EquipmentDTO> equipmentDTOList = equipmentDAO.getEquipmentByOwner(knight1.getName());
        if(equipmentDTOList == null){
        System.out.println("equipment was not found in the database.");
        } else{
        for(EquipmentDTO equipmentDTO : equipmentDTOList){
            knight1.getEquipment().add(equipmentDTO.loadEquipmentFromDB());
            }
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
