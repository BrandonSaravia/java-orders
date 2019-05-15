package com.market.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ORDNUM;

    private double ORDAMOUNT;

    private double ADVANCEAMOUNT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTCODE", nullable = false)
    @JsonIgnoreProperties({"ordersList", "hibernateLazyInitializer"})
    private Customers customers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGENTCODE", nullable = false)
    @JsonIgnoreProperties({"ordersList", "hibernateLazyInitializer"})
    private Agents agents;

    @Column(unique = false, nullable = false)
    private String ORDDESCRIPTION;


    public Orders() {
    }

    public Orders(double ORDAMOUNT, double ADVANCEAMOUNT, String ORDDESCRIPTION, Customers customers, Agents agents) {
        this.ORDAMOUNT = ORDAMOUNT;
        this.ADVANCEAMOUNT = ADVANCEAMOUNT;
        this.ORDDESCRIPTION = ORDDESCRIPTION;
        this.customers = customers;
        this.agents = agents;
    }

    public long getORDNUM() {
        return ORDNUM;
    }

    public void setORDNUM(long ORDNUM) {
        this.ORDNUM = ORDNUM;
    }

    public double getORDAMOUNT() {
        return ORDAMOUNT;
    }

    public void setORDAMOUNT(double ORDAMOUNT) {
        this.ORDAMOUNT = ORDAMOUNT;
    }

    public double getADVANCEAMOUNT() {
        return ADVANCEAMOUNT;
    }

    public void setADVANCEAMOUNT(double ADVANCEAMOUNT) {
        this.ADVANCEAMOUNT = ADVANCEAMOUNT;
    }

    public String getORDDESCRIPTION() {
        return ORDDESCRIPTION;
    }

    public void setORDDESCRIPTION(String ORDDESCRIPTION) {
        this.ORDDESCRIPTION = ORDDESCRIPTION;
    }

    public Customers getCUSTCODE() {
        return customers;
    }

    public void setCUSTCODE(Customers customers) {
        this.customers = customers;
    }

    public Agents getAGENTCODE() {
        return agents;
    }

    public void setAGENTCODE(Agents agents) {
        this.agents = agents;
    }
}
