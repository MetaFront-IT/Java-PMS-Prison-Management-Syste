package com.Arshan.Controlls;

import com.Arshan.models.dao.implement.BlockDaoImpl;
import com.Arshan.models.dao.implement.PrisonerDaoImpl;
import com.Arshan.models.entity.Block;

import java.util.Scanner;

public class Blocks {
    Scanner sc = new Scanner(System.in);
    BlockDaoImpl pd = new BlockDaoImpl();
    public void create() {
        try {
            System.out.println("Name : ");
            pd.create(new Block(sc.nextLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete() {
        try {
            System.out.println("id : ");
            pd.delete(sc.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getCells() {
        try {
            System.out.println("id : ");
            pd.getCells(sc.nextInt()).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
