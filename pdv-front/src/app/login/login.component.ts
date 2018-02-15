import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../router.animations';
import {Router} from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import {LoginService} from './login.service';
import { Auth } from '../shared/model/auth.model';
import { Input } from '@angular/core/src/metadata/directives';
import { Route } from '@angular/compiler/src/core';
import { Routes } from '@angular/router/src/config';
import { DashboardComponent } from '../layout/dashboard/dashboard.component';
import {Errors} from "../shared/model/errors.model";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {

    authType: String = '';
    auth: Auth;
    message: string;
    form: FormGroup;
    errors: Errors = {errors: {}};
    isSubmitting = false;

    private formSumitAttempt: boolean;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private loginService: LoginService) {}

    ngOnInit() {
        this.authType = 'login';
        this.auth = new Auth();
        this.message = '';
        this.configureForm();
    }

    configureForm() {
        this.form = this.formBuilder.group({
            email: [null, [Validators.required, Validators.email]],
            password: [null, Validators.required],
          });
    }

    clearMessage() {
        this.message = '';
    }

    isFieldValid(field: string) {
        return (
          (!this.form.get(field).valid && this.form.get(field).touched) ||
          (this.form.get(field).untouched && this.formSumitAttempt)
        );
    }

    onLoggedin () {
      this.loginService
        .attemptAuth(this.authType, this.auth)
        .subscribe(
        (data: any) =>  {
            localStorage.setItem('isLoggedin', 'true');
            this.router.navigateByUrl('/dashboard');
        },
        (error: any) => {
            this.errors = error;
            this.isSubmitting = false;
            this.message = 'Usuário ou senha inválidos';
          }
        );


    }
}
