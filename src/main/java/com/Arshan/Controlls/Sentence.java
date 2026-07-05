package com.Arshan.Controlls;

import com.Arshan.models.dao.SentenceDao;
import com.Arshan.models.dao.implement.PrisonerDaoImpl;
import com.Arshan.models.dao.implement.SentenceDaoImpl;
import com.Arshan.models.entity.enums.SentenceStatus;

import java.time.LocalDate;
import java.util.Scanner;

public class Sentence {
    private Scanner sc = new Scanner(System.in);
    private SentenceDaoImpl pd = new SentenceDaoImpl();
    public void create(){
        try {
            System.out.println("Crime Id : ");
            int crimeId = sc.nextInt();

            System.out.println("Start Date : \n YEAR, \n Month,\n Day");
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            LocalDate startDate = LocalDate.of(year, month, day);

            System.out.println("End Date : \n YEAR, \n Month, \n Day");
            int eYear = sc.nextInt();
            int eMonth = sc.nextInt();
            int eDay = sc.nextInt();
            LocalDate endDate = LocalDate.of(eYear, eMonth, eDay);

            pd.create(new com.Arshan.models.entity.Sentence(crimeId, startDate, endDate, SentenceStatus.ACTIVE));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getDuration() {
        System.out.println(pd.getDuration(sc.nextInt()));
    }
}
