import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit() {

  }

  authenticate(e) {
    e.preventDefault();
    console.log('Auth ok');
    this.router.navigate(['home']);
  }

}
