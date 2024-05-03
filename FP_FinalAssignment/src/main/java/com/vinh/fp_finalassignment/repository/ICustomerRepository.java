package com.vinh.fp_finalassignment.repository;

import com.vinh.fp_finalassignment.model.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    void add(Customer customer);
    void add(Customer... customers);
    Customer findByID(int id);
    List<Customer> getAll();
    void update(Customer customer);
    Customer removeByID(int id);
}
