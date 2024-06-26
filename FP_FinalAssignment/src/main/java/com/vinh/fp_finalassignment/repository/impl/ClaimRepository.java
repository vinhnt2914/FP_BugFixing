package com.vinh.fp_finalassignment.repository.impl;

import com.vinh.fp_finalassignment.model.Claim;
import com.vinh.fp_finalassignment.repository.EntityRepository;
import com.vinh.fp_finalassignment.repository.IClaimRepository;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ClaimRepository extends EntityRepository implements IClaimRepository {
    @Override
    public void add(Claim claim) {
        em.getTransaction().begin();
        em.persist(claim);
        em.getTransaction().commit();
    }

    @Override
    public void add(Claim... claims) {
        em.getTransaction().begin();
        for (Claim c : claims) {
            em.persist(c);
        }
        em.getTransaction().commit();
    }

    @Override
    public Claim findByID(String id) {
        return em.find(Claim.class, id);
    }

    @Override
    public List<Claim> getAll() {
        TypedQuery<Claim> query = em.createQuery("from Claim ", Claim.class);
        return query.getResultList();
    }

    @Override
    public void update(Claim claim) {
        Claim claimToUpdate = findByID(claim.getId());

        em.getTransaction().begin();

        claimToUpdate.setId(claim.getId());
        claimToUpdate.setContent(claim.getContent());
        claimToUpdate.setCustomer(claim.getCustomer());

        em.getTransaction().commit();
    }

    @Override
    public Claim removeByID(String id) {
        em.getTransaction().begin();
        Claim claimToRemove = em.find(Claim.class, id);
        em.remove(claimToRemove);
        em.getTransaction().commit();
        return claimToRemove;
    }
}
