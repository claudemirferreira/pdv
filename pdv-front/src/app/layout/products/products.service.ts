import { Injectable, Inject } from '@angular/core';
import { tokenNotExpired } from 'angular2-jwt';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import {HttpClientModule, HttpClient, HttpHeaders} from '@angular/common/http';

import {Auth} from '../../shared/model/auth.model';
import { Product } from '../../shared/model/product.model';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ProductsService {

    // readonly SAVE_ENDPOINT = 'http://localhost:8080/api/produtos';
    // readonly TOKEN_KEY = 'toke';

    constructor(private http: HttpClient) {}

    saveProducts(product: Product) {
        // let token = localStorage.getItem(this.TOKEN_KEY);
        // let body = JSON.stringify(product);
        // var header = new HttpHeaders();
        // header.append("Authorization", token);
        // return this.http.post(this.SAVE_ENDPOINT, body, header);
    }

}
