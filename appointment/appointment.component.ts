import { Component, OnInit } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css'] // Fixed typo: styleUrl -> styleUrls
})
export class AppointmentComponent implements OnInit {
  appointments: Appointment[] = [];

  // Inject the AppointmentService using a private property
  constructor(private appointmentService: AppointmentService) {}

  // Use ngOnInit lifecycle hook to load the appointments when the component initializes
  ngOnInit(): void {
    this.getAllAppointments();
  }

  // Method to fetch all appointments
  getAllAppointments(): void {
    this.appointmentService.getAllAppointments().subscribe(
      data => {
        this.appointments = data;
      },
      error => {
        console.error('Error fetching appointments:', error); // Log errors for debugging
      }
    );
  }

  deleteAppointment(id:number){
    this.appointmentService.deleteAppointment(id).subscribe(data =>{
      console.log(data);
      this.getAllAppointments();
    })
  }
}
