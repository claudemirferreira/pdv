import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Auth} from '../shared/model/auth.model';
import {ApiService} from "../shared/service/api.service";

import {UserAuth} from "../shared/model/user.model";
import {JwtService} from "../shared/guard/jwt.service";
import { distinctUntilChanged, map } from 'rxjs/operators';
import {ReplaySubject} from "rxjs/ReplaySubject";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";

@Injectable()
export class LoginService {

  private currentUserSubject = new BehaviorSubject<UserAuth>({} as UserAuth);
  public currentUser = this.currentUserSubject.asObservable().pipe(distinctUntilChanged());

  private isAuthenticatedSubject = new ReplaySubject<boolean>(1);
  public isAuthenticated = this.isAuthenticatedSubject.asObservable();


  constructor(
      private apiService: ApiService,
      private http: HttpClient,
      private jwtService: JwtService
    ) {}


    public attemptAuth(auth: Auth): Observable<UserAuth> {
        let body = JSON.stringify(auth);
        return this.apiService.post('/login', body)
          .pipe(map(
            data => {
              this.setAuth(data.user);
              return data;
            }
        ));
    }

    setAuth(user: UserAuth) {
      this.jwtService.saveToken(user.token);
      this.currentUserSubject.next(user);
      this.isAuthenticatedSubject.next(true);
    }

    purgeAuth() {
      this.jwtService.destroyToken();
      this.currentUserSubject.next({} as UserAuth);
      this.isAuthenticatedSubject.next(false);
    }

    getCurrentUser(): UserAuth {
      return this.currentUserSubject.getValue();
    }

}
