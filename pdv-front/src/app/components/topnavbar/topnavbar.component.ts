import { Component } from '@angular/core';
import { smoothlyMenu } from '../../app.helpers';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
    selector: 'topnavbar',
    templateUrl: './topnavbar.component.html'
})
export class Topnavbar implements OnInit {
    ngOnInit() {

    }

    toggleNavigation(): void {
        jQuery("body").toggleClass("mini-navbar");
        smoothlyMenu();
    }

    logout() {
        localStorage.clear();
        // location.href='http://to_login_page';
    }
}