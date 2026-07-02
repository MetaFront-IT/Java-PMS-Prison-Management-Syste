package com.Arshan;

import com.Arshan.models.dao.implement.CellDaoImpl;
import com.Arshan.models.dao.implement.PrisonerDaoImpl;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        PrisonerDaoImpl prisoner = new PrisonerDaoImpl();
        CellDaoImpl cellDao = new CellDaoImpl();
        System.out.println(cellDao.getRemaining(2));
    }
}
