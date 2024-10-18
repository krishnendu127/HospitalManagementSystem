import { Component } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Router } from '@angular/router';
import { Medicine } from '../medicine';

@Component({
  selector: 'app-create-medicine',
  templateUrl: './create-medicine.component.html',
  styleUrl: './create-medicine.component.css'
})
export class CreateMedicineComponent {
  medicine:Medicine=new Medicine();
  constructor(private medicineService:MedicineService,private router:Router){}
  onSubmit(){
    this.saveMedicine();
  }
  saveMedicine(){
    this.medicineService.saveMedicine(this.medicine).subscribe(data=>{
      console.log(data);
      this.goToMedicineList();

    })
  }
  goToMedicineList(){
    this.router.navigate(['/view-medicine-list']);
  }
}
