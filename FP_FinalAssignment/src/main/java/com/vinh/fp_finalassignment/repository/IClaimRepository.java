package com.vinh.fp_finalassignment.repository;

import com.vinh.fp_finalassignment.model.Claim;

import java.util.List;

public interface IClaimRepository {
    void add(Claim claim);
    void add(Claim... claims);
    Claim findByID(String id);
    List<Claim> getAll();
    void update(Claim claim);
    Claim removeByID(String id);
}
