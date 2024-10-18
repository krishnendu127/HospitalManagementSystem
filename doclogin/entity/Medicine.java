package com.HMS.HospitalManagement.doclogin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "drug_names")
    private String drugname;
    @Column(name = "stocks")
    private String stock;
    public Medicine() {
    }
    public Medicine(int id,String drugname,String stock){
        this.drugname=drugname;
        this.id=id;
        this.stock=stock;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }


}
