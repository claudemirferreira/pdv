import { BrowserModule } from '@angular/platform-browser';
import {ModuleWithProviders, NgModule} from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AuthModule } from './auth/auth.module';
import { HomeModule } from './home/home.module';
import { ApiService } from "./shared/api.service";
import { AuthGuard } from "./shared/auth-guard.service";
import { JwtService} from "./shared";
import {SharedModule} from "./shared/shared.modules";
import {UserService} from "./shared";

const rootRouting: ModuleWithProviders = RouterModule.forRoot([], { useHash: true });


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AuthModule,
    HomeModule,
    rootRouting,
    SharedModule,
  ],
  providers: [
    ApiService,
    AuthGuard,
    JwtService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

