import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PageHeaderModule} from './../../shared';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ProductsSearchRoutingModule} from "./products-search-routing.module";
import {ProductsSearchComponent} from "./products-search.component";

@NgModule({
    imports: [
        CommonModule,
        ProductsSearchRoutingModule,
        PageHeaderModule,
        FormsModule,
        ReactiveFormsModule],
    declarations: [ProductsSearchComponent]
})
export class ProductsSearchModule { }
