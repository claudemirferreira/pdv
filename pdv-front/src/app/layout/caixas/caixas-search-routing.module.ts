import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CaixasSearchComponent} from "./caixas-search.component";

const routes: Routes = [
    {
        path: '',
        component: CaixasSearchComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CaixasSearchRoutingModule {

}