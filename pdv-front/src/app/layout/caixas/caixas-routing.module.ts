import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CaixasComponent } from './caixas.component';

const routes: Routes = [
    {
        path: '',
        component: CaixasComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CaixasRoutingModule {}