package com.market.store.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.market.store.model.Agents;
import com.market.store.model.Customers;
import com.market.store.model.Orders;
import com.market.store.repos.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "AgentsService")
public class AgentsServiceImpl implements AgentsService {

    @Autowired
    private AgentsRepository restrepos;

    @JsonIgnoreProperties
    @Transactional
    @Override
    public Agents save(Agents agents) {
        Agents newAgent = new Agents();

        newAgent.setAGENTNAME(agents.getAGENTNAME());
        newAgent.setWORKINGAREA(agents.getWORKINGAREA());
        newAgent.setCOMMISSION(agents.getCOMMISSION());
        newAgent.setPHONE(agents.getPHONE());
        newAgent.setCOUNTRY(agents.getCOUNTRY());

        for (Customers c : agents.getCustomersList()) {
            newAgent.getCustomersList().add(new Customers(c.getCustname(), c.getCUSTCITY(), c.getWORKINGAREA(), c.getCUSTCOUNTRY(), c.getGRADE(), c.getOPENINGAMT(), c.getRECEIVEAMT(), c.getPAYMENTAMT(), c.getOUTSTANDINGAMT(), c.getPHONE(), c.getAGENTCODE()));
        }

        for (Orders o : agents.getOrdersList()) {
            newAgent.getOrdersList().add(new Orders(o.getORDAMOUNT(), o.getADVANCEAMOUNT(), o.getORDDESCRIPTION(), o.getCUSTCODE(), o.getAGENTCODE()));
        }

        return restrepos.save(newAgent);
    }
}