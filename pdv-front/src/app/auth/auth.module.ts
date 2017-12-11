import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import {AuthComponent} from "./auth.component";
import {NoAuthGuard} from "./no-auth-guard.service";
import {SharedModule} from "../shared/shared.modules";
import {AuthGuard} from "../shared/auth-guard.service";


const authRouting: ModuleWithProviders = RouterModule.forChild([
  {
    path: 'login',
    component: AuthComponent,
    canActivate: [NoAuthGuard]
  },
  {
    path: 'register',
    component: AuthComponent,
    canActivate: [NoAuthGuard]
  }
]);

@NgModule({
  imports: [
    authRouting,
    SharedModule
  ],
  declarations: [
    AuthComponent
  ],

  providers: [
    NoAuthGuard,
    AuthGuard
  ]
})


export class AuthModule {}
