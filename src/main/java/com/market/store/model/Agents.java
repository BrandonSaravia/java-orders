package com.market.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long AGENTCODE;

    private String AGENTNAME;
    private String WORKINGAREA;
    private double COMMISSION;
    private String PHONE;
    private String COUNTRY;

    @OneToMany(mappedBy = "agents", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"agents", "customersList"})
    private List<Customers> customersList = new ArrayList<>();

    @OneToMany(mappedBy = "agents", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"agents", "ordersList"})
    private List<Orders> ordersList = new ArrayList<>();


    public Agents() {
    }

    public Agents(String AGENTNAME, String WORKINGAREA, double COMMISSION, String PHONE, String COUNTRY) {
        this.AGENTNAME = AGENTNAME;
        this.WORKINGAREA = WORKINGAREA;
        this.COMMISSION = COMMISSION;
        this.PHONE = PHONE;
        this.COUNTRY = COUNTRY;
    }

    public long getAGENTCODE() {
        return AGENTCODE;
    }

    public void setAGENTCODE(long AGENTCODE) {
        this.AGENTCODE = AGENTCODE;
    }

    public String getAGENTNAME() {
        return AGENTNAME;
    }

    public void setAGENTNAME(String AGENTNAME) {
        this.AGENTNAME = AGENTNAME;
    }

    public String getWORKINGAREA() {
        return WORKINGAREA;
    }

    public void setWORKINGAREA(String WORKINGAREA) {
        this.WORKINGAREA = WORKINGAREA;
    }

    public double getCOMMISSION() {
        return COMMISSION;
    }

    public void setCOMMISSION(double COMMISSION) {
        this.COMMISSION = COMMISSION;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
