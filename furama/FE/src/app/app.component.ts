import {Component, OnInit} from '@angular/core';
import {UserService} from './service/security/user.service';
import {init} from 'protractor/built/launcher';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'furama';

  nameUser:string;
  role:string[]=[];

  constructor(
    private userService:UserService,
    private router:Router
  ) {

  }

  logout(){
    this.userService.logOut();
    window.location.reload();
  }

  ngOnInit(): void {
    if (this.userService.isLoggedIn()){
      this.nameUser=this.userService.getUserFromCache().fullName;
      let roles=this.userService.getUserFromCache().roles;
      for (let i = 0; i < roles.length; i++) {
        // console.log(roles[i].name);
        this.role.push(roles[i].name.substring(5));
      }
      // console.log(this.nameUser);
      // console.log(this.role);
    }
  }

  checkRole(){

  }

}
