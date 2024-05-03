package com.vinh.fp_finalassignment.model;

import com.vinh.fp_finalassignment.model.customer.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class InsuranceCard {
    @Id
    private String id;
    @OneToOne(mappedBy = "insuranceCard")
    private Customer customer;
    public InsuranceCard(String id) {
        this.id = id;
    }

    public InsuranceCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "id='" + id + '\'' +
                ", customer=" + customer.getId() +
                '}';
    }
}
