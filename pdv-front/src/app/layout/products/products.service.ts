import { Injectable, Inject } from '@angular/core';
import { tokenNotExpired } from 'angular2-jwt';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import {HttpClientModule, HttpClient} from '@angular/common/http';

import {Auth} from '../../shared/model/auth.model';

@Injectable()
export class ProductsService {

    constructor(private http: HttpClient) {}

}