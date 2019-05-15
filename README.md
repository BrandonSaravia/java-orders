# java-ordersList

A student that completes this project shows that they can:
* perform CRUD operations on an RDBMS using JPA and Hibernate.

## Introduction

This is a basic database scheme with customersList, ordersList, and sales agents.

## Instructions

Create a REST api server to store and read data from an in memory H2 database. 

The table layouts are as follows

* AGENTS
  * AGENTCODE primary key, not null Long
  * AGENTNAME string
  * WORKINGAREA string
  * COMMISSION double
  * PHONE string
  * COUNTRY string

* CUSTOMERS
  * CUSTCODE primary key, not null Long
  * custname String, not null
  * CUSTCITY String
  * WORKINGAREA String
  * CUSTCOUNTRY String
  * GRADE String
  * OPENINGAMT double
  * RECEIVEAMT double
  * PAYMENTAMT double
  * OUTSTANDINGAMT double
  * PHONE String
  * AGENTCODE Long foreign key (one agent to many customersList) not null

* ORDERS
  * ORDNUM primary key, not null Long
  * ORDAMOUNT double
  * ADVANCEAMOUNT double
  * CUSTCODE Long foreign key (one customer to many ordersList) not null
  * AGENTCODE Long foreign key (one agent to many ordersList) not null
  * ORDDESCRIPTION String


* Create the entities needed to store this data
* Load in the data. A file called data.sql would load the data using SQL. You need to modify it to load using a SeedData approach loading the data by creating objects.
 
Expose the following end points

* /customer/order - Returns all customersList with their ordersList
* /customer/name/{custname} - Returns all ordersList for a particular based on name

* /data/customer/new - Adds a new customer
* /data/customer/update/{custcode} - Updates the customer based off of custcode
* /data/customer/delete/{custcode} - Deletes the customer based off of custcode
  * this should also delete the ordersList of that customer

Stretch goals
* /agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)
* Add appropriate error exception handling
* Add appropriate logging for Tomcat, Spring, and custom logging for your project
