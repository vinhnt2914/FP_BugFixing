package com.vinh.fp_finalassignment;

import com.vinh.fp_finalassignment.model.Claim;
import com.vinh.fp_finalassignment.model.InsuranceCard;
import com.vinh.fp_finalassignment.model.customer.Dependant;
import com.vinh.fp_finalassignment.model.customer.PolicyHolder;
import com.vinh.fp_finalassignment.model.customer.PolicyOwner;
import com.vinh.fp_finalassignment.repository.impl.CustomerRepository;
import com.vinh.fp_finalassignment.service.CustomerService;

public class Main {
    public static void main(String[] args) {
        InsuranceCard card1 = new InsuranceCard("c-000001");
        InsuranceCard card2 = new InsuranceCard("c-000002");
        InsuranceCard card3 = new InsuranceCard("c-000003");
        InsuranceCard card4 = new InsuranceCard("c-000004");

        CustomerService customerService = new CustomerService();

        PolicyHolder c1 = customerService
                .makePolicyHolder()
                .username("vinhrmit1234")
                .password("Rmit@1234")
                .email("vinh@gmail.com")
                .phone("0818194444")
                .address("Hanoi")
                .fullName("Nguyen The Vinh")
                .insuranceCard(card4)
                .build();

        Dependant c2 = customerService
                .makeDependant()
                .fullName("Nguyen The Quang")
                .username("quangrmit1234")
                .password("Rmit@1234")
                .email("quang@gmail.com")
                .phone("123456789")
                .address("Haiphone")
                .insuranceCard(card1)
                .build();

        Dependant c3 = customerService
                .makeDependant()
                .username("khairmit1234")
                .password("Rmit@1234")
                .email("khai@gmail.com")
                .phone("123456812")
                .address("Sapa")
                .fullName("Tran Quang Khai")
                .insuranceCard(card2)
                .build();

        Dependant c4 = customerService
                .makeDependant()
                .username("quatrmit1234")
                .password("Rmit@1234")
                .email("quat@gmail.com")
                .phone("412389123")
                .address("Bac Ninh")
                .fullName("Cao Ba Quat")
                .insuranceCard(card3)
                .build();

        PolicyOwner c5 = customerService
                .makePolicyOwner()
                .username("kienrmit1234")
                .password("Rmit@1234")
                .email("kien@gmail.com")
                .phone("01421234112")
                .address("Thanh Hoa")
                .fullName("Dang Trung Kien")
                .build();

        // This line can cause the unsaved transient object error
        // c2, c3, c4 by the time of persisting
        // Solve using bulk adding, avoid persisting each object per transaction
        // Persist everything under one transaction
        c1.addDepdendants(c2, c3, c4);
        c5.addBeneficaries(c1, c2, c3);

        System.out.println("This can run");

        Claim claim1 = new Claim("f-0001", "No content", c1);
        Claim claim2 = new Claim("f-0002", "No content", c1);
        Claim claim3 = new Claim("f-0003", "No content", c2);
        Claim claim4 = new Claim("f-0004", "No content", c3);

        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.add(c1,c2,c3,c4,c5);

//        customerRepository.removeByID(5);

        customerRepository.close();

    }
}
