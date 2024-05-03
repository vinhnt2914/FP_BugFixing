package com.vinh.fp_finalassignment.model;

import com.vinh.fp_finalassignment.model.customer.Customer;
import com.vinh.fp_finalassignment.model.customer.PolicyOwner;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "policyOwner_beneficiary")
public abstract class Beneficiary extends Customer {
    @ManyToOne
    @JoinColumn(name = "policy_owner_id")
    private PolicyOwner policyOwner;

    public Beneficiary(GenericBeneficaryBuilder builder) {
        super(builder);
    }

    public Beneficiary() {
    }

    public PolicyOwner getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(PolicyOwner policyOwner) {
        this.policyOwner = policyOwner;
    }

    public abstract static class GenericBeneficaryBuilder<T extends GenericBeneficaryBuilder<T>> extends GenericCustomerBuilder<T> {
    }

}
