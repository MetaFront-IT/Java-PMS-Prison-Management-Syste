package com.Arshan.View;

import java.util.List;
import java.util.Scanner;
import com.Arshan.Controlls.*;
import com.Arshan.models.dao.PrisonerDao;
import com.Arshan.models.dao.SentenceDao;
import com.Arshan.models.dao.implement.BlockDaoImpl;
import com.Arshan.models.dao.implement.PrisonerDaoImpl;
import com.Arshan.models.entity.Transfer;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner sc = new Scanner(System.in);

    static void main() {
        while (true) {
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("1. Prisoner Management");
        System.out.println("2. Cell Management");
        System.out.println("3. Block Management");
        System.out.println("4. Guard Management");
        System.out.println("5. Sentence Management");
        System.out.println("6. Visit Management");
        System.out.println("7. Transfer");
        System.out.println("8. Reports");
        System.out.println("0. Exit");

        switch (sc.nextLine()) {
            case "1" -> {
                prisonerMenu();
            }
            case "2" -> {
                cellMenu();
            }
            case "3" -> {
                blockMenu();
            }
            case "4" -> {
                guardMenu();
            }
            case "5" -> {
                sentenceMenu();
            }
            case "6" -> {
                visitMenu();
            }
            case "7" -> {
                transfer();
            }
            case "8" -> {
                reportMenu();
            }
            case "0" -> {
                System.exit(0);
            }
        }
    }

    private static void prisonerMenu() {
        Prisoner controller = new Prisoner();
        System.out.println("\n--- Prisoner Menu ---");
        System.out.println("1. Add Prisoner");
        System.out.println("2. Update Prisoner");
        System.out.println("3. Delete Prisoner");
        System.out.println("4. Search Prisoner");
        System.out.println("5. Show All Prisoners");
        System.out.println("0. Back");

        switch (sc.nextLine()) {
            case "1" -> {
                controller.create();
            }
            case "2" -> {
                controller.update();
            }
            case "3" -> {
                controller.delete();
            }
            case "4" -> {
                controller.search();
            }
            case "5" -> {
                controller.getAll();
            }
            default -> System.out.println("Wrong");
        }
    }
    private static void cellMenu() {
        Cell controller = new Cell();
        System.out.println("\n--- Cell Menu ---");
        System.out.println("1. Add Cell");
        System.out.println("2. Update Cell");
        System.out.println("3. Get Remaining");
        System.out.println("4. Show Prisoners");
        System.out.println("0. Back");

        switch (sc.nextLine()) {
            case "1" -> {
                controller.create();
            }
            case "2" -> {
                controller.update();
            }
            case "3" -> {
                controller.remaining();
            }
            case "4" -> {
                controller.showPrisoners();
            }
            default -> System.out.println("Wrong");
        }
    }
    private static void blockMenu() {
        Blocks controller = new Blocks();
        System.out.println("\n--- Block Menu ---");
        System.out.println("1. Add Block");
        System.out.println("2. Delete Block");
        System.out.println("3. Get Cells");
        System.out.println("0. Back");

        switch (sc.nextLine()) {
            case "1" -> {
                controller.create();
            }
            case "2" -> {
                controller.delete();
            }
            case "3" -> {
                controller.getCells();
            }
            default -> System.out.println("Wrong");
        }
    }
    private static void guardMenu() {
        Guard controller = new Guard();
        System.out.println("\n--- Guard Menu ---");
        System.out.println("1. Add Guard");
        System.out.println("2. Update Guard");
        System.out.println("3. Show By Id");
        System.out.println("0. Back");

        switch (sc.nextLine()) {
            case "1" -> {
                controller.create();
            }
            case "2" -> {
                controller.update();
            }
            case "3" -> {
                controller.ShowById();
            }
            default -> System.out.println("Wrong");
        }
    }
    private static void sentenceMenu() {
        Sentence controller = new Sentence();
        System.out.println("\n--- Sentence Menu ---");
        System.out.println("1. Add Sentence");
        System.out.println("2. Get Duration");
        System.out.println("0. Back");

        switch (sc.nextLine()) {
            case "1" -> {
                controller.create();
            }
            case "2" -> {
                controller.getDuration();
            }
            default -> System.out.println("Wrong");
        }
    }
    private static void visitMenu() {
        Visit controller = new Visit();
        System.out.println("\n--- Visit Menu ---");
        System.out.println("1. Add Visit");
        System.out.println("2. Add Visitor");
        System.out.println("3. Cancel Visit");
        System.out.println("0. Back");

        switch (sc.nextLine()) {
            case "1" -> {
                controller.create();
            }
            case "2" -> {
                controller.createVisitor();
            }
            case "3" -> {
                controller.cancelVisit();
            }
            default -> System.out.println("Wrong");
        }
    }
    private static void reportMenu() {
        Reports controller = new Reports();
        System.out.println("\n--- Reports Menu ---");
        System.out.println("1. Get Prisoner Per Block");
        System.out.println("2. Get Prisoners Count by Cell");
        System.out.println("3. Get Empty Cells");
        System.out.println("4. Get Full Cells");
        System.out.println("5. Get Ending Sentences");
        System.out.println("6. Get Prisoners have Visit");
        System.out.println("7. Get By Crime");
        System.out.println("8. Get Block Guards");
        System.out.println("9. Get Average Prisoners per Blocks");
        System.out.println("10. Get Most occupied Blocks Count");
        System.out.println("11. Get Minimum occupied Blocks Count");
        System.out.println("0. Back");

        switch (sc.nextLine()) {
            case "1" -> {
                controller.getPrisonersPerBlock();
            }
            case "2" -> {
                controller.getByCell();
            }
            case "3" -> {
                controller.getEmptyCells();
            }
            case "4" -> {
                controller.getFullCells();
            }
            case "5" -> {
                controller.getEnding();
            }
            case "6" -> {
                controller.haveVisit();
            }
            case "7" -> {
                controller.filterByCrime();
            }
            case "8" -> {
                controller.getBlockGuards();
            }
            case "9" -> {
                controller.getAveragePerBlock();
            }
            case "10" -> {
                controller.getMaxBlocks();
            }
            case "11" -> {
                controller.getMinBlocks();
            }
            default -> System.out.println("Wrong");
        }
    }
    private static void transfer() {
        Prisoner controller = new Prisoner();
        controller.transfer();
    }
}