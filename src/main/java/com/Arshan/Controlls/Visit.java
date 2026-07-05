package com.Arshan.Controlls;

import com.Arshan.models.dao.VisitDao;
import com.Arshan.models.dao.VisitorDao;
import com.Arshan.models.dao.implement.CellDaoImpl;
import com.Arshan.models.dao.implement.VisitDaoImpl;
import com.Arshan.models.dao.implement.VisitorDaoImpl;
import com.Arshan.models.entity.enums.Shift;
import com.Arshan.models.entity.enums.VisitStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Visit {
    Scanner sc = new Scanner(System.in);
    VisitorDaoImpl pd = new VisitorDaoImpl();
    VisitDaoImpl vd = new VisitDaoImpl();
    public void create(){
        try {
            System.out.println("Prisoner Id : ");
            int prisonerId = sc.nextInt();
            System.out.println("Visitor Id : ");
            int visitorId = sc.nextInt();
            LocalDate date;
            while (true) {
                System.out.println("YEAR, Month, Day");
                try {
                    int year = sc.nextInt();
                    int month = sc.nextInt();
                    int day = sc.nextInt();

                    date = LocalDate.of(year, month, day);

                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            LocalTime time;
            while (true) {
                System.out.println("Time : \n Hour \n minute");
                try {
                    int hour = sc.nextInt();
                    int minute = sc.nextInt();

                    time = LocalTime.of(hour, minute);

                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            vd.create(new com.Arshan.models.entity.Visit(prisonerId, visitorId, date, time, VisitStatus.ACTIVE));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void createVisitor() {
        try {
            System.out.println("Firstname : ");
            String firstName = sc.nextLine();
            System.out.println("Lastname : ");
            String lastName = sc.nextLine();
            System.out.println("National code : ");
            String nationalCode = sc.nextLine();
            System.out.println("Relation to Prisoner : ");
            String relation = sc.nextLine();
            pd.create(new com.Arshan.models.entity.Visitor(firstName, lastName, nationalCode, relation));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void cancelVisit() {
        try {
            System.out.println("id : ");
            vd.cancelVisit(sc.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
