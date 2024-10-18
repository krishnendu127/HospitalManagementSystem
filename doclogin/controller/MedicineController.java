package com.HMS.HospitalManagement.doclogin.controller;

import com.HMS.HospitalManagement.doclogin.entity.Medicine;
import com.HMS.HospitalManagement.doclogin.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;
    @PostMapping("/insert")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineRepository.save(medicine);
    }
    @GetMapping
    public List<Medicine> getAllMedicines(){
        return medicineRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable int id) {
        Optional<Medicine> medicine = medicineRepository.findById(id);

        if (medicine.isPresent()) {
            medicineRepository.delete(medicine.get());
            System.out.println("Medicine with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Medicine with ID " + id + " not found.");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Medicine> updateMedicineById(@PathVariable int id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Medicine Not Found"));
        medicine.setDrugname(medicineDetails.getDrugname());
        medicine.setStock(medicineDetails.getStock());

        Medicine updatedMedicine = medicineRepository.save(medicine);
        return ResponseEntity.ok(updatedMedicine);
    }
    @GetMapping("/medicine/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable int id) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Medicine Not Found"));
        return ResponseEntity.ok(medicine);
    }
}
