import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { ProductsComponent } from './products/products.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

import {Topnavbar} from './components/topnavbar/topnavbar.component';
import {Navigation} from './components/navigation/navigation.component';

const appRoutes: Routes = [
  {
    path: '',
    component: AuthComponent,
    data: {}
  },
  {
    path: 'home',
    component: HomeComponent,
    data: {}
  }
];

@NgModule({
  declarations: [
    AppComponent,
    Navigation,
    AuthComponent,
    ProductsComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    Topnavbar
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
