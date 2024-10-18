import { Component } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css'] // Corrected 'styleUrl' to 'styleUrls'
})
export class CreateAppointmentComponent {
    appointment: Appointment = new Appointment();
    
    // Corrected the constructor
    constructor(private appointmentService: AppointmentService, private router: Router) {}

    saveAppointment() {
      this.appointmentService.createAppointment(this.appointment).subscribe(
        data => {
          console.log(data);
          this.goToAppointment();
        },
        error => {
          console.error('Error creating appointment:', error); // Added error handling
        }
      );
    }

    onSubmit() {
      this.saveAppointment();
    }

    goToAppointment() {
      this.router.navigate(['/appointmentlist']);
    }
}
