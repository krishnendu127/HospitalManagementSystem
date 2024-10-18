package com.HMS.HospitalManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "blood")
    private String blood;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "dose")
    private String dose;

    @Column(name = "fees")
    private String fees;

    @Column(name = "urgency")
    private String urgency;

    // No-argument constructor
    public Patient() {
    }

    // Parameterized constructor
    public Patient(int id, String name, int age, String blood, String prescription, String dose, String fees, String urgency) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.blood = blood;
        this.prescription = prescription;
        this.dose = dose;
        this.fees = fees;
        this.urgency = urgency;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
}
