package com.vinh.fp_finalassignment.service;

import com.vinh.fp_finalassignment.model.customer.Dependant;
import com.vinh.fp_finalassignment.model.customer.PolicyHolder;
import com.vinh.fp_finalassignment.model.customer.PolicyOwner;
public class CustomerService {
    public Dependant.DependantBuilder makeDependant() {
        return new Dependant.DependantBuilder();
    }

    public PolicyHolder.PolicyHolderBuilder makePolicyHolder() {
        return new PolicyHolder.PolicyHolderBuilder();
    }

    public PolicyOwner.PolicyOwnerBuilder makePolicyOwner() {
        return new PolicyOwner.PolicyOwnerBuilder();
    }

}
