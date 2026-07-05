package com.Arshan.Controlls;

import com.Arshan.models.dao.implement.BlockDaoImpl;
import com.Arshan.models.dao.implement.GuardDaoImpl;
import com.Arshan.models.entity.enums.Shift;

import java.util.Scanner;

public class Guard {
    Scanner sc = new Scanner(System.in);
    GuardDaoImpl pd = new GuardDaoImpl();
    public void create() {
        try {
            System.out.print("firstname : ");
            String firstName = sc.nextLine();
            System.out.print("lastname : ");
            String lastName = sc.nextLine();
            System.out.print("national code : ");
            String nationalCode = sc.nextLine();
            Shift shift;
            System.out.println("Shift : 1. Morning \t 2. Evening \t 3. Night");
            aa:
            while(true) {
                switch (sc.nextLine()) {
                    case "1" ->  {
                        shift = Shift.MORNING;
                        break aa;
                    }
                    case "2" -> {
                        shift = Shift.EVENING;
                        break aa;
                    }
                    case "3" -> {
                        shift = Shift.NIGHT;
                        break aa;
                    }
                    default -> System.out.println("incorrect");
                }
            }
            System.out.println("Block Id : ");
            int blockId = sc.nextInt();

            pd.create(new com.Arshan.models.entity.Guard(firstName, lastName, nationalCode, shift, blockId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update() {
        try {
            System.out.println("id : ");
            int id = sc.nextInt();
            System.out.print("firstname : ");
            String firstName = sc.nextLine();
            System.out.print("lastname : ");
            String lastName = sc.nextLine();
            System.out.print("national code : ");
            String nationalCode = sc.nextLine();
            Shift shift;
            System.out.println("Shift : 1. Morning \t 2. Evening \t 3. Night");
            aa:
            while(true) {
                switch (sc.nextLine()) {
                    case "1" ->  {
                        shift = Shift.MORNING;
                        break aa;
                    }
                    case "2" -> {
                        shift = Shift.EVENING;
                        break aa;
                    }
                    case "3" -> {
                        shift = Shift.NIGHT;
                        break aa;
                    }
                    default -> System.out.println("incorrect");
                }
            }
            System.out.println("Block Id : ");
            int blockId = sc.nextInt();

            pd.Update(new com.Arshan.models.entity.Guard(firstName, lastName, nationalCode, shift, blockId), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void ShowById() {
        try {
            pd.getById(sc.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
