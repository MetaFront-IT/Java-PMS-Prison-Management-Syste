package com.Arshan.Controlls;

import com.Arshan.models.dao.BlockDao;
import com.Arshan.models.dao.PrisonerDao;
import com.Arshan.models.dao.implement.*;

import java.util.List;
import java.util.Scanner;

public class Reports {
    private final Scanner sc = new Scanner(System.in);
    public void getPrisonersPerBlock() {
        try {
            BlockDaoImpl bd = new BlockDaoImpl();
            System.out.println("id : ");
            System.out.println(bd.getPrisonersCount(sc.nextInt()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getByCell() {
        try {
            CellDaoImpl bd = new CellDaoImpl();
            System.out.println("id : ");
            System.out.println(bd.getPrisonerCount(sc.nextInt()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getEmptyCells() {
        try {
            CellDaoImpl bd = new CellDaoImpl();
            List emptyCells = bd.getEmptyCell();
            if (!emptyCells.isEmpty()) {
                emptyCells.forEach(System.out::println);
            } else {
                System.out.println("is Empty");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getFullCells() {
        try {
            CellDaoImpl bd = new CellDaoImpl();
            List fullCells = bd.getFullCell();
            if (!fullCells.isEmpty()) {
                fullCells.forEach(System.out::println);
            } else {
                System.out.println("is Empty");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getEnding() {
        SentenceDaoImpl sd = new SentenceDaoImpl();
        try {
            sd.isEnding().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void haveVisit() {
        VisitDaoImpl dao = new VisitDaoImpl();
        try {
            dao.haveVisit().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void filterByCrime() {
        PrisonerDao dao = new PrisonerDaoImpl();
        try {
            System.out.println("Crime id : ");
            dao.getByCrime(sc.nextInt()).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getBlockGuards() {
        GuardDaoImpl dao = new GuardDaoImpl();
        try {
            System.out.println("Id : ");
            dao.getByBlock(sc.nextInt()).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getAveragePerBlock() {
        BlockDaoImpl dao = new BlockDaoImpl();
        try {
            System.out.println(dao.getAverageCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getMaxBlocks() {
        BlockDaoImpl dao = new BlockDaoImpl();
        try {
            System.out.println(dao.getMaxCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getMinBlocks() {
        BlockDaoImpl dao = new BlockDaoImpl();
        try {
            System.out.println(dao.getMinCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
