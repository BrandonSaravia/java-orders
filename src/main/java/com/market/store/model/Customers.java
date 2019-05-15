package com.market.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long CUSTCODE;

    @Column(nullable = false)
    private String custname;

    private String CUSTCITY;

    private String WORKINGAREA;

    private String CUSTCOUNTRY;

    private String GRADE;

    private double OPENINGAMT;

    private double RECEIVEAMT;

    private double PAYMENTAMT;

    private double OUTSTANDINGAMT;

    private String PHONE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGENTCODE", nullable = false)
    @JsonIgnoreProperties({"AGENTCODE", "hibernateLazyInitializer"})
    private Agents agents;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customers")
    private List<Orders> ordersList = new ArrayList<>();

    public Customers() {
    }

    public Customers(String custname, String CUSTCITY, String WORKINGAREA, String CUSTCOUNTRY, String GRADE, double OPENINGAMT, double RECEIVEAMT, double PAYMENTAMT, double OUTSTANDINGAMT, String PHONE, Agents agents) {
        this.custname = custname;
        this.CUSTCITY = CUSTCITY;
        this.WORKINGAREA = WORKINGAREA;
        this.CUSTCOUNTRY = CUSTCOUNTRY;
        this.GRADE = GRADE;
        this.OPENINGAMT = OPENINGAMT;
        this.RECEIVEAMT = RECEIVEAMT;
        this.PAYMENTAMT = PAYMENTAMT;
        this.OUTSTANDINGAMT = OUTSTANDINGAMT;
        this.PHONE = PHONE;
        this.agents = agents;
    }



    public long getCUSTCODE() {
        return CUSTCODE;
    }

    public void setCUSTCODE(long CUSTCODE) {
        this.CUSTCODE = CUSTCODE;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCUSTCITY() {
        return CUSTCITY;
    }

    public void setCUSTCITY(String CUSTCITY) {
        this.CUSTCITY = CUSTCITY;
    }

    public String getWORKINGAREA() {
        return WORKINGAREA;
    }

    public void setWORKINGAREA(String WORKINGAREA) {
        this.WORKINGAREA = WORKINGAREA;
    }

    public String getCUSTCOUNTRY() {
        return CUSTCOUNTRY;
    }

    public void setCUSTCOUNTRY(String CUSTCOUNTRY) {
        this.CUSTCOUNTRY = CUSTCOUNTRY;
    }

    public String getGRADE() {
        return GRADE;
    }

    public void setGRADE(String GRADE) {
        this.GRADE = GRADE;
    }

    public double getOPENINGAMT() {
        return OPENINGAMT;
    }

    public void setOPENINGAMT(double OPENINGAMT) {
        this.OPENINGAMT = OPENINGAMT;
    }

    public double getRECEIVEAMT() {
        return RECEIVEAMT;
    }

    public void setRECEIVEAMT(double RECEIVEAMT) {
        this.RECEIVEAMT = RECEIVEAMT;
    }

    public double getPAYMENTAMT() {
        return PAYMENTAMT;
    }

    public void setPAYMENTAMT(double PAYMENTAMT) {
        this.PAYMENTAMT = PAYMENTAMT;
    }

    public double getOUTSTANDINGAMT() {
        return OUTSTANDINGAMT;
    }

    public void setOUTSTANDINGAMT(double OUTSTANDINGAMT) {
        this.OUTSTANDINGAMT = OUTSTANDINGAMT;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public Agents getAGENTCODE() {
        return agents;
    }

    public void setAGENTCODE(Agents agents) {
        this.agents = agents;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
