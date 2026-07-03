package com.Arshan.models.dao;

import com.Arshan.models.entity.Crime;
import com.Arshan.models.entity.Sentence;
import com.Arshan.models.entity.enums.SentenceStatus;

import java.time.LocalDate;
import java.util.Date;

public interface SentenceDao {
    void create(Sentence entity);
    Sentence getById(int id);
    int getDuration(int id);
}
