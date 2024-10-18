import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { ActivatedRoute, RouteConfigLoadEnd, Router } from '@angular/router';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrl: './update-patient.component.css'
})
export class UpdatePatientComponent {
  id:number=0;
  patient:Patient=new Patient();
  constructor(private patientService:PatientService,private route:ActivatedRoute,private router:Router){}
  ngOnInit():void{
    this.id=this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.id).subscribe(data=>{
      this.patient=data;
    })
  }
  onUpdate(){
    this.patientService.updatePatient(this.id,this.patient).subscribe(data=>{
      console.log(data);
      this.goToDocDash();
    })
  }
  goToDocDash(){
    this.router.navigate(['/docdash']);
  }
}
