package com.vinh.fp_finalassignment.model.customer;

import com.vinh.fp_finalassignment.model.Beneficiary;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Dependant extends Beneficiary {
    @ManyToOne
    private PolicyHolder policyHolder;

    public Dependant(DependantBuilder builder) {
        super(builder);
    }

    public Dependant() {

    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    @Override
    public String toString() {
        return String.format("Dependant[id: %s, name: %s, policyHolder: %s]",
                getId(),
                getFullName(),
                policyHolder.getId());
    }

    public static class DependantBuilder extends GenericBeneficaryBuilder<DependantBuilder> {

        @Override
        public Dependant build() {
            return new Dependant(this);
        }
    }
}
