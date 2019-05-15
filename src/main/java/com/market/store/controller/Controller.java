package com.market.store.controller;

import com.market.store.model.Customers;
import com.market.store.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
public class Controller {

    @Autowired
    private CustomersService customersService;

    @GetMapping(value = "/customer/order", produces = {"application/json"})
    public ResponseEntity<?> listCustomersWithOrders() {
        ArrayList<Customers> customersWithOrders = customersService.findAll();

        return new ResponseEntity<>(customersWithOrders, HttpStatus.OK);
    }


    @GetMapping(value = "/customer/name/{custname}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerName(@PathVariable String custname) {

        Customers specificCustomer = customersService.findCustomerByName(custname);

        return new ResponseEntity<>(specificCustomer , HttpStatus.OK);
    }


    @GetMapping(value = "/data/customer/delete/{custcode}", produces = {"application/json"})
    public ResponseEntity<?> deleteCustomer(@PathVariable long custcode) {
        customersService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/data/customer/new", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers newCustomer) throws URISyntaxException {
        newCustomer = customersService.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/CUSTCODE").buildAndExpand(newCustomer.getCUSTCODE()).toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/data/customer/update/{custcode}", produces = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customers updateCustomer, @PathVariable long custcode) {
        customersService.update(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
