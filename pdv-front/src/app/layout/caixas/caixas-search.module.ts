import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PageHeaderModule} from './../../shared';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CaixasSearchRoutingModule} from "./caixas-search-routing.module";
import {CaixasSearchComponent} from "./caixas-search.component";

@NgModule({
    imports: [
        CommonModule,
        CaixasSearchRoutingModule,
        PageHeaderModule,
        FormsModule,
        ReactiveFormsModule],
    declarations: [CaixasSearchComponent]
})
export class CaixasSearchModule { }