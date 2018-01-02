import { Injectable, Inject } from '@angular/core';
import { tokenNotExpired } from 'angular2-jwt';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import {HttpClientModule, HttpClient} from '@angular/common/http';

import {Auth} from '../shared/model/auth.model';

@Injectable()
export class LoginService {

    readonly TOKEN_KEY = 'toke';

    constructor(private http: HttpClient) {}

    public getToken() {
        return localStorage.getItem(this.TOKEN_KEY);
    }

    public isAuthenticated(): boolean {
        const token = this.getToken();
        return tokenNotExpired(null, token);
    }

    public authenticated(auth: Auth) {
        let body = JSON.stringify(auth);
        //TODO modificar a forma de trabalhar com os endpoint 
        return this.http.post('http://localhost:8080/api/login', body);
    }

}