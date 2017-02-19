package ua.study.epam.main;

import ua.study.epam.dbservice.dao.*;
import ua.study.epam.dbservice.dto.*;
import ua.study.epam.equipment.Equipment;
import ua.study.epam.forge.*;
import ua.study.epam.knight.Knight;
import ua.study.epam.knight.barracks.*;
import ua.study.epam.knight.gender.Gender;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dima on 12.02.17.
 */
public class View {

    Scanner scanner = new Scanner(System.in);

    DAOFactory factory = DAOFactory.getInstance();
    KnightDAO knightDAO = factory.getKnightDAO();
    EquipmentDAO equipmentDAO = factory.getEquipmentDAO();

    Forge forge = ForgeImpl.instance();
    Barracks barracks = BarracksImpl.instance();

    public View() throws SQLException, ClassNotFoundException {
    }

    public void execute() throws SQLException {

        knightDAO.createKnightsTable();
        equipmentDAO.createEquipmentTable();

        //CREATE NEW KNIGHT
        System.out.println("Please enter unique knight name: ");
        String name = scanner.nextLine();
        if( name.length()==0) name = "anonymous";

        while(!(knightDAO.getKnightByName(name) == null)) {
            System.out.println("knight " + name + " already exists. Try one more time: ");
            name = scanner.nextLine();
            if( name.length()==0) name = "anonymous";
        }

        Knight knight = barracks.createKnight(Gender.MALE, name);
        System.out.println("knight " + knight.getName() + " created!");

        //CREATE FULL EQUIPMENT FOR KNIGHT
        if (!forge.createFullKnightEquipment(knight)) {
            System.out.println("knight hasn't enough money for full equipment :(");
        } else {
            System.out.println("knight equipment created: " + knight.getEquipment());
        }

        //COUNT ALL KNIGHT EQUIPMENT BY PRICE
        if (knight.getEquipment().isEmpty()) {
            System.out.println("knight hasn't any equipment :(");
        } else {
            System.out.println("total price of knight equipment - " + knight.countEquipmentPrice());
        }

        //SORT EQUIPMENT MIN TO MAX BY WEIGHT
        if (knight.getEquipment().isEmpty()) {
            System.out.println("knight hasn't any equipment :(");
        } else {
            knight.sortEquipmentByWeight();
            System.out.println("sort equipment by weight: " + knight.getEquipment());
        }

        //SEARCH EQUIPMENT WITHIN SPECIFIED PRICE RANGE
        if (knight.getEquipment().isEmpty()) {
            System.out.println("knight hasn't any equipment :(");
        } else {
            System.out.println("For searching equipment within specified price range, please enter min price: ");
            int minPrice = scanner.nextInt();

            System.out.println("Now enter max price: ");
            int maxPrice = scanner.nextInt();
            while (minPrice < 0 || minPrice > maxPrice || maxPrice > Integer.MAX_VALUE) {
                System.out.println("Sorry, the min price may not be less then 0 and may not be more then max price." +
                        "Max price may not be less then min price and more then " + Integer.MAX_VALUE + ". Try one more time!");
                System.out.println("enter min price: ");
                minPrice = scanner.nextInt();
                System.out.println("enter max price: ");
                maxPrice = scanner.nextInt();
            }

            List<Equipment> equipmentByPrice = knight.getEquipmentByPrice(minPrice, maxPrice);

            if (equipmentByPrice.isEmpty()) {
                System.out.println("knight hasn't any equipment that satisfies current request.");
            } else {
                System.out.println("knight equipment in entered price range (" + minPrice + " - " + maxPrice + "): ");
                System.out.println(equipmentByPrice);
            }
        }

        //SAVE KNIGHT WITH EQUIPMENT TO DATABASE
        knightDAO.insertIntoTableKnights(knight);
        equipmentDAO.insertIntoTableEquipment(knight);
        System.out.println("knight " + knight.getName() + " saved!");

        //LOAD KNIGHT AND EQUIPMENT FROM DATABASE
        KnightDTO knightDTO = knightDAO.getKnightByName(name);
        if (knightDTO == null) {
            System.out.println("knight " + name + " was not found in the database.");
        } else {
            Knight knight1 = knightDTO.loadKnightFromDB();
            List<EquipmentDTO> equipmentDTOList = equipmentDAO.getEquipmentByOwner(knight1.getName());
            if (equipmentDTOList == null) {
                System.out.println("equipment was not found in the database.");
            } else {
                for (EquipmentDTO dto : equipmentDTOList) {
                    knight1.getEquipment().add(dto.loadEquipmentFromDB());
                }
                System.out.println("knight " + knight1.getName() + " loaded!");
            }
        }
    }
}