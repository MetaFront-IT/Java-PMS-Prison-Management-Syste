package com.Arshan.Controlls;

import com.Arshan.models.dao.implement.PrisonerDaoImpl;
import com.Arshan.models.entity.enums.Gender;
import com.Arshan.models.entity.enums.PrisonerStatus;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Prisoner {
    Scanner sc = new Scanner(System.in);
    PrisonerDaoImpl pd = new PrisonerDaoImpl();
    public void create() {
        String firstName;
        while (true) {
            System.out.print("Firstname : ");
            firstName = sc.nextLine();

            if (firstName.contains("\\d+")) {
                System.out.println("Wrong input");
            } else {
                break;
            }
        }
        String lastname;
        while (true) {
            System.out.print("Lastname : ");
            lastname = sc.nextLine();

            if (lastname.matches("\\d+")) {
                System.out.println("Wrong input");
            } else {
                break;
            }
        }
        String nationalCode;
        while (true) {
            System.out.print("National Code : ");
            nationalCode = sc.nextLine();

            if (nationalCode.matches("\\d+")) {
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
        LocalDate birthDate;
        while (true) {
            System.out.println("YEAR, Month, Day");
            try {
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();

                birthDate = LocalDate.of(year, month, day);

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.nextLine();
        Gender gender;
        aa:
        while (true) {
            System.out.println("gender: ");
            System.out.println("1, Male");
            System.out.println("2, Female");

            switch (sc.nextLine()) {
                case "1" -> {
                    gender = Gender.MALE;
                    break aa;
                }
                case "2" -> {
                    gender = Gender.FEMALE;
                    break aa;
                }
                default -> System.out.println("Not Correct");
            }
        }
        System.out.print("Cell id: ");
        int cell = sc.nextInt();

        System.out.println("Sentence id: ");
        int sentence = sc.nextInt();
        pd.create(new com.Arshan.models.entity.Prisoner(firstName, lastname, nationalCode, birthDate, gender, PrisonerStatus.ACTIVE, sentence, cell));
    }

    public void update() {
        try {
            System.out.println("Id : ");
            int id = sc.nextInt();
            sc.nextLine();
            String firstName;
            while (true) {
                System.out.print("Firstname : ");
                firstName = sc.nextLine();

                if (firstName.contains("\\d+")) {
                    System.out.println("Wrong input");
                } else {
                    break;
                }
            }
            String lastname;
            while (true) {
                System.out.print("Lastname : ");
                lastname = sc.nextLine();

                if (lastname.matches("\\d+")) {
                    System.out.println("Wrong input");
                } else {
                    break;
                }
            }
            String nationalCode;
            while (true) {
                System.out.print("National Code : ");
                nationalCode = sc.nextLine();

                if (nationalCode.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Wrong input");
                }
            }
            LocalDate birthDate;
            while (true) {
                System.out.println("YEAR, Month, Day");
                try {
                    int year = sc.nextInt();
                    int month = sc.nextInt();
                    int day = sc.nextInt();

                    birthDate = LocalDate.of(year, month, day);

                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            Gender gender;
            aa:
            while (true) {
                System.out.println("gender: ");
                System.out.println("1, Male");
                System.out.println("2, Female");

                switch (sc.nextLine()) {
                    case "1" -> {
                        gender = Gender.MALE;
                        break aa;
                    }
                    case "2" -> {
                        gender = Gender.FEMALE;
                        break aa;
                    }
                    default -> System.out.println("Not Correct");
                }
            }

            PrisonerStatus ps;
            bb:
            while (true) {
                System.out.println("Status: ");
                System.out.println("1, Active");
                System.out.println("2, Transferred");

                switch (sc.nextLine()) {
                    case "1" -> {
                        ps = PrisonerStatus.ACTIVE;
                        break bb;
                    }
                    case "2" -> {
                        ps = PrisonerStatus.TRANSFERRED;
                        break bb;
                    }
                    case "3" -> {
                        ps = PrisonerStatus.RELEASED;
                        break bb;
                    }
                    default -> System.out.println("Not Correct");
                }
            }

            System.out.println("Sentence id: ");
            int sentence = sc.nextInt();
            pd.Update(new com.Arshan.models.entity.Prisoner(firstName, lastname, nationalCode, birthDate, gender,ps, sentence, 0), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete() {
        try {
            pd.delete(sc.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void search() {
        try {
            pd.search(sc.nextLine()).forEach((key, value) -> System.out.println(key + " " + value));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAll() {
        try {
            List<com.Arshan.models.entity.Prisoner> prisoners = pd.getAll();
            if (prisoners.isEmpty()) {
                System.out.println("Empty");
            } else {
                prisoners.forEach(System.out::println);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void transfer() {
        try {
            System.out.println("Prisoner id : ");
            int prisonerId = sc.nextInt();
            System.out.println("From cell id : ");
            int fromCell = sc.nextInt();
            System.out.println("To Cell id : ");
            int toCell = sc.nextInt();
            System.out.println("Guard id : ");
            int guardId = sc.nextInt();
            sc.nextLine();
            System.out.println("Description : ");
            String description = sc.nextLine();
            LocalDate transfferDate;
            while (true) {
                System.out.println("YEAR, Month, Day");
                try {
                    int year = sc.nextInt();
                    int month = sc.nextInt();
                    int day = sc.nextInt();

                    transfferDate = LocalDate.of(year, month, day);

                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            pd.transfer(prisonerId, fromCell, toCell, guardId, transfferDate, description);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
