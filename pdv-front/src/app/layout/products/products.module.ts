import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsComponent } from './products.component';
import { ProductsRoutingModule } from './products-routing.module';
import { PageHeaderModule } from './../../shared';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
    imports: [
        CommonModule,
        ProductsRoutingModule,
        PageHeaderModule,
        FormsModule,
        ReactiveFormsModule],
    declarations: [ProductsComponent]
})
export class ProductsModule { }
