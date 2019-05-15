package com.market.store.service;

import com.market.store.model.Customers;

import java.util.ArrayList;

public interface CustomersService {

    ArrayList<Customers> findAll();

    Customers save(Customers customer);

    Customers findCustomerByName(String Name);

    Customers update(Customers customer, long id);

    void delete(long id);
}


