import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { ReplaySubject } from 'rxjs/ReplaySubject';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


import {ApiService} from "./api.service";
import {JwtService} from "./jwt.service";
import {User} from "../models/user.model";

@Injectable()
export class UserService {

  private currentUserSubject = new BehaviorSubject<User>(new User());
  //public currentUser = this.currentUserSubject.asObservable().distinctUntilChanged();

  private isAuthenticatedSubject = new ReplaySubject<boolean>(1);
  public isAuthenticated = this.isAuthenticatedSubject.asObservable();

  constructor(
    private apiService: ApiService,
    private http: Http,
    private jwsService: JwtService
  ){}

  pupulate() {
    if(this.jwsService.getToken()) {
      this.apiService.get('/user').subscribe(
          data => this.setAuth(data.user),
          err => this.purgeAuth())
    } else {
      this.purgeAuth();
    }
  }

  setAuth(user: User) {
    this.jwsService.saveToken(user.token);
    this.currentUserSubject.next(user);
    this.isAuthenticatedSubject.next(true);
  }

  purgeAuth() {
    this.jwsService.destroyToken();
    this.currentUserSubject.next(new User());
    this.isAuthenticatedSubject.next(false);
  }

  attemptAuth(type, credentials): Observable<User> {
    const route = (type === 'login') ? '/login' : '';
    return this.apiService.post('/user' + route, {user:credentials})
      .map(
        data => {
          this.setAuth(data.user);
          return data;
        }
      );
  }

  getCurrentUser(): User {
    return this.currentUserSubject.value;
  }

  update(user): Observable<User> {
    return this.apiService.put('/user', {user})
      .map(data => {
        this.currentUserSubject.next(data.user);
        return data.user;
      });
  }

}
