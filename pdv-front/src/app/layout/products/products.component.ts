import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { Router } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { Routes } from '@angular/router/src/config';
import { Input } from '@angular/core/src/metadata/directives';

import { Product } from '../../shared/model/product.model';
import { DashboardComponent } from '../../layout/dashboard/dashboard.component';


@Component({
    selector: 'app-products',
    templateUrl: './products.component.html',
    styleUrls: ['./products.component.scss'],
    animations: [routerTransition()]
})
export class ProductsComponent implements OnInit {

    product: Product;
    productForm: FormGroup;

    private formSumitAttempt: boolean;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
    ) {}


    ngOnInit() {
        this.product = new Product();
        this.configureForm();
    }

    configureForm() {
        this.productForm = this.formBuilder.group({
            nome: [null, [Validators.required, Validators.nome]],
            precoVenda: [null, [Validators.required, Validators.precoVenda]],
            precoCusto: [null, [Validators.required, Validators.precoCusto]],
            codigoBarra: [null, [Validators.required, Validators.codigoBarra]],
            medida: [null, [Validators.required, Validators.medida]]
        });
    }

    isFieldValid(field: string) {
        return (
          (!this.productForm.get(field).valid && this.productForm.get(field).touched) ||
          (this.productForm.get(field).untouched && this.formSumitAttempt)
        );
    }

    saveProduct() {
        console.log(this.product);
    }
}