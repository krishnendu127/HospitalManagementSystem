import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private baseUrl = "http://localhost:8080/api/v2"; 

  constructor(private httpClient: HttpClient) { }

  getAllAppointments(): Observable<Appointment[]> {
      return this.httpClient.get<Appointment[]>(`${this.baseUrl}/appointments`); 
  }

  createAppointment(appointment: Appointment): Observable<Appointment> {
      return this.httpClient.post<Appointment>(`${this.baseUrl}/insert`, appointment); 
  }
  
  deleteAppointment(id:number):Observable<object>{
    return this.httpClient.delete(`${this.baseUrl}/appointments/${id}`)
  }
}
