package com.vinh.fp_finalassignment.repository.impl;

import com.vinh.fp_finalassignment.model.InsuranceCard;
import com.vinh.fp_finalassignment.model.customer.Customer;
import com.vinh.fp_finalassignment.repository.EntityRepository;
import com.vinh.fp_finalassignment.repository.IInsuranceCardRepository;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class InsuranceCardRepository extends EntityRepository implements IInsuranceCardRepository {

    @Override
    public void add(InsuranceCard insuranceCard) {
        em.getTransaction().begin();
        em.persist(insuranceCard);
        em.getTransaction().commit();
    }

    @Override
    public void add(InsuranceCard... insuranceCards) {
        em.getTransaction().begin();
        for (InsuranceCard c : insuranceCards) {
            em.persist(c);
        }
        em.getTransaction().commit();
    }

    @Override
    public InsuranceCard findByID(String id) {
        return em.find(InsuranceCard.class, id);
    }

    @Override
    public List<InsuranceCard> getAll() {
        TypedQuery<InsuranceCard> query = em.createQuery("from InsuranceCard ", InsuranceCard.class);
        return query.getResultList();
    }

    @Override
    public void update(InsuranceCard insuranceCard) {
        InsuranceCard insuranceCardToUpdate = findByID(insuranceCard.getId());
        em.getTransaction().begin();

        insuranceCardToUpdate.setId(insuranceCard.getId());
        insuranceCardToUpdate.setCustomer(insuranceCard.getCustomer());

        em.getTransaction().commit();
    }

    @Override
    public InsuranceCard removeByID(String id) {
        em.getTransaction().begin();
        InsuranceCard insuranceCardToRemove = em.find(InsuranceCard.class, id);
        em.remove(insuranceCardToRemove);
        em.getTransaction().commit();
        return insuranceCardToRemove;
    }
}
