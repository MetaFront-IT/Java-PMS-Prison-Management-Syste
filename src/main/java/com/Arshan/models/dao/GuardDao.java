package com.Arshan.models.dao;

import com.Arshan.models.entity.Guard;
import com.Arshan.models.entity.enums.Shift;

import java.util.HashMap;

public interface GuardDao extends GeneralDao<Guard, Integer>{
    void setBlock(Integer id, Integer blockId);
    HashMap<String, Shift> getShift();
}
