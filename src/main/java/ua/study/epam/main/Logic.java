package ua.study.epam.main;

import ua.study.epam.dbService.daoFactory.DAOFactory;
import ua.study.epam.dbService.equipmentDAO.EquipmentDAO;
import ua.study.epam.dbService.equipmentDTO.EquipmentDTO;
import ua.study.epam.dbService.knightDAO.KnightDAO;
import ua.study.epam.dbService.knightDTO.KnightDTO;
import ua.study.epam.forge.*;
import ua.study.epam.knight.Knight;
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
        //сделать проверку, есть ли уже такой герой
        System.out.println("Please enter unique knight`s name");
        String name = scanner.nextLine();
        Knight knight = new Knight(Gender.MALE, name, 20);
        System.out.println("knight " + name + " created!");

        forge.createFullKnightEquipment(knight);
        System.out.println("knight`s equipment: ");
        System.out.println(knight.getEquipment());

        System.out.println("total price of knight`s equipment - " + knight.countEquipmentPrice());
        knight.sortEquipmentByWeight();
        System.out.println("sort equipment by weight: ");
        System.out.println(knight.getEquipment());

        System.out.println("For searching equipment within specified price range, please enter min price: ");
        int minPrice = scanner.nextInt();
        System.out.println("Now enter max price: ");
        int maxPrice = scanner.nextInt();
        System.out.println("knight`s equipment in entered price range (" + minPrice + ", " + maxPrice + "): ");
        System.out.println(knight.getEquipmentByPrice(minPrice,maxPrice));

        factory.getKnightDAO().insertIntoTableKnights(knight);
        factory.getEquipmentDAO().insertIntoTableEquipment(knight);

        /*KnightDAO knightDAO = factory.getKnightDAO();
        //loading your knight from date base
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
