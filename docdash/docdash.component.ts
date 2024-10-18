import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient'; 
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-docdash',
  templateUrl: './docdash.component.html',
  styleUrls: ['./docdash.component.css'] 
})
export class DocdashComponent implements OnInit {
  patients: Patient[] = [];

  constructor(private patientService: PatientService, private router:Router) {}

  ngOnInit(): void {
    this.getPatients();
  }

  getPatients(): void {
    this.patientService.getPatientList().subscribe({
      next: (data) => {
        this.patients = data;
      },
      error: (err) => {
        console.error('Error fetching patients:', err);
      }
    });
  }
  updatePatient(id:number){
    this.router.navigate(['update-patient',id]);
  }
  deletePatient(id:number){
    this.patientService.deletePatient(id).subscribe(data=>{
      console.log(data);
    })
    this.getPatients();
  }
}
