import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doclogin',
  templateUrl: './doclogin.component.html',
  styleUrl: './doclogin.component.css'
})
export class DocloginComponent {
  password:string="";
  username:string="";
  isValidLogin=false;
  constructor(private router:Router){}
  checkLogin(){
    if(this.username=="krishnendu" && this.password=="123456789"){
      sessionStorage.setItem('username',this.username);
      this.router.navigate(['docdash']);
      return true;
    }
    else{
      alert("Wrong credentials");
      this.router.navigate(['home']);
      return false;
    }
  }
}
