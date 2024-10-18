import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css'] // Fix the property name from styleUrl to styleUrls
})
export class AdminloginComponent {
  password: string = '';
  username: string = '';
  isValidLogin = false;

  constructor(private router: Router) {}

  checkLogin() {
    if (this.username === 'krishnendu' && this.password === '123456789') {
      sessionStorage.setItem('username', this.username);
      this.router.navigate(['admin']); 
    } else {
      alert('Wrong credentials');
      this.router.navigate(['home']); 
    }
  }
}
