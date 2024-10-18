package com.HMS.HospitalManagement.controller;

import com.HMS.HospitalManagement.entity.Patient;
import com.HMS.HospitalManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @PostMapping("/insert")
    public Patient createpatient(@RequestBody  Patient patient){
        return patientRepository.save(patient);
    }
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) throws AttributeNotFoundException {
        Patient updatedPatient=patientRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient Not Found"));
        return ResponseEntity.ok(updatedPatient);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable int id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient Not Found"));
        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatientByID(@PathVariable int id, @RequestBody Patient patientDetails) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient Not Found"));
        patient.setName(patientDetails.getName());
        patient.setAge(patientDetails.getAge());
        patient.setBlood(patientDetails.getBlood());
        patient.setDose(patientDetails.getDose());
        patient.setFees(patientDetails.getFees());
        patient.setPrescription(patientDetails.getPrescription());
        patient.setUrgency(patientDetails.getUrgency());

        Patient updatedPatient=patientRepository.save(patient);
        return ResponseEntity.ok(updatedPatient);

    }
}
