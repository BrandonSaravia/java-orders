package com.market.store.service;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.market.store.model.Customers;
import com.market.store.model.Orders;
import com.market.store.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Transactional
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public ArrayList<Customers> findAll() {
        ArrayList<Customers> list = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Transactional
    @Override
    public Customers save(Customers customer) {
        Customers newCustomer = new Customers();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setWORKINGAREA(customer.getWORKINGAREA());
        newCustomer.setCUSTCOUNTRY(customer.getCUSTCOUNTRY());
        newCustomer.setGRADE(customer.getGRADE());
        newCustomer.setOPENINGAMT(customer.getOPENINGAMT());
        newCustomer.setRECEIVEAMT(customer.getRECEIVEAMT());
        newCustomer.setPAYMENTAMT(customer.getPAYMENTAMT());
        newCustomer.setOUTSTANDINGAMT(customer.getOUTSTANDINGAMT());
        newCustomer.setPHONE(customer.getPHONE());
        newCustomer.setAGENTCODE(customer.getAGENTCODE());

        for (Orders o : customer.getOrdersList()) {
            newCustomer.getOrdersList().add(new Orders(o.getORDAMOUNT(), o.getADVANCEAMOUNT(), o.getORDDESCRIPTION(), o.getCUSTCODE(), o.getAGENTCODE()));
        }

        return customersRepository.save(newCustomer);
    }

    @Override
    public Customers findCustomerByName(String name) {
        Customers customers = customersRepository.findCustomersByCustname(name);

        if (customers == null) {
            throw new EntityNotFoundException("Customer " + name + " not found");
        } else {
            return customers;
        }
    }

    @JsonIgnoreProperties
    @Transactional
    @Override
    public Customers update(Customers customer, long id) {
        Customers currentCustomer = customersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (customer.getCustname() != null) {
            currentCustomer.setCustname(customer.getCustname());
        }

        if (customer.getWORKINGAREA() != null) {
            currentCustomer.setWORKINGAREA(customer.getWORKINGAREA());
        }

        if (customer.getCUSTCOUNTRY() != null) {
            currentCustomer.setCUSTCOUNTRY(customer.getCUSTCOUNTRY());
        }

        if (customer.getGRADE() != null) {
            currentCustomer.setGRADE(customer.getGRADE());
        }

        if (customer.getOPENINGAMT() != 0.0) {
            currentCustomer.setOPENINGAMT(customer.getOPENINGAMT());
        }

        if (customer.getRECEIVEAMT() != 0.0) {
            currentCustomer.setRECEIVEAMT(customer.getRECEIVEAMT());
        }

        if (customer.getPAYMENTAMT() != 0.0) {
            currentCustomer.setPAYMENTAMT(customer.getPAYMENTAMT());
        }

        if (customer.getOUTSTANDINGAMT() != 0.0) {
            currentCustomer.setOUTSTANDINGAMT(customer.getOUTSTANDINGAMT());
        }

        if (customer.getPHONE() != null) {
            currentCustomer.setPHONE(customer.getPHONE());
        }

        if (customer.getAGENTCODE() != null) {
            currentCustomer.setAGENTCODE(customer.getAGENTCODE());
        }

        if (customer.getOrdersList().size() > 0) {
            for (Orders o : customer.getOrdersList()) {
                currentCustomer.getOrdersList().add(new Orders(o.getORDAMOUNT(), o.getADVANCEAMOUNT(), o.getORDDESCRIPTION(), o.getCUSTCODE(), o.getAGENTCODE()));
            }
        }

        return customersRepository.save(currentCustomer);
    }

    @Transactional
    @Override
    public void delete(long id) {
        if(customersRepository.findById(id).isPresent()) {
            customersRepository.deleteByCUSTCODE(id);
            customersRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }
}

//package com.market.store.service;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.market.store.model.Agents;
//import com.market.store.model.Customers;
//import com.market.store.model.Orders;
//import com.market.store.repos.AgentsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Transactional
//@Service(value = "AgentsService")
//public class AgentsServiceImpl implements AgentsService {
//
//    @Autowired
//    private AgentsRepository restrepos;

//    @Override
//    public List<Agents> findAll() {
//        ArrayList<Agents> list = new ArrayList<>();
//        restrepos.findAll().iterator().forEachRemaining(list::add);
//        return list;
//    }
//
//    @Override
//    public Agents findAgentsById(long id) throws EntityNotFoundException {
//        return restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
//    }
//
//    @Override
//    public Agents findAgentsByName(String name) {
//        Agents agents = restrepos.findByName(name);
//
//        if (agents == null) {
//            throw new EntityNotFoundException("Agent " + name + " not found");
//        } else {
//            return agents;
//        }
//    }
//
//    @Override
//    public void delete(long id) {
//        if (restrepos.findById(id).isPresent()) {
//            restrepos.deleteById(id);
//        } else {
//            throw new EntityNotFoundException(Long.toString(id));
//        }
//    }
//
//    @JsonIgnoreProperties
//    @Transactional
//    @Override
//    public Agents save(Agents agents) {
//        Agents newAgent = new Agents();
//
//        newAgent.setAGENTNAME(agents.getAGENTNAME());
//        newAgent.setWORKINGAREA(agents.getWORKINGAREA());
//        newAgent.setCOMMISSION(agents.getCOMMISSION());
//        newAgent.setPHONE(agents.getPHONE());
//        newAgent.setCOUNTRY(agents.getCOUNTRY());
//
//        for (Customers c : agents.getCustomersList()) {
//            newAgent.getCustomersList().add(new Customers(c.getCustname(), c.getWORKINGAREA(), c.getCUSTCOUNTRY(), c.getGRADE(), c.getOPENINGAMT(), c.getRECEIVEAMT(), c.getPAYMENTAMT(), c.getOUTSTANDINGAMT(), c.getPHONE(), c.getAGENTCODE()));
//        }
//
//        for (Orders o : agents.getOrdersList()) {
//            newAgent.getOrdersList().add(new Orders(o.getORDAMOUNT(), o.getADVANCEAMOUNT(), o.getORDDESCRIPTION(), o.getCUSTCODE(), o.getAGENTCODE()));
//        }
//
//        return restrepos.save(newAgent);
//    }
//
//    @JsonIgnoreProperties
//    @Transactional
//    @Override
//    public Agents update(Agents agents, long id) {
//        Agents currentAgent = restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
//
//        if (agents.getAGENTNAME() != null) {
//            currentAgent.setAGENTNAME(agents.getAGENTNAME());
//        }
//
//        if (agents.getWORKINGAREA() != null) {
//            currentAgent.setWORKINGAREA(agents.getWORKINGAREA());
//        }
//
//        if (agents.getCOMMISSION() != 0.0) {
//            currentAgent.setCOMMISSION(agents.getCOMMISSION());
//        }
//
//        if (agents.getPHONE() != null) {
//            currentAgent.setPHONE(agents.getPHONE());
//        }
//
//        if (agents.getCOUNTRY() != null) {
//            currentAgent.setCOUNTRY(agents.getCOUNTRY());
//        }
//
//        if (agents.getCustomersList().size() > 0) {
//            for (Customers c : agents.getCustomersList()) {
//                currentAgent.getCustomersList().add(new Customers(c.getCustname(), c.getWORKINGAREA(), c.getCUSTCOUNTRY(), c.getGRADE(), c.getOPENINGAMT(), c.getRECEIVEAMT(), c.getPAYMENTAMT(), c.getOUTSTANDINGAMT(), c.getPHONE(), c.getAGENTCODE()));
//            }
//        }
//
//        if (agents.getOrdersList().size() > 0) {
//            for (Orders o : agents.getOrdersList()) {
//                currentAgent.getOrdersList().add(new Orders(o.getORDAMOUNT(), o.getADVANCEAMOUNT(), o.getORDDESCRIPTION(), o.getCUSTCODE(), o.getAGENTCODE()));
//            }
//        }
//
//        return restrepos.save(currentAgent);
//    }
//}

