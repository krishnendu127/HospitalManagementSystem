package com.HMS.HospitalManagement.doclogin.controller;

import com.HMS.HospitalManagement.doclogin.entity.Appointment;
import com.HMS.HospitalManagement.doclogin.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "http://localhost:4200") // Local specific CORS
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable int id) throws AttributeNotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Appointment Not Found"));
        appointmentRepository.delete(appointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
