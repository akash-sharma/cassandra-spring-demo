package com.akash.cassandra.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Table("user")
public class User {

    @PrimaryKeyColumn(name = "first_name", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    private String firstName;

    @PrimaryKeyColumn(name = "last_name", type = PrimaryKeyType.PARTITIONED, ordinal = 1)
    private String lastName;

    @PrimaryKeyColumn(name = "adhar_number", type = PrimaryKeyType.PARTITIONED, ordinal = 2)
    private String adharNumber;

    @PrimaryKeyColumn(name = "dob", type = PrimaryKeyType.CLUSTERED, ordinal = 3)
    private LocalDate dob;

    @PrimaryKeyColumn(name = "address", type = PrimaryKeyType.CLUSTERED, ordinal = 4)
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdharNumber() {
        return adharNumber;
    }

    public void setAdharNumber(String adharNumber) {
        this.adharNumber = adharNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}