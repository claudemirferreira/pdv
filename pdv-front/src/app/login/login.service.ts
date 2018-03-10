import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ApiService} from "../shared/service/api.service";

import {UserAuth} from "../shared/model/user.model";
import {JwtService} from "../shared/guard/jwt.service";
import {distinctUntilChanged, map} from 'rxjs/operators';
import {ReplaySubject} from "rxjs/ReplaySubject";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";

@Injectable()
export class LoginService {

  private currentUserSubject = new BehaviorSubject<UserAuth>({} as UserAuth);
  public currentUser = this.currentUserSubject.asObservable().pipe(distinctUntilChanged());

  private isAuthenticatedSubject = new ReplaySubject<boolean>(1);
  public isAuthenticated = this.isAuthenticatedSubject.asObservable();

  constructor (
    private apiService: ApiService,
    private http: HttpClient,
    private jwtService: JwtService
  ) {}


  setAuth(user: UserAuth) {
    // Save JWT sent from server in localstorage
    this.jwtService.saveToken(user.token);
    // Set current user data into observable
    this.currentUserSubject.next(user);
    // Set isAuthenticated to true
    this.isAuthenticatedSubject.next(true);
  }

  attemptAuth(type, credentials): Observable<UserAuth> {
    const route = (type === 'login') ? '/login' : '';
    return this.apiService.post(route, {user: credentials})
      .pipe(map(
        data => {
          this.setAuth(data.user);
          this.jwtService.saveToken(data.user.token);
          return data;
        }
      ));
  }

  getCurrentUser(): UserAuth {
    return this.currentUserSubject.value;
  }

  // Update the user on the server (email, pass, etc)
  update(user): Observable<UserAuth> {
    return this.apiService
      .put('/user', { user })
      .pipe(map(data => {
        // Update the currentUser observable
        this.currentUserSubject.next(data.user);
        return data.user;
      }));
  }

}
