package com.vinh.fp_finalassignment.repository;

import com.vinh.fp_finalassignment.model.InsuranceCard;

import java.util.List;

public interface IInsuranceCardRepository {
    void add(InsuranceCard insuranceCard);
    void add(InsuranceCard... insuranceCards);
    InsuranceCard findByID(String id);
    List<InsuranceCard> getAll();
    void update(InsuranceCard insuranceCard);
    InsuranceCard removeByID(String id);
}
