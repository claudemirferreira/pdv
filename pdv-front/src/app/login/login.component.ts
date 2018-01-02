import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../router.animations';
import {Router} from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import {LoginService} from './login.service';
import { Auth } from '../shared/model/auth.model';
import { Input } from '@angular/core/src/metadata/directives';
import { Route } from '@angular/compiler/src/core';
import { Routes } from '@angular/router/src/config';
import { DashboardComponent } from '../layout/dashboard/dashboard.component';


@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {

    auth: Auth;
    message: string;

    constructor(
        private router: Router,
        private loginService: LoginService) {}

    ngOnInit() {
        this.auth = new Auth();
        this.message = '';
    }

    closeAlert(index) {
        console.log(index);
    }

    onLoggedin() {
        this.loginService.authenticated(this.auth).
            subscribe(
                (data: any) =>  {
                    localStorage.setItem('isLoggedin', 'true');
                    this.router.navigate(['/dashboard']);
                },
                (data: any) => {
                    console.log(data);
                    this.message = 'Usuário ou senha inválidos';
                }
            );
    }
}
