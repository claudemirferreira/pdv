import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsComponent } from './products.component';
import { ProductsRoutingModule } from './products-routing.module';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, ProductsRoutingModule, PageHeaderModule],
    declarations: [ProductsComponent]
})
export class ProductsModule {}
