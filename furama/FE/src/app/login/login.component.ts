import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {SubSink} from 'subsink';
import {UserService} from '../service/security/user.service';
import {Router} from '@angular/router';
import {HttpErrorResponse} from '@angular/common/http';
import {User} from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userGroup: FormGroup;
  private subs = new SubSink();

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.getLogin();
  }

  getLogin() {
    this.userGroup = this.fb.group({
      username: [''],
      password: ['']
    });
  }

  login() {
    let user: User = this.userGroup.value;
      this.userService.login(user).subscribe(
        (response) => {
          let json = JSON.stringify(response.body);
          let resJson = JSON.parse(json);
          this.userService.addTokenToCache(resJson.access_token,resJson.refresh_token);

        }, (error: HttpErrorResponse) => {
          console.log(error);
        },()=>{
          this.userService.getPrincipal().subscribe(data=>{
            let principal:User=null;
            principal=data;
            console.log(data);
            this.userService.addUserToCache(principal);
          },error => {
          },()=>{
            this.router.navigate(['']);
          })

        }
      )

  }

  ngOnDestroy(): void {
  }

}
