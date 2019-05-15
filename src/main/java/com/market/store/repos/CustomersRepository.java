package com.market.store.repos;

import com.market.store.model.Customers;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers, Long> {

    Customers findCustomersByCustname(String name);

    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE zooid = :id", nativeQuery = true)
    void deleteByCUSTCODE(long id);
}
