import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';

@Component({
  selector: 'app-admindash',
  templateUrl: './admindash.component.html',
  styleUrls: ['./admindash.component.css'] // Corrected from 'styleUrl' to 'styleUrls'
})
export class AdmindashComponent {
    patients: Patient[] = [];
    
    constructor(private patientService: PatientService) {}

    ngOnInit(): void {
        this.getPatients();
    }

    getPatients() {
        this.patientService.getPatientList().subscribe({
            next: (data) => { // Changed 'data' to 'next'
                this.patients = data;
                console.log('Patients fetched:', this.patients); // Log to check data
            },
            error: (err) => { // Ensure this handles error properly
                console.error('Error fetching patients', err);
            }
        });
    }
    deletePatient(id:number){
        this.patientService.deletePatient(id).subscribe(data =>{
            console.log(data);
            this.getPatients();
        })
    }
}
