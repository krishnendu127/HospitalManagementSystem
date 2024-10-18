package com.HMS.HospitalManagement.doclogin.repository;

import com.HMS.HospitalManagement.doclogin.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
