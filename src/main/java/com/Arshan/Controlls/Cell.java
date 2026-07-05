package com.Arshan.Controlls;

import com.Arshan.models.dao.implement.CellDaoImpl;
import com.Arshan.models.dao.implement.GuardDaoImpl;

import java.util.Scanner;

public class Cell {
    Scanner sc = new Scanner(System.in);
    CellDaoImpl pd = new CellDaoImpl();
    public void create() {
        try {
            System.out.println("Cell Number : ");
            int cellNumber = sc.nextInt();
            System.out.println("Capacity : ");
            int capacity = sc.nextInt();
            System.out.println("Block id : ");
            int blockId = sc.nextInt();
            pd.create(new com.Arshan.models.entity.Cell(cellNumber, capacity, blockId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update() {
        try {
            System.out.println("id : ");
            int id = sc.nextInt();
            System.out.println("Cell Number : ");
            int cellNumber = sc.nextInt();
            System.out.println("capacity : ");
            int capacity = sc.nextInt();
            System.out.println("Block id : ");
            int blockId = sc.nextInt();
            pd.Update(new com.Arshan.models.entity.Cell(cellNumber, capacity, blockId), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void remaining() {
        try {
            System.out.println("id");
            System.out.println(pd.getRemaining(sc.nextInt()) + "Remaining");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void showPrisoners() {
        try {
            System.out.println("id : ");
            System.out.println(pd.getPrisoners(sc.nextInt()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
