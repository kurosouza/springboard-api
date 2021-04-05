package org.springboard.entities;

import javax.persistence.Entity;
import javax.persistence.PersistenceUnit;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@PersistenceUnit(name = "local")
public  class Business extends PanacheEntity {

    public Long id;
    public String name;
    public String description;
    public String address;
    public String contactEmail;
    public String password;

    public String bcAddress;
    public String bcPKey;
    
}
