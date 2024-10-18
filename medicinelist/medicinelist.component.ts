import { Component } from '@angular/core';
import { Medicine } from '../medicine';
import { MedicineService } from '../medicine.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-medicinelist',
  templateUrl: './medicinelist.component.html',
  styleUrl: './medicinelist.component.css'
})
export class MedicinelistComponent {
  medicine:Medicine[]=[];
  constructor(private medicineService:MedicineService, private router:Router){}
  ngOnInit(): void {
    this.getMedicine();
  }
  getMedicine(){
    this.medicineService.getMedicineList().subscribe(data=>{
      this.medicine=data;
    })
  }
  updateMedicine(id:number){
    this.router.navigate(['update-medicine',id]);
  }
  deleteMedicine(id:number){
    this.medicineService.deleteMedicine(id).subscribe(data=>{
      console.log(data);
    })
    this.getMedicine();
  }
}
