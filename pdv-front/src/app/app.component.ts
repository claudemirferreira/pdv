import { Component } from '@angular/core';
import { Auth } from './model/AuthModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  loginInfo: Auth = {
      first_name: 'Andrew',
      last_name: 'Yang',
      avatar: 'ay.jpeg',
      title: 'Senior Developer'
  };
}
