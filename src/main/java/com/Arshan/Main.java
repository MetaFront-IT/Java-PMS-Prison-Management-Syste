package com.Arshan;

import com.Arshan.models.dao.SentenceDao;
import com.Arshan.models.dao.implement.CellDaoImpl;
import com.Arshan.models.dao.implement.PrisonerDaoImpl;
import com.Arshan.models.dao.implement.SentenceDaoImpl;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
//        PrisonerDaoImpl prisoner = new PrisonerDaoImpl();
//        CellDaoImpl cellDao = new CellDaoImpl();
//        System.out.println(cellDao.getRemaining(2));

        SentenceDao sentenceDao = new SentenceDaoImpl();

        System.out.println(sentenceDao.getDuration(31));
    }
}
