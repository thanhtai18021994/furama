import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpErrorResponse
} from '@angular/common/http';
import {BehaviorSubject, Observable, throwError} from 'rxjs';
import {UserService} from '../service/security/user.service';
import {Router} from '@angular/router';
import {catchError, filter, switchMap, take} from 'rxjs/operators';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  private isRefreshing = false;
  private refreshTokenSubject: BehaviorSubject<any> = new BehaviorSubject<any>(null);
  constructor(
    private userService:UserService,
    private router:Router
  ) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (request.url.includes(`${this.userService.uriApi}/api/login`)){
      console.log("go here");
      return next.handle(request);
    }
    console.log("token 3");
    console.log(this.userService.getTokenFromCache());
    const requestClone=this.addToken(request,this.userService.getTokenFromCache());

    return next.handle(requestClone).pipe(catchError(err => {
      if (err instanceof HttpErrorResponse && err.status===401){
        return this.handle401Error(request,next);
      }else {
        return throwError(err);
      }
    }));
  }

  private addToken(request: HttpRequest<any>, token: string) {
    return request.clone({
      setHeaders: {
        'Authorization': `Bearer ${token}`
      }
    });
  }

  private handle401Error(request: HttpRequest<any>, next: HttpHandler) {
    if (!this.isRefreshing) {
      this.isRefreshing = true;
      this.refreshTokenSubject.next(null);
      return this.userService.refreshToken().pipe(
        switchMap((token: any) => {
          this.isRefreshing = false;
          this.refreshTokenSubject.next(token.jwt);
          return next.handle(this.addToken(request, token.jwt));
        }));
    } else {
      return this.refreshTokenSubject.pipe(
        filter(token => token != null),
        take(1),
        switchMap(jwt => {
          return next.handle(this.addToken(request, jwt));
        }));
    }
  }

}
