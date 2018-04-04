import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CaixasComponent } from './caixas.component';
import { CaixasRoutingModule } from './caixas-routing.module';
import { PageHeaderModule } from './../../shared';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
    imports: [
        CommonModule,
        CaixasRoutingModule,
        PageHeaderModule,
        FormsModule,
        ReactiveFormsModule],
    declarations: [CaixasComponent]
})
export class CaixasModule { }