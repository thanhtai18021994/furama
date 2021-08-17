import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {UserService} from '../service/security/user.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerGuardGuard implements CanActivate {
  role: string[] = [];

  constructor(
    private router: Router,
    private userService: UserService
  ) {
    if (this.userService.getUserFromCache().roles) {
      let roles = this.userService.getUserFromCache().roles;
      for (let i = 0; i < roles.length; i++) {
        this.role.push(roles[i].name.substring(5));
      }
    }
    console.log(this.role.indexOf('ADMIN') >= 0);
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    console.log('check cus guard');
    console.log(this.userService.isLoggedIn());
    if (this.userService.isLoggedIn() &&(this.role.indexOf('ADMIN') >= 0)) {
      console.log('1');
      return true;
    } else {
      this.router.navigate(['/login']);
      console.log(2);
      return false;
    }
  }
}
